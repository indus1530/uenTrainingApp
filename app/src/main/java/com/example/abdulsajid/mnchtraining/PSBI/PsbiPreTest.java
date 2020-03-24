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

import com.example.abdulsajid.mnchtraining.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import Global.PSBI.PSBIPretest;
import Global.Session_Start;
import data.LocalDataManager;
import utils.Gothrough;

public class PsbiPreTest extends AppCompatActivity implements RadioButton.OnCheckedChangeListener, View.OnClickListener {

    //Declaration  
    TextView
            txt_psbipretestq1,
            txt_psbipretestq2,
            txt_psbipretestq3,
            txt_psbipretestq5;

    Button
            btn_psbipretestsubmit;

    LinearLayout
            ll_cnic,
            ll_psbipretestq1,
            ll_psbipretestq2,
            ll_psbipretestq3,
            ll_psbipretestq4,
            ll_psbipretestq5,
            ll_psbipretestq6,
            ll_psbipretestq7;


    RadioButton
            rb_psbipretestq1a1,
            rb_psbipretestq1a2,
            rb_psbipretestq1a3,
            rb_psbipretestq1a4,
            rb_psbipretestq2a1,
            rb_psbipretestq2a2,
            rb_psbipretestq2a3,
            rb_psbipretestq2a4,
            rb_psbipretestq3a1,
            rb_psbipretestq3a2,
            rb_psbipretestq3a3,
            rb_psbipretestq3a4,
            rb_psbipretestq4a1,
            rb_psbipretestq4a2,
            rb_psbipretestq4a3,
            rb_psbipretestq4a4,
            rb_psbipretestq5a1,
            rb_psbipretestq5a2,
            rb_psbipretestq5a3,
            rb_psbipretestq5a4,
            rb_psbipretestq6a1,
            rb_psbipretestq6a2,
            rb_psbipretestq6a3,
            rb_psbipretestq6a4,
            rb_psbipretestq7a1,
            rb_psbipretestq7a2,
            rb_psbipretestq7a3,
            rb_psbipretestq7a4;

    EditText
            ed_cnic_no;

    String
            cnic_no,
            psbipretest_date,
            psbipretest_time,
            psbipretestq1,
            psbipretestq2,
            psbipretestq3,
            psbipretestq4,
            psbipretestq5,
            psbipretestq6,
            psbipretestq7,
            pretest_result,
            STATUS;

    int currentSection;

