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
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abdulsajid.mnchtraining.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import Global.GDS.GDSPreTest;
import Global.Session_Start;
import data.LocalDataManager;
import utils.Gothrough;

public class GdsPreTest extends AppCompatActivity implements RadioButton.OnCheckedChangeListener, View.OnClickListener {


    //Declaration
    TextView
            txt_gdspretestq1,
            txt_gdspretestq2,
            txt_gdspretestq3,
            txt_gdspretestq4,
            txt_gdspretestq5,
            txt_gdspretestq6,
            txt_gdspretestq7,
            txt_gdspretestq8,
            txt_gdspretestq9,
            txt_gdspretestq10;

    Button
            btn_gdspretestsubmit;

    LinearLayout
            ll_cnic,
            ll_gdspretestq1,
            ll_gdspretestq2,
            ll_gdspretestq3,
            ll_gdspretestq4,
            ll_gdspretestq5,
            ll_gdspretestq6,
            ll_gdspretestq7,
            ll_gdspretestq8,
            ll_gdspretestq9,
            ll_gdspretestq10;

    RadioButton
            rb_gdspretestq1a1,
            rb_gdspretestq1a2,
            rb_gdspretestq1a3,
            rb_gdspretestq1a4,
            rb_gdspretestq2a1,
            rb_gdspretestq2a2,
            rb_gdspretestq2a3,
            rb_gdspretestq2a4,
            rb_gdspretestq3a1,
            rb_gdspretestq3a2,
            rb_gdspretestq3a3,
            rb_gdspretestq3a4,
            rb_gdspretestq4a1,
            rb_gdspretestq4a2,
            rb_gdspretestq4a3,
            rb_gdspretestq4a4,
            rb_gdspretestq5a1,
            rb_gdspretestq5a2,
            rb_gdspretestq5a3,
            rb_gdspretestq5a4,
            rb_gdspretestq6a1,
            rb_gdspretestq6a2,
            rb_gdspretestq7a1,
            rb_gdspretestq7a2,
            rb_gdspretestq7a3,
            rb_gdspretestq7a4,
            rb_gdspretestq8a1,
            rb_gdspretestq8a2,
            rb_gdspretestq8a3,
            rb_gdspretestq8a4,
            rb_gdspretestq9a1,
            rb_gdspretestq9a2,
            rb_gdspretestq9a3,
            rb_gdspretestq9a4,
            rb_gdspretestq10a1,
            rb_gdspretestq10a2,
            rb_gdspretestq10a3,
            rb_gdspretestq10a4;

    RadioGroup rg_gdspretestq1;

    EditText
            ed_cnic_no;

    String
            cnic_no,
            gdspretest_date,
            gdspretest_time,
            gdspretestq1,
            gdspretestq2,
            gdspretestq3,
            gdspretestq4,
            gdspretestq5,
            gdspretestq6,
            gdspretestq7,
            gdspretestq8,
            gdspretestq9,
            gdspretestq10,
            pretest_result,
            STATUS;

    int currentSection;

