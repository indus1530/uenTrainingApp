package com.example.abdulsajid.mnchtraining.PSBI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abdulsajid.mnchtraining.InterviewEnd;
import com.example.abdulsajid.mnchtraining.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import Global.PSBI.PSBIPostTest;
import Global.Session_Start;
import data.LocalDataManager;
import utils.Gothrough;

public class PsbiPostTest extends AppCompatActivity implements RadioButton.OnCheckedChangeListener, View.OnClickListener {

    //Declaration
    TextView
            txt_psbiposttestq1,
            txt_psbiposttestq2,
            txt_psbiposttestq3,
            txt_psbiposttestq5;

    Button
            btn_psbiposttestsubmit;

    LinearLayout
            ll_cnic,
            ll_pretest_result,
            ll_psbiposttestq1,
            ll_psbiposttestq2,
            ll_psbiposttestq3,
            ll_psbiposttestq4,
            ll_psbiposttestq5,
            ll_psbiposttestq6,
            ll_psbiposttestq7;


    RadioButton
            rb_psbiposttestq1a1,
            rb_psbiposttestq1a2,
            rb_psbiposttestq1a3,
            rb_psbiposttestq1a4,
            rb_psbiposttestq2a1,
            rb_psbiposttestq2a2,
            rb_psbiposttestq2a3,
            rb_psbiposttestq2a4,
            rb_psbiposttestq3a1,
            rb_psbiposttestq3a2,
            rb_psbiposttestq3a3,
            rb_psbiposttestq3a4,
            rb_psbiposttestq4a1,
            rb_psbiposttestq4a2,
            rb_psbiposttestq4a3,
            rb_psbiposttestq4a4,
            rb_psbiposttestq5a1,
            rb_psbiposttestq5a2,
            rb_psbiposttestq5a3,
            rb_psbiposttestq5a4,
            rb_psbiposttestq6a1,
            rb_psbiposttestq6a2,
            rb_psbiposttestq6a3,
            rb_psbiposttestq6a4,
            rb_psbiposttestq7a1,
            rb_psbiposttestq7a2,
            rb_psbiposttestq7a3,
            rb_psbiposttestq7a4;

    EditText
            ed_cnic_no,
            ed_pretest_result;

    String
            cnic_no,
            psbiposttest_date,
            psbiposttest_time,
            psbiposttestq1,
            psbiposttestq2,
            psbiposttestq3,
            psbiposttestq4,
            psbiposttestq5,
            psbiposttestq6,
            psbiposttestq7,
            pretest_result,
            posttest_result,
            STATUS;

    int currentSection;
    double ptp;

