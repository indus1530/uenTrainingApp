package com.example.abdulsajid.mnchtraining.DIARRHEA;

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

import data.LocalDataManager;
import utils.Gothrough;

public class DiarrheaPostTest extends AppCompatActivity implements RadioButton.OnCheckedChangeListener, View.OnClickListener {

    //Declaration 
    TextView
            txt_diarrheaposttestq1,
            txt_diarrheaposttestq2,
            txt_diarrheaposttestq3,
            txt_diarrheaposttestq4,
            txt_diarrheaposttestq7,
            txt_diarrheaposttestq9,
            txt_diarrheaposttestq10;

    Button
            btn_diarrheaposttestsubmit;

    LinearLayout
            ll_cnic,
            ll_pretest_result,
            ll_diarrheaposttestq1,
            ll_diarrheaposttestq2,
            ll_diarrheaposttestq3,
            ll_diarrheaposttestq4,
            ll_diarrheaposttestq5,
            ll_diarrheaposttestq6,
            ll_diarrheaposttestq7,
            ll_diarrheaposttestq8,
            ll_diarrheaposttestq9,
            ll_diarrheaposttestq10;


    RadioButton
            rb_diarrheaposttestq1a1,
            rb_diarrheaposttestq1a2,
            rb_diarrheaposttestq1a3,
            rb_diarrheaposttestq1a4,
            rb_diarrheaposttestq2a1,
            rb_diarrheaposttestq2a2,
            rb_diarrheaposttestq2a3,
            rb_diarrheaposttestq2a4,
            rb_diarrheaposttestq3a1,
            rb_diarrheaposttestq3a2,
            rb_diarrheaposttestq3a3,
            rb_diarrheaposttestq3a4,
            rb_diarrheaposttestq4a1,
            rb_diarrheaposttestq4a2,
            rb_diarrheaposttestq4a3,
            rb_diarrheaposttestq4a4,
            rb_diarrheaposttestq5a1,
            rb_diarrheaposttestq5a2,
            rb_diarrheaposttestq5a3,
            rb_diarrheaposttestq5a4,
            rb_diarrheaposttestq6a1,
            rb_diarrheaposttestq6a2,
            rb_diarrheaposttestq6a3,
            rb_diarrheaposttestq6a4,
            rb_diarrheaposttestq7a1,
            rb_diarrheaposttestq7a2,
            rb_diarrheaposttestq7a3,
            rb_diarrheaposttestq7a4,
            rb_diarrheaposttestq8a1,
            rb_diarrheaposttestq8a2,
            rb_diarrheaposttestq8a3,
            rb_diarrheaposttestq8a4,
            rb_diarrheaposttestq9a1,
            rb_diarrheaposttestq9a2,
            rb_diarrheaposttestq9a3,
            rb_diarrheaposttestq9a4,
            rb_diarrheaposttestq10a1,
            rb_diarrheaposttestq10a2,
            rb_diarrheaposttestq10a3,
            rb_diarrheaposttestq10a4;

    EditText
            ed_cnic_no,
            ed_pretest_result;

    String
            cnic_no,
            diarrheaposttest_date,
            diarrheaposttest_time,
            diarrheaposttestq1,
            diarrheaposttestq2,
            diarrheaposttestq3,
            diarrheaposttestq4,
            diarrheaposttestq5,
            diarrheaposttestq6,
            diarrheaposttestq7,
            diarrheaposttestq8,
            diarrheaposttestq9,
            diarrheaposttestq10,
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

        btn_diarrheaposttestsubmit = findViewById(R.id.btn_diarrheaposttestsubmit);

        ll_diarrheaposttestq1 = findViewById(R.id.ll_diarrheaposttestq1);
        ll_diarrheaposttestq2 = findViewById(R.id.ll_diarrheaposttestq2);
        ll_diarrheaposttestq3 = findViewById(R.id.ll_diarrheaposttestq3);
        ll_diarrheaposttestq4 = findViewById(R.id.ll_diarrheaposttestq4);
        ll_diarrheaposttestq5 = findViewById(R.id.ll_diarrheaposttestq5);
        ll_diarrheaposttestq6 = findViewById(R.id.ll_diarrheaposttestq6);
        ll_diarrheaposttestq7 = findViewById(R.id.ll_diarrheaposttestq7);
        ll_diarrheaposttestq8 = findViewById(R.id.ll_diarrheaposttestq8);
        ll_diarrheaposttestq9 = findViewById(R.id.ll_diarrheaposttestq9);
        ll_diarrheaposttestq10 = findViewById(R.id.ll_diarrheaposttestq10);

