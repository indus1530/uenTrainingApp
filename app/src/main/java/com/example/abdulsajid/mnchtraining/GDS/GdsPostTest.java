package com.example.abdulsajid.mnchtraining.GDS;

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

import Global.GDS.GDSPostTest;
import Global.Session_Start;
import data.LocalDataManager;
import utils.Gothrough;


public class GdsPostTest extends AppCompatActivity implements RadioButton.OnCheckedChangeListener, View.OnClickListener {

    //Declaration
    TextView
            txt_gdsposttestq1,
            txt_gdsposttestq2,
            txt_gdsposttestq3,
            txt_gdsposttestq4,
            txt_gdsposttestq5,
            txt_gdsposttestq6,
            txt_gdsposttestq7,
            txt_gdsposttestq8,
            txt_gdsposttestq9,
            txt_gdsposttestq10;

    Button
            btn_gdsposttestsubmit;

    LinearLayout
            ll_cnic,
            ll_pretest_result,
            ll_gdsposttestq1,
            ll_gdsposttestq2,
            ll_gdsposttestq3,
            ll_gdsposttestq4,
            ll_gdsposttestq5,
            ll_gdsposttestq6,
            ll_gdsposttestq7,
            ll_gdsposttestq8,
            ll_gdsposttestq9,
            ll_gdsposttestq10;

    RadioButton
            rb_gdsposttestq1a1,
            rb_gdsposttestq1a2,
            rb_gdsposttestq1a3,
            rb_gdsposttestq1a4,
            rb_gdsposttestq2a1,
            rb_gdsposttestq2a2,
            rb_gdsposttestq2a3,
            rb_gdsposttestq2a4,
            rb_gdsposttestq3a1,
            rb_gdsposttestq3a2,
            rb_gdsposttestq3a3,
            rb_gdsposttestq3a4,
            rb_gdsposttestq4a1,
            rb_gdsposttestq4a2,
            rb_gdsposttestq4a3,
            rb_gdsposttestq4a4,
            rb_gdsposttestq5a1,
            rb_gdsposttestq5a2,
            rb_gdsposttestq5a3,
            rb_gdsposttestq5a4,
            rb_gdsposttestq6a1,
            rb_gdsposttestq6a2,
            rb_gdsposttestq7a1,
            rb_gdsposttestq7a2,
            rb_gdsposttestq7a3,
            rb_gdsposttestq7a4,
            rb_gdsposttestq8a1,
            rb_gdsposttestq8a2,
            rb_gdsposttestq8a3,
            rb_gdsposttestq8a4,
            rb_gdsposttestq9a1,
            rb_gdsposttestq9a2,
            rb_gdsposttestq9a3,
            rb_gdsposttestq9a4,
            rb_gdsposttestq10a1,
            rb_gdsposttestq10a2,
            rb_gdsposttestq10a3,
            rb_gdsposttestq10a4;

    EditText
            ed_cnic_no,
            ed_pretest_result;

    String
            cnic_no,
            gdsposttest_date,
            gdsposttest_time,
            gdsposttestq1,
            gdsposttestq2,
            gdsposttestq3,
            gdsposttestq4,
            gdsposttestq5,
            gdsposttestq6,
            gdsposttestq7,
            gdsposttestq8,
            gdsposttestq9,
            gdsposttestq10,
            pretest_result,
            posttest_result,
            STATUS;

    int currentSection;
    double ptp;