    void Initialization() {

        ed_cnic_no = findViewById(R.id.ed_cnic_no);

        btn_psbipretestsubmit = findViewById(R.id.btn_psbipretestsubmit);

        ll_cnic = findViewById(R.id.ll_cnic);
        ll_psbipretestq1 = findViewById(R.id.ll_psbipretestq1);
        ll_psbipretestq2 = findViewById(R.id.ll_psbipretestq2);
        ll_psbipretestq3 = findViewById(R.id.ll_psbipretestq3);
        ll_psbipretestq4 = findViewById(R.id.ll_psbipretestq4);
        ll_psbipretestq5 = findViewById(R.id.ll_psbipretestq5);
        ll_psbipretestq6 = findViewById(R.id.ll_psbipretestq6);
        ll_psbipretestq7 = findViewById(R.id.ll_psbipretestq7);

        txt_psbipretestq1 = findViewById(R.id.txt_psbipretestq1);
        txt_psbipretestq2 = findViewById(R.id.txt_psbipretestq2);
        txt_psbipretestq3 = findViewById(R.id.txt_psbipretestq3);
        txt_psbipretestq5 = findViewById(R.id.txt_psbipretestq5);

        rb_psbipretestq1a1 = findViewById(R.id.rb_psbipretestq1a1);
        rb_psbipretestq1a2 = findViewById(R.id.rb_psbipretestq1a2);
        rb_psbipretestq1a3 = findViewById(R.id.rb_psbipretestq1a3);
        rb_psbipretestq1a4 = findViewById(R.id.rb_psbipretestq1a4);
        rb_psbipretestq2a1 = findViewById(R.id.rb_psbipretestq2a1);
        rb_psbipretestq2a2 = findViewById(R.id.rb_psbipretestq2a2);
        rb_psbipretestq2a3 = findViewById(R.id.rb_psbipretestq2a3);
        rb_psbipretestq2a4 = findViewById(R.id.rb_psbipretestq2a4);
        rb_psbipretestq3a1 = findViewById(R.id.rb_psbipretestq3a1);
        rb_psbipretestq3a2 = findViewById(R.id.rb_psbipretestq3a2);
        rb_psbipretestq3a3 = findViewById(R.id.rb_psbipretestq3a3);
        rb_psbipretestq3a4 = findViewById(R.id.rb_psbipretestq3a4);
        rb_psbipretestq4a1 = findViewById(R.id.rb_psbipretestq4a1);
        rb_psbipretestq4a2 = findViewById(R.id.rb_psbipretestq4a2);
        rb_psbipretestq4a3 = findViewById(R.id.rb_psbipretestq4a3);
        rb_psbipretestq4a4 = findViewById(R.id.rb_psbipretestq4a4);
        rb_psbipretestq5a1 = findViewById(R.id.rb_psbipretestq5a1);
        rb_psbipretestq5a2 = findViewById(R.id.rb_psbipretestq5a2);
        rb_psbipretestq5a3 = findViewById(R.id.rb_psbipretestq5a3);
        rb_psbipretestq5a4 = findViewById(R.id.rb_psbipretestq5a4);
        rb_psbipretestq6a1 = findViewById(R.id.rb_psbipretestq6a1);
        rb_psbipretestq6a2 = findViewById(R.id.rb_psbipretestq6a2);
        rb_psbipretestq6a3 = findViewById(R.id.rb_psbipretestq6a3);
        rb_psbipretestq6a4 = findViewById(R.id.rb_psbipretestq6a4);
        rb_psbipretestq7a1 = findViewById(R.id.rb_psbipretestq7a1);
        rb_psbipretestq7a2 = findViewById(R.id.rb_psbipretestq7a2);
        rb_psbipretestq7a3 = findViewById(R.id.rb_psbipretestq7a3);
        rb_psbipretestq7a4 = findViewById(R.id.rb_psbipretestq7a4);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psbi_pre_test);

        Initialization();
        events_call();

        Intent getcnicno = getIntent();
        cnic_no = getcnicno.getExtras().getString("cnic_no");
        ed_cnic_no.setText(cnic_no);
        ed_cnic_no.setEnabled(false);

        Date SDateTime = Calendar.getInstance().getTime();
        SimpleDateFormat Dateformat = new SimpleDateFormat("dd-MMM-yyyy");
        SimpleDateFormat Timeformat = new SimpleDateFormat("HH:mm:ss");
        String SToday = Dateformat.format(SDateTime);
        String STime = Timeformat.format(SDateTime);

