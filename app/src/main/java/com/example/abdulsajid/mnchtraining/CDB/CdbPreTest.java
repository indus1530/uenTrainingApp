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

import Global.CDB.CDBPreTest;
import data.LocalDataManager;
import utils.Gothrough;

public class CdbPreTest extends AppCompatActivity implements RadioButton.OnCheckedChangeListener, View.OnClickListener {

    //Declaration  
    TextView
            txt_cdbpretestq1,
            txt_cdbpretestq2,
            txt_cdbpretestq3,
            txt_cdbpretestq4,
            txt_cdbpretestq5,
            txt_cdbpretestq6,
            txt_cdbpretestq7,
            txt_cdbpretestq8,
            txt_cdbpretestq9,
            txt_cdbpretestq10;

    Button
            btn_cdbpretestsubmit;

    LinearLayout
            ll_cnic,
            ll_cdbpretestq1,
            ll_cdbpretestq2,
            ll_cdbpretestq3,
            ll_cdbpretestq4,
            ll_cdbpretestq5,
            ll_cdbpretestq6,
            ll_cdbpretestq7,
            ll_cdbpretestq8,
            ll_cdbpretestq9,
            ll_cdbpretestq10;


    RadioButton
            rb_cdbpretestq1a1,
            rb_cdbpretestq1a2,
            rb_cdbpretestq1a3,
            rb_cdbpretestq1a4,
            rb_cdbpretestq2a1,
            rb_cdbpretestq2a2,
            rb_cdbpretestq2a3,
            rb_cdbpretestq2a4,
            rb_cdbpretestq3a1,
            rb_cdbpretestq3a2,
            rb_cdbpretestq3a3,
            rb_cdbpretestq3a4,
            rb_cdbpretestq4a1,
            rb_cdbpretestq4a2,
            rb_cdbpretestq5a1,
            rb_cdbpretestq5a2,
            rb_cdbpretestq5a3,
            rb_cdbpretestq5a4,
            rb_cdbpretestq6a1,
            rb_cdbpretestq6a2,
            rb_cdbpretestq6a3,
            rb_cdbpretestq6a4,
            rb_cdbpretestq7a1,
            rb_cdbpretestq7a2,
            rb_cdbpretestq7a3,
            rb_cdbpretestq7a4,
            rb_cdbpretestq8a1,
            rb_cdbpretestq8a2,
            rb_cdbpretestq8a3,
            rb_cdbpretestq8a4,
            rb_cdbpretestq9a1,
            rb_cdbpretestq9a2,
            rb_cdbpretestq9a3,
            rb_cdbpretestq9a4,
            rb_cdbpretestq10a1,
            rb_cdbpretestq10a2,
            rb_cdbpretestq10a3,
            rb_cdbpretestq10a4;

    EditText
            ed_cnic_no;

    String
            cnic_no,
            cdbpretest_date,
            cdbpretest_time,
            cdbpretestq1,
            cdbpretestq2,
            cdbpretestq3,
            cdbpretestq4,
            cdbpretestq5,
            cdbpretestq6,
            cdbpretestq7,
            cdbpretestq8,
            cdbpretestq9,
            cdbpretestq10,
            pretest_result,
            STATUS;

    int currentSection;