    void Initialization() {
        ll_cnic = findViewById(R.id.ll_cnic);
        ed_cnic_no = findViewById(R.id.ed_cnic_no);

        txt_gdspretestq1 = findViewById(R.id.txt_gdspretestq1);
        txt_gdspretestq2 = findViewById(R.id.txt_gdspretestq2);
        txt_gdspretestq3 = findViewById(R.id.txt_gdspretestq3);
        txt_gdspretestq4 = findViewById(R.id.txt_gdspretestq4);
        txt_gdspretestq5 = findViewById(R.id.txt_gdspretestq5);
        txt_gdspretestq6 = findViewById(R.id.txt_gdspretestq6);
        txt_gdspretestq7 = findViewById(R.id.txt_gdspretestq7);
        txt_gdspretestq8 = findViewById(R.id.txt_gdspretestq8);
        txt_gdspretestq9 = findViewById(R.id.txt_gdspretestq9);
        txt_gdspretestq10 = findViewById(R.id.txt_gdspretestq10);

        rg_gdspretestq1 = findViewById(R.id.rg_gdspretestq1);

        btn_gdspretestsubmit = findViewById(R.id.btn_gdspretestsubmit);

        ll_cnic = findViewById(R.id.ll_cnic);
        ll_gdspretestq1 = findViewById(R.id.ll_gdspretestq1);
        ll_gdspretestq2 = findViewById(R.id.ll_gdspretestq2);
        ll_gdspretestq3 = findViewById(R.id.ll_gdspretestq3);
        ll_gdspretestq4 = findViewById(R.id.ll_gdspretestq4);
        ll_gdspretestq5 = findViewById(R.id.ll_gdspretestq5);
        ll_gdspretestq6 = findViewById(R.id.ll_gdspretestq6);
        ll_gdspretestq7 = findViewById(R.id.ll_gdspretestq7);
        ll_gdspretestq8 = findViewById(R.id.ll_gdspretestq8);
        ll_gdspretestq9 = findViewById(R.id.ll_gdspretestq9);
        ll_gdspretestq10 = findViewById(R.id.ll_gdspretestq10);

        rb_gdspretestq1a1 = findViewById(R.id.rb_gdspretestq1a1);
        rb_gdspretestq1a2 = findViewById(R.id.rb_gdspretestq1a2);
        rb_gdspretestq1a3 = findViewById(R.id.rb_gdspretestq1a3);
        rb_gdspretestq1a4 = findViewById(R.id.rb_gdspretestq1a4);
        rb_gdspretestq2a1 = findViewById(R.id.rb_gdspretestq2a1);
        rb_gdspretestq2a2 = findViewById(R.id.rb_gdspretestq2a2);
        rb_gdspretestq2a3 = findViewById(R.id.rb_gdspretestq2a3);
        rb_gdspretestq2a4 = findViewById(R.id.rb_gdspretestq2a4);
        rb_gdspretestq3a1 = findViewById(R.id.rb_gdspretestq3a1);
        rb_gdspretestq3a2 = findViewById(R.id.rb_gdspretestq3a2);
        rb_gdspretestq3a3 = findViewById(R.id.rb_gdspretestq3a3);
        rb_gdspretestq3a4 = findViewById(R.id.rb_gdspretestq3a4);
        rb_gdspretestq4a1 = findViewById(R.id.rb_gdspretestq4a1);
        rb_gdspretestq4a2 = findViewById(R.id.rb_gdspretestq4a2);
        rb_gdspretestq4a3 = findViewById(R.id.rb_gdspretestq4a3);
        rb_gdspretestq4a4 = findViewById(R.id.rb_gdspretestq4a4);
        rb_gdspretestq5a1 = findViewById(R.id.rb_gdspretestq5a1);
        rb_gdspretestq5a2 = findViewById(R.id.rb_gdspretestq5a2);
        rb_gdspretestq5a3 = findViewById(R.id.rb_gdspretestq5a3);
        rb_gdspretestq5a4 = findViewById(R.id.rb_gdspretestq5a4);
        rb_gdspretestq6a1 = findViewById(R.id.rb_gdspretestq6a1);
        rb_gdspretestq6a2 = findViewById(R.id.rb_gdspretestq6a2);
        rb_gdspretestq7a1 = findViewById(R.id.rb_gdspretestq7a1);
        rb_gdspretestq7a2 = findViewById(R.id.rb_gdspretestq7a2);
        rb_gdspretestq7a3 = findViewById(R.id.rb_gdspretestq7a3);
        rb_gdspretestq7a4 = findViewById(R.id.rb_gdspretestq7a4);
        rb_gdspretestq8a1 = findViewById(R.id.rb_gdspretestq8a1);
        rb_gdspretestq8a2 = findViewById(R.id.rb_gdspretestq8a2);
        rb_gdspretestq8a3 = findViewById(R.id.rb_gdspretestq8a3);
        rb_gdspretestq8a4 = findViewById(R.id.rb_gdspretestq8a4);
        rb_gdspretestq9a1 = findViewById(R.id.rb_gdspretestq9a1);
        rb_gdspretestq9a2 = findViewById(R.id.rb_gdspretestq9a2);
        rb_gdspretestq9a3 = findViewById(R.id.rb_gdspretestq9a3);
        rb_gdspretestq9a4 = findViewById(R.id.rb_gdspretestq9a4);
        rb_gdspretestq10a1 = findViewById(R.id.rb_gdspretestq10a1);
        rb_gdspretestq10a2 = findViewById(R.id.rb_gdspretestq10a2);
        rb_gdspretestq10a3 = findViewById(R.id.rb_gdspretestq10a3);
        rb_gdspretestq10a4 = findViewById(R.id.rb_gdspretestq10a4);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gds_pre_test);

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

