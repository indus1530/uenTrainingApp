package com.example.abdulsajid.mnchtraining;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import Global.Session_End;
import Global.Session_Start;
import data.LocalDataManager;
import utils.Gothrough;

public class InterviewEnd extends AppCompatActivity implements View.OnClickListener {

    static EditText
            ed_next_session_date,
            ed_next_session_time;
    Button
            btn_submit;
    LinearLayout
            ll_cnic,
            ll_result,
            ll_next_session,
            ll_session_status;
    RadioButton
            rb_status1,
            rb_status2,
            rb_status3,
            rb_status4;
    EditText
            ed_cnic_no,
            ed_training,
            ed_pretest_result,
            ed_posttest_result,
            ed_remarks,
            ed_ptp;
    String
            cnic_no,
            training,
            pretest_result,
            posttest_result,
            posttest_percent,
            Remarks,
            next_session_date,
            next_session_time,
            training_status,
            Session_End_Date,
            Session_End_Time,
            STATUS;

    int currentSection, bCurrentSection;
    double ptp;

    void Initialization() {


        // Layouts
        ll_cnic = findViewById(R.id.ll_cnic);
        ll_result = findViewById(R.id.ll_result);
        ll_next_session = findViewById(R.id.ll_next_session);
        ll_session_status = findViewById(R.id.ll_session_status);

        // Button Next
        btn_submit = findViewById(R.id.btn_submit);
        ed_cnic_no = findViewById(R.id.ed_cnic_no);
        ed_training = findViewById(R.id.ed_training);
        ed_pretest_result = findViewById(R.id.ed_pretest_result);
        ed_posttest_result = findViewById(R.id.ed_posttest_result);
        ed_remarks = findViewById(R.id.ed_remarks);
        ed_ptp = findViewById(R.id.ed_ptp);
        ed_next_session_date = findViewById(R.id.ed_next_session_date);
        ed_next_session_time = findViewById(R.id.ed_next_session_time);

        rb_status1 = findViewById(R.id.rb_status1);
        rb_status2 = findViewById(R.id.rb_status2);
        rb_status3 = findViewById(R.id.rb_status3);
        rb_status4 = findViewById(R.id.rb_status4);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview_end);

        Initialization();

        Intent getcnicno = getIntent();
        cnic_no = getcnicno.getExtras().getString("cnic_no");
        training = getcnicno.getExtras().getString("training");
        pretest_result = getcnicno.getExtras().getString("pretest_result");
        posttest_result = getcnicno.getExtras().getString("posttest_result");
        ptp = getcnicno.getExtras().getDouble("ptp");
        ed_cnic_no.setText(cnic_no);
        ed_training.setText(training);
        ed_pretest_result.setText(pretest_result);
        ed_posttest_result.setText(posttest_result);
        ed_ptp.setText(String.valueOf(ptp));
        ed_cnic_no.setEnabled(false);
        ed_training.setEnabled(false);
        ed_pretest_result.setEnabled(false);
        ed_posttest_result.setEnabled(false);
        ed_ptp.setEnabled(false);


//        ed_cent.setText(Integer.parseInt(posttest_result)/100*30);

        /*if (Integer.parseInt(posttest_result) <= 3){
            ed_remarks.setText("Need Attention");
        }else if (Integer.parseInt(posttest_result) <= 6){
            ed_remarks.setText("Satisfactory");
        }else if (Integer.parseInt(posttest_result) <= 9){
            ed_remarks.setText("Good");
        }else if (Integer.parseInt(posttest_result) == 10){
            ed_remarks.setText("Outstanding");
        }
        ed_remarks.setEnabled(false);*/

        /*if ((Integer.parseInt(Global.GDS.GDSPreTest.gdspretestq1)> 0) && (Integer.parseInt(Global.GDS.GDSPostTest.gdsposttestq1)> 0)){

            ed_training.setText("General Danger Signs");
        }*/


        if (ptp <= 30) {
            ed_remarks.setText("Need Attention");
        } else if (ptp <= 60) {
            ed_remarks.setText("Satisfactory");
        } else if (ptp <= 90) {
            ed_remarks.setText("Good");
        } else if (ptp >= 91) {
            ed_remarks.setText("Outstanding");
        }
        ed_remarks.setEnabled(false);


        bCurrentSection = getcnicno.getExtras().getInt("currentSection");


