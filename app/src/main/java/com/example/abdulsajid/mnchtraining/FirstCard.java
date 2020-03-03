package com.example.abdulsajid.mnchtraining;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class FirstCard extends AppCompatActivity implements View.OnClickListener {


    Button btn1, btn2, btn3, btn4;
    EditText ed_cnic_no;
    String cnic_no;
    LinearLayout ll_cnic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_card);

        ll_cnic = findViewById(R.id.ll_cnic);
        ed_cnic_no = findViewById(R.id.ed_cnic_no);
        Intent getcnicno = getIntent();
        cnic_no = getcnicno.getExtras().getString("cnic_no");
        ed_cnic_no.setText(cnic_no);
        ed_cnic_no.setEnabled(false);

        fun_initialization();

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);


    }


    void fun_initialization() {

        btn1 = findViewById(R.id.btn_pink);
        btn2 = findViewById(R.id.btn_yellow);
        btn3 = findViewById(R.id.btn_green);
        btn4 = findViewById(R.id.btn_fc_start);

        ed_cnic_no = findViewById(R.id.ed_cnic_no);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btn_pink) {

            final AlertDialog b = new AlertDialog.Builder(this).create();

            LayoutInflater layinflat = getLayoutInflater();
            View v = layinflat.inflate(R.layout.dialog_pink, null);
            b.setView(v);
            b.show();


        } else if (view.getId() == R.id.btn_yellow) {

            final AlertDialog b = new AlertDialog.Builder(this).create();

            LayoutInflater layoutInflater = getLayoutInflater();
            View v = layoutInflater.inflate(R.layout.dialog_yellow, null);
            b.setView(v);
            b.show();

        } else if (view.getId() == R.id.btn_green) {

            final AlertDialog b = new AlertDialog.Builder(this).create();

            LayoutInflater layoutInflater = getLayoutInflater();
            View v = layoutInflater.inflate(R.layout.dialog_green, null);
            b.setView(v);
            b.show();

        } else if (view.getId() == R.id.btn_fc_start) {

            if (ed_cnic_no.getText().toString().trim().length() > 0) {
                cnic_no = ed_cnic_no.getText().toString().trim();
            }

            Intent intt = new Intent(this, MainActivity.class);
            intt.putExtra("cnic_no", cnic_no);
            startActivity(intt);
            this.finish();
        }

    }


    public void onBackPressed() {
        Toast.makeText(this, "YOU ARE NOT ALLOWED TO GO ON BACK SCREEN SORRY!!!", Toast.LENGTH_LONG).show();
    }

}
