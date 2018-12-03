package com.example.abdulsajid.mnchtraining;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Global.Session_Start;
import data.LocalDataManager;
import utils.Districts;
import utils.Gothrough;
import utils.GpsTracker;
import utils.LocationHelper;
import utils.Tehsils;
import utils.Ucs;

//import com.example.abdulsajid.mnchtraining.utils.GpsTracker;
//import com.example.abdulsajid.mnchtraining.utils.LocationHelper;

public class Gps extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    //region Declaration
    int pk_id;
    LocationHelper.LocationResult locationResult;
    LocationHelper locationHelper;
    ProgressDialog progressBar;
    Button btn_gps_device, btn_gps, btn_next;

    Spinner sp_province,
            sp_district,
            sp_tehsil,
            sp_uc;

    LinearLayout
            ll_cnic,
            ll_providers,
            ll_province,
            ll_district,
            ll_tehsil,
            ll_uc,
            ll_gps;

    EditText
            ed_session_start_date,
            ed_session_start_time,
            ed_cnic_no,
            ed_facility_name,
            ed_provider_name,
            ed_qa_officer,
            ed_contact_no,
            ed_latitude,
            ed_longitude;

    String
            Session_Start_Date,
            Session_Start_Time,
            cnic_no,
            province,
            district,
            tehsil,
            Union_Council,
            facility_name,
            provider_name,
            qa_officer,
            contact_no,
            S_latitude,
            S_longitude,
            STATUS;

    //endregion
    List<String> dataDistricts = new ArrayList<>();
    List<String> dataTehsil = new ArrayList<>();
    List<String> dataUC = new ArrayList<>();


   /* boolean if_cnic_no_exist() {
        DBHelper db = new DBHelper(this);
        Cursor res = db.getData1("Log_table", cnic_no);

        return res.getCount() > 0;

    }*/

    void Initialization() {

        ll_cnic = findViewById(R.id.ll_cnic);
        ll_providers = findViewById(R.id.ll_providers);
        ll_province = findViewById(R.id.ll_province);
        ll_district = findViewById(R.id.ll_district);
        ll_tehsil = findViewById(R.id.ll_tehsil);
        ll_uc = findViewById(R.id.ll_uc);
        ll_gps = findViewById(R.id.ll_gps);

        sp_province = findViewById(R.id.sp_province);
        sp_district = findViewById(R.id.sp_district);
        sp_tehsil = findViewById(R.id.sp_tehsil);
        sp_uc = findViewById(R.id.sp_uc);

        ed_session_start_date = findViewById(R.id.ed_session_start_date);
        ed_session_start_time = findViewById(R.id.ed_session_start_time);
        ed_cnic_no = findViewById(R.id.ed_cnic_no);
        ed_facility_name = findViewById(R.id.ed_facility_name);
        ed_provider_name = findViewById(R.id.ed_provider_name);
        ed_qa_officer = findViewById(R.id.ed_qa_officer);
        ed_contact_no = findViewById(R.id.ed_contact_no);

        ed_latitude = findViewById(R.id.ed_latitude);
        ed_longitude = findViewById(R.id.ed_longitude);
        btn_gps = findViewById(R.id.btn_gps);
        btn_gps_device = findViewById(R.id.btn_gps_device);
        btn_next = findViewById(R.id.btn_frag_manh_next);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        Initialization();

        /*Intent getcnicno = getIntent();
        qa_officer = getcnicno.getExtras().getString("qa_officer");
        ed_qa_officer.setText(qa_officer);
        ed_qa_officer.setEnabled(false);*/

        /*String Curent_date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());​

        ed_session_start_date = Curent_date*/

        Date SDateTime = Calendar.getInstance().getTime();
        SimpleDateFormat Dateformat = new SimpleDateFormat("dd-MMM-yyyy");
        SimpleDateFormat Timeformat = new SimpleDateFormat("HH:mm:ss");
        String SToday = Dateformat.format(SDateTime);
        String STime = Timeformat.format(SDateTime);

        ed_session_start_date.setText(SToday);
        ed_session_start_date.setEnabled(false);
        ed_session_start_time.setText(STime);
        ed_session_start_time.setEnabled(false);
        Toast.makeText(this, SToday + " " + STime, Toast.LENGTH_LONG).show();

        btn_next.setOnClickListener(this);

        sp_province.setOnItemSelectedListener(this);
        sp_district.setOnItemSelectedListener(this);
        sp_tehsil.setOnItemSelectedListener(this);

        btn_gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GpsTracker gpsObj = new GpsTracker(Gps.this);
                gpsObj.requestLocationUpdate(new GpsTracker.LocationCallback() {
                    @Override
                    public void onNewLocation(String gpsData) {
                        if (gpsData.split("-").length > 1) {
                            ed_latitude.setText(gpsData.split("-")[0]);
                            ed_longitude.setText(gpsData.split("-")[1]);
                        } else {
                            ed_latitude.setText("00");
                            ed_longitude.setText("00");
                        }
                    }
                });
            }
        });