        ed_next_session_date.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sajidDatePickerDialog(v);
            }
        });

        ed_next_session_time.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sajidTimePickerDialog(v);
            }
        });

        if (bCurrentSection > 0) {
            currentSection = bCurrentSection;
            rb_status1.setEnabled(false);

        } else {
            currentSection = 111;
            rb_status2.setEnabled(false);
            rb_status3.setEnabled(false);
            rb_status4.setEnabled(false);
        }

        btn_submit.setOnClickListener(this);
    }


    public void sajidDatePickerDialog(View v) {
        DialogFragment newFragment = new InterviewEnd.DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void sajidTimePickerDialog(View v) {
        DialogFragment newFragment = new InterviewEnd.TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    @Override
    public void onClick(View view) {

        if (validateField() == false) {
            Toast.makeText(this, "Required fields are missing", Toast.LENGTH_LONG).show();
            return;
        }


        Date EDateTime = Calendar.getInstance().getTime();
        SimpleDateFormat Dateformat = new SimpleDateFormat("dd-MMM-yyyy");
        SimpleDateFormat Timeformat = new SimpleDateFormat("HH:mm:ss");
        String EToday = Dateformat.format(EDateTime);
        String ETime = Timeformat.format(EDateTime);

        Session_End_Date = EToday;
        Session_End_Time = ETime;

//        Toast.makeText(this,EToday +" "+ ETime,Toast.LENGTH_LONG).show();

        value_assignment();
        insert_data();

        /*//Toast.makeText(this, Q1311, Toast.LENGTH_LONG).show();


        DBHelper db = new DBHelper(this);

        ContentValues values = new ContentValues();
        values.put(Global.GS.Q1101_Q1610.Q1309, Q1309);
        values.put(Global.GS.Q1101_Q1610.Q1310, Q1310);
        values.put(Global.GS.Q1101_Q1610.Q1311, Q1311);
        values.put(Global.GS.Q1101_Q1610.currentSection, currentSection);

        Long res = db.updateData("Q1101_Q1610", values, cnic);


        if (res > 0) {

            Toast.makeText(this, "Thank you", Toast.LENGTH_LONG).show();

            Intent c = new Intent(this, MainActivity.class);
            startActivity(c);

        } else {

            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
        }
*/
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);

        this.finish();
        Toast.makeText(this, "You Have Done " + training + " at " + EToday + " " + ETime, Toast.LENGTH_LONG).show();


    }

    void value_assignment() {


        /*Calendar cdt = Calendar.getInstance();
        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String formattedDate = dt.format(cdt.getTime());
        String[] dtf = formattedDate.split(" ");

        if (dtf[0].length() > 0){

            Q1309 = dtf[0].trim();
        }

        if (dtf[1].length() > 0){

            Q1310 = dtf[1].trim();
        }

        Q1311 = "-1";*/

        STATUS = "0";

        if (ed_cnic_no.getText().toString().length() > 0) {
            cnic_no = ed_cnic_no.getText().toString().trim();
        }

        if (ed_training.getText().toString().length() > 0) {
            training = ed_training.getText().toString().trim();
        }

        if (ed_pretest_result.getText().toString().length() > 0) {
            pretest_result = ed_pretest_result.getText().toString().trim();
        }

        if (ed_posttest_result.getText().toString().length() > 0) {
            posttest_result = ed_posttest_result.getText().toString().trim();
        }

        if (ed_ptp.getText().toString().length() > 0) {
            posttest_percent = ed_ptp.getText().toString().trim();
        }

        if (ed_remarks.getText().toString().length() > 0) {
            Remarks = ed_remarks.getText().toString().trim();
        }

        if (ed_next_session_date.getText().toString().length() > 0) {
            next_session_date = ed_next_session_date.getText().toString().trim();
        }

        if (ed_next_session_time.getText().toString().length() > 0) {
            next_session_time = ed_next_session_time.getText().toString().trim();
        }


        if (rb_status1.isChecked()) {
            training_status = "1";
        } else if (rb_status2.isChecked()) {
            training_status = "2";
        } else if (rb_status3.isChecked()) {
            training_status = "3";
        } else if (rb_status4.isChecked()) {
            training_status = "4";
        }

    }

    void insert_data() {

        String query = "insert into Session_End("

                + Session_End.fk_id + ","
                + Global.Session_End.cnic_no + ","
                + Global.Session_End.training + ","
                + Global.Session_End.pretest_result + ","
                + Global.Session_End.posttest_result + ","
                + Global.Session_End.posttest_percent + ","
                + Global.Session_End.Remarks + ","
                + Global.Session_End.next_session_date + ","
                + Global.Session_End.next_session_time + ","
                + Global.Session_End.training_status + ","
                + Global.Session_End.Session_End_Date + ","
                + Global.Session_End.Session_End_Time + ","
                + Global.Session_End.STATUS + ")" +

                " values ('" +

                Session_Start.pk_id + "','" +
                cnic_no + "','" +
                training + "','" +
                pretest_result + "','" +
                posttest_result + "','" +
                posttest_percent + "','" +
                Remarks + "','" +
                next_session_date + "','" +
                next_session_time + "','" +
                training_status + "','" +
                Session_End_Date + "','" +
                Session_End_Time + "','" +
                STATUS + "')";

        query = String.format(query);

        LocalDataManager Lm = new LocalDataManager(this);

        LocalDataManager.database.execSQL(query);

        Toast.makeText(this, training + " Session data inserted Successfully", Toast.LENGTH_SHORT).show();

    }

    boolean validateField() {

        if (Gothrough.IamHiden(ll_cnic) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_result) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_next_session) == false) {
            return false;
        }

        return Gothrough.IamHiden(ll_session_status) != false;
    }

    public void onBackPressed() {
        Toast.makeText(this, "You are not allowed to go on back screen SORRY!!! \nIf you want to do so PLEASE CONTACT Dr. Samia", Toast.LENGTH_LONG).show();
    }

    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            ed_next_session_date.setText(day + "-" + (month + 1) + "-" + year);
        }
    }

    public static class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            ed_next_session_time.setText(hourOfDay + ":" + minute);
        }
    }

}
