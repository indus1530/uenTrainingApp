package com.example.abdulsajid.mnchtraining.Upload;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.abdulsajid.mnchtraining.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Global.CDB.CDBPostTest;
import Global.CDB.CDBPreTest;
import Global.Diarrhea.DiarrheaPostTest;
import Global.Diarrhea.DiarrheaPreTest;
import Global.GDS.GDSPostTest;
import Global.GDS.GDSPreTest;
import Global.PSBI.PSBIPostTest;
import Global.PSBI.PSBIPretest;
import Global.Session_End;
import data.DBHelper;
import data.LocalDataManager;

import static java.lang.Integer.parseInt;


public class SurveyCompletedActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_completed);

        List<String> list = new LocalDataManager(this).getLogList("0");


        if (list == null)
            return;

        Collections.sort(list);

        mRecyclerView = findViewById(R.id.list_survey_completed);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new SurveyCompletedCustomAdapter(this, list);
        mRecyclerView.setAdapter(mAdapter);
    }
}


class SurveyCompletedCustomAdapter extends RecyclerView.Adapter {

    Context mContext;
    List<String> mList;

    public SurveyCompletedCustomAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_survey_pending, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        final ViewHolder vh = (ViewHolder) holder;

        //rejected items..
        if (mList.get(position).contains("--00")) {
            vh.itemView.setBackgroundColor(Color.parseColor("#FFB7BC"));
        }

        vh.textName.setText(mList.get(position).split("--")[0]);
        vh.textId.setText(position + 1 + "");

        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder b = new AlertDialog.Builder(mContext);
                b.setTitle("Upload Interview");
                b.setMessage("Do you want to upload this interview ");
                b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        String memberId = vh.textName.getText().toString().trim();
                        String[] arrr = memberId.split("/");

                        //int id = parseInt(arrr[0]);
                        Session_End.cnic_upload = arrr[0];
                        String training = arrr[1];
                        int id = parseInt(arrr[2]);


                        //new Upload_Q1101_Q1610(mContext).execute();

