package com.example.abdulsajid.mnchtraining;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.abdulsajid.mnchtraining.CDB.CdbPreTest;
import com.example.abdulsajid.mnchtraining.DIARRHEA.DiarrheaPreTest;
import com.example.abdulsajid.mnchtraining.GDS.GdsPreTest;
import com.example.abdulsajid.mnchtraining.PSBI.PsbiPreTest;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    LinearLayout ll_cnic;
    ImageButton imgbtn_gds, imgbtn_cdb, imgbtn_diarrhea, imgbtn_psbi;
    EditText ed_cnic_no;
    String cnic_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Initalization();

        ll_cnic = findViewById(R.id.ll_cnic);
        ed_cnic_no = findViewById(R.id.ed_cnic_no);
        Intent getcnicno = getIntent();
        cnic_no = getcnicno.getExtras().getString("cnic_no");
        ed_cnic_no.setText(cnic_no);
        ed_cnic_no.setEnabled(false);


        imgbtn_gds.setOnClickListener(this);
        imgbtn_cdb.setOnClickListener(this);
        imgbtn_diarrhea.setOnClickListener(this);
        imgbtn_psbi.setOnClickListener(this);

    }

    void Initalization() {

        ed_cnic_no = findViewById(R.id.ed_cnic_no);
        imgbtn_gds = findViewById(R.id.imgbtn_gds);
        imgbtn_cdb = findViewById(R.id.imgbtn_cdb);
        imgbtn_diarrhea = findViewById(R.id.imgbtn_diarrhea);
        imgbtn_psbi = findViewById(R.id.imgbtn_psbi);
    }


    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.imgbtn_gds) {

            if (ed_cnic_no.getText().toString().trim().length() > 0) {
                cnic_no = ed_cnic_no.getText().toString().trim();
            }

            Intent intt = new Intent(this, GdsPreTest.class);
            intt.putExtra("cnic_no", cnic_no);
            startActivity(intt);
            this.finish();

        } else if (view.getId() == R.id.imgbtn_cdb) {
            if (ed_cnic_no.getText().toString().trim().length() > 0) {
                cnic_no = ed_cnic_no.getText().toString().trim();
            }

            Intent intt = new Intent(this, CdbPreTest.class);
            intt.putExtra("cnic_no", cnic_no);
            startActivity(intt);
            this.finish();

            //Toast.makeText(this, "Cough & Difficult Breathing Site is UNDER Construction", Toast.LENGTH_LONG).show();
        } else if (view.getId() == R.id.imgbtn_diarrhea) {
            if (ed_cnic_no.getText().toString().trim().length() > 0) {
                cnic_no = ed_cnic_no.getText().toString().trim();
            }

            Intent intt = new Intent(this, DiarrheaPreTest.class);
            intt.putExtra("cnic_no", cnic_no);
            startActivity(intt);
            this.finish();

            //Toast.makeText(this, "Diarrhea Site is UNDER Construction", Toast.LENGTH_LONG).show();
        } else if (view.getId() == R.id.imgbtn_psbi) {
            if (ed_cnic_no.getText().toString().trim().length() > 0) {
                cnic_no = ed_cnic_no.getText().toString().trim();
            }

            Intent intt = new Intent(this, PsbiPreTest.class);
            intt.putExtra("cnic_no", cnic_no);
            startActivity(intt);
            this.finish();

            //Toast.makeText(this, "Possible Serious Bacterial Infection PSBI Site is UNDER Construction", Toast.LENGTH_LONG).show();
        }
    }

    public void onBackPressed() {
        Toast.makeText(this, "YOU ARE NOT ALLOWED TO GO ON BACK SCREEN SORRY!!!", Toast.LENGTH_LONG).show();
    }
}
