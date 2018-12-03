package data;

import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import Global.CDB.CDBPostTest;
import Global.CDB.CDBPreTest;
import Global.Diarrhea.DiarrheaPostTest;
import Global.Diarrhea.DiarrheaPreTest;
import Global.GDS.GDSPostTest;
import Global.GDS.GDSPreTest;
import Global.PSBI.PSBIPostTest;
import Global.PSBI.PSBIPretest;
import Global.Session_End;
import Global.Session_Start;
import utils.MyPreferences;
import utils.PostRequestData;

//import com.example.abdulsajid.mnchtraining.utils.PostRequestData;

public class UploadHouseInfoAsync extends AsyncTask {

    public static ProgressDialog dialog;
    Context mContext;
    HashMap<String, String> param;
    String[] interviewLogData;
    String mUserMsg;

    // wait for Toast then kill app
    Thread thread = new Thread() {
        @Override
        public void run() {
            try {
                Thread.sleep(800); // As I am using LENGTH_LONG in Toast
                // Your_Activity.this.finish();


                int pid = android.os.Process.myPid();
                android.os.Process.killProcess(pid);
                // getActivity().finish();


                System.exit(0);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    public UploadHouseInfoAsync(Context context) {

        //stop interview
        // if(InterviewUploadingStatus.status<2)
        //   this.cancel(false);

        mContext = context;
        dialog = new ProgressDialog(context);
        param = new HashMap<>();
    }

    @Override
    protected void onPreExecute() {

        dialog.setMessage("Uploading house info..");
        dialog.setCancelable(false);
        dialog.show();

        //HashMap<String, List<String>> map = QuestionModel.quest.get("a");

        //region Query

        String query1 = "select * from Session_Start where id = '%s' order by id  desc LIMIT 1";
        String query2 = "select * from GDSPreTest where id = '%s' order by id  desc LIMIT 1";
        String query3 = "select * from GDSPostTest where id = '%s' order by id  desc LIMIT 1";
        String query4 = "select * from CDBPreTest where id = '%s' order by id  desc LIMIT 1";
        String query5 = "select * from CDBPostTest where id = '%s' order by id  desc LIMIT 1";
        String query6 = "select * from DiarrheaPreTest where id = '%s' order by id  desc LIMIT 1";
        String query7 = "select * from DiarrheaPostTest where id = '%s' order by id  desc LIMIT 1";
        String query8 = "select * from PSBIPreTest where id = '%s' order by id  desc LIMIT 1";
        String query9 = "select * from PSBIPostTest where id = '%s' order by id  desc LIMIT 1";
        String query10 = "select * from Session_End where id = '%s' order by id  desc LIMIT 1";

        query1 = String.format(query1, 1);
        query2 = String.format(query2, 1);
        query3 = String.format(query3, 1);
        query4 = String.format(query4, 1);
        query5 = String.format(query5, 1);
        query6 = String.format(query6, 1);
        query7 = String.format(query7, 1);
        query8 = String.format(query8, 1);
        query9 = String.format(query9, 1);
        query10 = String.format(query10, 1);

        LocalDataManager Lm = new LocalDataManager(mContext);

        Cursor c1 = LocalDataManager.database.rawQuery(query1, null);
        Cursor c2 = LocalDataManager.database.rawQuery(query2, null);
        Cursor c3 = LocalDataManager.database.rawQuery(query3, null);
        Cursor c4 = LocalDataManager.database.rawQuery(query4, null);
        Cursor c5 = LocalDataManager.database.rawQuery(query5, null);
        Cursor c6 = LocalDataManager.database.rawQuery(query6, null);
        Cursor c7 = LocalDataManager.database.rawQuery(query7, null);
        Cursor c8 = LocalDataManager.database.rawQuery(query8, null);
        Cursor c9 = LocalDataManager.database.rawQuery(query9, null);
        Cursor c10 = LocalDataManager.database.rawQuery(query10, null);


        if (c1 != null) {
            if (c1.moveToFirst()) {
                param.put(Global.Session_Start.cnic_no, c1.getString(c1.getColumnIndex("cnic_no")));
                param.put(Session_Start.Session_Start_Date, c1.getString(c1.getColumnIndex("Session_Start_Date")));
                param.put(Session_Start.Session_Start_Time, c1.getString(c1.getColumnIndex("Session_Start_Time")));
                param.put(Global.Session_Start.province, c1.getString(c1.getColumnIndex("province")));
                param.put(Global.Session_Start.district, c1.getString(c1.getColumnIndex("district")));
                param.put(Global.Session_Start.tehsil, c1.getString(c1.getColumnIndex("tehsil")));
                param.put(Global.Session_Start.Union_Council, c1.getString(c1.getColumnIndex("Union_Council")));
                param.put(Global.Session_Start.facility_name, c1.getString(c1.getColumnIndex("facility_name")));
                param.put(Global.Session_Start.provider_name, c1.getString(c1.getColumnIndex("provider_name")));
                param.put(Global.Session_Start.qa_officer, c1.getString(c1.getColumnIndex("qa_officer")));
                param.put(Global.Session_Start.contact_no, c1.getString(c1.getColumnIndex("contact_no")));
                param.put(Global.Session_Start.S_latitude, c1.getString(c1.getColumnIndex("S_latitude")));
                param.put(Global.Session_Start.S_longitude, c1.getString(c1.getColumnIndex("S_longitude")));
                param.put(Global.Session_Start.STATUS, c1.getString(c1.getColumnIndex("STATUS")));
            }
        }


        if (c2 != null) {
            if (c2.moveToFirst()) {
                param.put(GDSPreTest.cnic_no, c2.getString(c2.getColumnIndex("cnic_no")));
                param.put(GDSPreTest.gdspretest_date, c2.getString(c2.getColumnIndex("gdspretest_date")));
                param.put(GDSPreTest.gdspretest_time, c2.getString(c2.getColumnIndex("gdspretest_time")));
                param.put(GDSPreTest.gdspretestq1, c2.getString(c2.getColumnIndex("gdspretestq1")));
                param.put(GDSPreTest.gdspretestq2, c2.getString(c2.getColumnIndex("gdspretestq2")));
                param.put(GDSPreTest.gdspretestq3, c2.getString(c2.getColumnIndex("gdspretestq3")));
                param.put(GDSPreTest.gdspretestq4, c2.getString(c2.getColumnIndex("gdspretestq4")));
                param.put(GDSPreTest.gdspretestq5, c2.getString(c2.getColumnIndex("gdspretestq5")));
                param.put(GDSPreTest.gdspretestq6, c2.getString(c2.getColumnIndex("gdspretestq6")));
                param.put(GDSPreTest.gdspretestq7, c2.getString(c2.getColumnIndex("gdspretestq7")));
                param.put(GDSPreTest.gdspretestq8, c2.getString(c2.getColumnIndex("gdspretestq8")));
                param.put(GDSPreTest.gdspretestq9, c2.getString(c2.getColumnIndex("gdspretestq9")));
                param.put(GDSPreTest.gdspretestq10, c2.getString(c2.getColumnIndex("gdspretestq10")));
                param.put(GDSPreTest.pretest_result, c2.getString(c2.getColumnIndex("pretest_result")));
                param.put(GDSPreTest.STATUS, c2.getString(c2.getColumnIndex("STATUS")));
            }
        }


        if (c3 != null) {
            if (c3.moveToFirst()) {
                param.put(GDSPostTest.cnic_no, c3.getString(c3.getColumnIndex("cnic_no")));
                param.put(GDSPostTest.gdsposttest_date, c3.getString(c3.getColumnIndex("gdsposttest_date")));
                param.put(GDSPostTest.gdsposttest_time, c3.getString(c3.getColumnIndex("gdsposttest_time")));
                param.put(GDSPostTest.gdsposttestq1, c3.getString(c3.getColumnIndex("gdsposttestq1")));
                param.put(GDSPostTest.gdsposttestq2, c3.getString(c3.getColumnIndex("gdsposttestq2")));
                param.put(GDSPostTest.gdsposttestq3, c3.getString(c3.getColumnIndex("gdsposttestq3")));
                param.put(GDSPostTest.gdsposttestq4, c3.getString(c3.getColumnIndex("gdsposttestq4")));
                param.put(GDSPostTest.gdsposttestq5, c3.getString(c3.getColumnIndex("gdsposttestq5")));
                param.put(GDSPostTest.gdsposttestq6, c3.getString(c3.getColumnIndex("gdsposttestq6")));
                param.put(GDSPostTest.gdsposttestq7, c3.getString(c3.getColumnIndex("gdsposttestq7")));
                param.put(GDSPostTest.gdsposttestq8, c3.getString(c3.getColumnIndex("gdsposttestq8")));
                param.put(GDSPostTest.gdsposttestq9, c3.getString(c3.getColumnIndex("gdsposttestq9")));
                param.put(GDSPostTest.gdsposttestq10, c3.getString(c3.getColumnIndex("gdsposttestq10")));
                param.put(GDSPostTest.posttest_result, c3.getString(c3.getColumnIndex("posttest_result")));
                param.put(GDSPostTest.STATUS, c3.getString(c3.getColumnIndex("STATUS")));
            }
        }

        if (c4 != null) {
            if (c4.moveToFirst()) {
                param.put(CDBPreTest.cnic_no, c4.getString(c4.getColumnIndex("cnic_no")));
                param.put(CDBPreTest.cdbpretest_date, c4.getString(c4.getColumnIndex("cdbpretest_date")));
                param.put(CDBPreTest.cdbpretest_time, c4.getString(c4.getColumnIndex("cdbpretest_time")));
                param.put(CDBPreTest.cdbpretestq1, c4.getString(c4.getColumnIndex("cdbpretestq1")));
                param.put(CDBPreTest.cdbpretestq2, c4.getString(c4.getColumnIndex("cdbpretestq2")));
                param.put(CDBPreTest.cdbpretestq3, c4.getString(c4.getColumnIndex("cdbpretestq3")));
                param.put(CDBPreTest.cdbpretestq4, c4.getString(c4.getColumnIndex("cdbpretestq4")));
                param.put(CDBPreTest.cdbpretestq5, c4.getString(c4.getColumnIndex("cdbpretestq5")));
                param.put(CDBPreTest.cdbpretestq6, c4.getString(c4.getColumnIndex("cdbpretestq6")));
                param.put(CDBPreTest.cdbpretestq7, c4.getString(c4.getColumnIndex("cdbpretestq7")));
                param.put(CDBPreTest.cdbpretestq8, c4.getString(c4.getColumnIndex("cdbpretestq8")));
                param.put(CDBPreTest.cdbpretestq9, c4.getString(c4.getColumnIndex("cdbpretestq9")));
                param.put(CDBPreTest.cdbpretestq10, c4.getString(c4.getColumnIndex("cdbpretestq10")));
                param.put(CDBPreTest.pretest_result, c4.getString(c4.getColumnIndex("pretest_result")));
                param.put(CDBPreTest.STATUS, c4.getString(c4.getColumnIndex("STATUS")));
            }

        }

        if (c5 != null) {
            if (c5.moveToFirst()) {
                param.put(CDBPostTest.cnic_no, c5.getString(c5.getColumnIndex("cnic_no")));
                param.put(CDBPostTest.cdbposttest_date, c5.getString(c5.getColumnIndex("cdbposttest_date")));
                param.put(CDBPostTest.cdbposttest_time, c5.getString(c5.getColumnIndex("cdbposttest_time")));
                param.put(CDBPostTest.cdbposttestq1, c5.getString(c5.getColumnIndex("cdbposttestq1")));
                param.put(CDBPostTest.cdbposttestq2, c5.getString(c5.getColumnIndex("cdbposttestq2")));
                param.put(CDBPostTest.cdbposttestq3, c5.getString(c5.getColumnIndex("cdbposttestq3")));
                param.put(CDBPostTest.cdbposttestq4, c5.getString(c5.getColumnIndex("cdbposttestq4")));
                param.put(CDBPostTest.cdbposttestq5, c5.getString(c5.getColumnIndex("cdbposttestq5")));
                param.put(CDBPostTest.cdbposttestq6, c5.getString(c5.getColumnIndex("cdbposttestq6")));
                param.put(CDBPostTest.cdbposttestq7, c5.getString(c5.getColumnIndex("cdbposttestq7")));
                param.put(CDBPostTest.cdbposttestq8, c5.getString(c5.getColumnIndex("cdbposttestq8")));
                param.put(CDBPostTest.cdbposttestq9, c5.getString(c5.getColumnIndex("cdbposttestq9")));
                param.put(CDBPostTest.cdbposttestq10, c5.getString(c5.getColumnIndex("cdbposttestq10")));
                param.put(CDBPostTest.posttest_result, c5.getString(c5.getColumnIndex("posttest_result")));
                param.put(CDBPostTest.STATUS, c5.getString(c5.getColumnIndex("STATUS")));
            }

        }

        if (c6 != null) {
            if (c6.moveToFirst()) {
                param.put(DiarrheaPreTest.cnic_no, c6.getString(c6.getColumnIndex("cnic_no")));
                param.put(DiarrheaPreTest.diarrheapretest_date, c6.getString(c6.getColumnIndex("diarrheapretest_date")));
                param.put(DiarrheaPreTest.diarrheapretest_time, c6.getString(c6.getColumnIndex("diarrheapretest_time")));
                param.put(DiarrheaPreTest.diarrheapretestq1, c6.getString(c6.getColumnIndex("diarrheapretestq1")));
                param.put(DiarrheaPreTest.diarrheapretestq2, c6.getString(c6.getColumnIndex("diarrheapretestq2")));
                param.put(DiarrheaPreTest.diarrheapretestq3, c6.getString(c6.getColumnIndex("diarrheapretestq3")));
                param.put(DiarrheaPreTest.diarrheapretestq4, c6.getString(c6.getColumnIndex("diarrheapretestq4")));
                param.put(DiarrheaPreTest.diarrheapretestq5, c6.getString(c6.getColumnIndex("diarrheapretestq5")));
                param.put(DiarrheaPreTest.diarrheapretestq6, c6.getString(c6.getColumnIndex("diarrheapretestq6")));
                param.put(DiarrheaPreTest.diarrheapretestq7, c6.getString(c6.getColumnIndex("diarrheapretestq7")));
                param.put(DiarrheaPreTest.diarrheapretestq8, c6.getString(c6.getColumnIndex("diarrheapretestq8")));
                param.put(DiarrheaPreTest.diarrheapretestq9, c6.getString(c6.getColumnIndex("diarrheapretestq9")));
                param.put(DiarrheaPreTest.diarrheapretestq10, c6.getString(c6.getColumnIndex("diarrheapretestq10")));
                param.put(DiarrheaPreTest.pretest_result, c6.getString(c6.getColumnIndex("pretest_result")));
                param.put(DiarrheaPreTest.STATUS, c6.getString(c6.getColumnIndex("STATUS")));
            }

        }

        if (c7 != null) {
            if (c7.moveToFirst()) {
                param.put(DiarrheaPostTest.cnic_no, c7.getString(c7.getColumnIndex("cnic_no")));
                param.put(DiarrheaPostTest.diarrheaposttest_date, c7.getString(c7.getColumnIndex("diarrheaposttest_date")));
                param.put(DiarrheaPostTest.diarrheaposttest_time, c7.getString(c7.getColumnIndex("diarrheaposttest_time")));
                param.put(DiarrheaPostTest.diarrheaposttestq1, c7.getString(c7.getColumnIndex("diarrheaposttestq1")));
                param.put(DiarrheaPostTest.diarrheaposttestq2, c7.getString(c7.getColumnIndex("diarrheaposttestq2")));
                param.put(DiarrheaPostTest.diarrheaposttestq3, c7.getString(c7.getColumnIndex("diarrheaposttestq3")));
                param.put(DiarrheaPostTest.diarrheaposttestq4, c7.getString(c7.getColumnIndex("diarrheaposttestq4")));
                param.put(DiarrheaPostTest.diarrheaposttestq5, c7.getString(c7.getColumnIndex("diarrheaposttestq5")));
                param.put(DiarrheaPostTest.diarrheaposttestq6, c7.getString(c7.getColumnIndex("diarrheaposttestq6")));
                param.put(DiarrheaPostTest.diarrheaposttestq7, c7.getString(c7.getColumnIndex("diarrheaposttestq7")));
                param.put(DiarrheaPostTest.diarrheaposttestq8, c7.getString(c7.getColumnIndex("diarrheaposttestq8")));
                param.put(DiarrheaPostTest.diarrheaposttestq9, c7.getString(c7.getColumnIndex("diarrheaposttestq9")));
                param.put(DiarrheaPostTest.diarrheaposttestq10, c7.getString(c7.getColumnIndex("diarrheaposttestq10")));
                param.put(DiarrheaPostTest.posttest_result, c7.getString(c7.getColumnIndex("posttest_result")));
                param.put(DiarrheaPostTest.STATUS, c7.getString(c7.getColumnIndex("STATUS")));
            }

        }


        if (c8 != null) {
            if (c8.moveToFirst()) {
                param.put(PSBIPretest.cnic_no, c8.getString(c8.getColumnIndex("cnic_no")));
                param.put(PSBIPretest.psbipretest_date, c8.getString(c8.getColumnIndex("psbipretest_date")));
                param.put(PSBIPretest.psbipretest_time, c8.getString(c8.getColumnIndex("psbipretest_time")));
                param.put(PSBIPretest.psbipretestq1, c8.getString(c8.getColumnIndex("psbipretestq1")));
                param.put(PSBIPretest.psbipretestq2, c8.getString(c8.getColumnIndex("psbipretestq2")));
                param.put(PSBIPretest.psbipretestq3, c8.getString(c8.getColumnIndex("psbipretestq3")));
                param.put(PSBIPretest.psbipretestq4, c8.getString(c8.getColumnIndex("psbipretestq4")));
                param.put(PSBIPretest.psbipretestq5, c8.getString(c8.getColumnIndex("psbipretestq5")));
                param.put(PSBIPretest.psbipretestq6, c8.getString(c8.getColumnIndex("psbipretestq6")));
                param.put(PSBIPretest.psbipretestq7, c8.getString(c8.getColumnIndex("psbipretestq7")));
                param.put(PSBIPretest.pretest_result, c8.getString(c8.getColumnIndex("pretest_result")));
                param.put(PSBIPretest.STATUS, c8.getString(c8.getColumnIndex("STATUS")));
            }

        }


        if (c9 != null) {
            if (c9.moveToFirst()) {
                param.put(PSBIPostTest.cnic_no, c9.getString(c9.getColumnIndex("cnic_no")));
                param.put(PSBIPostTest.psbiposttest_date, c9.getString(c9.getColumnIndex("psbiposttest_date")));
                param.put(PSBIPostTest.psbiposttest_time, c9.getString(c9.getColumnIndex("psbiposttest_time")));
                param.put(PSBIPostTest.psbiposttestq1, c9.getString(c9.getColumnIndex("diarrheaposttestq1")));
                param.put(PSBIPostTest.psbiposttestq2, c9.getString(c9.getColumnIndex("diarrheaposttestq2")));
                param.put(PSBIPostTest.psbiposttestq3, c9.getString(c9.getColumnIndex("diarrheaposttestq3")));
                param.put(PSBIPostTest.psbiposttestq4, c9.getString(c9.getColumnIndex("diarrheaposttestq4")));
                param.put(PSBIPostTest.psbiposttestq5, c9.getString(c9.getColumnIndex("diarrheaposttestq5")));
                param.put(PSBIPostTest.psbiposttestq6, c9.getString(c9.getColumnIndex("diarrheaposttestq6")));
                param.put(PSBIPostTest.psbiposttestq7, c9.getString(c9.getColumnIndex("diarrheaposttestq7")));
                param.put(PSBIPostTest.posttest_result, c9.getString(c9.getColumnIndex("posttest_result")));
                param.put(PSBIPostTest.STATUS, c9.getString(c9.getColumnIndex("STATUS")));
            }

        }


        if (c10 != null) {
            if (c10.moveToFirst()) {
                param.put(Session_End.cnic_no, c10.getString(c10.getColumnIndex("cnic_no")));
                param.put(Session_End.training, c10.getString(c10.getColumnIndex("training")));
                param.put(Session_End.pretest_result, c10.getString(c10.getColumnIndex("pretest_result")));
                param.put(Session_End.posttest_result, c10.getString(c10.getColumnIndex("posttest_result")));
                param.put(Session_End.Remarks, c10.getString(c10.getColumnIndex("Remarks")));
                param.put(Session_End.next_session_date, c10.getString(c10.getColumnIndex("next_session_date")));
                param.put(Session_End.next_session_time, c10.getString(c10.getColumnIndex("next_session_time")));
                param.put(Session_End.training_status, c10.getString(c10.getColumnIndex("training_status")));
                param.put(Session_End.Session_End_Date, c10.getString(c10.getColumnIndex("Session_End_Date")));
                param.put(Session_End.Session_End_Time, c10.getString(c10.getColumnIndex("Session_End_Time")));
                param.put(Session_End.STATUS, c10.getString(c10.getColumnIndex("STATUS")));
            }
        }
        //endregion

        super.onPreExecute();
    }

    @Override
    protected Object doInBackground(Object[] objects) {

        String urlString = new MyPreferences(mContext).getReq1();
        // "http://umeed.bsoftproducts.com//Testing/insert_info";
        URL url;
        HttpURLConnection connection;

        try {
            url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setConnectTimeout(1000);

            OutputStream os = connection.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

            bw.write(PostRequestData.getData(param));
            bw.flush();

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String st = "", line;
                while ((line = br.readLine()) != null) {
                    st = st + line;
                }
                return st;
            } else {
                mUserMsg = "Server Couldn't process the request";
            }
        } catch (MalformedURLException e) {
            Toast.makeText(mContext, e.toString(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (IOException e) {
            mUserMsg = "Please make sure that Internet connection is available," +
                    " and server IP is inserted in settings";
            e.printStackTrace();
        } catch (Exception e) {

            e.printStackTrace();

        }
        return null;
    }


    void update_status(String id) {
        String query = "Update Session_Start set STATUS = '1' where id='" + id + "'";

        query = String.format(query);

        LocalDataManager Lm = new LocalDataManager(mContext);

        LocalDataManager.database.execSQL(query);

        Toast.makeText(mContext, "Status updated", Toast.LENGTH_SHORT).show();
    }


    protected void onPostExecute(Object o) {

        try {
            dialog.dismiss();

            if (mUserMsg != null)
                throw new IOException();


            //int houseId = Integer.parseInt(((String) o).replace("\"",""));

            String result = (((String) o).replace("\"", ""));


            Toast.makeText(mContext, "Interivew Has been Uploaded", Toast.LENGTH_SHORT).show();
            // new LocalDataManager(mContext).uploadInterview();

            // LogtableUpdates.UpdateLogStatusUpload(mContext,Validation.hfauploadid);

            //  update_status(param.get("id"));
            thread.start();
        } catch (IOException e) {
            //if connection was available via connecting but
            //we can't get data from server..
            if (mUserMsg == null)
                mUserMsg = "Please check connection";
            dialog.dismiss();
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
            mUserMsg = e.getMessage();
            dialog.dismiss();
        } catch (Exception e) {
            Toast.makeText(mContext, "Uploading failed at request 1", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
            return;
        } finally {
            if (mUserMsg != null)
                Toast.makeText(mContext, mUserMsg, Toast.LENGTH_SHORT).show();
        }


        super.onPostExecute(o);
    }
}