    void Initialization() {
        ll_cnic = findViewById(R.id.ll_cnic);
        ed_cnic_no = findViewById(R.id.ed_cnic_no);
        ll_pretest_result = findViewById(R.id.ll_pretest_result);
        ed_pretest_result = findViewById(R.id.ed_pretest_result);

        btn_psbiposttestsubmit = findViewById(R.id.btn_psbiposttestsubmit);

        ll_psbiposttestq1 = findViewById(R.id.ll_psbiposttestq1);
        ll_psbiposttestq2 = findViewById(R.id.ll_psbiposttestq2);
        ll_psbiposttestq3 = findViewById(R.id.ll_psbiposttestq3);
        ll_psbiposttestq4 = findViewById(R.id.ll_psbiposttestq4);
        ll_psbiposttestq5 = findViewById(R.id.ll_psbiposttestq5);
        ll_psbiposttestq6 = findViewById(R.id.ll_psbiposttestq6);
        ll_psbiposttestq7 = findViewById(R.id.ll_psbiposttestq7);

        txt_psbiposttestq1 = findViewById(R.id.txt_psbiposttestq1);
        txt_psbiposttestq2 = findViewById(R.id.txt_psbiposttestq2);
        txt_psbiposttestq3 = findViewById(R.id.txt_psbiposttestq3);
        txt_psbiposttestq5 = findViewById(R.id.txt_psbiposttestq5);

        rb_psbiposttestq1a1 = findViewById(R.id.rb_psbiposttestq1a1);
        rb_psbiposttestq1a2 = findViewById(R.id.rb_psbiposttestq1a2);
        rb_psbiposttestq1a3 = findViewById(R.id.rb_psbiposttestq1a3);
        rb_psbiposttestq1a4 = findViewById(R.id.rb_psbiposttestq1a4);
        rb_psbiposttestq2a1 = findViewById(R.id.rb_psbiposttestq2a1);
        rb_psbiposttestq2a2 = findViewById(R.id.rb_psbiposttestq2a2);
        rb_psbiposttestq2a3 = findViewById(R.id.rb_psbiposttestq2a3);
        rb_psbiposttestq2a4 = findViewById(R.id.rb_psbiposttestq2a4);
        rb_psbiposttestq3a1 = findViewById(R.id.rb_psbiposttestq3a1);
        rb_psbiposttestq3a2 = findViewById(R.id.rb_psbiposttestq3a2);
        rb_psbiposttestq3a3 = findViewById(R.id.rb_psbiposttestq3a3);
        rb_psbiposttestq3a4 = findViewById(R.id.rb_psbiposttestq3a4);
        rb_psbiposttestq4a1 = findViewById(R.id.rb_psbiposttestq4a1);
        rb_psbiposttestq4a2 = findViewById(R.id.rb_psbiposttestq4a2);
        rb_psbiposttestq4a3 = findViewById(R.id.rb_psbiposttestq4a3);
        rb_psbiposttestq4a4 = findViewById(R.id.rb_psbiposttestq4a4);
        rb_psbiposttestq5a1 = findViewById(R.id.rb_psbiposttestq5a1);
        rb_psbiposttestq5a2 = findViewById(R.id.rb_psbiposttestq5a2);
        rb_psbiposttestq5a3 = findViewById(R.id.rb_psbiposttestq5a3);
        rb_psbiposttestq5a4 = findViewById(R.id.rb_psbiposttestq5a4);
        rb_psbiposttestq6a1 = findViewById(R.id.rb_psbiposttestq6a1);
        rb_psbiposttestq6a2 = findViewById(R.id.rb_psbiposttestq6a2);
        rb_psbiposttestq6a3 = findViewById(R.id.rb_psbiposttestq6a3);
        rb_psbiposttestq6a4 = findViewById(R.id.rb_psbiposttestq6a4);
        rb_psbiposttestq7a1 = findViewById(R.id.rb_psbiposttestq7a1);
        rb_psbiposttestq7a2 = findViewById(R.id.rb_psbiposttestq7a2);
        rb_psbiposttestq7a3 = findViewById(R.id.rb_psbiposttestq7a3);
        rb_psbiposttestq7a4 = findViewById(R.id.rb_psbiposttestq7a4);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psbi_post_test);

        Initialization();
        events_call();

        Intent getcnicno = getIntent();
        cnic_no = getcnicno.getExtras().getString("cnic_no");
        pretest_result = getcnicno.getExtras().getString("pretest_result");
        ed_cnic_no.setText(cnic_no);
        ed_pretest_result.setText(pretest_result);
        ed_cnic_no.setEnabled(false);
        ed_pretest_result.setEnabled(false);

        Date SDateTime = Calendar.getInstance().getTime();
        SimpleDateFormat Dateformat = new SimpleDateFormat("dd-MMM-yyyy");
        SimpleDateFormat Timeformat = new SimpleDateFormat("HH:mm:ss");
        String SToday = Dateformat.format(SDateTime);
        String STime = Timeformat.format(SDateTime);