        txt_diarrheaposttestq1 = findViewById(R.id.txt_diarrheaposttestq1);
        txt_diarrheaposttestq2 = findViewById(R.id.txt_diarrheaposttestq2);
        txt_diarrheaposttestq3 = findViewById(R.id.txt_diarrheaposttestq3);
        txt_diarrheaposttestq4 = findViewById(R.id.txt_diarrheaposttestq4);
        txt_diarrheaposttestq7 = findViewById(R.id.txt_diarrheaposttestq7);
        txt_diarrheaposttestq9 = findViewById(R.id.txt_diarrheaposttestq9);
        txt_diarrheaposttestq10 = findViewById(R.id.txt_diarrheaposttestq10);

        rb_diarrheaposttestq1a1 = findViewById(R.id.rb_diarrheaposttestq1a1);
        rb_diarrheaposttestq1a2 = findViewById(R.id.rb_diarrheaposttestq1a2);
        rb_diarrheaposttestq1a3 = findViewById(R.id.rb_diarrheaposttestq1a3);
        rb_diarrheaposttestq1a4 = findViewById(R.id.rb_diarrheaposttestq1a4);
        rb_diarrheaposttestq2a1 = findViewById(R.id.rb_diarrheaposttestq2a1);
        rb_diarrheaposttestq2a2 = findViewById(R.id.rb_diarrheaposttestq2a2);
        rb_diarrheaposttestq2a3 = findViewById(R.id.rb_diarrheaposttestq2a3);
        rb_diarrheaposttestq2a4 = findViewById(R.id.rb_diarrheaposttestq2a4);
        rb_diarrheaposttestq3a1 = findViewById(R.id.rb_diarrheaposttestq3a1);
        rb_diarrheaposttestq3a2 = findViewById(R.id.rb_diarrheaposttestq3a2);
        rb_diarrheaposttestq3a3 = findViewById(R.id.rb_diarrheaposttestq3a3);
        rb_diarrheaposttestq3a4 = findViewById(R.id.rb_diarrheaposttestq3a4);
        rb_diarrheaposttestq4a1 = findViewById(R.id.rb_diarrheaposttestq4a1);
        rb_diarrheaposttestq4a2 = findViewById(R.id.rb_diarrheaposttestq4a2);
        rb_diarrheaposttestq4a3 = findViewById(R.id.rb_diarrheaposttestq4a3);
        rb_diarrheaposttestq4a4 = findViewById(R.id.rb_diarrheaposttestq4a4);
        rb_diarrheaposttestq5a1 = findViewById(R.id.rb_diarrheaposttestq5a1);
        rb_diarrheaposttestq5a2 = findViewById(R.id.rb_diarrheaposttestq5a2);
        rb_diarrheaposttestq5a3 = findViewById(R.id.rb_diarrheaposttestq5a3);
        rb_diarrheaposttestq5a4 = findViewById(R.id.rb_diarrheaposttestq5a4);
        rb_diarrheaposttestq6a1 = findViewById(R.id.rb_diarrheaposttestq6a1);
        rb_diarrheaposttestq6a2 = findViewById(R.id.rb_diarrheaposttestq6a2);
        rb_diarrheaposttestq6a3 = findViewById(R.id.rb_diarrheaposttestq6a3);
        rb_diarrheaposttestq6a4 = findViewById(R.id.rb_diarrheaposttestq6a4);
        rb_diarrheaposttestq7a1 = findViewById(R.id.rb_diarrheaposttestq7a1);
        rb_diarrheaposttestq7a2 = findViewById(R.id.rb_diarrheaposttestq7a2);
        rb_diarrheaposttestq7a3 = findViewById(R.id.rb_diarrheaposttestq7a3);
        rb_diarrheaposttestq7a4 = findViewById(R.id.rb_diarrheaposttestq7a4);
        rb_diarrheaposttestq8a1 = findViewById(R.id.rb_diarrheaposttestq8a1);
        rb_diarrheaposttestq8a2 = findViewById(R.id.rb_diarrheaposttestq8a2);
        rb_diarrheaposttestq8a3 = findViewById(R.id.rb_diarrheaposttestq8a3);
        rb_diarrheaposttestq8a4 = findViewById(R.id.rb_diarrheaposttestq8a4);
        rb_diarrheaposttestq9a1 = findViewById(R.id.rb_diarrheaposttestq9a1);
        rb_diarrheaposttestq9a2 = findViewById(R.id.rb_diarrheaposttestq9a2);
        rb_diarrheaposttestq9a3 = findViewById(R.id.rb_diarrheaposttestq9a3);
        rb_diarrheaposttestq9a4 = findViewById(R.id.rb_diarrheaposttestq9a4);
        rb_diarrheaposttestq10a1 = findViewById(R.id.rb_diarrheaposttestq10a1);
        rb_diarrheaposttestq10a2 = findViewById(R.id.rb_diarrheaposttestq10a2);
        rb_diarrheaposttestq10a3 = findViewById(R.id.rb_diarrheaposttestq10a3);
        rb_diarrheaposttestq10a4 = findViewById(R.id.rb_diarrheaposttestq10a4);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diarrhea_post_test);

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

        diarrheaposttest_date = SToday;
        diarrheaposttest_time = STime;
    }

    @Override
    public void onClick(View view) {
        if (validateField() == false) {
            Toast.makeText(this, "Required fields are missing", Toast.LENGTH_LONG).show();
            return;
        }

        value_assignment();
        insert_data();

        Intent intent = new Intent(DiarrheaPostTest.this, InterviewEnd.class);
        intent.putExtra("cnic_no", cnic_no);
        intent.putExtra("training", "Diarrhea");
        intent.putExtra("pretest_result", pretest_result);
        intent.putExtra("posttest_result", posttest_result);
        intent.putExtra("ptp", ptp);
        startActivity(intent);
        this.finish();
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {


        //Diarrhea-Q1  
        if (compoundButton.getId() == R.id.rb_diarrheaposttestq1a1
                || compoundButton.getId() == R.id.rb_diarrheaposttestq1a2
                || compoundButton.getId() == R.id.rb_diarrheaposttestq1a3
                || compoundButton.getId() == R.id.rb_diarrheaposttestq1a4) {

            if (rb_diarrheaposttestq1a1.isChecked()) {
                txt_diarrheaposttestq1.clearComposingText();
                String styledText = "1- The death of a child with acute diarrhea is usually due to <font color='blue'><b><i>Dehydration</i></b></font>.";
                txt_diarrheaposttestq1.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);

            } else if (rb_diarrheaposttestq1a2.isChecked()) {
                txt_diarrheaposttestq1.clearComposingText();
                String styledText = "1- The death of a child with acute diarrhea is usually due to <font color='blue'><b><i>Dysentery</i></b></font>.";
                txt_diarrheaposttestq1.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheaposttestq1a3.isChecked()) {
                txt_diarrheaposttestq1.clearComposingText();
                String styledText = "1- The death of a child with acute diarrhea is usually due to <font color='blue'><b><i>Hydration</i></b></font>.";
                txt_diarrheaposttestq1.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheaposttestq1a4.isChecked()) {
                txt_diarrheaposttestq1.clearComposingText();
                String styledText = "1- The death of a child with acute diarrhea is usually due to <font color='blue'><b><i>Malnutrition</i></b></font>.";
                txt_diarrheaposttestq1.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }


        //Diarrhea-Q2  
        if (compoundButton.getId() == R.id.rb_diarrheaposttestq2a1
                || compoundButton.getId() == R.id.rb_diarrheaposttestq2a2
                || compoundButton.getId() == R.id.rb_diarrheaposttestq2a3
                || compoundButton.getId() == R.id.rb_diarrheaposttestq2a4) {

            if (rb_diarrheaposttestq2a1.isChecked()) {
                txt_diarrheaposttestq2.clearComposingText();
                String styledText = "2- A child with persistent diarrhea needs Zinc DT for <font color='blue'><b><i>10</i></b></font> days.";
                txt_diarrheaposttestq2.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheaposttestq2a2.isChecked()) {
                txt_diarrheaposttestq2.clearComposingText();
                String styledText = "2- A child with persistent diarrhea needs Zinc DT for <font color='blue'><b><i>12</i></b></font> days.";
                txt_diarrheaposttestq2.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheaposttestq2a3.isChecked()) {
                txt_diarrheaposttestq2.clearComposingText();
                String styledText = "2- A child with persistent diarrhea needs Zinc DT for <font color='blue'><b><i>14</i></b></font> days.";
                txt_diarrheaposttestq2.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheaposttestq2a4.isChecked()) {
                txt_diarrheaposttestq2.clearComposingText();
                String styledText = "2- A child with persistent diarrhea needs Zinc DT for <font color='blue'><b><i>16</i></b></font> days.";
                txt_diarrheaposttestq2.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }


        //Diarrhea-Q3  
        if (compoundButton.getId() == R.id.rb_diarrheaposttestq3a1
                || compoundButton.getId() == R.id.rb_diarrheaposttestq3a2
                || compoundButton.getId() == R.id.rb_diarrheaposttestq3a3
                || compoundButton.getId() == R.id.rb_diarrheaposttestq3a4) {

            if (rb_diarrheaposttestq3a1.isChecked()) {
                txt_diarrheaposttestq3.clearComposingText();
                String styledText = "3- The antibiotic postscribed for dysentery is <font color='blue'><b><i>Ciprofloxacin</i></b></font> for 3 days.";
                txt_diarrheaposttestq3.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheaposttestq3a2.isChecked()) {
                txt_diarrheaposttestq3.clearComposingText();
                String styledText = "3- The antibiotic postscribed for dysentery is <font color='blue'><b><i>Amoxicillin</i></b></font> for 3 days.";
                txt_diarrheaposttestq3.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheaposttestq3a3.isChecked()) {
                txt_diarrheaposttestq3.clearComposingText();
                String styledText = "3- The antibiotic postscribed for dysentery is <font color='blue'><b><i>Ampicillin</i></b></font> for 3 days.";
                txt_diarrheaposttestq3.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheaposttestq3a4.isChecked()) {
                txt_diarrheaposttestq3.clearComposingText();
                String styledText = "3- The antibiotic postscribed for dysentery is <font color='blue'><b><i>Diazepam</i></b></font> for 3 days.";
                txt_diarrheaposttestq3.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }


        //Diarrhea-Q4   
        if (compoundButton.getId() == R.id.rb_diarrheaposttestq4a1
                || compoundButton.getId() == R.id.rb_diarrheaposttestq4a2
                || compoundButton.getId() == R.id.rb_diarrheaposttestq4a3
                || compoundButton.getId() == R.id.rb_diarrheaposttestq4a4) {

            if (rb_diarrheaposttestq4a1.isChecked()) {
                txt_diarrheaposttestq4.clearComposingText();
                String styledText = "4- The common cause of dysentery is <font color='blue'><b><i>Brucella</i></b></font> bacteria.";
                txt_diarrheaposttestq4.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheaposttestq4a2.isChecked()) {
                txt_diarrheaposttestq4.clearComposingText();
                String styledText = "4- The common cause of dysentery is <font color='blue'><b><i>Shigella</i></b></font> bacteria.";
                txt_diarrheaposttestq4.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheaposttestq4a3.isChecked()) {
                txt_diarrheaposttestq4.clearComposingText();
                String styledText = "4- The common cause of dysentery is <font color='blue'><b><i>Bacillus</i></b></font> bacteria.";
                txt_diarrheaposttestq4.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheaposttestq4a4.isChecked()) {
                txt_diarrheaposttestq4.clearComposingText();
                String styledText = "4- The common cause of dysentery is <font color='blue'><b><i>Salmonella</i></b></font> bacteria.";
                txt_diarrheaposttestq4.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }


        //Diarrhea-Q7   
        if (compoundButton.getId() == R.id.rb_diarrheaposttestq7a1
                || compoundButton.getId() == R.id.rb_diarrheaposttestq7a2
                || compoundButton.getId() == R.id.rb_diarrheaposttestq7a3
                || compoundButton.getId() == R.id.rb_diarrheaposttestq7a4) {

            if (rb_diarrheaposttestq7a1.isChecked()) {
                txt_diarrheaposttestq7.clearComposingText();
                String styledText = "7- Children with diarrhea who come to a health worker with NO <font color='blue'><b><i>Dehydration</i></b></font> are put on plan A.";
                txt_diarrheaposttestq7.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheaposttestq7a2.isChecked()) {
                txt_diarrheaposttestq7.clearComposingText();
                String styledText = "7- Children with diarrhea who come to a health worker with NO <font color='blue'><b><i>Dysentery</i></b></font> are put on plan A.";
                txt_diarrheaposttestq7.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheaposttestq7a3.isChecked()) {
                txt_diarrheaposttestq7.clearComposingText();
                String styledText = "7- Children with diarrhea who come to a health worker with NO <font color='blue'><b><i>Hydration</i></b></font> are put on plan A.";
                txt_diarrheaposttestq7.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheaposttestq7a4.isChecked()) {
                txt_diarrheaposttestq7.clearComposingText();
                String styledText = "7- Children with diarrhea who come to a health worker with NO <font color='blue'><b><i>Pneumonia</i></b></font> are put on plan A.";
                txt_diarrheaposttestq7.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }


        //Diarrhea-Q9  
        if (compoundButton.getId() == R.id.rb_diarrheaposttestq9a1
                || compoundButton.getId() == R.id.rb_diarrheaposttestq9a2
                || compoundButton.getId() == R.id.rb_diarrheaposttestq9a3
                || compoundButton.getId() == R.id.rb_diarrheaposttestq9a4) {

            if (rb_diarrheaposttestq9a1.isChecked()) {
                txt_diarrheaposttestq9.clearComposingText();
                String styledText = "9- What is the dose of Zinc DT for home treatment for a child 6 months or older <font color='blue'><b><i>(&#189;) tablet per day for 12 days</i></b></font>.";
                txt_diarrheaposttestq9.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheaposttestq9a2.isChecked()) {
                txt_diarrheaposttestq9.clearComposingText();
                String styledText = "9- What is the dose of Zinc DT for home treatment for a child 6 months or older <font color='blue'><b><i>1 tablet per day for 10 days</i></b></font>.";
                txt_diarrheaposttestq9.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheaposttestq9a3.isChecked()) {
                txt_diarrheaposttestq9.clearComposingText();
                String styledText = "9- What is the dose of Zinc DT for home treatment for a child 6 months or older <font color='blue'><b><i>1.5 tablets per day for 11 days</i></b></font>.";
                txt_diarrheaposttestq9.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheaposttestq9a4.isChecked()) {
                txt_diarrheaposttestq9.clearComposingText();
                String styledText = "9- What is the dose of Zinc DT for home treatment for a child 6 months or older <font color='blue'><b><i>2 tablets per day for 10 days</i></b></font>.";
                txt_diarrheaposttestq9.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }


        //Diarrhea-Q10  
        if (compoundButton.getId() == R.id.rb_diarrheaposttestq10a1
                || compoundButton.getId() == R.id.rb_diarrheaposttestq10a2
                || compoundButton.getId() == R.id.rb_diarrheaposttestq10a3
                || compoundButton.getId() == R.id.rb_diarrheaposttestq10a4) {

            if (rb_diarrheaposttestq10a1.isChecked()) {
                txt_diarrheaposttestq10.clearComposingText();
                String styledText = "10- <font color='blue'><b><i>PCV</i></b></font> vaccination is recommended for diarrhea by WHO for children  < 5 years.";
                txt_diarrheaposttestq10.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheaposttestq10a2.isChecked()) {
                txt_diarrheaposttestq10.clearComposingText();
                String styledText = "10- <font color='blue'><b><i>Hib</i></b></font> vaccination is recommended for diarrhea by WHO for children  < 5 years.";
                txt_diarrheaposttestq10.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheaposttestq10a3.isChecked()) {
                txt_diarrheaposttestq10.clearComposingText();
                String styledText = "10- <font color='blue'><b><i>Pertussis</i></b></font> vaccination is recommended for diarrhea by WHO for children  < 5 years.";
                txt_diarrheaposttestq10.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheaposttestq10a4.isChecked()) {
                txt_diarrheaposttestq10.clearComposingText();
                String styledText = "10- <font color='blue'><b><i>Rotavirus</i></b></font> vaccination is recommended for diarrhea by WHO for children  < 5 years.";
                txt_diarrheaposttestq10.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }

    }

    void events_call() {

        btn_diarrheaposttestsubmit.setOnClickListener(this);

        rb_diarrheaposttestq1a1.setOnCheckedChangeListener(this);
        rb_diarrheaposttestq1a2.setOnCheckedChangeListener(this);
        rb_diarrheaposttestq1a3.setOnCheckedChangeListener(this);
        rb_diarrheaposttestq1a4.setOnCheckedChangeListener(this);

        rb_diarrheaposttestq2a1.setOnCheckedChangeListener(this);
        rb_diarrheaposttestq2a2.setOnCheckedChangeListener(this);
        rb_diarrheaposttestq2a3.setOnCheckedChangeListener(this);
        rb_diarrheaposttestq2a4.setOnCheckedChangeListener(this);

        rb_diarrheaposttestq3a1.setOnCheckedChangeListener(this);
        rb_diarrheaposttestq3a2.setOnCheckedChangeListener(this);
        rb_diarrheaposttestq3a3.setOnCheckedChangeListener(this);
        rb_diarrheaposttestq3a4.setOnCheckedChangeListener(this);

        rb_diarrheaposttestq4a1.setOnCheckedChangeListener(this);
        rb_diarrheaposttestq4a2.setOnCheckedChangeListener(this);
        rb_diarrheaposttestq4a3.setOnCheckedChangeListener(this);
        rb_diarrheaposttestq4a4.setOnCheckedChangeListener(this);

        rb_diarrheaposttestq7a1.setOnCheckedChangeListener(this);
        rb_diarrheaposttestq7a2.setOnCheckedChangeListener(this);
        rb_diarrheaposttestq7a3.setOnCheckedChangeListener(this);
        rb_diarrheaposttestq7a4.setOnCheckedChangeListener(this);

        rb_diarrheaposttestq9a1.setOnCheckedChangeListener(this);
        rb_diarrheaposttestq9a2.setOnCheckedChangeListener(this);
        rb_diarrheaposttestq9a3.setOnCheckedChangeListener(this);
        rb_diarrheaposttestq9a4.setOnCheckedChangeListener(this);

        rb_diarrheaposttestq10a1.setOnCheckedChangeListener(this);
        rb_diarrheaposttestq10a2.setOnCheckedChangeListener(this);
        rb_diarrheaposttestq10a3.setOnCheckedChangeListener(this);
        rb_diarrheaposttestq10a4.setOnCheckedChangeListener(this);
    }

    void value_assignment() {

        cnic_no = "0";
        diarrheaposttestq1 = "-1";
        diarrheaposttestq2 = "-1";
        diarrheaposttestq3 = "-1";
        diarrheaposttestq4 = "-1";
        diarrheaposttestq5 = "-1";
        diarrheaposttestq6 = "-1";
        diarrheaposttestq7 = "-1";
        diarrheaposttestq8 = "-1";
        diarrheaposttestq9 = "-1";
        diarrheaposttestq10 = "-1";
        posttest_result = "0";
        STATUS = "0";


        int temp = 0;
        if (ed_cnic_no.getText().toString().length() > 0) {
            cnic_no = ed_cnic_no.getText().toString().trim();
        }

        //Q1
        if (rb_diarrheaposttestq1a1.isChecked()) {
            diarrheaposttestq1 = "1";
            temp = temp + 1;
        }
        if (rb_diarrheaposttestq1a2.isChecked()) {
            diarrheaposttestq1 = "2";
        }
        if (rb_diarrheaposttestq1a3.isChecked()) {
            diarrheaposttestq1 = "3";
        }
        if (rb_diarrheaposttestq1a4.isChecked()) {
            diarrheaposttestq1 = "4";
        }

        //Q2
        if (rb_diarrheaposttestq2a1.isChecked()) {
            diarrheaposttestq2 = "1";
            temp = temp + 1;
        }
        if (rb_diarrheaposttestq2a2.isChecked()) {
            diarrheaposttestq2 = "2";
        }
        if (rb_diarrheaposttestq2a3.isChecked()) {
            diarrheaposttestq2 = "3";
        }
        if (rb_diarrheaposttestq2a4.isChecked()) {
            diarrheaposttestq2 = "4";
        }

        //Q3
        if (rb_diarrheaposttestq3a1.isChecked()) {
            diarrheaposttestq3 = "1";
            temp = temp + 1;
        }
        if (rb_diarrheaposttestq3a2.isChecked()) {
            diarrheaposttestq3 = "2";
        }
        if (rb_diarrheaposttestq3a3.isChecked()) {
            diarrheaposttestq3 = "3";
        }
        if (rb_diarrheaposttestq3a4.isChecked()) {
            diarrheaposttestq3 = "4";
        }

        //Q4
        if (rb_diarrheaposttestq4a1.isChecked()) {
            diarrheaposttestq4 = "1";
        }
        if (rb_diarrheaposttestq4a2.isChecked()) {
            diarrheaposttestq4 = "2";
            temp = temp + 1;
        }
        if (rb_diarrheaposttestq4a3.isChecked()) {
            diarrheaposttestq4 = "3";
        }
        if (rb_diarrheaposttestq4a4.isChecked()) {
            diarrheaposttestq4 = "4";
        }

        //Q5
        if (rb_diarrheaposttestq5a1.isChecked()) {
            diarrheaposttestq5 = "1";
        }
        if (rb_diarrheaposttestq5a2.isChecked()) {
            diarrheaposttestq5 = "2";
        }
        if (rb_diarrheaposttestq5a3.isChecked()) {
            diarrheaposttestq5 = "3";
        }
        if (rb_diarrheaposttestq5a4.isChecked()) {
            diarrheaposttestq5 = "4";
            temp = temp + 1;
        }

        //Q6
        if (rb_diarrheaposttestq6a1.isChecked()) {
            diarrheaposttestq6 = "1";
        }
        if (rb_diarrheaposttestq6a2.isChecked()) {
            diarrheaposttestq6 = "2";
            temp = temp + 1;
        }
        if (rb_diarrheaposttestq6a3.isChecked()) {
            diarrheaposttestq6 = "3";
        }
        if (rb_diarrheaposttestq6a4.isChecked()) {
            diarrheaposttestq6 = "4";
        }

        //Q7
        if (rb_diarrheaposttestq7a1.isChecked()) {
            diarrheaposttestq7 = "1";
            temp = temp + 1;
        }
        if (rb_diarrheaposttestq7a2.isChecked()) {
            diarrheaposttestq7 = "2";
        }
        if (rb_diarrheaposttestq7a3.isChecked()) {
            diarrheaposttestq7 = "3";
        }
        if (rb_diarrheaposttestq7a4.isChecked()) {
            diarrheaposttestq7 = "4";
        }

        //Q8
        if (rb_diarrheaposttestq8a1.isChecked()) {
            diarrheaposttestq8 = "1";
        }
        if (rb_diarrheaposttestq8a2.isChecked()) {
            diarrheaposttestq8 = "2";
            temp = temp + 1;
        }
        if (rb_diarrheaposttestq8a3.isChecked()) {
            diarrheaposttestq8 = "3";
        }
        if (rb_diarrheaposttestq8a4.isChecked()) {
            diarrheaposttestq8 = "4";
        }

        //Q9
        if (rb_diarrheaposttestq9a1.isChecked()) {
            diarrheaposttestq9 = "1";
        }
        if (rb_diarrheaposttestq9a2.isChecked()) {
            diarrheaposttestq9 = "2";
            temp = temp + 1;
        }
        if (rb_diarrheaposttestq9a3.isChecked()) {
            diarrheaposttestq9 = "3";
        }
        if (rb_diarrheaposttestq9a4.isChecked()) {
            diarrheaposttestq9 = "4";
        }

        //Q10
        if (rb_diarrheaposttestq10a1.isChecked()) {
            diarrheaposttestq10 = "1";
        }
        if (rb_diarrheaposttestq10a2.isChecked()) {
            diarrheaposttestq10 = "2";
        }
        if (rb_diarrheaposttestq10a3.isChecked()) {
            diarrheaposttestq10 = "3";
        }
        if (rb_diarrheaposttestq10a4.isChecked()) {
            diarrheaposttestq10 = "4";
            temp = temp + 1;
        }

        posttest_result = String.valueOf(temp);
        ptp = Math.round(Double.parseDouble(posttest_result) / 10 * 100);
    }

    void insert_data() {
        String query = "insert into DiarrheaPostTest("

                + Global.Diarrhea.DiarrheaPostTest.fk_id + ","
                + Global.Diarrhea.DiarrheaPostTest.cnic_no + ","
                + Global.Diarrhea.DiarrheaPostTest.diarrheaposttest_date + ","
                + Global.Diarrhea.DiarrheaPostTest.diarrheaposttest_time + ","
                + Global.Diarrhea.DiarrheaPostTest.diarrheaposttestq1 + ","
                + Global.Diarrhea.DiarrheaPostTest.diarrheaposttestq2 + ","
                + Global.Diarrhea.DiarrheaPostTest.diarrheaposttestq3 + ","
                + Global.Diarrhea.DiarrheaPostTest.diarrheaposttestq4 + ","
                + Global.Diarrhea.DiarrheaPostTest.diarrheaposttestq5 + ","
                + Global.Diarrhea.DiarrheaPostTest.diarrheaposttestq6 + ","
                + Global.Diarrhea.DiarrheaPostTest.diarrheaposttestq7 + ","
                + Global.Diarrhea.DiarrheaPostTest.diarrheaposttestq8 + ","
                + Global.Diarrhea.DiarrheaPostTest.diarrheaposttestq9 + ","
                + Global.Diarrhea.DiarrheaPostTest.diarrheaposttestq10 + ","
                + Global.Diarrhea.DiarrheaPostTest.posttest_result + ","
                + Global.Diarrhea.DiarrheaPostTest.STATUS + ")" +

                " values ('" +

                Global.Session_Start.pk_id + "','" +
                cnic_no + "','" +
                diarrheaposttest_date + "','" +
                diarrheaposttest_time + "','" +
                diarrheaposttestq1 + "','" +
                diarrheaposttestq2 + "','" +
                diarrheaposttestq3 + "','" +
                diarrheaposttestq4 + "','" +
                diarrheaposttestq5 + "','" +
                diarrheaposttestq6 + "','" +
                diarrheaposttestq7 + "','" +
                diarrheaposttestq8 + "','" +
                diarrheaposttestq9 + "','" +
                diarrheaposttestq10 + "','" +
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

        if (Gothrough.IamHiden(ll_diarrheaposttestq1) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_diarrheaposttestq2) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_diarrheaposttestq3) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_diarrheaposttestq4) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_diarrheaposttestq5) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_diarrheaposttestq6) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_diarrheaposttestq7) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_diarrheaposttestq8) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_diarrheaposttestq9) == false) {
            return false;
        }

        return Gothrough.IamHiden(ll_diarrheaposttestq10) != false;
    }

    public void onBackPressed() {
        Toast.makeText(this, "You are not allowed to go on back screen SORRY!!! \nIf you want to do so PLEASE CONTACT Dr. Samia", Toast.LENGTH_LONG).show();
    }


}
