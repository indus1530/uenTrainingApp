package com.example.abdulsajid.mnchtraining.CDB;

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

import data.LocalDataManager;
import utils.Gothrough;

public class CdbPostTest extends AppCompatActivity implements RadioButton.OnCheckedChangeListener, View.OnClickListener {

    //Declaration  
    TextView
            txt_cdbposttestq1,
            txt_cdbposttestq2,
            txt_cdbposttestq3,
            txt_cdbposttestq4,
            txt_cdbposttestq5,
            txt_cdbposttestq6,
            txt_cdbposttestq7,
            txt_cdbposttestq8,
            txt_cdbposttestq9,
            txt_cdbposttestq10;

    Button
            btn_cdbposttestsubmit;

    LinearLayout
            ll_cnic,
            ll_pretest_result,
            ll_cdbposttestq1,
            ll_cdbposttestq2,
            ll_cdbposttestq3,
            ll_cdbposttestq4,
            ll_cdbposttestq5,
            ll_cdbposttestq6,
            ll_cdbposttestq7,
            ll_cdbposttestq8,
            ll_cdbposttestq9,
            ll_cdbposttestq10;


    RadioButton
            rb_cdbposttestq1a1,
            rb_cdbposttestq1a2,
            rb_cdbposttestq1a3,
            rb_cdbposttestq1a4,
            rb_cdbposttestq2a1,
            rb_cdbposttestq2a2,
            rb_cdbposttestq2a3,
            rb_cdbposttestq2a4,
            rb_cdbposttestq3a1,
            rb_cdbposttestq3a2,
            rb_cdbposttestq3a3,
            rb_cdbposttestq3a4,
            rb_cdbposttestq4a1,
            rb_cdbposttestq4a2,
            rb_cdbposttestq5a1,
            rb_cdbposttestq5a2,
            rb_cdbposttestq5a3,
            rb_cdbposttestq5a4,
            rb_cdbposttestq6a1,
            rb_cdbposttestq6a2,
            rb_cdbposttestq6a3,
            rb_cdbposttestq6a4,
            rb_cdbposttestq7a1,
            rb_cdbposttestq7a2,
            rb_cdbposttestq7a3,
            rb_cdbposttestq7a4,
            rb_cdbposttestq8a1,
            rb_cdbposttestq8a2,
            rb_cdbposttestq8a3,
            rb_cdbposttestq8a4,
            rb_cdbposttestq9a1,
            rb_cdbposttestq9a2,
            rb_cdbposttestq9a3,
            rb_cdbposttestq9a4,
            rb_cdbposttestq10a1,
            rb_cdbposttestq10a2,
            rb_cdbposttestq10a3,
            rb_cdbposttestq10a4;

    EditText
            ed_cnic_no,
            ed_pretest_result;

    String
            cnic_no,
            cdbposttest_date,
            cdbposttest_time,
            cdbposttestq1,
            cdbposttestq2,
            cdbposttestq3,
            cdbposttestq4,
            cdbposttestq5,
            cdbposttestq6,
            cdbposttestq7,
            cdbposttestq8,
            cdbposttestq9,
            cdbposttestq10,
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

        btn_cdbposttestsubmit = findViewById(R.id.btn_cdbposttestsubmit);

        ll_cdbposttestq1 = findViewById(R.id.ll_cdbposttestq1);
        ll_cdbposttestq2 = findViewById(R.id.ll_cdbposttestq2);
        ll_cdbposttestq3 = findViewById(R.id.ll_cdbposttestq3);
        ll_cdbposttestq4 = findViewById(R.id.ll_cdbposttestq4);
        ll_cdbposttestq5 = findViewById(R.id.ll_cdbposttestq5);
        ll_cdbposttestq6 = findViewById(R.id.ll_cdbposttestq6);
        ll_cdbposttestq7 = findViewById(R.id.ll_cdbposttestq7);
        ll_cdbposttestq8 = findViewById(R.id.ll_cdbposttestq8);
        ll_cdbposttestq9 = findViewById(R.id.ll_cdbposttestq9);
        ll_cdbposttestq10 = findViewById(R.id.ll_cdbposttestq10);