    void Initialization() {
        ll_cnic = findViewById(R.id.ll_cnic);
        ed_cnic_no = findViewById(R.id.ed_cnic_no);

        btn_cdbpretestsubmit = findViewById(R.id.btn_cdbpretestsubmit);

        ll_cnic = findViewById(R.id.ll_cnic);
        ll_cdbpretestq1 = findViewById(R.id.ll_cdbpretestq1);
        ll_cdbpretestq2 = findViewById(R.id.ll_cdbpretestq2);
        ll_cdbpretestq3 = findViewById(R.id.ll_cdbpretestq3);
        ll_cdbpretestq4 = findViewById(R.id.ll_cdbpretestq4);
        ll_cdbpretestq5 = findViewById(R.id.ll_cdbpretestq5);
        ll_cdbpretestq6 = findViewById(R.id.ll_cdbpretestq6);
        ll_cdbpretestq7 = findViewById(R.id.ll_cdbpretestq7);
        ll_cdbpretestq8 = findViewById(R.id.ll_cdbpretestq8);
        ll_cdbpretestq9 = findViewById(R.id.ll_cdbpretestq9);
        ll_cdbpretestq10 = findViewById(R.id.ll_cdbpretestq10);

        txt_cdbpretestq1 = findViewById(R.id.txt_cdbpretestq1);
        txt_cdbpretestq2 = findViewById(R.id.txt_cdbpretestq2);
        txt_cdbpretestq3 = findViewById(R.id.txt_cdbpretestq3);
        txt_cdbpretestq4 = findViewById(R.id.txt_cdbpretestq4);
        txt_cdbpretestq5 = findViewById(R.id.txt_cdbpretestq5);
        txt_cdbpretestq6 = findViewById(R.id.txt_cdbpretestq6);
        txt_cdbpretestq7 = findViewById(R.id.txt_cdbpretestq7);
        txt_cdbpretestq8 = findViewById(R.id.txt_cdbpretestq8);
        txt_cdbpretestq9 = findViewById(R.id.txt_cdbpretestq9);
        txt_cdbpretestq10 = findViewById(R.id.txt_cdbpretestq10);

        rb_cdbpretestq1a1 = findViewById(R.id.rb_cdbpretestq1a1);
        rb_cdbpretestq1a2 = findViewById(R.id.rb_cdbpretestq1a2);
        rb_cdbpretestq1a3 = findViewById(R.id.rb_cdbpretestq1a3);
        rb_cdbpretestq1a4 = findViewById(R.id.rb_cdbpretestq1a4);
        rb_cdbpretestq2a1 = findViewById(R.id.rb_cdbpretestq2a1);
        rb_cdbpretestq2a2 = findViewById(R.id.rb_cdbpretestq2a2);
        rb_cdbpretestq2a3 = findViewById(R.id.rb_cdbpretestq2a3);
        rb_cdbpretestq2a4 = findViewById(R.id.rb_cdbpretestq2a4);
        rb_cdbpretestq3a1 = findViewById(R.id.rb_cdbpretestq3a1);
        rb_cdbpretestq3a2 = findViewById(R.id.rb_cdbpretestq3a2);
        rb_cdbpretestq3a3 = findViewById(R.id.rb_cdbpretestq3a3);
        rb_cdbpretestq3a4 = findViewById(R.id.rb_cdbpretestq3a4);
        rb_cdbpretestq4a1 = findViewById(R.id.rb_cdbpretestq4a1);
        rb_cdbpretestq4a2 = findViewById(R.id.rb_cdbpretestq4a2);
        rb_cdbpretestq5a1 = findViewById(R.id.rb_cdbpretestq5a1);
        rb_cdbpretestq5a2 = findViewById(R.id.rb_cdbpretestq5a2);
        rb_cdbpretestq5a3 = findViewById(R.id.rb_cdbpretestq5a3);
        rb_cdbpretestq5a4 = findViewById(R.id.rb_cdbpretestq5a4);
        rb_cdbpretestq6a1 = findViewById(R.id.rb_cdbpretestq6a1);
        rb_cdbpretestq6a2 = findViewById(R.id.rb_cdbpretestq6a2);
        rb_cdbpretestq6a3 = findViewById(R.id.rb_cdbpretestq6a3);
        rb_cdbpretestq6a4 = findViewById(R.id.rb_cdbpretestq6a4);
        rb_cdbpretestq7a1 = findViewById(R.id.rb_cdbpretestq7a1);
        rb_cdbpretestq7a2 = findViewById(R.id.rb_cdbpretestq7a2);
        rb_cdbpretestq7a3 = findViewById(R.id.rb_cdbpretestq7a3);
        rb_cdbpretestq7a4 = findViewById(R.id.rb_cdbpretestq7a4);
        rb_cdbpretestq8a1 = findViewById(R.id.rb_cdbpretestq8a1);
        rb_cdbpretestq8a2 = findViewById(R.id.rb_cdbpretestq8a2);
        rb_cdbpretestq8a3 = findViewById(R.id.rb_cdbpretestq8a3);
        rb_cdbpretestq8a4 = findViewById(R.id.rb_cdbpretestq8a4);
        rb_cdbpretestq9a1 = findViewById(R.id.rb_cdbpretestq9a1);
        rb_cdbpretestq9a2 = findViewById(R.id.rb_cdbpretestq9a2);
        rb_cdbpretestq9a3 = findViewById(R.id.rb_cdbpretestq9a3);
        rb_cdbpretestq9a4 = findViewById(R.id.rb_cdbpretestq9a4);
        rb_cdbpretestq10a1 = findViewById(R.id.rb_cdbpretestq10a1);
        rb_cdbpretestq10a2 = findViewById(R.id.rb_cdbpretestq10a2);
        rb_cdbpretestq10a3 = findViewById(R.id.rb_cdbpretestq10a3);
        rb_cdbpretestq10a4 = findViewById(R.id.rb_cdbpretestq10a4);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cdb_pre_test);

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

