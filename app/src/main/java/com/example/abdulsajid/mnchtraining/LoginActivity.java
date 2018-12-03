package com.example.abdulsajid.mnchtraining;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abdulsajid.mnchtraining.GDS.GdsTraining;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import utils.MyPreferences;
import utils.PostRequestData;

//import com.example.abdulsajid.mnchtraining.utils.PostRequestData;


public class LoginActivity extends AppCompatActivity implements View.OnTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText textUsername = findViewById(R.id.login_username);
        final EditText textPassword = findViewById(R.id.login_password);
        final TextView textlogout = findViewById(R.id.txt_logut);
        Button btnLogin = findViewById(R.id.login_btn);
        final MyPreferences preferences = new MyPreferences(this);


        textlogout.setOnTouchListener(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (textUsername.getText().toString().trim().isEmpty()
                        || textPassword.getText().toString().trim().isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                    return;
                }
               /* else if(preferences.getUserId()==-1) {


                    new LoginAsync(LoginActivity.this, textUsername.getText().toString().trim(),
                            textPassword.getText().toString().trim()).execute();
                }*/
                else {
                    //    if(textUsername.getText().toString().trim().equals(preferences.getUsername())) {

                    //    if(textPassword.getText().toString().trim().equals(preferences.getPassword())) {


                    if (textUsername.getText().toString().trim().equals("abc")) {

                        if (textPassword.getText().toString().trim().equals("abc")) {

                            // call andother activity


                            // Intent intent = new Intent(LoginActivity.this, FirstCard.class);

                            Intent intent = new Intent(LoginActivity.this, GdsTraining.class);
//                             intent.putExtra("qa_officer", textUsername.getText().toString().trim());
                            LoginActivity.this.startActivity(intent);
                            LoginActivity.this.finish();

                        } else {
                            textPassword.setError("Incorrect Password");
                        }

                    } else {
                        textUsername.setError("Incorrect user name");
                    }
                }

            }
        });

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        MyPreferences MyPreferences;


        new MyPreferences(LoginActivity.this).removeUserId();
        Toast.makeText(this, "Logout Successfully", Toast.LENGTH_LONG).show();
        return false;
    }
}

class LoginAsync extends AsyncTask {
    Context mContext;
    ProgressDialog mDialog;
    String mUserMsg, mUsername, mPassword;

    public LoginAsync(Context context, String username, String password) {
        this.mContext = context;
        this.mUsername = username;
        this.mPassword = password;
        mDialog = new ProgressDialog(context);
    }

    @Override
    protected void onPreExecute() {
        mDialog.setMessage("Logging in..");
        mDialog.setCancelable(false);
        mDialog.show();

        super.onPreExecute();
    }

    @Override
    protected Object doInBackground(Object[] params) {
        URL url;
        HttpURLConnection connection;
        String urlString = new MyPreferences(mContext).getReqLogin();

        //"http://umeed.bsoftproducts.com//Testing/check_user_id";

        try {
            url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");

            OutputStream os = connection.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

            // set pa
            // rameter values for post-request
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("username", mUsername);
            param.put("password", mPassword);

            bw.write(PostRequestData.getData(param));
            bw.flush();

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String data = "", line;
                while ((line = br.readLine()) != null) {
                    data += line;
                }

                return data;
            } else {
                mUserMsg = "Server Couldn't process the request";
            }
        } catch (IOException e) {
            mUserMsg = "Please make sure that Internet connection is available," +
                    " and server IP is inserted in settings";
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        try {

            //connection isn't available or something is wrong with server address
            if (mUserMsg != null)
                throw new IOException();

            String resp = (String) o;

            if (resp == null || resp.equals(""))
                throw new NullPointerException("Server response is empty");
            else if (resp.equals("-1")) {
                mUserMsg = "Incorrect username or password";
            } else {
                mUserMsg = null;
                MyPreferences prefs = new MyPreferences(mContext);

                // for login id and data collectore Name irfan

                //   Toast.makeText(mContext, resp, Toast.LENGTH_SHORT).show();
                String[] resp_arry = resp.split(",");
                String userid = resp_arry[0];

                String name = resp_arry[1];
                String District = resp_arry[2];

                prefs.setUserId(Integer.parseInt(userid));

                prefs.setUsername(mUsername);
                prefs.setPassword(mPassword);
                prefs.setName(name);
                prefs.setDistrict(District);

                // redirect to another activity from here..
                Intent intent = new Intent(mContext, HomeActivity.class);
//                intent.putExtra("qa_officer", String.valueOf(mUsername));
                mContext.startActivity(intent);
                ((Activity) mContext).finish();
            }

        } catch (IOException e) {
            //if connection was available via connecting but
            //we can't get data from server..
            if (mUserMsg == null)
                mUserMsg = "Please check connection";
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
            mUserMsg = e.getMessage();
        } finally {
            if (mUserMsg != null)
                Toast.makeText(mContext, mUserMsg, Toast.LENGTH_SHORT).show();
        }
        // hide the progressDialog
        mDialog.hide();

        super.onPostExecute(o);
    }
}
// end of Async - Login Class