        txt_cdbposttestq1 = findViewById(R.id.txt_cdbposttestq1);
        txt_cdbposttestq2 = findViewById(R.id.txt_cdbposttestq2);
        txt_cdbposttestq3 = findViewById(R.id.txt_cdbposttestq3);
        txt_cdbposttestq4 = findViewById(R.id.txt_cdbposttestq4);
        txt_cdbposttestq5 = findViewById(R.id.txt_cdbposttestq5);
        txt_cdbposttestq6 = findViewById(R.id.txt_cdbposttestq6);
        txt_cdbposttestq7 = findViewById(R.id.txt_cdbposttestq7);
        txt_cdbposttestq8 = findViewById(R.id.txt_cdbposttestq8);
        txt_cdbposttestq9 = findViewById(R.id.txt_cdbposttestq9);
        txt_cdbposttestq10 = findViewById(R.id.txt_cdbposttestq10);

        rb_cdbposttestq1a1 = findViewById(R.id.rb_cdbposttestq1a1);
        rb_cdbposttestq1a2 = findViewById(R.id.rb_cdbposttestq1a2);
        rb_cdbposttestq1a3 = findViewById(R.id.rb_cdbposttestq1a3);
        rb_cdbposttestq1a4 = findViewById(R.id.rb_cdbposttestq1a4);
        rb_cdbposttestq2a1 = findViewById(R.id.rb_cdbposttestq2a1);
        rb_cdbposttestq2a2 = findViewById(R.id.rb_cdbposttestq2a2);
        rb_cdbposttestq2a3 = findViewById(R.id.rb_cdbposttestq2a3);
        rb_cdbposttestq2a4 = findViewById(R.id.rb_cdbposttestq2a4);
        rb_cdbposttestq3a1 = findViewById(R.id.rb_cdbposttestq3a1);
        rb_cdbposttestq3a2 = findViewById(R.id.rb_cdbposttestq3a2);
        rb_cdbposttestq3a3 = findViewById(R.id.rb_cdbposttestq3a3);
        rb_cdbposttestq3a4 = findViewById(R.id.rb_cdbposttestq3a4);
        rb_cdbposttestq4a1 = findViewById(R.id.rb_cdbposttestq4a1);
        rb_cdbposttestq4a2 = findViewById(R.id.rb_cdbposttestq4a2);
        rb_cdbposttestq5a1 = findViewById(R.id.rb_cdbposttestq5a1);
        rb_cdbposttestq5a2 = findViewById(R.id.rb_cdbposttestq5a2);
        rb_cdbposttestq5a3 = findViewById(R.id.rb_cdbposttestq5a3);
        rb_cdbposttestq5a4 = findViewById(R.id.rb_cdbposttestq5a4);
        rb_cdbposttestq6a1 = findViewById(R.id.rb_cdbposttestq6a1);
        rb_cdbposttestq6a2 = findViewById(R.id.rb_cdbposttestq6a2);
        rb_cdbposttestq6a3 = findViewById(R.id.rb_cdbposttestq6a3);
        rb_cdbposttestq6a4 = findViewById(R.id.rb_cdbposttestq6a4);
        rb_cdbposttestq7a1 = findViewById(R.id.rb_cdbposttestq7a1);
        rb_cdbposttestq7a2 = findViewById(R.id.rb_cdbposttestq7a2);
        rb_cdbposttestq7a3 = findViewById(R.id.rb_cdbposttestq7a3);
        rb_cdbposttestq7a4 = findViewById(R.id.rb_cdbposttestq7a4);
        rb_cdbposttestq8a1 = findViewById(R.id.rb_cdbposttestq8a1);
        rb_cdbposttestq8a2 = findViewById(R.id.rb_cdbposttestq8a2);
        rb_cdbposttestq8a3 = findViewById(R.id.rb_cdbposttestq8a3);
        rb_cdbposttestq8a4 = findViewById(R.id.rb_cdbposttestq8a4);
        rb_cdbposttestq9a1 = findViewById(R.id.rb_cdbposttestq9a1);
        rb_cdbposttestq9a2 = findViewById(R.id.rb_cdbposttestq9a2);
        rb_cdbposttestq9a3 = findViewById(R.id.rb_cdbposttestq9a3);
        rb_cdbposttestq9a4 = findViewById(R.id.rb_cdbposttestq9a4);
        rb_cdbposttestq10a1 = findViewById(R.id.rb_cdbposttestq10a1);
        rb_cdbposttestq10a2 = findViewById(R.id.rb_cdbposttestq10a2);
        rb_cdbposttestq10a3 = findViewById(R.id.rb_cdbposttestq10a3);
        rb_cdbposttestq10a4 = findViewById(R.id.rb_cdbposttestq10a4);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cdb_post_test);

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

        cdbposttest_date = SToday;
        cdbposttest_time = STime;
    }

    @Override
    public void onClick(View view) {
        if (validateField() == false) {
            Toast.makeText(this, "Required fields are missing", Toast.LENGTH_LONG).show();
            return;
        }

        value_assignment();
        insert_data();

        Intent intent = new Intent(this, com.example.abdulsajid.mnchtraining.InterviewEnd.class);
        intent.putExtra("cnic_no", cnic_no);
        intent.putExtra("training", "Cough & Difficult Breathing");
        intent.putExtra("pretest_result", pretest_result);
        intent.putExtra("posttest_result", posttest_result);
        intent.putExtra("ptp", ptp);
        startActivity(intent);
        this.finish();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {


        //GDS-Q1  
        if (compoundButton.getId() == R.id.rb_cdbposttestq1a1
                || compoundButton.getId() == R.id.rb_cdbposttestq1a2
                || compoundButton.getId() == R.id.rb_cdbposttestq1a3
                || compoundButton.getId() == R.id.rb_cdbposttestq1a4) {

            if (rb_cdbposttestq1a1.isChecked()) {
                txt_cdbposttestq1.clearComposingText();
                String styledText = "1- Cough or difficult breathing that lasts for more than 14 days may indicate <font color='blue'><b><i>Tuberculosis</i></b></font>.";
                txt_cdbposttestq1.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_cdbposttestq1a2.isChecked()) {
                txt_cdbposttestq1.clearComposingText();
                String styledText = "1- Cough or difficult breathing that lasts for more than 14 days may indicate <font color='blue'><b><i>Asthma</i></b></font>.";
                txt_cdbposttestq1.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_cdbposttestq1a3.isChecked()) {
                txt_cdbposttestq1.clearComposingText();
                String styledText = "1- Cough or difficult breathing that lasts for more than 14 days may indicate <font color='blue'><b><i>Whooping cough</i></b></font>.";
                txt_cdbposttestq1.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_cdbposttestq1a4.isChecked()) {
                txt_cdbposttestq1.clearComposingText();
                String styledText = "1- Cough or difficult breathing that lasts for more than 14 days may indicate <font color='blue'><b><i>All of the below</i></b></font>.";
                txt_cdbposttestq1.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }


        //GDS-Q3  
        if (compoundButton.getId() == R.id.rb_cdbposttestq3a1
                || compoundButton.getId() == R.id.rb_cdbposttestq3a2
                || compoundButton.getId() == R.id.rb_cdbposttestq3a3
                || compoundButton.getId() == R.id.rb_cdbposttestq3a4) {

            if (rb_cdbposttestq3a1.isChecked()) {
                txt_cdbposttestq3.clearComposingText();
                String styledText = "3- Fast breathing or <font color='blue'><b><i>Wheeze</i></b></font> if postsent in a child between 2 months to 5 years of age are the clinical signs for Pneumonia.";
                txt_cdbposttestq3.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_cdbposttestq3a2.isChecked()) {
                txt_cdbposttestq3.clearComposingText();
                String styledText = "3- Fast breathing or <font color='blue'><b><i>Chest in-drawing</i></b></font> if postsent in a child between 2 months to 5 years of age are the clinical signs for Pneumonia.";
                txt_cdbposttestq3.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_cdbposttestq3a3.isChecked()) {
                txt_cdbposttestq3.clearComposingText();
                String styledText = "3- Fast breathing or <font color='blue'><b><i>Cough</i></b></font> if postsent in a child between 2 months to 5 years of age are the clinical signs for Pneumonia.";
                txt_cdbposttestq3.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_cdbposttestq3a4.isChecked()) {
                txt_cdbposttestq3.clearComposingText();
                String styledText = "3- Fast breathing or <font color='blue'><b><i>Fever</i></b></font> if postsent in a child between 2 months to 5 years of age are the clinical signs for Pneumonia.";
                txt_cdbposttestq3.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }


        //GDS-Q4   
        if (compoundButton.getId() == R.id.rb_cdbposttestq4a1
                || compoundButton.getId() == R.id.rb_cdbposttestq4a2) {

            if (rb_cdbposttestq4a1.isChecked()) {
                txt_cdbposttestq4.clearComposingText();
                String styledText = "4- The child has chest in drawing if the lower chest wall (lower ribs) goes <font color='blue'><b><i>IN</i></b></font> when the child breathes IN.";
                txt_cdbposttestq4.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_cdbposttestq4a2.isChecked()) {
                txt_cdbposttestq4.clearComposingText();
                String styledText = "4- The child has chest in drawing if the lower chest wall (lower ribs) goes <font color='blue'><b><i>OUT</i></b></font> when the child breathes IN.";
                txt_cdbposttestq4.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }


        //GDS-Q6
        if (compoundButton.getId() == R.id.rb_cdbposttestq6a1
                || compoundButton.getId() == R.id.rb_cdbposttestq6a2
                || compoundButton.getId() == R.id.rb_cdbposttestq6a3
                || compoundButton.getId() == R.id.rb_cdbposttestq6a4) {

            if (rb_cdbposttestq6a1.isChecked()) {
                txt_cdbposttestq6.clearComposingText();
                String styledText = "6- The dose for intramuscular antibiotics (urgent referral); Ampicillin <font color='blue'><b><i>40</i></b></font>mg/kg and Gentamicin <font color='blue'><b><i>7</i></b></font>mg/kg.";
                txt_cdbposttestq6.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_cdbposttestq6a2.isChecked()) {
                txt_cdbposttestq6.clearComposingText();
                String styledText = "6- The dose for intramuscular antibiotics (urgent referral); Ampicillin <font color='blue'><b><i>45</i></b></font>mg/kg and Gentamicin <font color='blue'><b><i>7.5</i></b></font>mg/kg.";
                txt_cdbposttestq6.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_cdbposttestq6a3.isChecked()) {
                txt_cdbposttestq6.clearComposingText();
                String styledText = "6- The dose for intramuscular antibiotics (urgent referral); Ampicillin <font color='blue'><b><i>50</i></b></font>mg/kg and Gentamicin <font color='blue'><b><i>7.5</i></b></font>mg/kg.";
                txt_cdbposttestq6.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_cdbposttestq6a4.isChecked()) {
                txt_cdbposttestq6.clearComposingText();
                String styledText = "6- The dose for intramuscular antibiotics (urgent referral); Ampicillin <font color='blue'><b><i>55</i></b></font>mg/kg and Gentamicin <font color='blue'><b><i>8</i></b></font>mg/kg.";
                txt_cdbposttestq6.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }


        //GDS-Q8
        if (compoundButton.getId() == R.id.rb_cdbposttestq8a1
                || compoundButton.getId() == R.id.rb_cdbposttestq8a2
                || compoundButton.getId() == R.id.rb_cdbposttestq8a3
                || compoundButton.getId() == R.id.rb_cdbposttestq8a4) {

            if (rb_cdbposttestq8a1.isChecked()) {
                txt_cdbposttestq8.clearComposingText();
                String styledText = "8- Standard flow rates for oxygen through nasal prongs or nasal catheters are up to <font color='blue'><b><i>2</i></b></font> L/min for infants, up to <font color='blue'><b><i>4</i></b></font> L/min for older children.";
                txt_cdbposttestq8.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_cdbposttestq8a2.isChecked()) {
                txt_cdbposttestq8.clearComposingText();
                String styledText = "8- Standard flow rates for oxygen through nasal prongs or nasal catheters are up to <font color='blue'><b><i>3</i></b></font> L/min for infants, up to <font color='blue'><b><i>4</i></b></font> L/min for older children.";
                txt_cdbposttestq8.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_cdbposttestq8a3.isChecked()) {
                txt_cdbposttestq8.clearComposingText();
                String styledText = "8- Standard flow rates for oxygen through nasal prongs or nasal catheters are up to <font color='blue'><b><i>3.5</i></b></font> L/min for infants, up to <font color='blue'><b><i>4.5</i></b></font> L/min for older children.";
                txt_cdbposttestq8.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_cdbposttestq8a4.isChecked()) {
                txt_cdbposttestq8.clearComposingText();
                String styledText = "8- Standard flow rates for oxygen through nasal prongs or nasal catheters are up to <font color='blue'><b><i>4</i></b></font> L/min for infants, up to <font color='blue'><b><i>4.5</i></b></font> L/min for older children.";
                txt_cdbposttestq8.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }

    }

    void events_call() {

        btn_cdbposttestsubmit.setOnClickListener(this);

        rb_cdbposttestq1a1.setOnCheckedChangeListener(this);
        rb_cdbposttestq1a2.setOnCheckedChangeListener(this);
        rb_cdbposttestq1a3.setOnCheckedChangeListener(this);
        rb_cdbposttestq1a4.setOnCheckedChangeListener(this);

        rb_cdbposttestq3a1.setOnCheckedChangeListener(this);
        rb_cdbposttestq3a2.setOnCheckedChangeListener(this);
        rb_cdbposttestq3a3.setOnCheckedChangeListener(this);
        rb_cdbposttestq3a4.setOnCheckedChangeListener(this);

        rb_cdbposttestq4a1.setOnCheckedChangeListener(this);
        rb_cdbposttestq4a2.setOnCheckedChangeListener(this);

        rb_cdbposttestq6a1.setOnCheckedChangeListener(this);
        rb_cdbposttestq6a2.setOnCheckedChangeListener(this);
        rb_cdbposttestq6a3.setOnCheckedChangeListener(this);
        rb_cdbposttestq6a4.setOnCheckedChangeListener(this);

        rb_cdbposttestq8a1.setOnCheckedChangeListener(this);
        rb_cdbposttestq8a2.setOnCheckedChangeListener(this);
        rb_cdbposttestq8a3.setOnCheckedChangeListener(this);
        rb_cdbposttestq8a4.setOnCheckedChangeListener(this);
    }

    void value_assignment() {

        cnic_no = "0";
        cdbposttestq1 = "-1";
        cdbposttestq2 = "-1";
        cdbposttestq3 = "-1";
        cdbposttestq4 = "-1";
        cdbposttestq5 = "-1";
        cdbposttestq6 = "-1";
        cdbposttestq7 = "-1";
        cdbposttestq8 = "-1";
        cdbposttestq9 = "-1";
        cdbposttestq10 = "-1";
        posttest_result = "0";
        STATUS = "0";


        int temp = 0;
        cnic_no = ed_cnic_no.getText().toString().length() > 0 ? ed_cnic_no.getText().toString().trim() : "0";

        //Q1
        if (rb_cdbposttestq1a1.isChecked()) {
            cdbposttestq1 = "1";
        }
        if (rb_cdbposttestq1a2.isChecked()) {
            cdbposttestq1 = "2";
        }
        if (rb_cdbposttestq1a3.isChecked()) {
            cdbposttestq1 = "3";
        }
        if (rb_cdbposttestq1a4.isChecked()) {
            cdbposttestq1 = "4";
            temp = temp + 1;
        }

        //Q2
        if (rb_cdbposttestq2a1.isChecked()) {
            cdbposttestq2 = "1";
        }
        if (rb_cdbposttestq2a2.isChecked()) {
            cdbposttestq2 = "2";
        }
        if (rb_cdbposttestq2a3.isChecked()) {
            cdbposttestq2 = "3";
            temp = temp + 1;
        }
        if (rb_cdbposttestq2a4.isChecked()) {
            cdbposttestq2 = "4";
        }

        //Q3
        if (rb_cdbposttestq3a1.isChecked()) {
            cdbposttestq3 = "1";
        }
        if (rb_cdbposttestq3a2.isChecked()) {
            cdbposttestq3 = "2";
            temp = temp + 1;
        }
        if (rb_cdbposttestq3a3.isChecked()) {
            cdbposttestq3 = "3";
        }
        if (rb_cdbposttestq3a4.isChecked()) {
            cdbposttestq3 = "4";
        }

        //Q4
        if (rb_cdbposttestq4a1.isChecked()) {
            cdbposttestq4 = "1";
            temp = temp + 1;
        }
        if (rb_cdbposttestq4a2.isChecked()) {
            cdbposttestq4 = "2";
        }

        //Q5
        if (rb_cdbposttestq5a1.isChecked()) {
            cdbposttestq5 = "1";
        }
        if (rb_cdbposttestq5a2.isChecked()) {
            cdbposttestq5 = "2";
        }
        if (rb_cdbposttestq5a3.isChecked()) {
            cdbposttestq5 = "3";
            temp = temp + 1;
        }
        if (rb_cdbposttestq5a4.isChecked()) {
            cdbposttestq5 = "4";
        }

        //Q6
        if (rb_cdbposttestq6a1.isChecked()) {
            cdbposttestq6 = "1";
        }
        if (rb_cdbposttestq6a2.isChecked()) {
            cdbposttestq6 = "2";
        }
        if (rb_cdbposttestq6a3.isChecked()) {
            cdbposttestq6 = "3";
            temp = temp + 1;
        }
        if (rb_cdbposttestq6a4.isChecked()) {
            cdbposttestq6 = "4";
        }

        //Q7
        if (rb_cdbposttestq7a1.isChecked()) {
            cdbposttestq7 = "1";
            temp = temp + 1;
        }
        if (rb_cdbposttestq7a2.isChecked()) {
            cdbposttestq7 = "2";
        }
        if (rb_cdbposttestq7a3.isChecked()) {
            cdbposttestq7 = "3";
        }
        if (rb_cdbposttestq7a4.isChecked()) {
            cdbposttestq7 = "4";
        }

        //Q8
        if (rb_cdbposttestq8a1.isChecked()) {
            cdbposttestq8 = "1";
            temp = temp + 1;
        }
        if (rb_cdbposttestq8a2.isChecked()) {
            cdbposttestq8 = "2";
        }
        if (rb_cdbposttestq8a3.isChecked()) {
            cdbposttestq8 = "3";
        }
        if (rb_cdbposttestq8a4.isChecked()) {
            cdbposttestq8 = "4";
        }

        //Q9
        if (rb_cdbposttestq9a1.isChecked()) {
            cdbposttestq9 = "1";
        }
        if (rb_cdbposttestq9a2.isChecked()) {
            cdbposttestq9 = "2";
        }
        if (rb_cdbposttestq9a3.isChecked()) {
            cdbposttestq9 = "3";
        }
        if (rb_cdbposttestq9a4.isChecked()) {
            cdbposttestq9 = "4";
            temp = temp + 1;
        }

        //Q10
        if (rb_cdbposttestq10a1.isChecked()) {
            cdbposttestq10 = "1";
        }
        if (rb_cdbposttestq10a2.isChecked()) {
            cdbposttestq10 = "2";
        }
        if (rb_cdbposttestq10a3.isChecked()) {
            cdbposttestq10 = "3";
        }
        if (rb_cdbposttestq10a4.isChecked()) {
            cdbposttestq10 = "4";
            temp = temp + 1;
        }


        posttest_result = String.valueOf(temp);

        ptp = Math.round(Double.parseDouble(posttest_result) / 10 * 100);
    }

    void insert_data() {
        String query = "insert into CDBPostTest("

                + Global.CDB.CDBPostTest.fk_id + ","
                + Global.CDB.CDBPostTest.cnic_no + ","
                + Global.CDB.CDBPostTest.cdbposttest_date + ","
                + Global.CDB.CDBPostTest.cdbposttest_time + ","
                + Global.CDB.CDBPostTest.cdbposttestq1 + ","
                + Global.CDB.CDBPostTest.cdbposttestq2 + ","
                + Global.CDB.CDBPostTest.cdbposttestq3 + ","
                + Global.CDB.CDBPostTest.cdbposttestq4 + ","
                + Global.CDB.CDBPostTest.cdbposttestq5 + ","
                + Global.CDB.CDBPostTest.cdbposttestq6 + ","
                + Global.CDB.CDBPostTest.cdbposttestq7 + ","
                + Global.CDB.CDBPostTest.cdbposttestq8 + ","
                + Global.CDB.CDBPostTest.cdbposttestq9 + ","
                + Global.CDB.CDBPostTest.cdbposttestq10 + ","
                + Global.CDB.CDBPostTest.posttest_result + ","
                + Global.CDB.CDBPostTest.STATUS + ")" +

                " values ('" +

                Global.Session_Start.pk_id + "','" +
                cnic_no + "','" +
                cdbposttest_date + "','" +
                cdbposttest_time + "','" +
                cdbposttestq1 + "','" +
                cdbposttestq2 + "','" +
                cdbposttestq3 + "','" +
                cdbposttestq4 + "','" +
                cdbposttestq5 + "','" +
                cdbposttestq6 + "','" +
                cdbposttestq7 + "','" +
                cdbposttestq8 + "','" +
                cdbposttestq9 + "','" +
                cdbposttestq10 + "','" +
                pretest_result + "','" +
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

        if (Gothrough.IamHiden(ll_pretest_result) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_cdbposttestq1) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_cdbposttestq2) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_cdbposttestq3) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_cdbposttestq4) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_cdbposttestq5) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_cdbposttestq6) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_cdbposttestq7) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_cdbposttestq8) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_cdbposttestq9) == false) {
            return false;
        }

        return Gothrough.IamHiden(ll_cdbposttestq10) != false;
    }

    public void onBackPressed() {
        Toast.makeText(this, "You are not allowed to go on back screen SORRY!!! \nIf you want to do so PLEASE CONTACT Dr. Samia", Toast.LENGTH_LONG).show();
    }

}
