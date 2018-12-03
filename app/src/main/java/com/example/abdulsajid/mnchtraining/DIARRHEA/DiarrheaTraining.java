package com.example.abdulsajid.mnchtraining.DIARRHEA;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.abdulsajid.mnchtraining.R;

import utils.Gothrough;

public class DiarrheaTraining extends AppCompatActivity implements View.OnClickListener {

    Button
            btn_diarrheatrainingsubmit;
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

        btn_diarrheatrainingsubmit = findViewById(R.id.btn_diarrheatrainingsubmit);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diarrhea_training);

        Initialization();

        Intent getcnicno = getIntent();
        cnic_no = getcnicno.getExtras().getString("cnic_no");
        pretest_result = getcnicno.getExtras().getString("pretest_result");
        ed_cnic_no.setText(cnic_no);
        ed_pretest_result.setText(pretest_result);
        ed_cnic_no.setEnabled(false);
        ed_pretest_result.setEnabled(false);

        btn_diarrheatrainingsubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (validateField() == false) {
            Toast.makeText(this, "Required fields are missing", Toast.LENGTH_LONG).show();
            return;
        }

        Intent intent = new Intent(DiarrheaTraining.this, DiarrheaPostTest.class);
        intent.putExtra("cnic_no", cnic_no);
        intent.putExtra("pretest_result", pretest_result);
        startActivity(intent);
        this.finish();

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
