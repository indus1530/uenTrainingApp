package com.example.abdulsajid.mnchtraining.GDS;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.abdulsajid.mnchtraining.R;
import com.example.abdulsajid.mnchtraining.ZoomActivity;
import com.example.abdulsajid.mnchtraining.videact;

import utils.Gothrough;

public class GdsTraining extends AppCompatActivity implements View.OnClickListener {

    Button
            btn_blue,
            btn_cyan,
            btn_green2,
            btn_green1,
            btn_gdstrainingsubmit,
            btn_recordingform;

    ImageButton
            gds12,
            imgbtn_sd;

    EditText
            ed_cnic_no,
            ed_pretest_result;

    LinearLayout
            ll_cnic,
            ll_pretest_result;

    String
            cnic_no,
            pretest_result;


    void Initialization() {
        ll_cnic = findViewById(R.id.ll_cnic);
        ed_cnic_no = findViewById(R.id.ed_cnic_no);

        ll_pretest_result = findViewById(R.id.ll_pretest_result);
        ed_pretest_result = findViewById(R.id.ed_pretest_result);

        btn_recordingform = findViewById(R.id.btn_recordingform);
        gds12 = findViewById(R.id.gds12);
        imgbtn_sd = findViewById(R.id.imgbtn_sd);

        btn_blue = findViewById(R.id.btn_blue);
        btn_cyan = findViewById(R.id.btn_cyan);
        btn_green2 = findViewById(R.id.btn_green2);
        btn_green1 = findViewById(R.id.btn_green1);

        btn_gdstrainingsubmit = findViewById(R.id.btn_gdstrainingsubmit);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gds_training);

        Initialization();

        /*Intent getcnicno = getIntent();
        cnic_no = getcnicno.getExtras().getString("cnic_no");
        pretest_result = getcnicno.getExtras().getString("pretest_result");
        ed_cnic_no.setText(cnic_no);
        ed_pretest_result.setText(pretest_result);
        ed_cnic_no.setEnabled(false);
        ed_pretest_result.setEnabled(false);*/

        gds12.setOnClickListener(this);
        imgbtn_sd.setOnClickListener(this);

        btn_blue.setOnClickListener(this);
        btn_cyan.setOnClickListener(this);
        btn_green2.setOnClickListener(this);
        btn_green1.setOnClickListener(this);

        btn_recordingform.setOnClickListener(this);
        btn_gdstrainingsubmit.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btn_recordingform) {
            Intent itt = new Intent(GdsTraining.this, GdsRecordingForm.class);
            startActivity(itt);
        } else if (view.getId() == R.id.gds12) {
            Intent itt = new Intent(GdsTraining.this, ZoomActivity.class);
            startActivity(itt);
        } else if (view.getId() == R.id.imgbtn_sd) {
            Intent itt = new Intent(GdsTraining.this, videact.class);
            startActivity(itt);
        } else if (view.getId() == R.id.btn_blue) {
            final AlertDialog b = new AlertDialog.Builder(this).create();

            LayoutInflater layoutInflater = getLayoutInflater();
            View v = layoutInflater.inflate(R.layout.dialog_blue, null);
            b.setView(v);
            b.show();
        } else if (view.getId() == R.id.btn_cyan) {
            final AlertDialog b = new AlertDialog.Builder(this).create();

            LayoutInflater layoutInflater = getLayoutInflater();
            View v = layoutInflater.inflate(R.layout.dialog_cyan, null);
            b.setView(v);
            b.show();
        } else if (view.getId() == R.id.btn_green2) {
            final AlertDialog b = new AlertDialog.Builder(this).create();

            LayoutInflater layoutInflater = getLayoutInflater();
            View v = layoutInflater.inflate(R.layout.dialog_green2, null);
            b.setView(v);
            b.show();
        } else if (view.getId() == R.id.btn_green1) {
            final AlertDialog b = new AlertDialog.Builder(this).create();

            LayoutInflater layoutInflater = getLayoutInflater();
            View v = layoutInflater.inflate(R.layout.dialog_green1, null);
            b.setView(v);
            b.show();
        } else if (view.getId() == R.id.btn_gdstrainingsubmit) {
            if (validateField() == false) {
                Toast.makeText(this, "Required fields are missing", Toast.LENGTH_LONG).show();
                return;
            }

            Intent intent = new Intent(GdsTraining.this, GdsPostTest.class);
            intent.putExtra("cnic_no", cnic_no);
            intent.putExtra("pretest_result", pretest_result);
            startActivity(intent);
            this.finish();
        }
    }

    boolean validateField() {

        if (Gothrough.IamHiden(ll_cnic) == false) {
            return false;
        }

        return Gothrough.IamHiden(ll_pretest_result) != false;
    }

    public void onBackPressed() {
        Toast.makeText(this, "You are not allowed to go on back screen SORRY!!! \nIf you want to do so PLEASE CONTACT Dr. Samia", Toast.LENGTH_LONG).show();
    }
}