//////////////////////////////////////////// get by Device gps.....................


        // to get location updates, initialize LocationResult
        this.locationResult = new LocationHelper.LocationResult() {
            @Override
            public void gotLocation(Location location) {

                //Got the location!
                if (location != null) {

                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();


                    ed_latitude.setText(latitude + "");
                    ed_longitude.setText(longitude + "");

                    locationHelper.stopGettingLocationUpdates();
                    // here you can save the latitude and longitude values
                    // maybe in your text file or database
                    progressBar.dismiss();
                } else {
                    //Toast.makeText(getApplicationContext.this,"Kindly Turn ON Device GPS",Toast.LENGTH_LONG).show();
                    progressBar.dismiss();
                }


            }

        };


        this.locationHelper = new LocationHelper();
        btn_gps_device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressBar = new ProgressDialog(Gps.this);
                progressBar.setMessage("Searching for GPS coordinates...");
                progressBar.setCancelable(false);
                progressBar.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {

                    }
                });
                progressBar.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        locationHelper.stopGettingLocationUpdates();
                        dialog.dismiss();
                    }
                });
                progressBar.show();


                locationHelper.getLocation(Gps.this, locationResult);


            }
        });

    }

    @Override
    public void onClick(View view) {
        if (validateField() == false) {
            Toast.makeText(this, "Required fields are missing", Toast.LENGTH_LONG).show();
            return;
        }

        value_assignment();
        insert_data();

        Intent intent = new Intent(Gps.this, FirstCard.class);
        intent.putExtra("cnic_no", cnic_no);
        startActivity(intent);

    }

    void value_assignment() {
        cnic_no = "-1";
        Session_Start_Date = "-1";
        Session_Start_Time = "-1";
        province = "-1";
        district = "-1";
        tehsil = "-1";
        Union_Council = "-1";
        facility_name = "-1";
        provider_name = "-1";
        qa_officer = "-1";
        contact_no = "-1";
        STATUS = "0";

        if (ed_session_start_date.getText().toString().length() > 0) {
            Session_Start_Date = ed_session_start_date.getText().toString().trim();
        }

        if (ed_session_start_time.getText().toString().length() > 0) {
            Session_Start_Time = ed_session_start_time.getText().toString().trim();
        }

        if (ed_cnic_no.getText().toString().length() > 0) {
            cnic_no = ed_cnic_no.getText().toString().trim();
        }

        if ((!(sp_province.getCount() == 0)) && (sp_province.getSelectedItem().toString() != "Select")) {
            province = sp_province.getSelectedItem().toString().trim();
        }


        if ((!(sp_district.getCount() == 0)) && (sp_district.getSelectedItem().toString() != "Select")) {
            district = sp_district.getSelectedItem().toString().trim();
        }

        if ((!(sp_tehsil.getCount() == 0)) && (sp_tehsil.getSelectedItem().toString() != "Select")) {
            tehsil = sp_tehsil.getSelectedItem().toString().trim();
        }

        if ((!(sp_uc.getCount() == 0)) && (sp_uc.getSelectedItem().toString() != "Select")) {
            Union_Council = sp_uc.getSelectedItem().toString().trim();
        }

        if (ed_facility_name.getText().toString().length() > 0) {
            facility_name = ed_facility_name.getText().toString().trim();
        }

        if (ed_provider_name.getText().toString().length() > 0) {
            provider_name = ed_provider_name.getText().toString().trim();
        }

        if (ed_qa_officer.getText().toString().length() > 0) {
            qa_officer = ed_qa_officer.getText().toString().trim();
        }

        if (ed_contact_no.getText().toString().length() > 0) {
            contact_no = ed_contact_no.getText().toString().trim();
        }

        if (ed_latitude.getText().toString().length() > 0) {
            S_latitude = ed_latitude.getText().toString().trim();
        }

        if (ed_longitude.getText().toString().length() > 0) {
            S_longitude = ed_longitude.getText().toString().trim();
        }

    }

    void insert_data() {

        String query = "insert into Session_Start("
                + Session_Start.cnic_no + ","
                + Session_Start.Session_Start_Date + ","
                + Session_Start.Session_Start_Time + ","
                + Session_Start.province + ","
                + Session_Start.district + ","
                + Session_Start.tehsil + ","
                + Session_Start.Union_Council + ","
                + Session_Start.facility_name + ","
                + Session_Start.provider_name + ","
                + Session_Start.qa_officer + ","
                + Session_Start.contact_no + ","
                + Session_Start.S_latitude + ","
                + Session_Start.S_longitude + ","
                + Session_Start.STATUS + ") values ('" +

                cnic_no + "','" +
                Session_Start_Date + "','" +
                Session_Start_Time + "','" +
                province + "','" +
                district + "','" +
                tehsil + "','" +
                Union_Council + "','" +
                facility_name + "','" +
                provider_name + "','" +
                qa_officer + "','" +
                contact_no + "','" +
                S_latitude + "','" +
                S_longitude + "','" +
                STATUS + "')";


        query = String.format(query);

        LocalDataManager Lm = new LocalDataManager(this);

        LocalDataManager.database.execSQL(query);

        query = "select * from Session_Start ORDER BY id DESC LIMIT 1";
        Cursor c = LocalDataManager.database.rawQuery(query, null);


        if (c != null)
            if (c.moveToFirst())
                Global.Session_Start.pk_id = String.valueOf(c.getInt(0));

        Toast.makeText(this, "Session Start", Toast.LENGTH_SHORT).show();
    }

    boolean validateField() {

        if (Gothrough.IamHiden(ll_cnic) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_province) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_district) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_tehsil) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_uc) == false) {
            return false;
        }

        if (Gothrough.IamHiden(ll_providers) == false) {
            return false;
        }

        return Gothrough.IamHiden(ll_gps) != false;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        int id = adapterView.getId();
        switch (id) {
            case R.id.sp_province:

                if (sp_province.getSelectedItem().toString().equals("Select"))
                    break;

                dataDistricts = Districts.get(sp_province.getSelectedItem().toString());
                ArrayAdapter<String> dataAdapterD = new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, dataDistricts);

                dataAdapterD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sp_district.setAdapter(dataAdapterD);

                sp_district.setSelection(0);
                sp_tehsil.setAdapter(null);
                break;

            case R.id.sp_district:
                if (sp_district.getSelectedItem().toString().equals("Select"))
                    break;
                dataTehsil = Tehsils.get(sp_district.getSelectedItem().toString());
                dataAdapterD = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dataTehsil);
                dataAdapterD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sp_tehsil.setAdapter(dataAdapterD);

                sp_tehsil.setSelection(0);
                sp_uc.setAdapter(null);
                break;

            case R.id.sp_tehsil:
                if (sp_tehsil.getSelectedItem().toString().equals("Select"))
                    break;
                dataUC = Ucs.get(sp_tehsil.getSelectedItem().toString());
                dataAdapterD = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dataUC);

                dataAdapterD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sp_uc.setAdapter(dataAdapterD);

                sp_uc.setSelection(0);

                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void onBackPressed() {

            /*String str = "1_MIND-2_MINDMIND-3_MINDMINDMIND-4_MINDMINDMINDMIND-5_MINDMINDMINDMINDMIND-6_MINDMINDMINDMINDMINDMIND-7_MINDMINDMINDMINDMINDMINDMIND!";
            String parts[] = str.split("-");
            String val = "0";
            for(int i = 0; i < parts.length; i++){

            //Toast.makeText(this, "--------> "+ parts[i]);

            val = parts[i];
            Toast.makeText(this, "---------------------  "+val+"  --------------------- ",Toast.LENGTH_SHORT).show();
        }*/


        this.finish();
    }
}