        psbipretest_date = SToday;
        psbipretest_time = STime;
    }

    @Override
    public void onClick(View view) {
        if (validateField() == false) {
            Toast.makeText(this, "Required fields are missing", Toast.LENGTH_LONG).show();
            return;
        }

        value_assignment();
        insert_data();

        Intent intent = new Intent(PsbiPreTest.this, PsbiTraining.class);
        intent.putExtra("cnic_no", cnic_no);
        intent.putExtra("pretest_result", pretest_result);
        startActivity(intent);
        this.finish();

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {


        //PSBI-Q1  
        if (compoundButton.getId() == R.id.rb_psbipretestq1a1
                || compoundButton.getId() == R.id.rb_psbipretestq1a2
                || compoundButton.getId() == R.id.rb_psbipretestq1a3
                || compoundButton.getId() == R.id.rb_psbipretestq1a4) {

            if (rb_psbipretestq1a1.isChecked()) {
                txt_psbipretestq1.clearComposingText();
                String styledText = "1- Skin pustules among young infants are the sign of <font color='blue'><b><i>Jaundice</i></b></font>.";
                txt_psbipretestq1.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_psbipretestq1a2.isChecked()) {
                txt_psbipretestq1.clearComposingText();
                String styledText = "1- Skin pustules among young infants are the sign of <font color='blue'><b><i>Local Bacterial Infection</i></b></font>.";
                txt_psbipretestq1.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_psbipretestq1a3.isChecked()) {
                txt_psbipretestq1.clearComposingText();
                String styledText = "1- Skin pustules among young infants are the sign of <font color='blue'><b><i>Thrush</i></b></font>.";
                txt_psbipretestq1.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_psbipretestq1a4.isChecked()) {
                txt_psbipretestq1.clearComposingText();
                String styledText = "1- Skin pustules among young infants are the sign of <font color='blue'><b><i>Diarrhea</i></b></font>.";
                txt_psbipretestq1.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }


        //PSBI-Q2  
        if (compoundButton.getId() == R.id.rb_psbipretestq2a1
                || compoundButton.getId() == R.id.rb_psbipretestq2a2
                || compoundButton.getId() == R.id.rb_psbipretestq2a3
                || compoundButton.getId() == R.id.rb_psbipretestq2a4) {

            if (rb_psbipretestq2a1.isChecked()) {
                txt_psbipretestq2.clearComposingText();
                String styledText = "2- The follow-up time for sick young infants with diarrhea and pneumonia is <font color='blue'><b><i>2nd Day</i></b></font>.";
                txt_psbipretestq2.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_psbipretestq2a2.isChecked()) {
                txt_psbipretestq2.clearComposingText();
                String styledText = "2- The follow-up time for sick young infants with diarrhea and pneumonia is <font color='blue'><b><i>3rd Day</i></b></font>.";
                txt_psbipretestq2.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_psbipretestq2a3.isChecked()) {
                txt_psbipretestq2.clearComposingText();
                String styledText = "2- The follow-up time for sick young infants with diarrhea and pneumonia is <font color='blue'><b><i>4th Day</i></b></font>.";
                txt_psbipretestq2.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_psbipretestq2a4.isChecked()) {
                txt_psbipretestq2.clearComposingText();
                String styledText = "2- The follow-up time for sick young infants with diarrhea and pneumonia is <font color='blue'><b><i>5th Day</i></b></font>.";
                txt_psbipretestq2.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }


        //PSBI-Q3  
        if (compoundButton.getId() == R.id.rb_psbipretestq3a1
                || compoundButton.getId() == R.id.rb_psbipretestq3a2
                || compoundButton.getId() == R.id.rb_psbipretestq3a3
                || compoundButton.getId() == R.id.rb_psbipretestq3a4) {

            if (rb_psbipretestq3a1.isChecked()) {
                txt_psbipretestq3.clearComposingText();
                String styledText = "3- Persistent vomiting is defined as vomiting following three attempts to feed the infant within <font color='blue'><b><i>10 minutes</i></b></font>, and the infant vomits after each attempt.";
                txt_psbipretestq3.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_psbipretestq3a2.isChecked()) {
                txt_psbipretestq3.clearComposingText();
                String styledText = "3- Persistent vomiting is defined as vomiting following three attempts to feed the infant within <font color='blue'><b><i>20 minutes</i></b></font>, and the infant vomits after each attempt.";
                txt_psbipretestq3.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_psbipretestq3a3.isChecked()) {
                txt_psbipretestq3.clearComposingText();
                String styledText = "3- Persistent vomiting is defined as vomiting following three attempts to feed the infant within <font color='blue'><b><i>30 minutes</i></b></font>, and the infant vomits after each attempt.";
                txt_psbipretestq3.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_psbipretestq3a4.isChecked()) {
                txt_psbipretestq3.clearComposingText();
                String styledText = "3- Persistent vomiting is defined as vomiting following three attempts to feed the infant within <font color='blue'><b><i>40 minutes</i></b></font>, and the infant vomits after each attempt.";
                txt_psbipretestq3.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }


        //PSBI-Q5  
        if (compoundButton.getId() == R.id.rb_psbipretestq5a1
                || compoundButton.getId() == R.id.rb_psbipretestq5a2
                || compoundButton.getId() == R.id.rb_psbipretestq5a3
                || compoundButton.getId() == R.id.rb_psbipretestq5a4) {

            if (rb_psbipretestq5a1.isChecked()) {
                txt_psbipretestq5.clearComposingText();
                String styledText = "5- Pre referral treatment for severe Pneumonia or very severe disease in young infant up to 2 months require first dose of an appropriate <font color='blue'><b><i>Oral</i></b></font> antibiotic.";
                txt_psbipretestq5.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_psbipretestq5a2.isChecked()) {
                txt_psbipretestq5.clearComposingText();
                String styledText = "5- Pre referral treatment for severe Pneumonia or very severe disease in young infant up to 2 months require first dose of an appropriate <font color='blue'><b><i>Intravenous</i></b></font> antibiotic.";
                txt_psbipretestq5.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_psbipretestq5a3.isChecked()) {
                txt_psbipretestq5.clearComposingText();
                String styledText = "5- Pre referral treatment for severe Pneumonia or very severe disease in young infant up to 2 months require first dose of an appropriate <font color='blue'><b><i>Intramuscular</i></b></font> antibiotic.";
                txt_psbipretestq5.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_psbipretestq5a4.isChecked()) {
                txt_psbipretestq5.clearComposingText();
                String styledText = "5- Pre referral treatment for severe Pneumonia or very severe disease in young infant up to 2 months require first dose of an appropriate <font color='blue'><b><i>None of the below</i></b></font> antibiotic.";
                txt_psbipretestq5.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }

    }

    void events_call() {

        btn_psbipretestsubmit.setOnClickListener(this);

        rb_psbipretestq1a1.setOnCheckedChangeListener(this);
        rb_psbipretestq1a2.setOnCheckedChangeListener(this);
        rb_psbipretestq1a3.setOnCheckedChangeListener(this);
        rb_psbipretestq1a4.setOnCheckedChangeListener(this);

        rb_psbipretestq2a1.setOnCheckedChangeListener(this);
        rb_psbipretestq2a2.setOnCheckedChangeListener(this);
        rb_psbipretestq2a3.setOnCheckedChangeListener(this);
        rb_psbipretestq2a4.setOnCheckedChangeListener(this);

        rb_psbipretestq3a1.setOnCheckedChangeListener(this);
        rb_psbipretestq3a2.setOnCheckedChangeListener(this);
        rb_psbipretestq3a3.setOnCheckedChangeListener(this);
        rb_psbipretestq3a4.setOnCheckedChangeListener(this);

        rb_psbipretestq5a1.setOnCheckedChangeListener(this);
        rb_psbipretestq5a2.setOnCheckedChangeListener(this);
        rb_psbipretestq5a3.setOnCheckedChangeListener(this);
        rb_psbipretestq5a4.setOnCheckedChangeListener(this);
    }

    void value_assignment() {

        pretest_result = "0";
        STATUS = "0";
        int temp = 0;

        cnic_no = ed_cnic_no.getText().toString().length() > 0 ? ed_cnic_no.getText().toString().trim() : "0";

        //Q1
        if (rb_psbipretestq1a1.isChecked()) {
            psbipretestq1 = "1";
        }
        if (rb_psbipretestq1a2.isChecked()) {
            psbipretestq1 = "2";
            temp = temp + 1;
        }
        if (rb_psbipretestq1a3.isChecked()) {
            psbipretestq1 = "3";
        }
        if (rb_psbipretestq1a4.isChecked()) {
            psbipretestq1 = "4";
        }

        //Q2
        if (rb_psbipretestq2a1.isChecked()) {
            psbipretestq2 = "1";
        }
        if (rb_psbipretestq2a2.isChecked()) {
            psbipretestq2 = "2";
        }
        if (rb_psbipretestq2a3.isChecked()) {
            psbipretestq2 = "3";
            temp = temp + 1;
        }
        if (rb_psbipretestq2a4.isChecked()) {
            psbipretestq2 = "4";
        }

        //Q3
        if (rb_psbipretestq3a1.isChecked()) {
            psbipretestq3 = "1";
        }
        if (rb_psbipretestq3a2.isChecked()) {
            psbipretestq3 = "2";
        }
        if (rb_psbipretestq3a3.isChecked()) {
            psbipretestq3 = "3";
            temp = temp + 1;
        }
        if (rb_psbipretestq3a4.isChecked()) {
            psbipretestq3 = "4";
        }

        //Q4
        if (rb_psbipretestq4a1.isChecked()) {
            psbipretestq4 = "1";
            temp = temp + 1;
        }
        if (rb_psbipretestq4a2.isChecked()) {
            psbipretestq4 = "2";
        }
        if (rb_psbipretestq4a3.isChecked()) {
            psbipretestq4 = "3";
        }
        if (rb_psbipretestq4a4.isChecked()) {
            psbipretestq4 = "4";
        }

        //Q5
        if (rb_psbipretestq5a1.isChecked()) {
            psbipretestq5 = "1";
        }
        if (rb_psbipretestq5a2.isChecked()) {
            psbipretestq5 = "2";
        }
        if (rb_psbipretestq5a3.isChecked()) {
            psbipretestq5 = "3";
            temp = temp + 1;
        }
        if (rb_psbipretestq5a4.isChecked()) {
            psbipretestq5 = "4";
        }

        //Q6
        if (rb_psbipretestq6a1.isChecked()) {
            psbipretestq6 = "1";
        }
        if (rb_psbipretestq6a2.isChecked()) {
            psbipretestq6 = "2";
            temp = temp + 1;
        }
        if (rb_psbipretestq6a3.isChecked()) {
            psbipretestq6 = "3";
        }
        if (rb_psbipretestq6a4.isChecked()) {
            psbipretestq6 = "4";
        }

        //Q7
        if (rb_psbipretestq7a1.isChecked()) {
            psbipretestq7 = "1";
        }
        if (rb_psbipretestq7a2.isChecked()) {
            psbipretestq7 = "2";
        }
        if (rb_psbipretestq7a3.isChecked()) {
            psbipretestq7 = "3";
            temp = temp + 1;
        }
        if (rb_psbipretestq7a4.isChecked()) {
            psbipretestq7 = "4";
        }

        pretest_result = String.valueOf(temp);
    }

    void insert_data() {
        String query = "insert into PSBIPretest("

                + PSBIPretest.fk_id + ","
                + Global.PSBI.PSBIPretest.cnic_no + ","
                + PSBIPretest.psbipretest_date + ","
                + PSBIPretest.psbipretest_time + ","
                + Global.PSBI.PSBIPretest.psbipretestq1 + ","
                + Global.PSBI.PSBIPretest.psbipretestq2 + ","
                + Global.PSBI.PSBIPretest.psbipretestq3 + ","
                + Global.PSBI.PSBIPretest.psbipretestq4 + ","
                + Global.PSBI.PSBIPretest.psbipretestq5 + ","
                + Global.PSBI.PSBIPretest.psbipretestq6 + ","
                + Global.PSBI.PSBIPretest.psbipretestq7 + ","
                + Global.PSBI.PSBIPretest.pretest_result + ","
                + Global.PSBI.PSBIPretest.STATUS + ")" +

                " values ('" +

                Session_Start.pk_id + "','" +
                cnic_no + "','" +
                psbipretest_date + "','" +
                psbipretest_time + "','" +
                psbipretestq1 + "','" +
                psbipretestq2 + "','" +
                psbipretestq3 + "','" +
                psbipretestq4 + "','" +
                psbipretestq5 + "','" +
                psbipretestq6 + "','" +
                psbipretestq7 + "','" +
                pretest_result + "','" +
                STATUS + "')";

        query = String.format(query);

        LocalDataManager Lm = new LocalDataManager(this);

        LocalDataManager.database.execSQL(query);

        Toast.makeText(this, "Pre-Test Result Saved. \nYour score is 0" + pretest_result, Toast.LENGTH_SHORT).show();
    }

    boolean validateField() {

        if (Gothrough.IamHiden(ll_cnic) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_psbipretestq1) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_psbipretestq2) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_psbipretestq3) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_psbipretestq4) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_psbipretestq5) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_psbipretestq6) == false) {
            return false;
        }

        return Gothrough.IamHiden(ll_psbipretestq7) != false;
    }

    public void onBackPressed() {
        Toast.makeText(this, "You are not allowed to go on back screen SORRY!!! \nIf you want to do so PLEASE CONTACT Dr. Samia", Toast.LENGTH_LONG).show();
    }


}
