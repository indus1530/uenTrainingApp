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

import com.example.abdulsajid.mnchtraining.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import Global.Session_Start;
import data.LocalDataManager;
import utils.Gothrough;

public class DiarrheaPreTest extends AppCompatActivity implements RadioButton.OnCheckedChangeListener, View.OnClickListener {

    //Declaration 
    TextView
            txt_diarrheapretestq1,
            txt_diarrheapretestq2,
            txt_diarrheapretestq3,
            txt_diarrheapretestq4,
            txt_diarrheapretestq7,
            txt_diarrheapretestq9,
            txt_diarrheapretestq10;

    Button
            btn_diarrheapretestsubmit;

    LinearLayout
            ll_cnic,
            ll_diarrheapretestq1,
            ll_diarrheapretestq2,
            ll_diarrheapretestq3,
            ll_diarrheapretestq4,
            ll_diarrheapretestq5,
            ll_diarrheapretestq6,
            ll_diarrheapretestq7,
            ll_diarrheapretestq8,
            ll_diarrheapretestq9,
            ll_diarrheapretestq10;


    RadioButton
            rb_diarrheapretestq1a1,
            rb_diarrheapretestq1a2,
            rb_diarrheapretestq1a3,
            rb_diarrheapretestq1a4,
            rb_diarrheapretestq2a1,
            rb_diarrheapretestq2a2,
            rb_diarrheapretestq2a3,
            rb_diarrheapretestq2a4,
            rb_diarrheapretestq3a1,
            rb_diarrheapretestq3a2,
            rb_diarrheapretestq3a3,
            rb_diarrheapretestq3a4,
            rb_diarrheapretestq4a1,
            rb_diarrheapretestq4a2,
            rb_diarrheapretestq4a3,
            rb_diarrheapretestq4a4,
            rb_diarrheapretestq5a1,
            rb_diarrheapretestq5a2,
            rb_diarrheapretestq5a3,
            rb_diarrheapretestq5a4,
            rb_diarrheapretestq6a1,
            rb_diarrheapretestq6a2,
            rb_diarrheapretestq6a3,
            rb_diarrheapretestq6a4,
            rb_diarrheapretestq7a1,
            rb_diarrheapretestq7a2,
            rb_diarrheapretestq7a3,
            rb_diarrheapretestq7a4,
            rb_diarrheapretestq8a1,
            rb_diarrheapretestq8a2,
            rb_diarrheapretestq8a3,
            rb_diarrheapretestq8a4,
            rb_diarrheapretestq9a1,
            rb_diarrheapretestq9a2,
            rb_diarrheapretestq9a3,
            rb_diarrheapretestq9a4,
            rb_diarrheapretestq10a1,
            rb_diarrheapretestq10a2,
            rb_diarrheapretestq10a3,
            rb_diarrheapretestq10a4;

    EditText
            ed_cnic_no;

    String
            cnic_no,
            diarrheapretest_date,
            diarrheapretest_time,
            diarrheapretestq1,
            diarrheapretestq2,
            diarrheapretestq3,
            diarrheapretestq4,
            diarrheapretestq5,
            diarrheapretestq6,
            diarrheapretestq7,
            diarrheapretestq8,
            diarrheapretestq9,
            diarrheapretestq10,
            pretest_result,
            STATUS;

    int currentSection;

