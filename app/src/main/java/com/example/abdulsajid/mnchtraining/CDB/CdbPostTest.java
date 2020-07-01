package com.example.abdulsajid.mnchtraining.CDB;

import android.content.Intent;
import android.databinding.DataBindingUtil;
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
import com.example.abdulsajid.mnchtraining.databinding.ActivityCdbPostTestBinding;

import java.text.SimpleDateFormat;
import java.util.Date;

import data.LocalDataManager;
import utils.Gothrough;

public class CdbPostTest extends AppCompatActivity implements RadioButton.OnCheckedChangeListener, View.OnClickListener {

    ActivityCdbPostTestBinding bi;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_cdb_post_test);
        bi.setCallback(this);
        setupSkips();

        Intent getcnicno = getIntent();
        cnic_no = getcnicno.getExtras().getString("cnic_no");
        pretest_result = getcnicno.getExtras().getString("pretest_result");
        ed_cnic_no.setText(cnic_no);
        ed_pretest_result.setText(pretest_result);
        bi.edCnicNo.setEnabled(false);
        bi.edPretestResult.setEnabled(false);

        cdbposttest_date = new SimpleDateFormat("dd-MM-yyyy").format(new Date().getTime());
        cdbposttest_time = new SimpleDateFormat("HH:mm:ss").format(new Date().getTime());
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

    void setupSkips() {

        bi.cdbposttestq1.setOnCheckedChangeListener((new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == bi.rbCdbposttestq1a1.getId()) {
                    bi.txtCdbposttestq1.clearComposingText();
                    String styledText = "1- Cough or difficult breathing that lasts for more than 14 days may indicate <font color='blue'><b><i>Tuberculosis</i></b></font>.";
                    bi.txtCdbposttestq1.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
                } else if (i == bi.rbCdbposttestq1a2.getId()) {
                    bi.txtCdbposttestq1.clearComposingText();
                    String styledText = "1- Cough or difficult breathing that lasts for more than 14 days may indicate <font color='blue'><b><i>Asthma</i></b></font>.";
                    bi.txtCdbposttestq1.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
                } else if (i == bi.rbCdbposttestq1a3.getId()) {
                    bi.txtCdbposttestq1.clearComposingText();
                    String styledText = "1- Cough or difficult breathing that lasts for more than 14 days may indicate <font color='blue'><b><i>Whooping cough</i></b></font>.";
                    bi.txtCdbposttestq1.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
                } else if (i == bi.rbCdbposttestq1a4.getId()) {
                    bi.txtCdbposttestq1.clearComposingText();
                    String styledText = "1- Cough or difficult breathing that lasts for more than 14 days may indicate <font color='blue'><b><i>All of the below</i></b></font>.";
                    bi.txtCdbposttestq1.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
                }
            }
        }));

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

        int temp = 0;

        cnic_no = ed_cnic_no.getText().toString().length() > 0 ? ed_cnic_no.getText().toString().trim() : "0";

        //Q1
        cdbposttestq1 = rb_cdbposttestq1a1.isChecked() ? "1"
                : rb_cdbposttestq1a2.isChecked() ? "2"
                : rb_cdbposttestq1a3.isChecked() ? "3"
                : rb_cdbposttestq1a4.isChecked() ? "4"
                : "0";
        temp = cdbposttestq1.equals("2") ? temp + 1 : temp;

        //Q2
        cdbposttestq2 = rb_cdbposttestq2a1.isChecked() ? "1"
                : rb_cdbposttestq2a2.isChecked() ? "2"
                : rb_cdbposttestq2a3.isChecked() ? "3"
                : rb_cdbposttestq2a4.isChecked() ? "4"
                : "0";
        temp = cdbposttestq2.equals("4") ? temp + 1 : temp;

        //Q3
        cdbposttestq3 = rb_cdbposttestq3a1.isChecked() ? "1"
                : rb_cdbposttestq3a2.isChecked() ? "2"
                : rb_cdbposttestq3a3.isChecked() ? "3"
                : rb_cdbposttestq3a4.isChecked() ? "4"
                : "0";
        temp = cdbposttestq3.equals("2") ? temp + 1 : temp;

        //Q4
        cdbposttestq4 = rb_cdbposttestq4a1.isChecked() ? "1"
                : rb_cdbposttestq4a2.isChecked() ? "2"
                : "0";
        temp = cdbposttestq4.equals("1") ? temp + 1 : temp;

        //Q5
        cdbposttestq5 = rb_cdbposttestq5a1.isChecked() ? "1"
                : rb_cdbposttestq5a2.isChecked() ? "2"
                : rb_cdbposttestq5a3.isChecked() ? "3"
                : rb_cdbposttestq5a4.isChecked() ? "4"
                : "0";
        temp = cdbposttestq5.equals("3") ? temp + 1 : temp;

        //Q6
        cdbposttestq6 = rb_cdbposttestq6a1.isChecked() ? "1"
                : rb_cdbposttestq6a2.isChecked() ? "2"
                : rb_cdbposttestq6a3.isChecked() ? "3"
                : rb_cdbposttestq6a4.isChecked() ? "4"
                : "0";
        temp = cdbposttestq6.equals("3") ? temp + 1 : temp;

        //Q7
        cdbposttestq7 = rb_cdbposttestq7a1.isChecked() ? "1"
                : rb_cdbposttestq7a2.isChecked() ? "2"
                : rb_cdbposttestq7a3.isChecked() ? "3"
                : rb_cdbposttestq7a4.isChecked() ? "4"
                : "0";
        temp = cdbposttestq7.equals("1") ? temp + 1 : temp;

        //Q8
        cdbposttestq8 = rb_cdbposttestq8a1.isChecked() ? "1"
                : rb_cdbposttestq8a2.isChecked() ? "2"
                : rb_cdbposttestq8a3.isChecked() ? "3"
                : rb_cdbposttestq8a4.isChecked() ? "4"
                : "0";
        temp = cdbposttestq8.equals("1") ? temp + 1 : temp;

        //Q9
        cdbposttestq9 = rb_cdbposttestq9a1.isChecked() ? "1"
                : rb_cdbposttestq9a2.isChecked() ? "2"
                : rb_cdbposttestq9a3.isChecked() ? "3"
                : rb_cdbposttestq9a4.isChecked() ? "4"
                : "0";
        temp = cdbposttestq9.equals("4") ? temp + 1 : temp;

        //Q10
        cdbposttestq10 = rb_cdbposttestq10a1.isChecked() ? "1"
                : rb_cdbposttestq10a2.isChecked() ? "2"
                : rb_cdbposttestq10a3.isChecked() ? "3"
                : rb_cdbposttestq10a4.isChecked() ? "4"
                : "0";
        temp = cdbposttestq10.equals("4") ? temp + 1 : temp;

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