        psbiposttest_date = SToday;
        psbiposttest_time = STime;
    }

    @Override
    public void onClick(View view) {

        if (validateField() == false) {
            Toast.makeText(this, "Required fields are missing", Toast.LENGTH_LONG).show();
            return;
        }

        value_assignment();
        insert_data();

        Intent intent = new Intent(PsbiPostTest.this, InterviewEnd.class);
        intent.putExtra("cnic_no", cnic_no);
        intent.putExtra("training", "Possible Serious Bacterial Infection");
        intent.putExtra("pretest_result", pretest_result);
        intent.putExtra("posttest_result", posttest_result);
        intent.putExtra("ptp", ptp);
        startActivity(intent);
        this.finish();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {


        //PSBI-Q1  
        if (compoundButton.getId() == R.id.rb_psbiposttestq1a1
                || compoundButton.getId() == R.id.rb_psbiposttestq1a2
                || compoundButton.getId() == R.id.rb_psbiposttestq1a3
                || compoundButton.getId() == R.id.rb_psbiposttestq1a4) {

            if (rb_psbiposttestq1a1.isChecked()) {
                txt_psbiposttestq1.clearComposingText();
                String styledText = "1- Skin pustules among young infants are the sign of <font color='blue'><b><i>Jaundice</i></b></font>.";
                txt_psbiposttestq1.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_psbiposttestq1a2.isChecked()) {
                txt_psbiposttestq1.clearComposingText();
                String styledText = "1- Skin pustules among young infants are the sign of <font color='blue'><b><i>Local Bacterial Infection</i></b></font>.";
                txt_psbiposttestq1.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_psbiposttestq1a3.isChecked()) {
                txt_psbiposttestq1.clearComposingText();
                String styledText = "1- Skin pustules among young infants are the sign of <font color='blue'><b><i>Thrush</i></b></font>.";
                txt_psbiposttestq1.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_psbiposttestq1a4.isChecked()) {
                txt_psbiposttestq1.clearComposingText();
                String styledText = "1- Skin pustules among young infants are the sign of <font color='blue'><b><i>Diarrhea</i></b></font>.";
                txt_psbiposttestq1.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }


        //PSBI-Q2  
        if (compoundButton.getId() == R.id.rb_psbiposttestq2a1
                || compoundButton.getId() == R.id.rb_psbiposttestq2a2
                || compoundButton.getId() == R.id.rb_psbiposttestq2a3
                || compoundButton.getId() == R.id.rb_psbiposttestq2a4) {

            if (rb_psbiposttestq2a1.isChecked()) {
                txt_psbiposttestq2.clearComposingText();
                String styledText = "2- The follow-up time for sick young infants with diarrhea and pneumonia is <font color='blue'><b><i>2nd Day</i></b></font>.";
                txt_psbiposttestq2.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_psbiposttestq2a2.isChecked()) {
                txt_psbiposttestq2.clearComposingText();
                String styledText = "2- The follow-up time for sick young infants with diarrhea and pneumonia is <font color='blue'><b><i>3rd Day</i></b></font>.";
                txt_psbiposttestq2.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_psbiposttestq2a3.isChecked()) {
                txt_psbiposttestq2.clearComposingText();
                String styledText = "2- The follow-up time for sick young infants with diarrhea and pneumonia is <font color='blue'><b><i>4th Day</i></b></font>.";
                txt_psbiposttestq2.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_psbiposttestq2a4.isChecked()) {
                txt_psbiposttestq2.clearComposingText();
                String styledText = "2- The follow-up time for sick young infants with diarrhea and pneumonia is <font color='blue'><b><i>5th Day</i></b></font>.";
                txt_psbiposttestq2.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }


        //PSBI-Q3  
        if (compoundButton.getId() == R.id.rb_psbiposttestq3a1
                || compoundButton.getId() == R.id.rb_psbiposttestq3a2
                || compoundButton.getId() == R.id.rb_psbiposttestq3a3
                || compoundButton.getId() == R.id.rb_psbiposttestq3a4) {

            if (rb_psbiposttestq3a1.isChecked()) {
                txt_psbiposttestq3.clearComposingText();
                String styledText = "3- Persistent vomiting is defined as vomiting following three attempts to feed the infant within <font color='blue'><b><i>10 minutes</i></b></font>, and the infant vomits after each attempt.";
                txt_psbiposttestq3.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_psbiposttestq3a2.isChecked()) {
                txt_psbiposttestq3.clearComposingText();
                String styledText = "3- Persistent vomiting is defined as vomiting following three attempts to feed the infant within <font color='blue'><b><i>20 minutes</i></b></font>, and the infant vomits after each attempt.";
                txt_psbiposttestq3.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_psbiposttestq3a3.isChecked()) {
                txt_psbiposttestq3.clearComposingText();
                String styledText = "3- Persistent vomiting is defined as vomiting following three attempts to feed the infant within <font color='blue'><b><i>30 minutes</i></b></font>, and the infant vomits after each attempt.";
                txt_psbiposttestq3.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_psbiposttestq3a4.isChecked()) {
                txt_psbiposttestq3.clearComposingText();
                String styledText = "3- Persistent vomiting is defined as vomiting following three attempts to feed the infant within <font color='blue'><b><i>40 minutes</i></b></font>, and the infant vomits after each attempt.";
                txt_psbiposttestq3.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }


        //PSBI-Q5  
        if (compoundButton.getId() == R.id.rb_psbiposttestq5a1
                || compoundButton.getId() == R.id.rb_psbiposttestq5a2
                || compoundButton.getId() == R.id.rb_psbiposttestq5a3
                || compoundButton.getId() == R.id.rb_psbiposttestq5a4) {

            if (rb_psbiposttestq5a1.isChecked()) {
                txt_psbiposttestq5.clearComposingText();
                String styledText = "5- Pre referral treatment for severe Pneumonia or very severe disease in young infant up to 2 months require first dose of an appropriate <font color='blue'><b><i>Oral</i></b></font> antibiotic.";
                txt_psbiposttestq5.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_psbiposttestq5a2.isChecked()) {
                txt_psbiposttestq5.clearComposingText();
                String styledText = "5- Pre referral treatment for severe Pneumonia or very severe disease in young infant up to 2 months require first dose of an appropriate <font color='blue'><b><i>Intravenous</i></b></font> antibiotic.";
                txt_psbiposttestq5.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_psbiposttestq5a3.isChecked()) {
                txt_psbiposttestq5.clearComposingText();
                String styledText = "5- Pre referral treatment for severe Pneumonia or very severe disease in young infant up to 2 months require first dose of an appropriate <font color='blue'><b><i>Intramuscular</i></b></font> antibiotic.";
                txt_psbiposttestq5.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_psbiposttestq5a4.isChecked()) {
                txt_psbiposttestq5.clearComposingText();
                String styledText = "5- Pre referral treatment for severe Pneumonia or very severe disease in young infant up to 2 months require first dose of an appropriate <font color='blue'><b><i>None of the below</i></b></font> antibiotic.";
                txt_psbiposttestq5.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }

    }

    void events_call() {

        btn_psbiposttestsubmit.setOnClickListener(this);

        rb_psbiposttestq1a1.setOnCheckedChangeListener(this);
        rb_psbiposttestq1a2.setOnCheckedChangeListener(this);
        rb_psbiposttestq1a3.setOnCheckedChangeListener(this);
        rb_psbiposttestq1a4.setOnCheckedChangeListener(this);

        rb_psbiposttestq2a1.setOnCheckedChangeListener(this);
        rb_psbiposttestq2a2.setOnCheckedChangeListener(this);
        rb_psbiposttestq2a3.setOnCheckedChangeListener(this);
        rb_psbiposttestq2a4.setOnCheckedChangeListener(this);

        rb_psbiposttestq3a1.setOnCheckedChangeListener(this);
        rb_psbiposttestq3a2.setOnCheckedChangeListener(this);
        rb_psbiposttestq3a3.setOnCheckedChangeListener(this);
        rb_psbiposttestq3a4.setOnCheckedChangeListener(this);

        rb_psbiposttestq5a1.setOnCheckedChangeListener(this);
        rb_psbiposttestq5a2.setOnCheckedChangeListener(this);
        rb_psbiposttestq5a3.setOnCheckedChangeListener(this);
        rb_psbiposttestq5a4.setOnCheckedChangeListener(this);
    }

    void value_assignment() {

        posttest_result = "0";
        STATUS = "0";
        int temp = 0;

        cnic_no = ed_cnic_no.getText().toString().length() > 0 ? ed_cnic_no.getText().toString().trim() : "0";

        //Q1
        psbiposttestq1 = rb_psbiposttestq1a1.isChecked() ? "1"
                : rb_psbiposttestq1a2.isChecked() ? "2"
                : rb_psbiposttestq1a3.isChecked() ? "3"
                : rb_psbiposttestq1a4.isChecked() ? "4"
                : "-1";
        temp = psbiposttestq1.equals("2") ? temp++ : temp;

        //Q2
        psbiposttestq2 = rb_psbiposttestq2a1.isChecked() ? "1"
                : rb_psbiposttestq2a2.isChecked() ? "2"
                : rb_psbiposttestq2a3.isChecked() ? "3"
                : rb_psbiposttestq2a4.isChecked() ? "4"
                : "-1";
        temp = psbiposttestq2.equals("3") ? temp++ : temp;

        //Q3
        psbiposttestq3 = rb_psbiposttestq3a1.isChecked() ? "1"
                : rb_psbiposttestq3a2.isChecked() ? "2"
                : rb_psbiposttestq3a3.isChecked() ? "3"
                : rb_psbiposttestq3a4.isChecked() ? "4"
                : "-1";
        temp = psbiposttestq3.equals("3") ? temp++ : temp;

        //Q4
        psbiposttestq4 = rb_psbiposttestq4a1.isChecked() ? "1"
                : rb_psbiposttestq4a2.isChecked() ? "2"
                : rb_psbiposttestq4a3.isChecked() ? "3"
                : rb_psbiposttestq4a4.isChecked() ? "4"
                : "-1";
        temp = psbiposttestq4.equals("1") ? temp++ : temp;

        //Q5
        psbiposttestq5 = rb_psbiposttestq5a1.isChecked() ? "1"
                : rb_psbiposttestq5a2.isChecked() ? "2"
                : rb_psbiposttestq5a3.isChecked() ? "3"
                : rb_psbiposttestq5a4.isChecked() ? "4"
                : "-1";
        temp = psbiposttestq5.equals("3") ? temp++ : temp;

        //Q6
        psbiposttestq6 = rb_psbiposttestq6a1.isChecked() ? "1"
                : rb_psbiposttestq6a2.isChecked() ? "2"
                : rb_psbiposttestq6a3.isChecked() ? "3"
                : rb_psbiposttestq6a4.isChecked() ? "4"
                : "-1";
        temp = psbiposttestq6.equals("2") ? temp++ : temp;

        //Q7
        psbiposttestq7 = rb_psbiposttestq7a1.isChecked() ? "1"
                : rb_psbiposttestq7a2.isChecked() ? "2"
                : rb_psbiposttestq7a3.isChecked() ? "3"
                : rb_psbiposttestq7a4.isChecked() ? "4"
                : "-1";
        temp = psbiposttestq7.equals("3") ? temp++ : temp;


        posttest_result = String.valueOf(temp);

        ptp = Math.round(Double.parseDouble(posttest_result) / 7 * 100);
    }

    void insert_data() {
        String query = "insert into PSBIPostTest("

                + PSBIPostTest.fk_id + ","
                + PSBIPostTest.cnic_no + ","
                + PSBIPostTest.psbiposttest_date + ","
                + PSBIPostTest.psbiposttest_time + ","
                + PSBIPostTest.psbiposttestq1 + ","
                + PSBIPostTest.psbiposttestq2 + ","
                + PSBIPostTest.psbiposttestq3 + ","
                + PSBIPostTest.psbiposttestq4 + ","
                + PSBIPostTest.psbiposttestq5 + ","
                + PSBIPostTest.psbiposttestq6 + ","
                + PSBIPostTest.psbiposttestq7 + ","
                + PSBIPostTest.posttest_result + ","
                + Global.PSBI.PSBIPostTest.STATUS + ")" +

                " values ('" +

                Session_Start.pk_id + "','" +
                cnic_no + "','" +
                psbiposttest_date + "','" +
                psbiposttest_time + "','" +
                psbiposttestq1 + "','" +
                psbiposttestq2 + "','" +
                psbiposttestq3 + "','" +
                psbiposttestq4 + "','" +
                psbiposttestq5 + "','" +
                psbiposttestq6 + "','" +
                psbiposttestq7 + "','" +
                posttest_result + "','" +
                STATUS + "')";

        query = String.format(query);

        LocalDataManager Lm = new LocalDataManager(this);

        LocalDataManager.database.execSQL(query);

        Toast.makeText(this, "Post-Test Result Saved. \nYour score is 0" + posttest_result, Toast.LENGTH_SHORT).show();
    }

    boolean validateField() {

        if (Gothrough.IamHiden(ll_cnic) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_psbiposttestq1) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_psbiposttestq2) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_psbiposttestq3) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_psbiposttestq4) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_psbiposttestq5) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_psbiposttestq6) == false) {
            return false;
        }

        return Gothrough.IamHiden(ll_psbiposttestq7) != false;
    }

    public void onBackPressed() {
        Toast.makeText(this, "You are not allowed to go on back screen SORRY!!! \nIf you want to do so PLEASE CONTACT Dr. Samia", Toast.LENGTH_LONG).show();
    }


}