    void Initialization() {

        btn_gdsposttestsubmit = findViewById(R.id.btn_gdsposttestsubmit);

        ll_cnic = findViewById(R.id.ll_cnic);
        ll_pretest_result = findViewById(R.id.ll_pretest_result);
        ll_gdsposttestq1 = findViewById(R.id.ll_gdsposttestq1);
        ll_gdsposttestq2 = findViewById(R.id.ll_gdsposttestq2);
        ll_gdsposttestq3 = findViewById(R.id.ll_gdsposttestq3);
        ll_gdsposttestq4 = findViewById(R.id.ll_gdsposttestq4);
        ll_gdsposttestq5 = findViewById(R.id.ll_gdsposttestq5);
        ll_gdsposttestq6 = findViewById(R.id.ll_gdsposttestq6);
        ll_gdsposttestq7 = findViewById(R.id.ll_gdsposttestq7);
        ll_gdsposttestq8 = findViewById(R.id.ll_gdsposttestq8);
        ll_gdsposttestq9 = findViewById(R.id.ll_gdsposttestq9);
        ll_gdsposttestq10 = findViewById(R.id.ll_gdsposttestq10);

        ed_cnic_no = findViewById(R.id.ed_cnic_no);
        ed_pretest_result = findViewById(R.id.ed_pretest_result);

        txt_gdsposttestq1 = findViewById(R.id.txt_gdsposttestq1);
        txt_gdsposttestq2 = findViewById(R.id.txt_gdsposttestq2);
        txt_gdsposttestq3 = findViewById(R.id.txt_gdsposttestq3);
        txt_gdsposttestq4 = findViewById(R.id.txt_gdsposttestq4);
        txt_gdsposttestq5 = findViewById(R.id.txt_gdsposttestq5);
        txt_gdsposttestq6 = findViewById(R.id.txt_gdsposttestq6);
        txt_gdsposttestq7 = findViewById(R.id.txt_gdsposttestq7);
        txt_gdsposttestq8 = findViewById(R.id.txt_gdsposttestq8);
        txt_gdsposttestq9 = findViewById(R.id.txt_gdsposttestq9);
        txt_gdsposttestq10 = findViewById(R.id.txt_gdsposttestq10);

        rb_gdsposttestq1a1 = findViewById(R.id.rb_gdsposttestq1a1);
        rb_gdsposttestq1a2 = findViewById(R.id.rb_gdsposttestq1a2);
        rb_gdsposttestq1a3 = findViewById(R.id.rb_gdsposttestq1a3);
        rb_gdsposttestq1a4 = findViewById(R.id.rb_gdsposttestq1a4);
        rb_gdsposttestq2a1 = findViewById(R.id.rb_gdsposttestq2a1);
        rb_gdsposttestq2a2 = findViewById(R.id.rb_gdsposttestq2a2);
        rb_gdsposttestq2a3 = findViewById(R.id.rb_gdsposttestq2a3);
        rb_gdsposttestq2a4 = findViewById(R.id.rb_gdsposttestq2a4);
        rb_gdsposttestq3a1 = findViewById(R.id.rb_gdsposttestq3a1);
        rb_gdsposttestq3a2 = findViewById(R.id.rb_gdsposttestq3a2);
        rb_gdsposttestq3a3 = findViewById(R.id.rb_gdsposttestq3a3);
        rb_gdsposttestq3a4 = findViewById(R.id.rb_gdsposttestq3a4);
        rb_gdsposttestq4a1 = findViewById(R.id.rb_gdsposttestq4a1);
        rb_gdsposttestq4a2 = findViewById(R.id.rb_gdsposttestq4a2);
        rb_gdsposttestq4a3 = findViewById(R.id.rb_gdsposttestq4a3);
        rb_gdsposttestq4a4 = findViewById(R.id.rb_gdsposttestq4a4);
        rb_gdsposttestq5a1 = findViewById(R.id.rb_gdsposttestq5a1);
        rb_gdsposttestq5a2 = findViewById(R.id.rb_gdsposttestq5a2);
        rb_gdsposttestq5a3 = findViewById(R.id.rb_gdsposttestq5a3);
        rb_gdsposttestq5a4 = findViewById(R.id.rb_gdsposttestq5a4);
        rb_gdsposttestq6a1 = findViewById(R.id.rb_gdsposttestq6a1);
        rb_gdsposttestq6a2 = findViewById(R.id.rb_gdsposttestq6a2);
        rb_gdsposttestq7a1 = findViewById(R.id.rb_gdsposttestq7a1);
        rb_gdsposttestq7a2 = findViewById(R.id.rb_gdsposttestq7a2);
        rb_gdsposttestq7a3 = findViewById(R.id.rb_gdsposttestq7a3);
        rb_gdsposttestq7a4 = findViewById(R.id.rb_gdsposttestq7a4);
        rb_gdsposttestq8a1 = findViewById(R.id.rb_gdsposttestq8a1);
        rb_gdsposttestq8a2 = findViewById(R.id.rb_gdsposttestq8a2);
        rb_gdsposttestq8a3 = findViewById(R.id.rb_gdsposttestq8a3);
        rb_gdsposttestq8a4 = findViewById(R.id.rb_gdsposttestq8a4);
        rb_gdsposttestq9a1 = findViewById(R.id.rb_gdsposttestq9a1);
        rb_gdsposttestq9a2 = findViewById(R.id.rb_gdsposttestq9a2);
        rb_gdsposttestq9a3 = findViewById(R.id.rb_gdsposttestq9a3);
        rb_gdsposttestq9a4 = findViewById(R.id.rb_gdsposttestq9a4);
        rb_gdsposttestq10a1 = findViewById(R.id.rb_gdsposttestq10a1);
        rb_gdsposttestq10a2 = findViewById(R.id.rb_gdsposttestq10a2);
        rb_gdsposttestq10a3 = findViewById(R.id.rb_gdsposttestq10a3);
        rb_gdsposttestq10a4 = findViewById(R.id.rb_gdsposttestq10a4);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gds_post_test);

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