        cdbpretest_date = SToday;
        cdbpretest_time = STime;
    }

    @Override
    public void onClick(View view) {
        if (validateField() == false) {
            Toast.makeText(this, "Required fields are missing", Toast.LENGTH_LONG).show();
            return;
        }

        value_assignment();
        insert_data();

        Intent intent = new Intent(this, CdbTraining.class);
        intent.putExtra("cnic_no", cnic_no);
        intent.putExtra("pretest_result", pretest_result);
        startActivity(intent);
        this.finish();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {


        //GDS-Q1  
        if (compoundButton.getId() == R.id.rb_cdbpretestq1a1
                || compoundButton.getId() == R.id.rb_cdbpretestq1a2
                || compoundButton.getId() == R.id.rb_cdbpretestq1a3
                || compoundButton.getId() == R.id.rb_cdbpretestq1a4) {

            if (rb_cdbpretestq1a1.isChecked()) {
                txt_cdbpretestq1.clearComposingText();
                String styledText = "1- Cough or difficult breathing that lasts for more than 14 days may indicate <font color='blue'><b><i>Tuberculosis</i></b></font>.";
                txt_cdbpretestq1.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_cdbpretestq1a2.isChecked()) {
                txt_cdbpretestq1.clearComposingText();
                String styledText = "1- Cough or difficult breathing that lasts for more than 14 days may indicate <font color='blue'><b><i>Asthma</i></b></font>.";
                txt_cdbpretestq1.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_cdbpretestq1a3.isChecked()) {
                txt_cdbpretestq1.clearComposingText();
                String styledText = "1- Cough or difficult breathing that lasts for more than 14 days may indicate <font color='blue'><b><i>Whooping cough</i></b></font>.";
                txt_cdbpretestq1.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_cdbpretestq1a4.isChecked()) {
                txt_cdbpretestq1.clearComposingText();
                String styledText = "1- Cough or difficult breathing that lasts for more than 14 days may indicate <font color='blue'><b><i>All of the below</i></b></font>.";
                txt_cdbpretestq1.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }


        //GDS-Q3  
        if (compoundButton.getId() == R.id.rb_cdbpretestq3a1
                || compoundButton.getId() == R.id.rb_cdbpretestq3a2
                || compoundButton.getId() == R.id.rb_cdbpretestq3a3
                || compoundButton.getId() == R.id.rb_cdbpretestq3a4) {

            if (rb_cdbpretestq3a1.isChecked()) {
                txt_cdbpretestq3.clearComposingText();
                String styledText = "3- Fast breathing or <font color='blue'><b><i>Wheeze</i></b></font> if present in a child between 2 months to 5 years of age are the clinical signs for Pneumonia.";
                txt_cdbpretestq3.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_cdbpretestq3a2.isChecked()) {
                txt_cdbpretestq3.clearComposingText();
                String styledText = "3- Fast breathing or <font color='blue'><b><i>Chest in-drawing</i></b></font> if present in a child between 2 months to 5 years of age are the clinical signs for Pneumonia.";
                txt_cdbpretestq3.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_cdbpretestq3a3.isChecked()) {
                txt_cdbpretestq3.clearComposingText();
                String styledText = "3- Fast breathing or <font color='blue'><b><i>Cough</i></b></font> if present in a child between 2 months to 5 years of age are the clinical signs for Pneumonia.";
                txt_cdbpretestq3.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_cdbpretestq3a4.isChecked()) {
                txt_cdbpretestq3.clearComposingText();
                String styledText = "3- Fast breathing or <font color='blue'><b><i>Fever</i></b></font> if present in a child between 2 months to 5 years of age are the clinical signs for Pneumonia.";
                txt_cdbpretestq3.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }


        //GDS-Q4   
        if (compoundButton.getId() == R.id.rb_cdbpretestq4a1
                || compoundButton.getId() == R.id.rb_cdbpretestq4a2) {

            if (rb_cdbpretestq4a1.isChecked()) {
                txt_cdbpretestq4.clearComposingText();
                String styledText = "4- The child has chest in drawing if the lower chest wall (lower ribs) goes <font color='blue'><b><i>IN</i></b></font> when the child breathes IN.";
                txt_cdbpretestq4.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_cdbpretestq4a2.isChecked()) {
                txt_cdbpretestq4.clearComposingText();
                String styledText = "4- The child has chest in drawing if the lower chest wall (lower ribs) goes <font color='blue'><b><i>OUT</i></b></font> when the child breathes IN.";
                txt_cdbpretestq4.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }


        //GDS-Q6
        if (compoundButton.getId() == R.id.rb_cdbpretestq6a1
                || compoundButton.getId() == R.id.rb_cdbpretestq6a2
                || compoundButton.getId() == R.id.rb_cdbpretestq6a3
                || compoundButton.getId() == R.id.rb_cdbpretestq6a4) {

            if (rb_cdbpretestq6a1.isChecked()) {
                txt_cdbpretestq6.clearComposingText();
                String styledText = "6- The dose for intramuscular antibiotics (urgent referral); Ampicillin <font color='blue'><b><i>40</i></b></font>mg/kg and Gentamicin <font color='blue'><b><i>7</i></b></font>mg/kg.";
                txt_cdbpretestq6.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_cdbpretestq6a2.isChecked()) {
                txt_cdbpretestq6.clearComposingText();
                String styledText = "6- The dose for intramuscular antibiotics (urgent referral); Ampicillin <font color='blue'><b><i>45</i></b></font>mg/kg and Gentamicin <font color='blue'><b><i>7.5</i></b></font>mg/kg.";
                txt_cdbpretestq6.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_cdbpretestq6a3.isChecked()) {
                txt_cdbpretestq6.clearComposingText();
                String styledText = "6- The dose for intramuscular antibiotics (urgent referral); Ampicillin <font color='blue'><b><i>50</i></b></font>mg/kg and Gentamicin <font color='blue'><b><i>7.5</i></b></font>mg/kg.";
                txt_cdbpretestq6.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_cdbpretestq6a4.isChecked()) {
                txt_cdbpretestq6.clearComposingText();
                String styledText = "6- The dose for intramuscular antibiotics (urgent referral); Ampicillin <font color='blue'><b><i>55</i></b></font>mg/kg and Gentamicin <font color='blue'><b><i>8</i></b></font>mg/kg.";
                txt_cdbpretestq6.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }


        //GDS-Q8
        if (compoundButton.getId() == R.id.rb_cdbpretestq8a1
                || compoundButton.getId() == R.id.rb_cdbpretestq8a2
                || compoundButton.getId() == R.id.rb_cdbpretestq8a3
                || compoundButton.getId() == R.id.rb_cdbpretestq8a4) {

            if (rb_cdbpretestq8a1.isChecked()) {
                txt_cdbpretestq8.clearComposingText();
                String styledText = "8- Standard flow rates for oxygen through nasal prongs or nasal catheters are up to <font color='blue'><b><i>2</i></b></font> L/min for infants, up to <font color='blue'><b><i>4</i></b></font> L/min for older children.";
                txt_cdbpretestq8.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_cdbpretestq8a2.isChecked()) {
                txt_cdbpretestq8.clearComposingText();
                String styledText = "8- Standard flow rates for oxygen through nasal prongs or nasal catheters are up to <font color='blue'><b><i>3</i></b></font> L/min for infants, up to <font color='blue'><b><i>4</i></b></font> L/min for older children.";
                txt_cdbpretestq8.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_cdbpretestq8a3.isChecked()) {
                txt_cdbpretestq8.clearComposingText();
                String styledText = "8- Standard flow rates for oxygen through nasal prongs or nasal catheters are up to <font color='blue'><b><i>3.5</i></b></font> L/min for infants, up to <font color='blue'><b><i>4.5</i></b></font> L/min for older children.";
                txt_cdbpretestq8.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_cdbpretestq8a4.isChecked()) {
                txt_cdbpretestq8.clearComposingText();
                String styledText = "8- Standard flow rates for oxygen through nasal prongs or nasal catheters are up to <font color='blue'><b><i>4</i></b></font> L/min for infants, up to <font color='blue'><b><i>4.5</i></b></font> L/min for older children.";
                txt_cdbpretestq8.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }

    }

    void events_call() {

        btn_cdbpretestsubmit.setOnClickListener(this);

        rb_cdbpretestq1a1.setOnCheckedChangeListener(this);
        rb_cdbpretestq1a2.setOnCheckedChangeListener(this);
        rb_cdbpretestq1a3.setOnCheckedChangeListener(this);
        rb_cdbpretestq1a4.setOnCheckedChangeListener(this);

        rb_cdbpretestq3a1.setOnCheckedChangeListener(this);
        rb_cdbpretestq3a2.setOnCheckedChangeListener(this);
        rb_cdbpretestq3a3.setOnCheckedChangeListener(this);
        rb_cdbpretestq3a4.setOnCheckedChangeListener(this);

        rb_cdbpretestq4a1.setOnCheckedChangeListener(this);
        rb_cdbpretestq4a2.setOnCheckedChangeListener(this);

        rb_cdbpretestq6a1.setOnCheckedChangeListener(this);
        rb_cdbpretestq6a2.setOnCheckedChangeListener(this);
        rb_cdbpretestq6a3.setOnCheckedChangeListener(this);
        rb_cdbpretestq6a4.setOnCheckedChangeListener(this);

        rb_cdbpretestq8a1.setOnCheckedChangeListener(this);
        rb_cdbpretestq8a2.setOnCheckedChangeListener(this);
        rb_cdbpretestq8a3.setOnCheckedChangeListener(this);
        rb_cdbpretestq8a4.setOnCheckedChangeListener(this);
    }

    void value_assignment() {

        cnic_no = "0";
        cdbpretestq1 = "-1";
        cdbpretestq2 = "-1";
        cdbpretestq3 = "-1";
        cdbpretestq4 = "-1";
        cdbpretestq5 = "-1";
        cdbpretestq6 = "-1";
        cdbpretestq7 = "-1";
        cdbpretestq8 = "-1";
        cdbpretestq9 = "-1";
        cdbpretestq10 = "-1";
        pretest_result = "0";
        STATUS = "0";


        int temp = 0;

        cnic_no = ed_cnic_no.getText().toString().length() > 0 ? ed_cnic_no.getText().toString().trim() : "0";

        //Q1
        cdbpretestq1 = rb_cdbpretestq1a1.isChecked() ? "1"
                : rb_cdbpretestq1a2.isChecked() ? "2"
                : rb_cdbpretestq1a3.isChecked() ? "3"
                : rb_cdbpretestq1a4.isChecked() ? "4"
                : "-1";
        temp = cdbpretestq1.equals("4") ? temp + 1 : temp;

        //Q2
        cdbpretestq2 = rb_cdbpretestq2a1.isChecked() ? "1"
                : rb_cdbpretestq2a2.isChecked() ? "2"
                : rb_cdbpretestq2a3.isChecked() ? "3"
                : rb_cdbpretestq2a4.isChecked() ? "4"
                : "-1";
        temp = cdbpretestq2.equals("3") ? temp + 1 : temp;

        //Q3
        cdbpretestq3 = rb_cdbpretestq3a1.isChecked() ? "1"
                : rb_cdbpretestq3a2.isChecked() ? "2"
                : rb_cdbpretestq3a3.isChecked() ? "3"
                : rb_cdbpretestq3a4.isChecked() ? "4"
                : "-1";
        temp = cdbpretestq3.equals("2") ? temp + 1 : temp;

        //Q4
        cdbpretestq4 = rb_cdbpretestq4a1.isChecked() ? "1"
                : rb_cdbpretestq4a2.isChecked() ? "2"
                : "-1";
        temp = cdbpretestq4.equals("1") ? temp + 1 : temp;

        //Q5
        cdbpretestq5 = rb_cdbpretestq5a1.isChecked() ? "1"
                : rb_cdbpretestq5a2.isChecked() ? "2"
                : rb_cdbpretestq5a3.isChecked() ? "3"
                : rb_cdbpretestq5a4.isChecked() ? "4"
                : "-1";
        temp = cdbpretestq5.equals("3") ? temp + 1 : temp;

        //Q6
        cdbpretestq6 = rb_cdbpretestq6a1.isChecked() ? "1"
                : rb_cdbpretestq6a2.isChecked() ? "2"
                : rb_cdbpretestq6a3.isChecked() ? "3"
                : rb_cdbpretestq6a4.isChecked() ? "4"
                : "-1";
        temp = cdbpretestq6.equals("3") ? temp + 1 : temp;

        //Q7
        cdbpretestq7 = rb_cdbpretestq7a1.isChecked() ? "1"
                : rb_cdbpretestq7a2.isChecked() ? "2"
                : rb_cdbpretestq7a3.isChecked() ? "3"
                : rb_cdbpretestq7a4.isChecked() ? "4"
                : "-1";
        temp = cdbpretestq7.equals("1") ? temp + 1 : temp;

        //Q8
        cdbpretestq8 = rb_cdbpretestq8a1.isChecked() ? "1"
                : rb_cdbpretestq8a2.isChecked() ? "2"
                : rb_cdbpretestq8a3.isChecked() ? "3"
                : rb_cdbpretestq8a4.isChecked() ? "4"
                : "-1";
        temp = cdbpretestq8.equals("1") ? temp + 1 : temp;

        //Q9
        cdbpretestq9 = rb_cdbpretestq9a1.isChecked() ? "1"
                : rb_cdbpretestq9a2.isChecked() ? "2"
                : rb_cdbpretestq9a3.isChecked() ? "3"
                : rb_cdbpretestq9a4.isChecked() ? "4"
                : "-1";
        temp = cdbpretestq9.equals("4") ? temp + 1 : temp;

        //Q10
        cdbpretestq10 = rb_cdbpretestq10a1.isChecked() ? "1"
                : rb_cdbpretestq10a2.isChecked() ? "2"
                : rb_cdbpretestq10a3.isChecked() ? "3"
                : rb_cdbpretestq10a4.isChecked() ? "4"
                : "-1";
        temp = cdbpretestq10.equals("4") ? temp + 1 : temp;

        pretest_result = String.valueOf(temp);
    }

    void insert_data() {
        String query = "insert into CDBPreTest("

                + Global.CDB.CDBPreTest.fk_id + ","
                + CDBPreTest.cnic_no + ","
                + CDBPreTest.cdbpretest_date + ","
                + CDBPreTest.cdbpretest_time + ","
                + CDBPreTest.cdbpretestq1 + ","
                + CDBPreTest.cdbpretestq2 + ","
                + CDBPreTest.cdbpretestq3 + ","
                + CDBPreTest.cdbpretestq4 + ","
                + CDBPreTest.cdbpretestq5 + ","
                + CDBPreTest.cdbpretestq6 + ","
                + CDBPreTest.cdbpretestq7 + ","
                + CDBPreTest.cdbpretestq8 + ","
                + CDBPreTest.cdbpretestq9 + ","
                + CDBPreTest.cdbpretestq10 + ","
                + CDBPreTest.pretest_result + ","
                + CDBPreTest.STATUS + ")" +

                " values ('" +

                Global.Session_Start.pk_id + "','" +
                cnic_no + "','" +
                cdbpretest_date + "','" +
                cdbpretest_time + "','" +
                cdbpretestq1 + "','" +
                cdbpretestq2 + "','" +
                cdbpretestq3 + "','" +
                cdbpretestq4 + "','" +
                cdbpretestq5 + "','" +
                cdbpretestq6 + "','" +
                cdbpretestq7 + "','" +
                cdbpretestq8 + "','" +
                cdbpretestq9 + "','" +
                cdbpretestq10 + "','" +
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

        if (Gothrough.IamHiden(ll_cdbpretestq1) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_cdbpretestq2) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_cdbpretestq3) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_cdbpretestq4) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_cdbpretestq5) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_cdbpretestq6) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_cdbpretestq7) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_cdbpretestq8) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_cdbpretestq9) == false) {
            return false;
        }

        return Gothrough.IamHiden(ll_cdbpretestq10) != false;
    }

    public void onBackPressed() {
        Toast.makeText(this, "You are not allowed to go on back screen SORRY!!!", Toast.LENGTH_LONG).show();
    }


}