                        if (arrr[1].contains("General Danger Signs")) {
                            upload_gds(arrr[0], parseInt(arrr[2]), vh.itemView);


                        } else if (arrr[1].contains("Cough & Difficult Breathing")) {
                            upload_cdb(arrr[0], parseInt(arrr[2]), vh.itemView);

                        } else if (arrr[1].contains("Diarrhea")) {
                            upload_diarrhea(arrr[0], parseInt(arrr[2]), vh.itemView);

                        } else if (arrr[1].contains("Possible Serious Bacterial Infection")) {
                            upload_psbi(arrr[0], parseInt(arrr[2]), vh.itemView);
                        }


                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                    }
                }).show();
            }
        });
    }

    /*public void update_status(int id) {

        DBHelper db = new DBHelper(mContext);

        ContentValues values = new ContentValues();

        values.put("STATUS", "1");

        Long res = db.updateData("Session_Start", values, id);
    }*/

    /* public void update_data (String table,
                              ContentValues values,
                              String whereClause,
                              String[] whereArgs){
         return ;
     }*/
    public void updateData(String id) {

        String query = "Update Session_End  set STATUS='1' where STATUS='0' and id=" + id;
        LocalDataManager Lm = new LocalDataManager(mContext);
        LocalDataManager.database.execSQL(query);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    //USING PROStaff
    public void upload_gds(final String cnic_no, final int id, final View itemView) {

        final String ROOT_URL = "http://10.198.97.62:80/sm/Welcome/collect_GDS";

        final RequestQueue myRequestQueue = Volley.newRequestQueue(mContext);

        StringRequest sendMyRequest = new StringRequest(Request.Method.POST, ROOT_URL,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONObject JSONObject = new JSONObject(response);
                            Toast.makeText(mContext, JSONObject.getString("message"), Toast.LENGTH_LONG).show();

                            if (Integer.valueOf(JSONObject.getString("counter")) == 4) {

                                updateData(id + "");
                                itemView.setVisibility(View.GONE);
                            } else {
                                Toast.makeText(mContext, "Some tables couldn't get data", Toast.LENGTH_LONG).show();
                            }

                            myRequestQueue.getCache().clear();

                        } catch (JSONException e) {

                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(mContext, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }) {

            @Override
            protected Map<String, String> getParams() {

                Map<String, String> params = new HashMap<>();

                //ArrayList<String> loopResponse = new ArrayList();

                DBHelper db = new DBHelper(mContext);

                Cursor c1 = db.getData1("Session_Start", cnic_no, id);
                Cursor c2 = db.getData2("GDSPreTest", cnic_no, id);
                Cursor c3 = db.getData2("GDSPostTest", cnic_no, id);
                Cursor c4 = db.getData2("Session_End", cnic_no, id);

                params.put("table1", "session_start");
                params.put("table2", "gdspretest");
                params.put("table3", "gdsposttest");
                params.put("table4", "session_end");

                if (c1.getCount() > 0) {

                    if (c1.moveToFirst()) {

                        params.put("app_id1", c1.getString(c1.getColumnIndex("id")));
                        params.put(Global.Session_Start.cnic_no, c1.getString(c1.getColumnIndex("cnic_no")));
                        params.put(Global.Session_Start.Session_Start_Date, c1.getString(c1.getColumnIndex("Session_Start_Date")));
                        params.put(Global.Session_Start.Session_Start_Time, c1.getString(c1.getColumnIndex("Session_Start_Time")));
                        params.put(Global.Session_Start.province, c1.getString(c1.getColumnIndex("province")));
                        params.put(Global.Session_Start.district, c1.getString(c1.getColumnIndex("district")));
                        params.put(Global.Session_Start.tehsil, c1.getString(c1.getColumnIndex("tehsil")));
                        params.put(Global.Session_Start.Union_Council, c1.getString(c1.getColumnIndex("Union_Council")));
                        params.put(Global.Session_Start.facility_name, c1.getString(c1.getColumnIndex("facility_name")));
                        params.put(Global.Session_Start.provider_name, c1.getString(c1.getColumnIndex("provider_name")));
                        params.put(Global.Session_Start.qa_officer, c1.getString(c1.getColumnIndex("qa_officer")));
                        params.put(Global.Session_Start.contact_no, c1.getString(c1.getColumnIndex("contact_no")));
                        params.put(Global.Session_Start.S_latitude, c1.getString(c1.getColumnIndex("S_latitude")));
                        params.put(Global.Session_Start.S_longitude, c1.getString(c1.getColumnIndex("S_longitude")));
                        params.put(Global.Session_Start.STATUS, c1.getString(c1.getColumnIndex("STATUS")));
                    }
                }

                if (c2.getCount() > 0) {

                    if (c2.moveToFirst()) {

                        params.put("app_id2", c2.getString(c2.getColumnIndex("id")));
                        params.put(GDSPreTest.fk_id, c2.getString(c2.getColumnIndex("fk_id")));
                        params.put(GDSPreTest.cnic_no, c2.getString(c2.getColumnIndex("cnic_no")));
                        params.put(GDSPreTest.gdspretest_date, c2.getString(c2.getColumnIndex("gdspretest_date")));
                        params.put(GDSPreTest.gdspretest_time, c2.getString(c2.getColumnIndex("gdspretest_time")));
                        params.put(GDSPreTest.gdspretestq1, c2.getString(c2.getColumnIndex("gdspretestq1")));
                        params.put(GDSPreTest.gdspretestq2, c2.getString(c2.getColumnIndex("gdspretestq2")));
                        params.put(GDSPreTest.gdspretestq3, c2.getString(c2.getColumnIndex("gdspretestq3")));
                        params.put(GDSPreTest.gdspretestq4, c2.getString(c2.getColumnIndex("gdspretestq4")));
                        params.put(GDSPreTest.gdspretestq5, c2.getString(c2.getColumnIndex("gdspretestq5")));
                        params.put(GDSPreTest.gdspretestq6, c2.getString(c2.getColumnIndex("gdspretestq6")));
                        params.put(GDSPreTest.gdspretestq7, c2.getString(c2.getColumnIndex("gdspretestq7")));
                        params.put(GDSPreTest.gdspretestq8, c2.getString(c2.getColumnIndex("gdspretestq8")));
                        params.put(GDSPreTest.gdspretestq9, c2.getString(c2.getColumnIndex("gdspretestq9")));
                        params.put(GDSPreTest.gdspretestq10, c2.getString(c2.getColumnIndex("gdspretestq10")));
                        params.put(GDSPreTest.pretest_result, c2.getString(c2.getColumnIndex("pretest_result")));
                        params.put(GDSPreTest.STATUS, c2.getString(c2.getColumnIndex("STATUS")));
                    }
                }

                if (c3.getCount() > 0) {

                    if (c3.moveToFirst()) {

                        params.put("app_id3", c3.getString(c3.getColumnIndex("id")));
                        params.put(GDSPostTest.fk_id, c3.getString(c3.getColumnIndex("fk_id")));
                        params.put(GDSPostTest.cnic_no, c3.getString(c3.getColumnIndex("cnic_no")));
                        params.put(GDSPostTest.gdsposttest_date, c3.getString(c3.getColumnIndex("gdsposttest_date")));
                        params.put(GDSPostTest.gdsposttest_time, c3.getString(c3.getColumnIndex("gdsposttest_time")));
                        params.put(GDSPostTest.gdsposttestq1, c3.getString(c3.getColumnIndex("gdsposttestq1")));
                        params.put(GDSPostTest.gdsposttestq2, c3.getString(c3.getColumnIndex("gdsposttestq2")));
                        params.put(GDSPostTest.gdsposttestq3, c3.getString(c3.getColumnIndex("gdsposttestq3")));
                        params.put(GDSPostTest.gdsposttestq4, c3.getString(c3.getColumnIndex("gdsposttestq4")));
                        params.put(GDSPostTest.gdsposttestq5, c3.getString(c3.getColumnIndex("gdsposttestq5")));
                        params.put(GDSPostTest.gdsposttestq6, c3.getString(c3.getColumnIndex("gdsposttestq6")));
                        params.put(GDSPostTest.gdsposttestq7, c3.getString(c3.getColumnIndex("gdsposttestq7")));
                        params.put(GDSPostTest.gdsposttestq8, c3.getString(c3.getColumnIndex("gdsposttestq8")));
                        params.put(GDSPostTest.gdsposttestq9, c3.getString(c3.getColumnIndex("gdsposttestq9")));
                        params.put(GDSPostTest.gdsposttestq10, c3.getString(c3.getColumnIndex("gdsposttestq10")));
                        params.put(GDSPostTest.posttest_result, c3.getString(c3.getColumnIndex("posttest_result")));
                        params.put(GDSPostTest.STATUS, c3.getString(c3.getColumnIndex("STATUS")));
                    }
                }

                if (c4.getCount() > 0) {

                    if (c4.moveToFirst()) {

                        params.put("app_id4", c4.getString(c4.getColumnIndex("id")));
                        params.put(Session_End.fk_id, c4.getString(c4.getColumnIndex("fk_id")));
                        params.put(Session_End.cnic_no, c4.getString(c4.getColumnIndex("cnic_no")));
                        params.put(Session_End.training, c4.getString(c4.getColumnIndex("training")));
                        params.put(Session_End.pretest_result, c4.getString(c4.getColumnIndex("pretest_result")));
                        params.put(Session_End.posttest_result, c4.getString(c4.getColumnIndex("posttest_result")));
                        params.put(Session_End.posttest_percent, c4.getString(c4.getColumnIndex("posttest_percent")));
                        params.put(Session_End.Remarks, c4.getString(c4.getColumnIndex("Remarks")));
                        params.put(Session_End.next_session_date, c4.getString(c4.getColumnIndex("next_session_date")));
                        params.put(Session_End.next_session_time, c4.getString(c4.getColumnIndex("next_session_time")));
                        params.put(Session_End.training_status, c4.getString(c4.getColumnIndex("training_status")));
                        params.put(Session_End.Session_End_Date, c4.getString(c4.getColumnIndex("Session_End_Date")));
                        params.put(Session_End.Session_End_Time, c4.getString(c4.getColumnIndex("Session_End_Time")));
                        params.put(Session_End.STATUS, c4.getString(c4.getColumnIndex("STATUS")));
                    }
                }

                return params;
            }
        };

        myRequestQueue.add(sendMyRequest);
    }

    public void upload_cdb(final String cnic_no, final int id, final View itemView) {

        final String ROOT_URL = "http://10.198.97.62:80/sm/Welcome/collect_CDB";

        final RequestQueue myRequestQueue = Volley.newRequestQueue(mContext);

        StringRequest sendMyRequest = new StringRequest(Request.Method.POST, ROOT_URL,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONObject JSONObject = new JSONObject(response);
                            Toast.makeText(mContext, JSONObject.getString("message"), Toast.LENGTH_LONG).show();

                            if (Integer.valueOf(JSONObject.getString("counter")) == 4) {

                                updateData(id + "");
                                itemView.setVisibility(View.GONE);
                            } else {
                                Toast.makeText(mContext, "Some tables couldn't get data", Toast.LENGTH_LONG).show();
                            }

                            myRequestQueue.getCache().clear();

                        } catch (JSONException e) {

                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(mContext, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }) {

            @Override
            protected Map<String, String> getParams() {

                Map<String, String> params = new HashMap<>();

                //ArrayList<String> loopResponse = new ArrayList();

                DBHelper db = new DBHelper(mContext);

                Cursor c1 = db.getData1("Session_Start", cnic_no, id);
                Cursor c2 = db.getData2("CDBPreTest", cnic_no, id);
                Cursor c3 = db.getData2("CDBPostTest", cnic_no, id);
                Cursor c4 = db.getData2("Session_End", cnic_no, id);

                params.put("table1", "session_start");
                params.put("table2", "cdbpretest");
                params.put("table3", "cdbposttest");
                params.put("table4", "session_end");

                if (c1.getCount() > 0) {

                    if (c1.moveToFirst()) {

                        params.put("app_id1", c1.getString(c1.getColumnIndex("id")));
                        params.put(Global.Session_Start.cnic_no, c1.getString(c1.getColumnIndex("cnic_no")));
                        params.put(Global.Session_Start.Session_Start_Date, c1.getString(c1.getColumnIndex("Session_Start_Date")));
                        params.put(Global.Session_Start.Session_Start_Time, c1.getString(c1.getColumnIndex("Session_Start_Time")));
                        params.put(Global.Session_Start.province, c1.getString(c1.getColumnIndex("province")));
                        params.put(Global.Session_Start.district, c1.getString(c1.getColumnIndex("district")));
                        params.put(Global.Session_Start.tehsil, c1.getString(c1.getColumnIndex("tehsil")));
                        params.put(Global.Session_Start.Union_Council, c1.getString(c1.getColumnIndex("Union_Council")));
                        params.put(Global.Session_Start.facility_name, c1.getString(c1.getColumnIndex("facility_name")));
                        params.put(Global.Session_Start.provider_name, c1.getString(c1.getColumnIndex("provider_name")));
                        params.put(Global.Session_Start.qa_officer, c1.getString(c1.getColumnIndex("qa_officer")));
                        params.put(Global.Session_Start.contact_no, c1.getString(c1.getColumnIndex("contact_no")));
                        params.put(Global.Session_Start.S_latitude, c1.getString(c1.getColumnIndex("S_latitude")));
                        params.put(Global.Session_Start.S_longitude, c1.getString(c1.getColumnIndex("S_longitude")));
                        params.put(Global.Session_Start.STATUS, c1.getString(c1.getColumnIndex("STATUS")));
                    }
                }

                if (c2.getCount() > 0) {

                    if (c2.moveToFirst()) {

                        params.put("app_id2", c2.getString(c2.getColumnIndex("id")));
                        params.put(CDBPreTest.fk_id, c2.getString(c2.getColumnIndex("fk_id")));
                        params.put(CDBPreTest.cnic_no, c2.getString(c2.getColumnIndex("cnic_no")));
                        params.put(CDBPreTest.cdbpretest_date, c2.getString(c2.getColumnIndex("cdbpretest_date")));
                        params.put(CDBPreTest.cdbpretest_time, c2.getString(c2.getColumnIndex("cdbpretest_time")));
                        params.put(CDBPreTest.cdbpretestq1, c2.getString(c2.getColumnIndex("cdbpretestq1")));
                        params.put(CDBPreTest.cdbpretestq2, c2.getString(c2.getColumnIndex("cdbpretestq2")));
                        params.put(CDBPreTest.cdbpretestq3, c2.getString(c2.getColumnIndex("cdbpretestq3")));
                        params.put(CDBPreTest.cdbpretestq4, c2.getString(c2.getColumnIndex("cdbpretestq4")));
                        params.put(CDBPreTest.cdbpretestq5, c2.getString(c2.getColumnIndex("cdbpretestq5")));
                        params.put(CDBPreTest.cdbpretestq6, c2.getString(c2.getColumnIndex("cdbpretestq6")));
                        params.put(CDBPreTest.cdbpretestq7, c2.getString(c2.getColumnIndex("cdbpretestq7")));
                        params.put(CDBPreTest.cdbpretestq8, c2.getString(c2.getColumnIndex("cdbpretestq8")));
                        params.put(CDBPreTest.cdbpretestq9, c2.getString(c2.getColumnIndex("cdbpretestq9")));
                        params.put(CDBPreTest.cdbpretestq10, c2.getString(c2.getColumnIndex("cdbpretestq10")));
                        params.put(CDBPreTest.pretest_result, c2.getString(c2.getColumnIndex("pretest_result")));
                        params.put(CDBPreTest.STATUS, c2.getString(c2.getColumnIndex("STATUS")));
                    }
                }


                if (c3.getCount() > 0) {

                    if (c3.moveToFirst()) {

                        params.put("app_id3", c3.getString(c3.getColumnIndex("id")));
                        params.put(CDBPostTest.fk_id, c3.getString(c3.getColumnIndex("fk_id")));
                        params.put(CDBPostTest.cnic_no, c3.getString(c3.getColumnIndex("cnic_no")));
                        params.put(CDBPostTest.cdbposttest_date, c3.getString(c3.getColumnIndex("cdbposttest_date")));
                        params.put(CDBPostTest.cdbposttest_time, c3.getString(c3.getColumnIndex("cdbposttest_time")));
                        params.put(CDBPostTest.cdbposttestq1, c3.getString(c3.getColumnIndex("cdbposttestq1")));
                        params.put(CDBPostTest.cdbposttestq2, c3.getString(c3.getColumnIndex("cdbposttestq2")));
                        params.put(CDBPostTest.cdbposttestq3, c3.getString(c3.getColumnIndex("cdbposttestq3")));
                        params.put(CDBPostTest.cdbposttestq4, c3.getString(c3.getColumnIndex("cdbposttestq4")));
                        params.put(CDBPostTest.cdbposttestq5, c3.getString(c3.getColumnIndex("cdbposttestq5")));
                        params.put(CDBPostTest.cdbposttestq6, c3.getString(c3.getColumnIndex("cdbposttestq6")));
                        params.put(CDBPostTest.cdbposttestq7, c3.getString(c3.getColumnIndex("cdbposttestq7")));
                        params.put(CDBPostTest.cdbposttestq8, c3.getString(c3.getColumnIndex("cdbposttestq8")));
                        params.put(CDBPostTest.cdbposttestq9, c3.getString(c3.getColumnIndex("cdbposttestq9")));
                        params.put(CDBPostTest.cdbposttestq10, c3.getString(c3.getColumnIndex("cdbposttestq10")));
                        params.put(CDBPostTest.posttest_result, c3.getString(c3.getColumnIndex("posttest_result")));
                        params.put(CDBPostTest.STATUS, c3.getString(c3.getColumnIndex("STATUS")));
                    }
                }

                if (c4.getCount() > 0) {

                    if (c4.moveToFirst()) {

                        params.put("app_id4", c4.getString(c4.getColumnIndex("id")));
                        params.put(Session_End.fk_id, c4.getString(c4.getColumnIndex("fk_id")));
                        params.put(Session_End.cnic_no, c4.getString(c4.getColumnIndex("cnic_no")));
                        params.put(Session_End.training, c4.getString(c4.getColumnIndex("training")));
                        params.put(Session_End.pretest_result, c4.getString(c4.getColumnIndex("pretest_result")));
                        params.put(Session_End.posttest_result, c4.getString(c4.getColumnIndex("posttest_result")));
                        params.put(Session_End.posttest_percent, c4.getString(c4.getColumnIndex("posttest_percent")));
                        params.put(Session_End.Remarks, c4.getString(c4.getColumnIndex("Remarks")));
                        params.put(Session_End.next_session_date, c4.getString(c4.getColumnIndex("next_session_date")));
                        params.put(Session_End.next_session_time, c4.getString(c4.getColumnIndex("next_session_time")));
                        params.put(Session_End.training_status, c4.getString(c4.getColumnIndex("training_status")));
                        params.put(Session_End.Session_End_Date, c4.getString(c4.getColumnIndex("Session_End_Date")));
                        params.put(Session_End.Session_End_Time, c4.getString(c4.getColumnIndex("Session_End_Time")));
                        params.put(Session_End.STATUS, c4.getString(c4.getColumnIndex("STATUS")));
                    }
                }

                return params;
            }
        };

        myRequestQueue.add(sendMyRequest);
    }

    public void upload_diarrhea(final String cnic_no, final int id, final View itemView) {

        final String ROOT_URL = "http://10.198.97.62:80/sm/Welcome/collect_Diarrhea";

        final RequestQueue myRequestQueue = Volley.newRequestQueue(mContext);

        StringRequest sendMyRequest = new StringRequest(Request.Method.POST, ROOT_URL,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONObject JSONObject = new JSONObject(response);
                            Toast.makeText(mContext, JSONObject.getString("message"), Toast.LENGTH_LONG).show();

                            if (Integer.valueOf(JSONObject.getString("counter")) == 4) {

                                updateData(id + "");
                                itemView.setVisibility(View.GONE);
                            } else {
                                Toast.makeText(mContext, "Some tables couldn't get data", Toast.LENGTH_LONG).show();
                            }

                            myRequestQueue.getCache().clear();

                        } catch (JSONException e) {

                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(mContext, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }) {

            @Override
            protected Map<String, String> getParams() {

                Map<String, String> params = new HashMap<>();

                //ArrayList<String> loopResponse = new ArrayList();

                DBHelper db = new DBHelper(mContext);

                Cursor c1 = db.getData1("Session_Start", cnic_no, id);
                Cursor c2 = db.getData2("DiarrheaPreTest", cnic_no, id);
                Cursor c3 = db.getData2("DiarrheaPostTest", cnic_no, id);
                Cursor c4 = db.getData2("Session_End", cnic_no, id);

                params.put("table1", "session_start");
                params.put("table2", "diarrheapretest");
                params.put("table3", "diarrheaposttest");
                params.put("table4", "session_end");

                if (c1.getCount() > 0) {

                    if (c1.moveToFirst()) {

                        params.put("app_id1", c1.getString(c1.getColumnIndex("id")));
                        params.put(Global.Session_Start.cnic_no, c1.getString(c1.getColumnIndex("cnic_no")));
                        params.put(Global.Session_Start.Session_Start_Date, c1.getString(c1.getColumnIndex("Session_Start_Date")));
                        params.put(Global.Session_Start.Session_Start_Time, c1.getString(c1.getColumnIndex("Session_Start_Time")));
                        params.put(Global.Session_Start.province, c1.getString(c1.getColumnIndex("province")));
                        params.put(Global.Session_Start.district, c1.getString(c1.getColumnIndex("district")));
                        params.put(Global.Session_Start.tehsil, c1.getString(c1.getColumnIndex("tehsil")));
                        params.put(Global.Session_Start.Union_Council, c1.getString(c1.getColumnIndex("Union_Council")));
                        params.put(Global.Session_Start.facility_name, c1.getString(c1.getColumnIndex("facility_name")));
                        params.put(Global.Session_Start.provider_name, c1.getString(c1.getColumnIndex("provider_name")));
                        params.put(Global.Session_Start.qa_officer, c1.getString(c1.getColumnIndex("qa_officer")));
                        params.put(Global.Session_Start.contact_no, c1.getString(c1.getColumnIndex("contact_no")));
                        params.put(Global.Session_Start.S_latitude, c1.getString(c1.getColumnIndex("S_latitude")));
                        params.put(Global.Session_Start.S_longitude, c1.getString(c1.getColumnIndex("S_longitude")));
                        params.put(Global.Session_Start.STATUS, c1.getString(c1.getColumnIndex("STATUS")));
                    }
                }

                if (c2.getCount() > 0) {

                    if (c2.moveToFirst()) {

                        params.put("app_id2", c2.getString(c2.getColumnIndex("id")));
                        params.put(DiarrheaPreTest.fk_id, c2.getString(c2.getColumnIndex("fk_id")));
                        params.put(Global.Diarrhea.DiarrheaPreTest.cnic_no, c2.getString(c2.getColumnIndex("cnic_no")));
                        params.put(Global.Diarrhea.DiarrheaPreTest.diarrheapretest_date, c2.getString(c2.getColumnIndex("diarrheapretest_date")));
                        params.put(Global.Diarrhea.DiarrheaPreTest.diarrheapretest_time, c2.getString(c2.getColumnIndex("diarrheapretest_time")));
                        params.put(Global.Diarrhea.DiarrheaPreTest.diarrheapretestq1, c2.getString(c2.getColumnIndex("diarrheapretestq1")));
                        params.put(Global.Diarrhea.DiarrheaPreTest.diarrheapretestq2, c2.getString(c2.getColumnIndex("diarrheapretestq2")));
                        params.put(Global.Diarrhea.DiarrheaPreTest.diarrheapretestq3, c2.getString(c2.getColumnIndex("diarrheapretestq3")));
                        params.put(Global.Diarrhea.DiarrheaPreTest.diarrheapretestq4, c2.getString(c2.getColumnIndex("diarrheapretestq4")));
                        params.put(Global.Diarrhea.DiarrheaPreTest.diarrheapretestq5, c2.getString(c2.getColumnIndex("diarrheapretestq5")));
                        params.put(Global.Diarrhea.DiarrheaPreTest.diarrheapretestq6, c2.getString(c2.getColumnIndex("diarrheapretestq6")));
                        params.put(Global.Diarrhea.DiarrheaPreTest.diarrheapretestq7, c2.getString(c2.getColumnIndex("diarrheapretestq7")));
                        params.put(Global.Diarrhea.DiarrheaPreTest.diarrheapretestq8, c2.getString(c2.getColumnIndex("diarrheapretestq8")));
                        params.put(Global.Diarrhea.DiarrheaPreTest.diarrheapretestq9, c2.getString(c2.getColumnIndex("diarrheapretestq9")));
                        params.put(Global.Diarrhea.DiarrheaPreTest.diarrheapretestq10, c2.getString(c2.getColumnIndex("diarrheapretestq10")));
                        params.put(Global.Diarrhea.DiarrheaPreTest.pretest_result, c2.getString(c2.getColumnIndex("pretest_result")));
                        params.put(Global.Diarrhea.DiarrheaPreTest.STATUS, c2.getString(c2.getColumnIndex("STATUS")));
                    }
                }


                if (c3.getCount() > 0) {

                    if (c3.moveToFirst()) {

                        params.put("app_id3", c3.getString(c3.getColumnIndex("id")));
                        params.put(DiarrheaPostTest.fk_id, c3.getString(c3.getColumnIndex("fk_id")));
                        params.put(Global.Diarrhea.DiarrheaPostTest.cnic_no, c3.getString(c3.getColumnIndex("cnic_no")));
                        params.put(Global.Diarrhea.DiarrheaPostTest.diarrheaposttest_date, c3.getString(c3.getColumnIndex("diarrheaposttest_date")));
                        params.put(Global.Diarrhea.DiarrheaPostTest.diarrheaposttest_time, c3.getString(c3.getColumnIndex("diarrheaposttest_time")));
                        params.put(Global.Diarrhea.DiarrheaPostTest.diarrheaposttestq1, c3.getString(c3.getColumnIndex("diarrheaposttestq1")));
                        params.put(Global.Diarrhea.DiarrheaPostTest.diarrheaposttestq2, c3.getString(c3.getColumnIndex("diarrheaposttestq2")));
                        params.put(Global.Diarrhea.DiarrheaPostTest.diarrheaposttestq3, c3.getString(c3.getColumnIndex("diarrheaposttestq3")));
                        params.put(Global.Diarrhea.DiarrheaPostTest.diarrheaposttestq4, c3.getString(c3.getColumnIndex("diarrheaposttestq4")));
                        params.put(Global.Diarrhea.DiarrheaPostTest.diarrheaposttestq5, c3.getString(c3.getColumnIndex("diarrheaposttestq5")));
                        params.put(Global.Diarrhea.DiarrheaPostTest.diarrheaposttestq6, c3.getString(c3.getColumnIndex("diarrheaposttestq6")));
                        params.put(Global.Diarrhea.DiarrheaPostTest.diarrheaposttestq7, c3.getString(c3.getColumnIndex("diarrheaposttestq7")));
                        params.put(Global.Diarrhea.DiarrheaPostTest.diarrheaposttestq8, c3.getString(c3.getColumnIndex("diarrheaposttestq8")));
                        params.put(Global.Diarrhea.DiarrheaPostTest.diarrheaposttestq9, c3.getString(c3.getColumnIndex("diarrheaposttestq9")));
                        params.put(Global.Diarrhea.DiarrheaPostTest.diarrheaposttestq10, c3.getString(c3.getColumnIndex("diarrheaposttestq10")));
                        params.put(Global.Diarrhea.DiarrheaPostTest.posttest_result, c3.getString(c3.getColumnIndex("posttest_result")));
                        params.put(Global.Diarrhea.DiarrheaPostTest.STATUS, c3.getString(c3.getColumnIndex("STATUS")));
                    }
                }

                if (c4.getCount() > 0) {

                    if (c4.moveToFirst()) {

                        params.put("app_id4", c4.getString(c4.getColumnIndex("id")));
                        params.put(Session_End.fk_id, c4.getString(c4.getColumnIndex("fk_id")));
                        params.put(Global.Session_End.cnic_no, c4.getString(c4.getColumnIndex("cnic_no")));
                        params.put(Global.Session_End.training, c4.getString(c4.getColumnIndex("training")));
                        params.put(Global.Session_End.pretest_result, c4.getString(c4.getColumnIndex("pretest_result")));
                        params.put(Global.Session_End.posttest_result, c4.getString(c4.getColumnIndex("posttest_result")));
                        params.put(Global.Session_End.posttest_percent, c4.getString(c4.getColumnIndex("posttest_percent")));
                        params.put(Global.Session_End.Remarks, c4.getString(c4.getColumnIndex("Remarks")));
                        params.put(Global.Session_End.next_session_date, c4.getString(c4.getColumnIndex("next_session_date")));
                        params.put(Global.Session_End.next_session_time, c4.getString(c4.getColumnIndex("next_session_time")));
                        params.put(Global.Session_End.training_status, c4.getString(c4.getColumnIndex("training_status")));
                        params.put(Global.Session_End.Session_End_Date, c4.getString(c4.getColumnIndex("Session_End_Date")));
                        params.put(Global.Session_End.Session_End_Time, c4.getString(c4.getColumnIndex("Session_End_Time")));
                        params.put(Global.Session_End.STATUS, c4.getString(c4.getColumnIndex("STATUS")));
                    }
                }

                return params;
            }
        };

        myRequestQueue.add(sendMyRequest);
    }

    public void upload_psbi(final String cnic_no, final int id, final View itemView) {

        final String ROOT_URL = "http://10.198.97.62:80/sm/Welcome/collect_PSBI";

        final RequestQueue myRequestQueue = Volley.newRequestQueue(mContext);

        StringRequest sendMyRequest = new StringRequest(Request.Method.POST, ROOT_URL,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONObject JSONObject = new JSONObject(response);
                            Toast.makeText(mContext, JSONObject.getString("message"), Toast.LENGTH_LONG).show();

                            if (Integer.valueOf(JSONObject.getString("counter")) == 4) {

                                updateData(id + "");
                                itemView.setVisibility(View.GONE);
                            } else {
                                Toast.makeText(mContext, "Some tables couldn't get data", Toast.LENGTH_LONG).show();
                            }

                            myRequestQueue.getCache().clear();

                        } catch (JSONException e) {

                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(mContext, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }) {

            @Override
            protected Map<String, String> getParams() {

                Map<String, String> params = new HashMap<>();

                //ArrayList<String> loopResponse = new ArrayList();

                DBHelper db = new DBHelper(mContext);

                Cursor c1 = db.getData1("Session_Start", cnic_no, id);
                Cursor c2 = db.getData2("PSBIPreTest", cnic_no, id);
                Cursor c3 = db.getData2("PSBIPostTest", cnic_no, id);
                Cursor c4 = db.getData2("Session_End", cnic_no, id);

                params.put("table1", "session_start");
                params.put("table2", "psbipretest");
                params.put("table3", "psbiposttest");
                params.put("table4", "session_end");

                if (c1.getCount() > 0) {

                    if (c1.moveToFirst()) {

                        params.put("app_id1", c1.getString(c1.getColumnIndex("id")));
                        params.put(Global.Session_Start.cnic_no, c1.getString(c1.getColumnIndex("cnic_no")));
                        params.put(Global.Session_Start.Session_Start_Date, c1.getString(c1.getColumnIndex("Session_Start_Date")));
                        params.put(Global.Session_Start.Session_Start_Time, c1.getString(c1.getColumnIndex("Session_Start_Time")));
                        params.put(Global.Session_Start.province, c1.getString(c1.getColumnIndex("province")));
                        params.put(Global.Session_Start.district, c1.getString(c1.getColumnIndex("district")));
                        params.put(Global.Session_Start.tehsil, c1.getString(c1.getColumnIndex("tehsil")));
                        params.put(Global.Session_Start.Union_Council, c1.getString(c1.getColumnIndex("Union_Council")));
                        params.put(Global.Session_Start.facility_name, c1.getString(c1.getColumnIndex("facility_name")));
                        params.put(Global.Session_Start.provider_name, c1.getString(c1.getColumnIndex("provider_name")));
                        params.put(Global.Session_Start.qa_officer, c1.getString(c1.getColumnIndex("qa_officer")));
                        params.put(Global.Session_Start.contact_no, c1.getString(c1.getColumnIndex("contact_no")));
                        params.put(Global.Session_Start.S_latitude, c1.getString(c1.getColumnIndex("S_latitude")));
                        params.put(Global.Session_Start.S_longitude, c1.getString(c1.getColumnIndex("S_longitude")));
                        params.put(Global.Session_Start.STATUS, c1.getString(c1.getColumnIndex("STATUS")));
                    }
                }

                if (c2.getCount() > 0) {

                    if (c2.moveToFirst()) {

                        params.put("app_id2", c2.getString(c2.getColumnIndex("id")));
                        params.put(PSBIPretest.fk_id, c2.getString(c2.getColumnIndex("fk_id")));
                        params.put(PSBIPretest.cnic_no, c2.getString(c2.getColumnIndex("cnic_no")));
                        params.put(PSBIPretest.psbipretest_date, c2.getString(c2.getColumnIndex("psbipretest_date")));
                        params.put(PSBIPretest.psbipretest_time, c2.getString(c2.getColumnIndex("psbipretest_time")));
                        params.put(PSBIPretest.psbipretestq1, c2.getString(c2.getColumnIndex("psbipretestq1")));
                        params.put(PSBIPretest.psbipretestq2, c2.getString(c2.getColumnIndex("psbipretestq2")));
                        params.put(PSBIPretest.psbipretestq3, c2.getString(c2.getColumnIndex("psbipretestq3")));
                        params.put(PSBIPretest.psbipretestq4, c2.getString(c2.getColumnIndex("psbipretestq4")));
                        params.put(PSBIPretest.psbipretestq5, c2.getString(c2.getColumnIndex("psbipretestq5")));
                        params.put(PSBIPretest.psbipretestq6, c2.getString(c2.getColumnIndex("psbipretestq6")));
                        params.put(PSBIPretest.psbipretestq7, c2.getString(c2.getColumnIndex("psbipretestq7")));
                        params.put(PSBIPretest.pretest_result, c2.getString(c2.getColumnIndex("pretest_result")));
                        params.put(PSBIPretest.STATUS, c2.getString(c2.getColumnIndex("STATUS")));
                    }
                }


                if (c3.getCount() > 0) {

                    if (c3.moveToFirst()) {

                        params.put("app_id3", c3.getString(c3.getColumnIndex("id")));
                        params.put(PSBIPostTest.fk_id, c3.getString(c3.getColumnIndex("fk_id")));
                        params.put(PSBIPostTest.cnic_no, c3.getString(c3.getColumnIndex("cnic_no")));
                        params.put(PSBIPostTest.psbiposttest_date, c3.getString(c3.getColumnIndex("psbiposttest_date")));
                        params.put(PSBIPostTest.psbiposttest_time, c3.getString(c3.getColumnIndex("psbiposttest_time")));
                        params.put(PSBIPostTest.psbiposttestq1, c3.getString(c3.getColumnIndex("psbiposttestq1")));
                        params.put(PSBIPostTest.psbiposttestq2, c3.getString(c3.getColumnIndex("psbiposttestq2")));
                        params.put(PSBIPostTest.psbiposttestq3, c3.getString(c3.getColumnIndex("psbiposttestq3")));
                        params.put(PSBIPostTest.psbiposttestq4, c3.getString(c3.getColumnIndex("psbiposttestq4")));
                        params.put(PSBIPostTest.psbiposttestq5, c3.getString(c3.getColumnIndex("psbiposttestq5")));
                        params.put(PSBIPostTest.psbiposttestq6, c3.getString(c3.getColumnIndex("psbiposttestq6")));
                        params.put(PSBIPostTest.psbiposttestq7, c3.getString(c3.getColumnIndex("psbiposttestq7")));
                        params.put(PSBIPostTest.posttest_result, c3.getString(c3.getColumnIndex("posttest_result")));
                        params.put(PSBIPostTest.STATUS, c3.getString(c3.getColumnIndex("STATUS")));
                    }
                }

                if (c4.getCount() > 0) {

                    if (c4.moveToFirst()) {

                        params.put("app_id4", c4.getString(c4.getColumnIndex("id")));
                        params.put(Session_End.fk_id, c4.getString(c4.getColumnIndex("fk_id")));
                        params.put(Session_End.cnic_no, c4.getString(c4.getColumnIndex("cnic_no")));
                        params.put(Session_End.training, c4.getString(c4.getColumnIndex("training")));
                        params.put(Session_End.pretest_result, c4.getString(c4.getColumnIndex("pretest_result")));
                        params.put(Session_End.posttest_result, c4.getString(c4.getColumnIndex("posttest_result")));
                        params.put(Session_End.posttest_percent, c4.getString(c4.getColumnIndex("posttest_percent")));
                        params.put(Session_End.Remarks, c4.getString(c4.getColumnIndex("Remarks")));
                        params.put(Session_End.next_session_date, c4.getString(c4.getColumnIndex("next_session_date")));
                        params.put(Session_End.next_session_time, c4.getString(c4.getColumnIndex("next_session_time")));
                        params.put(Session_End.training_status, c4.getString(c4.getColumnIndex("training_status")));
                        params.put(Session_End.Session_End_Date, c4.getString(c4.getColumnIndex("Session_End_Date")));
                        params.put(Session_End.Session_End_Time, c4.getString(c4.getColumnIndex("Session_End_Time")));
                        params.put(Session_End.STATUS, c4.getString(c4.getColumnIndex("STATUS")));
                    }
                }

                return params;
            }
        };

        myRequestQueue.add(sendMyRequest);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textName, textId;

        public ViewHolder(View v) {
            super(v);
            textName = v.findViewById(R.id.text_item_survey_pending_name);
            textId = v.findViewById(R.id.text_item_survey_pending_id);
        }
    }

}