        gdsposttest_date = SToday;
        gdsposttest_time = STime;

    }

    @Override
    public void onClick(View view) {

        if (validateField() == false) {
            Toast.makeText(this, "Required fields are missing", Toast.LENGTH_LONG).show();
            return;
        }

        value_assignment();
        insert_data();

        Intent intent = new Intent(this, InterviewEnd.class);
        intent.putExtra("cnic_no", cnic_no);
        intent.putExtra("training", "General Danger Signs");
        intent.putExtra("pretest_result", pretest_result);
        intent.putExtra("posttest_result", posttest_result);
        intent.putExtra("ptp", ptp);
        startActivity(intent);
        this.finish();

    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {


        //GDS-Q1  
        if (compoundButton.getId() == R.id.rb_gdsposttestq1a1
                || compoundButton.getId() == R.id.rb_gdsposttestq1a2
                || compoundButton.getId() == R.id.rb_gdsposttestq1a3
                || compoundButton.getId() == R.id.rb_gdsposttestq1a4) {

            if (rb_gdsposttestq1a1.isChecked()) {
                txt_gdsposttestq1.clearComposingText();
                String styledText = "1- Children with <font color='blue'><b><i>Mild illness</i></b></font> on the IMNCI chart usually need urgent referral to hospital.";
                txt_gdsposttestq1.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_gdsposttestq1a2.isChecked()) {
                txt_gdsposttestq1.clearComposingText();
                String styledText = "1- Children with <font color='blue'><b><i>Pneumonia</i></b></font> on the IMNCI chart usually need urgent referral to hospital.";
                txt_gdsposttestq1.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_gdsposttestq1a3.isChecked()) {
                txt_gdsposttestq1.clearComposingText();
                String styledText = "1- Children with <font color='blue'><b><i>Dehydration</i></b></font> on the IMNCI chart usually need urgent referral to hospital.";
                txt_gdsposttestq1.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_gdsposttestq1a4.isChecked()) {
                txt_gdsposttestq1.clearComposingText();
                String styledText = "1- Children with <font color='blue'><b><i>Severe disease/classification</i></b></font> on the IMNCI chart usually need urgent referral to hospital.";
                txt_gdsposttestq1.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }


        //GDS-Q2  
        if (compoundButton.getId() == R.id.rb_gdsposttestq2a1
                || compoundButton.getId() == R.id.rb_gdsposttestq2a2
                || compoundButton.getId() == R.id.rb_gdsposttestq2a3
                || compoundButton.getId() == R.id.rb_gdsposttestq2a4) {

            if (rb_gdsposttestq2a1.isChecked()) {
                txt_gdsposttestq2.clearComposingText();
                String styledText = "2- <font color='blue'><b><i>Persistent diarrhea</i></b></font> is the exception for severe classification or severe disease where referral to the hospital is needed but not urgent.";
                txt_gdsposttestq2.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_gdsposttestq2a2.isChecked()) {
                txt_gdsposttestq2.clearComposingText();
                String styledText = "2- <font color='blue'><b><i>Severe dehydration</i></b></font> is the exception for severe classification or severe disease where referral to the hospital is needed but not urgent.";
                txt_gdsposttestq2.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_gdsposttestq2a3.isChecked()) {
                txt_gdsposttestq2.clearComposingText();
                String styledText = "2- <font color='blue'><b><i>Severe persistent diarrhea</i></b></font> is the exception for severe classification or severe disease where referral to the hospital is needed but not urgent.";
                txt_gdsposttestq2.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_gdsposttestq2a4.isChecked()) {
                txt_gdsposttestq2.clearComposingText();
                String styledText = "2- <font color='blue'><b><i>Severe pneumonia</i></b></font> is the exception for severe classification or severe disease where referral to the hospital is needed but not urgent.";
                txt_gdsposttestq2.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }


        //GDS-Q3  
        if (compoundButton.getId() == R.id.rb_gdsposttestq3a1
                || compoundButton.getId() == R.id.rb_gdsposttestq3a2
                || compoundButton.getId() == R.id.rb_gdsposttestq3a3
                || compoundButton.getId() == R.id.rb_gdsposttestq3a4) {

            if (rb_gdsposttestq3a1.isChecked()) {
                txt_gdsposttestq3.clearComposingText();
                String styledText = "3- Presence of even <font color='blue'><b><i>One</i></b></font> danger sign indicates that underlying disease is severe.";
                txt_gdsposttestq3.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_gdsposttestq3a2.isChecked()) {
                txt_gdsposttestq3.clearComposingText();
                String styledText = "3- Presence of even <font color='blue'><b><i>Two</i></b></font> danger sign indicates that underlying disease is severe.";
                txt_gdsposttestq3.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_gdsposttestq3a3.isChecked()) {
                txt_gdsposttestq3.clearComposingText();
                String styledText = "3- Presence of even <font color='blue'><b><i>Three</i></b></font> danger sign indicates that underlying disease is severe.";
                txt_gdsposttestq3.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_gdsposttestq3a4.isChecked()) {
                txt_gdsposttestq3.clearComposingText();
                String styledText = "3- Presence of even <font color='blue'><b><i>None</i></b></font> danger sign indicates that underlying disease is severe.";
                txt_gdsposttestq3.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }


        //GDS-Q4   
        if (compoundButton.getId() == R.id.rb_gdsposttestq4a1
                || compoundButton.getId() == R.id.rb_gdsposttestq4a2
                || compoundButton.getId() == R.id.rb_gdsposttestq4a3
                || compoundButton.getId() == R.id.rb_gdsposttestq4a4) {

            if (rb_gdsposttestq4a1.isChecked()) {
                txt_gdsposttestq4.clearComposingText();
                String styledText = "4- For assessing a general danger sign, a healthcare provider needs to ASK <font color='blue'><b><i>One</i></b></font> questions and LOOK for <font color='blue'><b><i>Two</i></b></font> observations to observe the child's actions.";
                txt_gdsposttestq4.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_gdsposttestq4a2.isChecked()) {
                txt_gdsposttestq4.clearComposingText();
                String styledText = "4- For assessing a general danger sign, a healthcare provider needs to ASK <font color='blue'><b><i>Two</i></b></font> questions and LOOK for <font color='blue'><b><i>Two</i></b></font> observations to observe the child's actions.";
                txt_gdsposttestq4.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_gdsposttestq4a3.isChecked()) {
                txt_gdsposttestq4.clearComposingText();
                String styledText = "4- For assessing a general danger sign, a healthcare provider needs to ASK <font color='blue'><b><i>Three</i></b></font> questions and LOOK for <font color='blue'><b><i>Two</i></b></font> observations to observe the child's actions.";
                txt_gdsposttestq4.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_gdsposttestq4a4.isChecked()) {
                txt_gdsposttestq4.clearComposingText();
                String styledText = "4- For assessing a general danger sign, a healthcare provider needs to ASK <font color='blue'><b><i>Three</i></b></font> questions and LOOK for <font color='blue'><b><i>One</i></b></font> observations to observe the child's actions.";
                txt_gdsposttestq4.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }


        //GDS-Q8  
        if (compoundButton.getId() == R.id.rb_gdsposttestq8a1
                || compoundButton.getId() == R.id.rb_gdsposttestq8a2
                || compoundButton.getId() == R.id.rb_gdsposttestq8a3
                || compoundButton.getId() == R.id.rb_gdsposttestq8a4) {

            if (rb_gdsposttestq8a1.isChecked()) {
                txt_gdsposttestq8.clearComposingText();
                String styledText = "8- A child who is not able to hold anything down at all has the sign <font color='blue'><b><i>Not able to drink or breastfeed</i></b></font>.";
                txt_gdsposttestq8.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_gdsposttestq8a2.isChecked()) {
                txt_gdsposttestq8.clearComposingText();
                String styledText = "8- A child who is not able to hold anything down at all has the sign <font color='blue'><b><i>Vomits everything</i></b></font>.";
                txt_gdsposttestq8.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_gdsposttestq8a3.isChecked()) {
                txt_gdsposttestq8.clearComposingText();
                String styledText = "8- A child who is not able to hold anything down at all has the sign <font color='blue'><b><i>Lethargic</i></b></font>.";
                txt_gdsposttestq8.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_gdsposttestq8a4.isChecked()) {
                txt_gdsposttestq8.clearComposingText();
                String styledText = "8- A child who is not able to hold anything down at all has the sign <font color='blue'><b><i>Unconscious</i></b></font>.";
                txt_gdsposttestq8.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }


        //GDS-Q10  
        if (compoundButton.getId() == R.id.rb_gdsposttestq10a1
                || compoundButton.getId() == R.id.rb_gdsposttestq10a2
                || compoundButton.getId() == R.id.rb_gdsposttestq10a3
                || compoundButton.getId() == R.id.rb_gdsposttestq10a4) {

            if (rb_gdsposttestq10a1.isChecked()) {
                txt_gdsposttestq10.clearComposingText();
                String styledText = "10- To make sugar water: Dissolve 4 level teaspoons of sugar (20 grams) in a <font color='blue'><b><i>100-ml</i></b></font> cup of clean water.";
                txt_gdsposttestq10.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_gdsposttestq10a2.isChecked()) {
                txt_gdsposttestq10.clearComposingText();
                String styledText = "10- To make sugar water: Dissolve 4 level teaspoons of sugar (20 grams) in a <font color='blue'><b><i>150-ml</i></b></font> cup of clean water.";
                txt_gdsposttestq10.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_gdsposttestq10a3.isChecked()) {
                txt_gdsposttestq10.clearComposingText();
                String styledText = "10- To make sugar water: Dissolve 4 level teaspoons of sugar (20 grams) in a <font color='blue'><b><i>200-ml</i></b></font> cup of clean water.";
                txt_gdsposttestq10.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_gdsposttestq10a4.isChecked()) {
                txt_gdsposttestq10.clearComposingText();
                String styledText = "10- To make sugar water: Dissolve 4 level teaspoons of sugar (20 grams) in a <font color='blue'><b><i>250-ml</i></b></font> cup of clean water.";
                txt_gdsposttestq10.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }

    }

    void events_call() {

        btn_gdsposttestsubmit.setOnClickListener(this);
        rb_gdsposttestq1a1.setOnCheckedChangeListener(this);
        rb_gdsposttestq1a2.setOnCheckedChangeListener(this);
        rb_gdsposttestq1a3.setOnCheckedChangeListener(this);
        rb_gdsposttestq1a4.setOnCheckedChangeListener(this);

        rb_gdsposttestq2a1.setOnCheckedChangeListener(this);
        rb_gdsposttestq2a2.setOnCheckedChangeListener(this);
        rb_gdsposttestq2a3.setOnCheckedChangeListener(this);
        rb_gdsposttestq2a4.setOnCheckedChangeListener(this);

        rb_gdsposttestq3a1.setOnCheckedChangeListener(this);
        rb_gdsposttestq3a2.setOnCheckedChangeListener(this);
        rb_gdsposttestq3a3.setOnCheckedChangeListener(this);
        rb_gdsposttestq3a4.setOnCheckedChangeListener(this);

        rb_gdsposttestq4a1.setOnCheckedChangeListener(this);
        rb_gdsposttestq4a2.setOnCheckedChangeListener(this);
        rb_gdsposttestq4a3.setOnCheckedChangeListener(this);
        rb_gdsposttestq4a4.setOnCheckedChangeListener(this);

        rb_gdsposttestq5a1.setOnCheckedChangeListener(this);
        rb_gdsposttestq5a2.setOnCheckedChangeListener(this);
        rb_gdsposttestq5a3.setOnCheckedChangeListener(this);
        rb_gdsposttestq5a4.setOnCheckedChangeListener(this);

        rb_gdsposttestq6a1.setOnCheckedChangeListener(this);
        rb_gdsposttestq6a2.setOnCheckedChangeListener(this);

        rb_gdsposttestq7a1.setOnCheckedChangeListener(this);
        rb_gdsposttestq7a2.setOnCheckedChangeListener(this);
        rb_gdsposttestq7a3.setOnCheckedChangeListener(this);
        rb_gdsposttestq7a4.setOnCheckedChangeListener(this);

        rb_gdsposttestq8a1.setOnCheckedChangeListener(this);
        rb_gdsposttestq8a2.setOnCheckedChangeListener(this);
        rb_gdsposttestq8a3.setOnCheckedChangeListener(this);
        rb_gdsposttestq8a4.setOnCheckedChangeListener(this);

        rb_gdsposttestq9a1.setOnCheckedChangeListener(this);
        rb_gdsposttestq9a2.setOnCheckedChangeListener(this);
        rb_gdsposttestq9a3.setOnCheckedChangeListener(this);
        rb_gdsposttestq9a4.setOnCheckedChangeListener(this);

        rb_gdsposttestq10a1.setOnCheckedChangeListener(this);
        rb_gdsposttestq10a2.setOnCheckedChangeListener(this);
        rb_gdsposttestq10a3.setOnCheckedChangeListener(this);
        rb_gdsposttestq10a4.setOnCheckedChangeListener(this);
    }

    void value_assignment() {

        posttest_result = "0";
        STATUS = "0";


        int temp = 0;

        cnic_no = ed_cnic_no.getText().toString().length() > 0 ? ed_cnic_no.getText().toString().trim() : "0";

        //Q1
        gdsposttestq1 = rb_gdsposttestq1a1.isChecked() ? "1"
                : rb_gdsposttestq1a2.isChecked() ? "2"
                : rb_gdsposttestq1a3.isChecked() ? "3"
                : rb_gdsposttestq1a4.isChecked() ? "4"
                : "-1";
        temp = gdsposttestq1.equals("4") ? temp + 1 : temp;

        //Q2
        if (rb_gdsposttestq2a1.isChecked()) {
            gdsposttestq2 = "1";
        }
        if (rb_gdsposttestq2a2.isChecked()) {
            gdsposttestq2 = "2";
        }
        if (rb_gdsposttestq2a3.isChecked()) {
            gdsposttestq2 = "3";
            temp = temp + 1;
        }
        if (rb_gdsposttestq2a4.isChecked()) {
            gdsposttestq2 = "4";
        }

        //Q3
        if (rb_gdsposttestq3a1.isChecked()) {
            gdsposttestq3 = "1";
            temp = temp + 1;
        }
        if (rb_gdsposttestq3a2.isChecked()) {
            gdsposttestq3 = "2";
        }
        if (rb_gdsposttestq3a3.isChecked()) {
            gdsposttestq3 = "3";
        }
        if (rb_gdsposttestq3a4.isChecked()) {
            gdsposttestq3 = "4";
        }

        //Q4
        if (rb_gdsposttestq4a1.isChecked()) {
            gdsposttestq4 = "1";
        }
        if (rb_gdsposttestq4a2.isChecked()) {
            gdsposttestq4 = "2";
        }
        if (rb_gdsposttestq4a3.isChecked()) {
            gdsposttestq4 = "3";
            temp = temp + 1;
        }
        if (rb_gdsposttestq4a4.isChecked()) {
            gdsposttestq4 = "4";
        }

        //Q5
        if (rb_gdsposttestq5a1.isChecked()) {
            gdsposttestq5 = "1";
        }
        if (rb_gdsposttestq5a2.isChecked()) {
            gdsposttestq5 = "2";
        }
        if (rb_gdsposttestq5a3.isChecked()) {
            gdsposttestq5 = "3";
        }
        if (rb_gdsposttestq5a4.isChecked()) {
            gdsposttestq5 = "4";
            temp = temp + 1;
        }

        //Q6
        if (rb_gdsposttestq6a1.isChecked()) {
            gdsposttestq6 = "1";
        }
        if (rb_gdsposttestq6a2.isChecked()) {
            gdsposttestq6 = "2";
            temp = temp + 1;
        }

        //Q7
        if (rb_gdsposttestq7a1.isChecked()) {
            gdsposttestq7 = "1";
        }
        if (rb_gdsposttestq7a2.isChecked()) {
            gdsposttestq7 = "2";
        }
        if (rb_gdsposttestq7a3.isChecked()) {
            gdsposttestq7 = "3";
            temp = temp + 1;
        }
        if (rb_gdsposttestq7a4.isChecked()) {
            gdsposttestq7 = "4";
        }

        //Q8
        if (rb_gdsposttestq8a1.isChecked()) {
            gdsposttestq8 = "1";
        }
        if (rb_gdsposttestq8a2.isChecked()) {
            gdsposttestq8 = "2";
            temp = temp + 1;
        }
        if (rb_gdsposttestq8a3.isChecked()) {
            gdsposttestq8 = "3";
        }
        if (rb_gdsposttestq8a4.isChecked()) {
            gdsposttestq8 = "4";
        }

        //Q9
        if (rb_gdsposttestq9a1.isChecked()) {
            gdsposttestq9 = "1";
            temp = temp + 1;
        }
        if (rb_gdsposttestq9a2.isChecked()) {
            gdsposttestq9 = "2";
        }
        if (rb_gdsposttestq9a3.isChecked()) {
            gdsposttestq9 = "3";
        }
        if (rb_gdsposttestq9a4.isChecked()) {
            gdsposttestq9 = "4";
        }

        //Q10
        if (rb_gdsposttestq10a1.isChecked()) {
            gdsposttestq10 = "1";
        }
        if (rb_gdsposttestq10a2.isChecked()) {
            gdsposttestq10 = "2";
        }
        if (rb_gdsposttestq10a3.isChecked()) {
            gdsposttestq10 = "3";
            temp = temp + 1;
        }
        if (rb_gdsposttestq10a4.isChecked()) {
            gdsposttestq10 = "4";
        }
        posttest_result = String.valueOf(temp);
        ptp = Math.round(Double.parseDouble(posttest_result) / 10 * 100);
    }

    void insert_data() {
        String query = "insert into GDSPostTest("

                + GDSPostTest.fk_id + ","
                + GDSPostTest.cnic_no + ","
                + GDSPostTest.gdsposttest_date + ","
                + GDSPostTest.gdsposttest_time + ","
                + GDSPostTest.gdsposttestq1 + ","
                + GDSPostTest.gdsposttestq2 + ","
                + GDSPostTest.gdsposttestq3 + ","
                + GDSPostTest.gdsposttestq4 + ","
                + GDSPostTest.gdsposttestq5 + ","
                + GDSPostTest.gdsposttestq6 + ","
                + GDSPostTest.gdsposttestq7 + ","
                + GDSPostTest.gdsposttestq8 + ","
                + GDSPostTest.gdsposttestq9 + ","
                + GDSPostTest.gdsposttestq10 + ","
                + GDSPostTest.posttest_result + ","
                + GDSPostTest.STATUS + ")" +

                " values ('" +

                Session_Start.pk_id + "','" +
                cnic_no + "','" +
                gdsposttest_date + "','" +
                gdsposttest_time + "','" +
                gdsposttestq1 + "','" +
                gdsposttestq2 + "','" +
                gdsposttestq3 + "','" +
                gdsposttestq4 + "','" +
                gdsposttestq5 + "','" +
                gdsposttestq6 + "','" +
                gdsposttestq7 + "','" +
                gdsposttestq8 + "','" +
                gdsposttestq9 + "','" +
                gdsposttestq10 + "','" +
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

        if (Gothrough.IamHiden(ll_gdsposttestq1) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_gdsposttestq2) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_gdsposttestq3) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_gdsposttestq4) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_gdsposttestq5) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_gdsposttestq6) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_gdsposttestq7) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_gdsposttestq8) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_gdsposttestq9) == false) {
            return false;
        }

        return Gothrough.IamHiden(ll_gdsposttestq10) != false;
    }

    public void onBackPressed() {
        Toast.makeText(this, "You are not allowed to go on back screen SORRY!!! \nIf you want to do so PLEASE CONTACT Dr. Samia", Toast.LENGTH_LONG).show();
    }

}