    void Initialization() {
        ll_cnic = findViewById(R.id.ll_cnic);
        ed_cnic_no = findViewById(R.id.ed_cnic_no);

        btn_diarrheapretestsubmit = findViewById(R.id.btn_diarrheapretestsubmit);

        ll_cnic = findViewById(R.id.ll_cnic);
        ll_diarrheapretestq1 = findViewById(R.id.ll_diarrheapretestq1);
        ll_diarrheapretestq2 = findViewById(R.id.ll_diarrheapretestq2);
        ll_diarrheapretestq3 = findViewById(R.id.ll_diarrheapretestq3);
        ll_diarrheapretestq4 = findViewById(R.id.ll_diarrheapretestq4);
        ll_diarrheapretestq5 = findViewById(R.id.ll_diarrheapretestq5);
        ll_diarrheapretestq6 = findViewById(R.id.ll_diarrheapretestq6);
        ll_diarrheapretestq7 = findViewById(R.id.ll_diarrheapretestq7);
        ll_diarrheapretestq8 = findViewById(R.id.ll_diarrheapretestq8);
        ll_diarrheapretestq9 = findViewById(R.id.ll_diarrheapretestq9);
        ll_diarrheapretestq10 = findViewById(R.id.ll_diarrheapretestq10);

        txt_diarrheapretestq1 = findViewById(R.id.txt_diarrheapretestq1);
        txt_diarrheapretestq2 = findViewById(R.id.txt_diarrheapretestq2);
        txt_diarrheapretestq3 = findViewById(R.id.txt_diarrheapretestq3);
        txt_diarrheapretestq4 = findViewById(R.id.txt_diarrheapretestq4);
        txt_diarrheapretestq7 = findViewById(R.id.txt_diarrheapretestq7);
        txt_diarrheapretestq9 = findViewById(R.id.txt_diarrheapretestq9);
        txt_diarrheapretestq10 = findViewById(R.id.txt_diarrheapretestq10);

        rb_diarrheapretestq1a1 = findViewById(R.id.rb_diarrheapretestq1a1);
        rb_diarrheapretestq1a2 = findViewById(R.id.rb_diarrheapretestq1a2);
        rb_diarrheapretestq1a3 = findViewById(R.id.rb_diarrheapretestq1a3);
        rb_diarrheapretestq1a4 = findViewById(R.id.rb_diarrheapretestq1a4);
        rb_diarrheapretestq2a1 = findViewById(R.id.rb_diarrheapretestq2a1);
        rb_diarrheapretestq2a2 = findViewById(R.id.rb_diarrheapretestq2a2);
        rb_diarrheapretestq2a3 = findViewById(R.id.rb_diarrheapretestq2a3);
        rb_diarrheapretestq2a4 = findViewById(R.id.rb_diarrheapretestq2a4);
        rb_diarrheapretestq3a1 = findViewById(R.id.rb_diarrheapretestq3a1);
        rb_diarrheapretestq3a2 = findViewById(R.id.rb_diarrheapretestq3a2);
        rb_diarrheapretestq3a3 = findViewById(R.id.rb_diarrheapretestq3a3);
        rb_diarrheapretestq3a4 = findViewById(R.id.rb_diarrheapretestq3a4);
        rb_diarrheapretestq4a1 = findViewById(R.id.rb_diarrheapretestq4a1);
        rb_diarrheapretestq4a2 = findViewById(R.id.rb_diarrheapretestq4a2);
        rb_diarrheapretestq4a3 = findViewById(R.id.rb_diarrheapretestq4a3);
        rb_diarrheapretestq4a4 = findViewById(R.id.rb_diarrheapretestq4a4);
        rb_diarrheapretestq5a1 = findViewById(R.id.rb_diarrheapretestq5a1);
        rb_diarrheapretestq5a2 = findViewById(R.id.rb_diarrheapretestq5a2);
        rb_diarrheapretestq5a3 = findViewById(R.id.rb_diarrheapretestq5a3);
        rb_diarrheapretestq5a4 = findViewById(R.id.rb_diarrheapretestq5a4);
        rb_diarrheapretestq6a1 = findViewById(R.id.rb_diarrheapretestq6a1);
        rb_diarrheapretestq6a2 = findViewById(R.id.rb_diarrheapretestq6a2);
        rb_diarrheapretestq6a3 = findViewById(R.id.rb_diarrheapretestq6a3);
        rb_diarrheapretestq6a4 = findViewById(R.id.rb_diarrheapretestq6a4);
        rb_diarrheapretestq7a1 = findViewById(R.id.rb_diarrheapretestq7a1);
        rb_diarrheapretestq7a2 = findViewById(R.id.rb_diarrheapretestq7a2);
        rb_diarrheapretestq7a3 = findViewById(R.id.rb_diarrheapretestq7a3);
        rb_diarrheapretestq7a4 = findViewById(R.id.rb_diarrheapretestq7a4);
        rb_diarrheapretestq8a1 = findViewById(R.id.rb_diarrheapretestq8a1);
        rb_diarrheapretestq8a2 = findViewById(R.id.rb_diarrheapretestq8a2);
        rb_diarrheapretestq8a3 = findViewById(R.id.rb_diarrheapretestq8a3);
        rb_diarrheapretestq8a4 = findViewById(R.id.rb_diarrheapretestq8a4);
        rb_diarrheapretestq9a1 = findViewById(R.id.rb_diarrheapretestq9a1);
        rb_diarrheapretestq9a2 = findViewById(R.id.rb_diarrheapretestq9a2);
        rb_diarrheapretestq9a3 = findViewById(R.id.rb_diarrheapretestq9a3);
        rb_diarrheapretestq9a4 = findViewById(R.id.rb_diarrheapretestq9a4);
        rb_diarrheapretestq10a1 = findViewById(R.id.rb_diarrheapretestq10a1);
        rb_diarrheapretestq10a2 = findViewById(R.id.rb_diarrheapretestq10a2);
        rb_diarrheapretestq10a3 = findViewById(R.id.rb_diarrheapretestq10a3);
        rb_diarrheapretestq10a4 = findViewById(R.id.rb_diarrheapretestq10a4);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diarrhea_pre_test);

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