        gdspretest_date = SToday;
        gdspretest_time = STime;

    }


    @Override
    public void onClick(View view) {

        if (validateField() == false) {
            Toast.makeText(this, "Required fields are missing", Toast.LENGTH_LONG).show();
            return;
        }

        value_assignment();
        insert_data();

        Intent intent = new Intent(this, GdsTraining.class);
        intent.putExtra("cnic_no", cnic_no);
        intent.putExtra("pretest_result", pretest_result);
        startActivity(intent);
        this.finish();

    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {


        /*if(rg_gdspretestq1.getCheckedRadioButtonId()!=-1){
            int id= rg_gdspretestq1.getCheckedRadioButtonId();
            View radioButton = rg_gdspretestq1.findViewById(id);
            int radioId = radioGroup.indexOfChild(radioButton);
            RadioButton btn = (RadioButton) rg_gdspretestq1.getChildAt(radioId);
            String selection = (String) btn.getText();
        }*/

        /*// get selected radio button from radioGroup
        int selectedId = radioGroup.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        radioButton = (RadioButton) findViewById(selectedId);

        Toast.makeText(MyAndroidAppActivity.this,
                radioButton.getText(), Toast.LENGTH_SHORT).show();*/

        //GDS-Q1  
        if (compoundButton.getId() == R.id.rb_gdspretestq1a1
                || compoundButton.getId() == R.id.rb_gdspretestq1a2
                || compoundButton.getId() == R.id.rb_gdspretestq1a3
                || compoundButton.getId() == R.id.rb_gdspretestq1a4) {

            if (rb_gdspretestq1a1.isChecked()) {
                txt_gdspretestq1.clearComposingText();
                String styledText = "1- Children with <font color='blue'><b><i>Mild illness</i></b></font> on the IMNCI chart usually need urgent referral to hospital.";
                txt_gdspretestq1.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);


                /*Entity entity;
                entity = (Entity) Document.getDoctype().getEntities().item(i);
                String path = entity.getSystemId();*/

                /*txt_gdspretestq1.setText(getString(R.string.gdspretestq1));*/

            } else if (rb_gdspretestq1a2.isChecked()) {
                txt_gdspretestq1.clearComposingText();
                String styledText = "1- Children with <font color='blue'><b><i>Pneumonia</i></b></font> on the IMNCI chart usually need urgent referral to hospital.";
                txt_gdspretestq1.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_gdspretestq1a3.isChecked()) {
                txt_gdspretestq1.clearComposingText();
                String styledText = "1- Children with <font color='blue'><b><i>Dehydration</i></b></font> on the IMNCI chart usually need urgent referral to hospital.";
                txt_gdspretestq1.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_gdspretestq1a4.isChecked()) {
                txt_gdspretestq1.clearComposingText();
                String styledText = "1- Children with <font color='blue'><b><i>Severe disease/classification</i></b></font> on the IMNCI chart usually need urgent referral to hospital.";
                txt_gdspretestq1.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }


        //GDS-Q2  
        if (compoundButton.getId() == R.id.rb_gdspretestq2a1
                || compoundButton.getId() == R.id.rb_gdspretestq2a2
                || compoundButton.getId() == R.id.rb_gdspretestq2a3
                || compoundButton.getId() == R.id.rb_gdspretestq2a4) {

            if (rb_gdspretestq2a1.isChecked()) {
                txt_gdspretestq2.clearComposingText();
                String styledText = "2- <font color='blue'><b><i>Persistent diarrhea</i></b></font> is the exception for severe classification or severe disease where referral to the hospital is needed but not urgent.";
                txt_gdspretestq2.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_gdspretestq2a2.isChecked()) {
                txt_gdspretestq2.clearComposingText();
                String styledText = "2- <font color='blue'><b><i>Severe dehydration</i></b></font> is the exception for severe classification or severe disease where referral to the hospital is needed but not urgent.";
                txt_gdspretestq2.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_gdspretestq2a3.isChecked()) {
                txt_gdspretestq2.clearComposingText();
                String styledText = "2- <font color='blue'><b><i>Severe persistent diarrhea</i></b></font> is the exception for severe classification or severe disease where referral to the hospital is needed but not urgent.";
                txt_gdspretestq2.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_gdspretestq2a4.isChecked()) {
                txt_gdspretestq2.clearComposingText();
                String styledText = "2- <font color='blue'><b><i>Severe pneumonia</i></b></font> is the exception for severe classification or severe disease where referral to the hospital is needed but not urgent.";
                txt_gdspretestq2.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }


        //GDS-Q3  
        if (compoundButton.getId() == R.id.rb_gdspretestq3a1
                || compoundButton.getId() == R.id.rb_gdspretestq3a2
                || compoundButton.getId() == R.id.rb_gdspretestq3a3
                || compoundButton.getId() == R.id.rb_gdspretestq3a4) {

            if (rb_gdspretestq3a1.isChecked()) {
                txt_gdspretestq3.clearComposingText();
                String styledText = "3- Presence of even <font color='blue'><b><i>One</i></b></font> danger sign indicates that underlying disease is severe.";
                txt_gdspretestq3.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_gdspretestq3a2.isChecked()) {
                txt_gdspretestq3.clearComposingText();
                String styledText = "3- Presence of even <font color='blue'><b><i>Two</i></b></font> danger sign indicates that underlying disease is severe.";
                txt_gdspretestq3.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_gdspretestq3a3.isChecked()) {
                txt_gdspretestq3.clearComposingText();
                String styledText = "3- Presence of even <font color='blue'><b><i>Three</i></b></font> danger sign indicates that underlying disease is severe.";
                txt_gdspretestq3.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_gdspretestq3a4.isChecked()) {
                txt_gdspretestq3.clearComposingText();
                String styledText = "3- Presence of even <font color='blue'><b><i>None</i></b></font> danger sign indicates that underlying disease is severe.";
                txt_gdspretestq3.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }


        //GDS-Q4   
        if (compoundButton.getId() == R.id.rb_gdspretestq4a1
                || compoundButton.getId() == R.id.rb_gdspretestq4a2
                || compoundButton.getId() == R.id.rb_gdspretestq4a3
                || compoundButton.getId() == R.id.rb_gdspretestq4a4) {

            if (rb_gdspretestq4a1.isChecked()) {
                txt_gdspretestq4.clearComposingText();
                String styledText = "4- For assessing a general danger sign, a healthcare provider needs to ASK <font color='blue'><b><i>One</i></b></font> questions and LOOK for <font color='blue'><b><i>Two</i></b></font> observations to observe the child's actions.";
                txt_gdspretestq4.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_gdspretestq4a2.isChecked()) {
                txt_gdspretestq4.clearComposingText();
                String styledText = "4- For assessing a general danger sign, a healthcare provider needs to ASK <font color='blue'><b><i>Two</i></b></font> questions and LOOK for <font color='blue'><b><i>Two</i></b></font> observations to observe the child's actions.";
                txt_gdspretestq4.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_gdspretestq4a3.isChecked()) {
                txt_gdspretestq4.clearComposingText();
                String styledText = "4- For assessing a general danger sign, a healthcare provider needs to ASK <font color='blue'><b><i>Three</i></b></font> questions and LOOK for <font color='blue'><b><i>Two</i></b></font> observations to observe the child's actions.";
                txt_gdspretestq4.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_gdspretestq4a4.isChecked()) {
                txt_gdspretestq4.clearComposingText();
                String styledText = "4- For assessing a general danger sign, a healthcare provider needs to ASK <font color='blue'><b><i>Three</i></b></font> questions and LOOK for <font color='blue'><b><i>One</i></b></font> observations to observe the child's actions.";
                txt_gdspretestq4.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }


        //GDS-Q8  
        if (compoundButton.getId() == R.id.rb_gdspretestq8a1
                || compoundButton.getId() == R.id.rb_gdspretestq8a2
                || compoundButton.getId() == R.id.rb_gdspretestq8a3
                || compoundButton.getId() == R.id.rb_gdspretestq8a4) {

            if (rb_gdspretestq8a1.isChecked()) {
                txt_gdspretestq8.clearComposingText();
                String styledText = "8- A child who is not able to hold anything down at all has the sign <font color='blue'><b><i>Not able to drink or breastfeed</i></b></font>.";
                txt_gdspretestq8.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_gdspretestq8a2.isChecked()) {
                txt_gdspretestq8.clearComposingText();
                String styledText = "8- A child who is not able to hold anything down at all has the sign <font color='blue'><b><i>Vomits everything</i></b></font>.";
                txt_gdspretestq8.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_gdspretestq8a3.isChecked()) {
                txt_gdspretestq8.clearComposingText();
                String styledText = "8- A child who is not able to hold anything down at all has the sign <font color='blue'><b><i>Lethargic</i></b></font>.";
                txt_gdspretestq8.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_gdspretestq8a4.isChecked()) {
                txt_gdspretestq8.clearComposingText();
                String styledText = "8- A child who is not able to hold anything down at all has the sign <font color='blue'><b><i>Unconscious</i></b></font>.";
                txt_gdspretestq8.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }


        //GDS-Q10  
        if (compoundButton.getId() == R.id.rb_gdspretestq10a1
                || compoundButton.getId() == R.id.rb_gdspretestq10a2
                || compoundButton.getId() == R.id.rb_gdspretestq10a3
                || compoundButton.getId() == R.id.rb_gdspretestq10a4) {

            if (rb_gdspretestq10a1.isChecked()) {
                txt_gdspretestq10.clearComposingText();
                String styledText = "10- To make sugar water: Dissolve 4 level teaspoons of sugar (20 grams) in a <font color='blue'><b><i>100-ml</i></b></font> cup of clean water.";
                txt_gdspretestq10.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_gdspretestq10a2.isChecked()) {
                txt_gdspretestq10.clearComposingText();
                String styledText = "10- To make sugar water: Dissolve 4 level teaspoons of sugar (20 grams) in a <font color='blue'><b><i>150-ml</i></b></font> cup of clean water.";
                txt_gdspretestq10.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_gdspretestq10a3.isChecked()) {
                txt_gdspretestq10.clearComposingText();
                String styledText = "10- To make sugar water: Dissolve 4 level teaspoons of sugar (20 grams) in a <font color='blue'><b><i>200-ml</i></b></font> cup of clean water.";
                txt_gdspretestq10.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            } else if (rb_gdspretestq10a4.isChecked()) {
                txt_gdspretestq10.clearComposingText();
                String styledText = "10- To make sugar water: Dissolve 4 level teaspoons of sugar (20 grams) in a <font color='blue'><b><i>250-ml</i></b></font> cup of clean water.";
                txt_gdspretestq10.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
            }
        }

    }

    void events_call() {

        btn_gdspretestsubmit.setOnClickListener(this);
        /*rg_gdspretestq1.getCheckedRadioButtonId();*/
        rb_gdspretestq1a1.setOnCheckedChangeListener(this);
        rb_gdspretestq1a2.setOnCheckedChangeListener(this);
        rb_gdspretestq1a3.setOnCheckedChangeListener(this);
        rb_gdspretestq1a4.setOnCheckedChangeListener(this);

        rb_gdspretestq2a1.setOnCheckedChangeListener(this);
        rb_gdspretestq2a2.setOnCheckedChangeListener(this);
        rb_gdspretestq2a3.setOnCheckedChangeListener(this);
        rb_gdspretestq2a4.setOnCheckedChangeListener(this);

        rb_gdspretestq3a1.setOnCheckedChangeListener(this);
        rb_gdspretestq3a2.setOnCheckedChangeListener(this);
        rb_gdspretestq3a3.setOnCheckedChangeListener(this);
        rb_gdspretestq3a4.setOnCheckedChangeListener(this);

        rb_gdspretestq4a1.setOnCheckedChangeListener(this);
        rb_gdspretestq4a2.setOnCheckedChangeListener(this);
        rb_gdspretestq4a3.setOnCheckedChangeListener(this);
        rb_gdspretestq4a4.setOnCheckedChangeListener(this);

        rb_gdspretestq5a1.setOnCheckedChangeListener(this);
        rb_gdspretestq5a2.setOnCheckedChangeListener(this);
        rb_gdspretestq5a3.setOnCheckedChangeListener(this);
        rb_gdspretestq5a4.setOnCheckedChangeListener(this);

        rb_gdspretestq6a1.setOnCheckedChangeListener(this);
        rb_gdspretestq6a2.setOnCheckedChangeListener(this);

        rb_gdspretestq7a1.setOnCheckedChangeListener(this);
        rb_gdspretestq7a2.setOnCheckedChangeListener(this);
        rb_gdspretestq7a3.setOnCheckedChangeListener(this);
        rb_gdspretestq7a4.setOnCheckedChangeListener(this);

        rb_gdspretestq8a1.setOnCheckedChangeListener(this);
        rb_gdspretestq8a2.setOnCheckedChangeListener(this);
        rb_gdspretestq8a3.setOnCheckedChangeListener(this);
        rb_gdspretestq8a4.setOnCheckedChangeListener(this);

        rb_gdspretestq9a1.setOnCheckedChangeListener(this);
        rb_gdspretestq9a2.setOnCheckedChangeListener(this);
        rb_gdspretestq9a3.setOnCheckedChangeListener(this);
        rb_gdspretestq9a4.setOnCheckedChangeListener(this);

        rb_gdspretestq10a1.setOnCheckedChangeListener(this);
        rb_gdspretestq10a2.setOnCheckedChangeListener(this);
        rb_gdspretestq10a3.setOnCheckedChangeListener(this);
        rb_gdspretestq10a4.setOnCheckedChangeListener(this);
    }

    void value_assignment() {

        pretest_result = "0";
        STATUS = "0";
        int temp = 0;

        cnic_no = ed_cnic_no.getText().toString().length() > 0 ? ed_cnic_no.getText().toString().trim() : "0";

        //Q1
        gdspretestq1 = rb_gdspretestq1a1.isChecked() ? "1"
                : rb_gdspretestq1a2.isChecked() ? "2"
                : rb_gdspretestq1a3.isChecked() ? "3"
                : rb_gdspretestq1a4.isChecked() ? "4"
                : "-1";
        temp = gdspretestq1.equals("4") ? temp + 1 : temp;

        //Q2
        gdspretestq2 = rb_gdspretestq2a1.isChecked() ? "1"
                : rb_gdspretestq2a2.isChecked() ? "2"
                : rb_gdspretestq2a3.isChecked() ? "3"
                : rb_gdspretestq2a4.isChecked() ? "4"
                : "-1";
        temp = gdspretestq2.equals("3") ? temp + 1 : temp;

        //Q3
        gdspretestq3 = rb_gdspretestq3a1.isChecked() ? "1"
                : rb_gdspretestq3a2.isChecked() ? "2"
                : rb_gdspretestq3a3.isChecked() ? "3"
                : rb_gdspretestq3a4.isChecked() ? "4"
                : "-1";
        temp = gdspretestq3.equals("1") ? temp + 1 : temp;

        //Q4
        gdspretestq4 = rb_gdspretestq4a1.isChecked() ? "1"
                : rb_gdspretestq4a2.isChecked() ? "2"
                : rb_gdspretestq4a3.isChecked() ? "3"
                : rb_gdspretestq4a4.isChecked() ? "4"
                : "-1";
        temp = gdspretestq4.equals("3") ? temp + 1 : temp;

        //Q5
        gdspretestq5 = rb_gdspretestq5a1.isChecked() ? "1"
                : rb_gdspretestq5a2.isChecked() ? "2"
                : rb_gdspretestq5a3.isChecked() ? "3"
                : rb_gdspretestq5a4.isChecked() ? "4"
                : "-1";
        temp = gdspretestq5.equals("4") ? temp + 1 : temp;

        //Q6
        gdspretestq6 = rb_gdspretestq6a1.isChecked() ? "1"
                : rb_gdspretestq6a2.isChecked() ? "2"
                : "-1";
        temp = gdspretestq6.equals("2") ? temp + 1 : temp;

        //Q7
        gdspretestq7 = rb_gdspretestq7a1.isChecked() ? "1"
                : rb_gdspretestq7a2.isChecked() ? "2"
                : rb_gdspretestq7a3.isChecked() ? "3"
                : rb_gdspretestq7a4.isChecked() ? "4"
                : "-1";
        temp = gdspretestq7.equals("3") ? temp + 1 : temp;

        //Q8
        gdspretestq8 = rb_gdspretestq8a1.isChecked() ? "1"
                : rb_gdspretestq8a2.isChecked() ? "2"
                : rb_gdspretestq8a3.isChecked() ? "3"
                : rb_gdspretestq8a4.isChecked() ? "4"
                : "-1";
        temp = gdspretestq8.equals("2") ? temp + 1 : temp;

        //Q9
        gdspretestq9 = rb_gdspretestq9a1.isChecked() ? "1"
                : rb_gdspretestq9a2.isChecked() ? "2"
                : rb_gdspretestq9a3.isChecked() ? "3"
                : rb_gdspretestq9a4.isChecked() ? "4"
                : "-1";
        temp = gdspretestq9.equals("1") ? temp + 1 : temp;

        //Q9
        gdspretestq9 = rb_gdspretestq9a1.isChecked() ? "1"
                : rb_gdspretestq9a2.isChecked() ? "2"
                : rb_gdspretestq9a3.isChecked() ? "3"
                : rb_gdspretestq9a4.isChecked() ? "4"
                : "-1";
        temp = gdspretestq9.equals("1") ? temp + 1 : temp;

        //Q10
        gdspretestq10 = rb_gdspretestq10a1.isChecked() ? "1"
                : rb_gdspretestq10a2.isChecked() ? "2"
                : rb_gdspretestq10a3.isChecked() ? "3"
                : rb_gdspretestq10a4.isChecked() ? "4"
                : "-1";
        temp = gdspretestq10.equals("3") ? temp + 1 : temp;

        pretest_result = String.valueOf(temp);

    }

    void insert_data() {
        String query = "insert into GDSPreTest("

                + GDSPreTest.fk_id + ","
                + GDSPreTest.cnic_no + ","
                + GDSPreTest.gdspretest_date + ","
                + GDSPreTest.gdspretest_time + ","
                + GDSPreTest.gdspretestq1 + ","
                + GDSPreTest.gdspretestq2 + ","
                + GDSPreTest.gdspretestq3 + ","
                + GDSPreTest.gdspretestq4 + ","
                + GDSPreTest.gdspretestq5 + ","
                + GDSPreTest.gdspretestq6 + ","
                + GDSPreTest.gdspretestq7 + ","
                + GDSPreTest.gdspretestq8 + ","
                + GDSPreTest.gdspretestq9 + ","
                + GDSPreTest.gdspretestq10 + ","
                + GDSPreTest.pretest_result + ","
                + GDSPreTest.STATUS + ")" +

                " values ('" +

                Session_Start.pk_id + "','" +
                cnic_no + "','" +
                gdspretest_date + "','" +
                gdspretest_time + "','" +
                gdspretestq1 + "','" +
                gdspretestq2 + "','" +
                gdspretestq3 + "','" +
                gdspretestq4 + "','" +
                gdspretestq5 + "','" +
                gdspretestq6 + "','" +
                gdspretestq7 + "','" +
                gdspretestq8 + "','" +
                gdspretestq9 + "','" +
                gdspretestq10 + "','" +
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

        if (Gothrough.IamHiden(ll_gdspretestq1) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_gdspretestq2) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_gdspretestq3) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_gdspretestq4) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_gdspretestq5) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_gdspretestq6) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_gdspretestq7) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_gdspretestq8) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_gdspretestq9) == false) {
            return false;
        }

        return Gothrough.IamHiden(ll_gdspretestq10) != false;
    }

    public void onBackPressed() {
        Toast.makeText(this, "You are not allowed to go on back screen SORRY!!! \nIf you want to do so PLEASE CONTACT Dr. Samia", Toast.LENGTH_LONG).show();
    }


}
