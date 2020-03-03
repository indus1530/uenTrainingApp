package com.example.abdulsajid.mnchtraining.CDB;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.abdulsajid.mnchtraining.R;
import com.example.abdulsajid.mnchtraining.VideoPlayerActivity;

import utils.Gothrough;

public class CdbTraining extends AppCompatActivity implements View.OnClickListener {

    Button
            btn_cdbtrainingsubmit;
    ImageButton
            imgbtn_exercise_chest_indrawing,
            imgbtn_stridor,
            imgbtn_wheeze;

    EditText ed_cnic_no, ed_pretest_result;
    LinearLayout ll_cnic, ll_pretest_result;
    String cnic_no, pretest_result;

    void Initialization() {
        ll_cnic = findViewById(R.id.ll_cnic);
        ed_cnic_no = findViewById(R.id.ed_cnic_no);

        ll_pretest_result = findViewById(R.id.ll_pretest_result);
        ed_pretest_result = findViewById(R.id.ed_pretest_result);

        btn_cdbtrainingsubmit = findViewById(R.id.btn_cdbtrainingsubmit);
        imgbtn_exercise_chest_indrawing = findViewById(R.id.imgbtn_exercise_chest_indrawing);
        imgbtn_stridor = findViewById(R.id.imgbtn_stridor);
        imgbtn_wheeze = findViewById(R.id.imgbtn_wheeze);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cdb_training);

        Initialization();

        Intent getcnicno = getIntent();
        cnic_no = getcnicno.getExtras().getString("cnic_no");
        pretest_result = getcnicno.getExtras().getString("pretest_result");
        ed_cnic_no.setText(cnic_no);
        ed_pretest_result.setText(pretest_result);
        ed_cnic_no.setEnabled(false);
        ed_pretest_result.setEnabled(false);

        btn_cdbtrainingsubmit.setOnClickListener(this);
        imgbtn_exercise_chest_indrawing.setOnClickListener(this);
        imgbtn_stridor.setOnClickListener(this);
        imgbtn_wheeze.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.imgbtn_exercise_chest_indrawing) {
            String fileName = "psbiii";
            VideoPlayerActivity.showRemoteVideo(this, "android.resource://" + getPackageName() + "/raw/" + fileName);
        } else if (view.getId() == R.id.imgbtn_stridor) {
            String fileName = "breastfeeding";
            VideoPlayerActivity.showRemoteVideo(this, "android.resource://" + getPackageName() + "/raw/" + fileName);
        } else if (view.getId() == R.id.imgbtn_wheeze) {
            String fileName = "breastfeeding";
            VideoPlayerActivity.showRemoteVideo(this, "android.resource://" + getPackageName() + "/raw/" + fileName);
        } else if (view.getId() == R.id.btn_cdbtrainingsubmit) {
            if (validateField() == false) {
                Toast.makeText(this, "Required fields are missing", Toast.LENGTH_LONG).show();
                return;
            }

            Intent intent = new Intent(CdbTraining.this, CdbPostTest.class);
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
        Toast.makeText(this, "You are not allowed to go on back screen SORRY!!!", Toast.LENGTH_LONG).show();
    }
}