        diarrheapretest_date = SToday;
        diarrheapretest_time = STime;
    }

    @Override
    public void onClick(View view) {
        if (validateField() == false) {
            Toast.makeText(this, "Required fields are missing", Toast.LENGTH_LONG).show();
            return;
        }

        value_assignment();
        insert_data();

        Intent intent = new Intent(DiarrheaPreTest.this, DiarrheaTraining.class);
        intent.putExtra("cnic_no", cnic_no);
        intent.putExtra("pretest_result", pretest_result);
        startActivity(intent);
        this.finish();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {


        //Diarrhea-Q1
        if (compoundButton.getId() == R.id.rb_diarrheapretestq1a1
                || compoundButton.getId() == R.id.rb_diarrheapretestq1a2
                || compoundButton.getId() == R.id.rb_diarrheapretestq1a3
                || compoundButton.getId() == R.id.rb_diarrheapretestq1a4) {

            if (rb_diarrheapretestq1a1.isChecked()) {
                txt_diarrheapretestq1.clearComposingText();
                String styledText = "1- The death of a child with acute diarrhea is usually due to <font color='blue'><b><i>Dehydration</i></b></font>.";
                txt_diarrheapretestq1.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);

            } else if (rb_diarrheapretestq1a2.isChecked()) {
                txt_diarrheapretestq1.clearComposingText();
                String styledText = "1- The death of a child with acute diarrhea is usually due to <font color='blue'><b><i>Dysentery</i></b></font>.";
                txt_diarrheapretestq1.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheapretestq1a3.isChecked()) {
                txt_diarrheapretestq1.clearComposingText();
                String styledText = "1- The death of a child with acute diarrhea is usually due to <font color='blue'><b><i>Hydration</i></b></font>.";
                txt_diarrheapretestq1.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheapretestq1a4.isChecked()) {
                txt_diarrheapretestq1.clearComposingText();
                String styledText = "1- The death of a child with acute diarrhea is usually due to <font color='blue'><b><i>Malnutrition</i></b></font>.";
                txt_diarrheapretestq1.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }


        //Diarrhea-Q2
        if (compoundButton.getId() == R.id.rb_diarrheapretestq2a1
                || compoundButton.getId() == R.id.rb_diarrheapretestq2a2
                || compoundButton.getId() == R.id.rb_diarrheapretestq2a3
                || compoundButton.getId() == R.id.rb_diarrheapretestq2a4) {

            if (rb_diarrheapretestq2a1.isChecked()) {
                txt_diarrheapretestq2.clearComposingText();
                String styledText = "2- A child with persistent diarrhea needs Zinc DT for <font color='blue'><b><i>10</i></b></font> days.";
                txt_diarrheapretestq2.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheapretestq2a2.isChecked()) {
                txt_diarrheapretestq2.clearComposingText();
                String styledText = "2- A child with persistent diarrhea needs Zinc DT for <font color='blue'><b><i>12</i></b></font> days.";
                txt_diarrheapretestq2.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheapretestq2a3.isChecked()) {
                txt_diarrheapretestq2.clearComposingText();
                String styledText = "2- A child with persistent diarrhea needs Zinc DT for <font color='blue'><b><i>14</i></b></font> days.";
                txt_diarrheapretestq2.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheapretestq2a4.isChecked()) {
                txt_diarrheapretestq2.clearComposingText();
                String styledText = "2- A child with persistent diarrhea needs Zinc DT for <font color='blue'><b><i>16</i></b></font> days.";
                txt_diarrheapretestq2.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }


        //Diarrhea-Q3
        if (compoundButton.getId() == R.id.rb_diarrheapretestq3a1
                || compoundButton.getId() == R.id.rb_diarrheapretestq3a2
                || compoundButton.getId() == R.id.rb_diarrheapretestq3a3
                || compoundButton.getId() == R.id.rb_diarrheapretestq3a4) {

            if (rb_diarrheapretestq3a1.isChecked()) {
                txt_diarrheapretestq3.clearComposingText();
                String styledText = "3- The antibiotic prescribed for dysentery is <font color='blue'><b><i>Ciprofloxacin</i></b></font> for 3 days.";
                txt_diarrheapretestq3.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheapretestq3a2.isChecked()) {
                txt_diarrheapretestq3.clearComposingText();
                String styledText = "3- The antibiotic prescribed for dysentery is <font color='blue'><b><i>Amoxicillin</i></b></font> for 3 days.";
                txt_diarrheapretestq3.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheapretestq3a3.isChecked()) {
                txt_diarrheapretestq3.clearComposingText();
                String styledText = "3- The antibiotic prescribed for dysentery is <font color='blue'><b><i>Ampicillin</i></b></font> for 3 days.";
                txt_diarrheapretestq3.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheapretestq3a4.isChecked()) {
                txt_diarrheapretestq3.clearComposingText();
                String styledText = "3- The antibiotic prescribed for dysentery is <font color='blue'><b><i>Diazepam</i></b></font> for 3 days.";
                txt_diarrheapretestq3.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }


        //Diarrhea-Q4
        if (compoundButton.getId() == R.id.rb_diarrheapretestq4a1
                || compoundButton.getId() == R.id.rb_diarrheapretestq4a2
                || compoundButton.getId() == R.id.rb_diarrheapretestq4a3
                || compoundButton.getId() == R.id.rb_diarrheapretestq4a4) {

            if (rb_diarrheapretestq4a1.isChecked()) {
                txt_diarrheapretestq4.clearComposingText();
                String styledText = "4- The common cause of dysentery is <font color='blue'><b><i>Brucella</i></b></font> bacteria.";
                txt_diarrheapretestq4.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheapretestq4a2.isChecked()) {
                txt_diarrheapretestq4.clearComposingText();
                String styledText = "4- The common cause of dysentery is <font color='blue'><b><i>Shigella</i></b></font> bacteria.";
                txt_diarrheapretestq4.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheapretestq4a3.isChecked()) {
                txt_diarrheapretestq4.clearComposingText();
                String styledText = "4- The common cause of dysentery is <font color='blue'><b><i>Bacillus</i></b></font> bacteria.";
                txt_diarrheapretestq4.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheapretestq4a4.isChecked()) {
                txt_diarrheapretestq4.clearComposingText();
                String styledText = "4- The common cause of dysentery is <font color='blue'><b><i>Salmonella</i></b></font> bacteria.";
                txt_diarrheapretestq4.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }


        //Diarrhea-Q7
        if (compoundButton.getId() == R.id.rb_diarrheapretestq7a1
                || compoundButton.getId() == R.id.rb_diarrheapretestq7a2
                || compoundButton.getId() == R.id.rb_diarrheapretestq7a3
                || compoundButton.getId() == R.id.rb_diarrheapretestq7a4) {

            if (rb_diarrheapretestq7a1.isChecked()) {
                txt_diarrheapretestq7.clearComposingText();
                String styledText = "7- Children with diarrhea who come to a health worker with NO <font color='blue'><b><i>Dehydration</i></b></font> are put on plan A.";
                txt_diarrheapretestq7.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheapretestq7a2.isChecked()) {
                txt_diarrheapretestq7.clearComposingText();
                String styledText = "7- Children with diarrhea who come to a health worker with NO <font color='blue'><b><i>Dysentery</i></b></font> are put on plan A.";
                txt_diarrheapretestq7.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheapretestq7a3.isChecked()) {
                txt_diarrheapretestq7.clearComposingText();
                String styledText = "7- Children with diarrhea who come to a health worker with NO <font color='blue'><b><i>Hydration</i></b></font> are put on plan A.";
                txt_diarrheapretestq7.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheapretestq7a4.isChecked()) {
                txt_diarrheapretestq7.clearComposingText();
                String styledText = "7- Children with diarrhea who come to a health worker with NO <font color='blue'><b><i>Pneumonia</i></b></font> are put on plan A.";
                txt_diarrheapretestq7.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }


        //Diarrhea-Q9
        if (compoundButton.getId() == R.id.rb_diarrheapretestq9a1
                || compoundButton.getId() == R.id.rb_diarrheapretestq9a2
                || compoundButton.getId() == R.id.rb_diarrheapretestq9a3
                || compoundButton.getId() == R.id.rb_diarrheapretestq9a4) {

            if (rb_diarrheapretestq9a1.isChecked()) {
                txt_diarrheapretestq9.clearComposingText();
                String styledText = "9- What is the dose of Zinc DT for home treatment for a child 6 months or older <font color='blue'><b><i>(&#189;) tablet per day for 12 days</i></b></font>.";
                txt_diarrheapretestq9.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheapretestq9a2.isChecked()) {
                txt_diarrheapretestq9.clearComposingText();
                String styledText = "9- What is the dose of Zinc DT for home treatment for a child 6 months or older <font color='blue'><b><i>1 tablet per day for 10 days</i></b></font>.";
                txt_diarrheapretestq9.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheapretestq9a3.isChecked()) {
                txt_diarrheapretestq9.clearComposingText();
                String styledText = "9- What is the dose of Zinc DT for home treatment for a child 6 months or older <font color='blue'><b><i>1.5 tablets per day for 11 days</i></b></font>.";
                txt_diarrheapretestq9.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheapretestq9a4.isChecked()) {
                txt_diarrheapretestq9.clearComposingText();
                String styledText = "9- What is the dose of Zinc DT for home treatment for a child 6 months or older <font color='blue'><b><i>2 tablets per day for 10 days</i></b></font>.";
                txt_diarrheapretestq9.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }


        //Diarrhea-Q10
        if (compoundButton.getId() == R.id.rb_diarrheapretestq10a1
                || compoundButton.getId() == R.id.rb_diarrheapretestq10a2
                || compoundButton.getId() == R.id.rb_diarrheapretestq10a3
                || compoundButton.getId() == R.id.rb_diarrheapretestq10a4) {

            if (rb_diarrheapretestq10a1.isChecked()) {
                txt_diarrheapretestq10.clearComposingText();
                String styledText = "10- <font color='blue'><b><i>PCV</i></b></font> vaccination is recommended for diarrhea by WHO for children  < 5 years.";
                txt_diarrheapretestq10.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheapretestq10a2.isChecked()) {
                txt_diarrheapretestq10.clearComposingText();
                String styledText = "10- <font color='blue'><b><i>Hib</i></b></font> vaccination is recommended for diarrhea by WHO for children  < 5 years.";
                txt_diarrheapretestq10.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheapretestq10a3.isChecked()) {
                txt_diarrheapretestq10.clearComposingText();
                String styledText = "10- <font color='blue'><b><i>Pertussis</i></b></font> vaccination is recommended for diarrhea by WHO for children  < 5 years.";
                txt_diarrheapretestq10.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_diarrheapretestq10a4.isChecked()) {
                txt_diarrheapretestq10.clearComposingText();
                String styledText = "10- <font color='blue'><b><i>Rotavirus</i></b></font> vaccination is recommended for diarrhea by WHO for children  < 5 years.";
                txt_diarrheapretestq10.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }

    }

    void events_call() {

        btn_diarrheapretestsubmit.setOnClickListener(this);

        rb_diarrheapretestq1a1.setOnCheckedChangeListener(this);
        rb_diarrheapretestq1a2.setOnCheckedChangeListener(this);
        rb_diarrheapretestq1a3.setOnCheckedChangeListener(this);
        rb_diarrheapretestq1a4.setOnCheckedChangeListener(this);

        rb_diarrheapretestq2a1.setOnCheckedChangeListener(this);
        rb_diarrheapretestq2a2.setOnCheckedChangeListener(this);
        rb_diarrheapretestq2a3.setOnCheckedChangeListener(this);
        rb_diarrheapretestq2a4.setOnCheckedChangeListener(this);

        rb_diarrheapretestq3a1.setOnCheckedChangeListener(this);
        rb_diarrheapretestq3a2.setOnCheckedChangeListener(this);
        rb_diarrheapretestq3a3.setOnCheckedChangeListener(this);
        rb_diarrheapretestq3a4.setOnCheckedChangeListener(this);

        rb_diarrheapretestq4a1.setOnCheckedChangeListener(this);
        rb_diarrheapretestq4a2.setOnCheckedChangeListener(this);
        rb_diarrheapretestq4a3.setOnCheckedChangeListener(this);
        rb_diarrheapretestq4a4.setOnCheckedChangeListener(this);

        rb_diarrheapretestq7a1.setOnCheckedChangeListener(this);
        rb_diarrheapretestq7a2.setOnCheckedChangeListener(this);
        rb_diarrheapretestq7a3.setOnCheckedChangeListener(this);
        rb_diarrheapretestq7a4.setOnCheckedChangeListener(this);

        rb_diarrheapretestq9a1.setOnCheckedChangeListener(this);
        rb_diarrheapretestq9a2.setOnCheckedChangeListener(this);
        rb_diarrheapretestq9a3.setOnCheckedChangeListener(this);
        rb_diarrheapretestq9a4.setOnCheckedChangeListener(this);

        rb_diarrheapretestq10a1.setOnCheckedChangeListener(this);
        rb_diarrheapretestq10a2.setOnCheckedChangeListener(this);
        rb_diarrheapretestq10a3.setOnCheckedChangeListener(this);
        rb_diarrheapretestq10a4.setOnCheckedChangeListener(this);
    }

    void value_assignment() {

        pretest_result = "0";
        STATUS = "0";

        int temp = 0;

        cnic_no = ed_cnic_no.getText().toString().length() > 0 ? ed_cnic_no.getText().toString().trim() : "0";

        //Q1
        diarrheapretestq1 = rb_diarrheapretestq1a1.isChecked() ? "1"
                : rb_diarrheapretestq1a2.isChecked() ? "2"
                : rb_diarrheapretestq1a3.isChecked() ? "3"
                : rb_diarrheapretestq1a4.isChecked() ? "4"
                : "-1";
        temp = diarrheapretestq1.equals("1") ? temp + 1 : temp;

        //Q2
        diarrheapretestq2 = rb_diarrheapretestq2a1.isChecked() ? "1"
                : rb_diarrheapretestq2a2.isChecked() ? "2"
                : rb_diarrheapretestq2a3.isChecked() ? "3"
                : rb_diarrheapretestq2a4.isChecked() ? "4"
                : "-1";
        temp = diarrheapretestq2.equals("1") ? temp + 1 : temp;

        //Q3
        diarrheapretestq3 = rb_diarrheapretestq3a1.isChecked() ? "1"
                : rb_diarrheapretestq3a2.isChecked() ? "2"
                : rb_diarrheapretestq3a3.isChecked() ? "3"
                : rb_diarrheapretestq3a4.isChecked() ? "4"
                : "-1";
        temp = diarrheapretestq3.equals("1") ? temp + 1 : temp;

        //Q4
        diarrheapretestq4 = rb_diarrheapretestq4a1.isChecked() ? "1"
                : rb_diarrheapretestq4a2.isChecked() ? "2"
                : rb_diarrheapretestq4a3.isChecked() ? "3"
                : rb_diarrheapretestq4a4.isChecked() ? "4"
                : "-1";
        temp = diarrheapretestq4.equals("2") ? temp + 1 : temp;

        //Q5
        diarrheapretestq5 = rb_diarrheapretestq5a1.isChecked() ? "1"
                : rb_diarrheapretestq5a2.isChecked() ? "2"
                : rb_diarrheapretestq5a3.isChecked() ? "3"
                : rb_diarrheapretestq5a4.isChecked() ? "4"
                : "-1";
        temp = diarrheapretestq5.equals("4") ? temp + 1 : temp;

        //Q6
        if (rb_diarrheapretestq6a1.isChecked()) {
            diarrheapretestq6 = "1";
        }
        if (rb_diarrheapretestq6a2.isChecked()) {
            diarrheapretestq6 = "2";
            temp = temp + 1;
        }
        if (rb_diarrheapretestq6a3.isChecked()) {
            diarrheapretestq6 = "3";
        }
        if (rb_diarrheapretestq6a4.isChecked()) {
            diarrheapretestq6 = "4";
        }

        //Q7
        if (rb_diarrheapretestq7a1.isChecked()) {
            diarrheapretestq7 = "1";
            temp = temp + 1;
        }
        if (rb_diarrheapretestq7a2.isChecked()) {
            diarrheapretestq7 = "2";
        }
        if (rb_diarrheapretestq7a3.isChecked()) {
            diarrheapretestq7 = "3";
        }
        if (rb_diarrheapretestq7a4.isChecked()) {
            diarrheapretestq7 = "4";
        }

        //Q8
        if (rb_diarrheapretestq8a1.isChecked()) {
            diarrheapretestq8 = "1";
        }
        if (rb_diarrheapretestq8a2.isChecked()) {
            diarrheapretestq8 = "2";
            temp = temp + 1;
        }
        if (rb_diarrheapretestq8a3.isChecked()) {
            diarrheapretestq8 = "3";
        }
        if (rb_diarrheapretestq8a4.isChecked()) {
            diarrheapretestq8 = "4";
        }

        //Q9
        if (rb_diarrheapretestq9a1.isChecked()) {
            diarrheapretestq9 = "1";
        }
        if (rb_diarrheapretestq9a2.isChecked()) {
            diarrheapretestq9 = "2";
            temp = temp + 1;
        }
        if (rb_diarrheapretestq9a3.isChecked()) {
            diarrheapretestq9 = "3";
        }
        if (rb_diarrheapretestq9a4.isChecked()) {
            diarrheapretestq9 = "4";
        }

        //Q10
        if (rb_diarrheapretestq10a1.isChecked()) {
            diarrheapretestq10 = "1";
        }
        if (rb_diarrheapretestq10a2.isChecked()) {
            diarrheapretestq10 = "2";
        }
        if (rb_diarrheapretestq10a3.isChecked()) {
            diarrheapretestq10 = "3";
        }
        if (rb_diarrheapretestq10a4.isChecked()) {
            diarrheapretestq10 = "4";
            temp = temp + 1;
        }

        pretest_result = String.valueOf(temp);
    }

    void insert_data() {
        String query = "insert into DiarrheaPreTest("

                + Global.Diarrhea.DiarrheaPreTest.fk_id + ","
                + Global.Diarrhea.DiarrheaPreTest.cnic_no + ","
                + Global.Diarrhea.DiarrheaPreTest.diarrheapretest_date + ","
                + Global.Diarrhea.DiarrheaPreTest.diarrheapretest_time + ","
                + Global.Diarrhea.DiarrheaPreTest.diarrheapretestq1 + ","
                + Global.Diarrhea.DiarrheaPreTest.diarrheapretestq2 + ","
                + Global.Diarrhea.DiarrheaPreTest.diarrheapretestq3 + ","
                + Global.Diarrhea.DiarrheaPreTest.diarrheapretestq4 + ","
                + Global.Diarrhea.DiarrheaPreTest.diarrheapretestq5 + ","
                + Global.Diarrhea.DiarrheaPreTest.diarrheapretestq6 + ","
                + Global.Diarrhea.DiarrheaPreTest.diarrheapretestq7 + ","
                + Global.Diarrhea.DiarrheaPreTest.diarrheapretestq8 + ","
                + Global.Diarrhea.DiarrheaPreTest.diarrheapretestq9 + ","
                + Global.Diarrhea.DiarrheaPreTest.diarrheapretestq10 + ","
                + Global.Diarrhea.DiarrheaPreTest.pretest_result + ","
                + Global.Diarrhea.DiarrheaPreTest.STATUS + ")" +

                " values ('" +

                Session_Start.pk_id + "','" +
                cnic_no + "','" +
                diarrheapretest_date + "','" +
                diarrheapretest_time + "','" +
                diarrheapretestq1 + "','" +
                diarrheapretestq2 + "','" +
                diarrheapretestq3 + "','" +
                diarrheapretestq4 + "','" +
                diarrheapretestq5 + "','" +
                diarrheapretestq6 + "','" +
                diarrheapretestq7 + "','" +
                diarrheapretestq8 + "','" +
                diarrheapretestq9 + "','" +
                diarrheapretestq10 + "','" +
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

        if (Gothrough.IamHiden(ll_diarrheapretestq1) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_diarrheapretestq2) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_diarrheapretestq3) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_diarrheapretestq4) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_diarrheapretestq5) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_diarrheapretestq6) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_diarrheapretestq7) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_diarrheapretestq8) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_diarrheapretestq9) == false) {
            return false;
        }

        return Gothrough.IamHiden(ll_diarrheapretestq10) != false;
    }

    public void onBackPressed() {
        Toast.makeText(this, "You are not allowed to go on back screen SORRY!!! \nIf you want to do so PLEASE CONTACT Dr. Samia", Toast.LENGTH_LONG).show();
    }


}
