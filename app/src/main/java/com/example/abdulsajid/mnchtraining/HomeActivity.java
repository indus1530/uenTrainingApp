package com.example.abdulsajid.mnchtraining;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abdulsajid.mnchtraining.Upload.SurveyCompletedActivity;

import utils.MyPreferences;

/*import com.irfansyed.VAS.VASMonitring.GS.Q1101_Q1610;
import com.irfansyed.VAS.VASMonitring.Pending.SurveyPendingActivity;
import com.irfansyed.VAS.VASMonitring.R;*/

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView Profile_name;
    private Boolean exit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.abdulsajid.mnchtraining.R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final MyPreferences preferences = new MyPreferences(this);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, com.example.abdulsajid.mnchtraining.R.string.navigation_drawer_open, com.example.abdulsajid.mnchtraining.R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);

        //DBHelper dbHelper = new DBHelper(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
//            super.onBackPressed();
            if (exit) {
                finish(); // finish activity

                Intent ii = new Intent(this, LoginActivity.class);
                ii.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(ii);
                finish();

            } else {
                Toast.makeText(this, "Press Back again to Exit.",
                        Toast.LENGTH_SHORT).show();
                exit = true;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        exit = false;
                    }
                }, 3 * 1000);

            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(com.example.abdulsajid.mnchtraining.R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();
        Intent intent = null;

        int put_extr = 0;
        final MyPreferences preferences = new MyPreferences(HomeActivity.this);

        if (id == R.id.upload_data) {
            intent = new Intent(this, SurveyCompletedActivity.class);

            intent.putExtra("put_extra", put_extr);
            if (intent != null)
                startActivity(intent);
        }
        if (id == R.id.start_session) {

            intent = new Intent(this, Gps.class);

            intent.putExtra("put_extra", put_extr);
            if (intent != null)
                startActivity(intent);
            // intent = new Intent(this, com.irfansyed.VAS.VASMonitring.RP.w204_w222.class);
            put_extr = 1;
        }/*

        if (id == R.id.stage_2) {
            intent = new Intent(this, N2001_N2011.class);
            put_extr = 1;
        }

        if (id == R.id.stage_3) {
            intent = new Intent(this, Genifno.class);
            put_extr = 1;

        }

        if (id == R.id.stage_4) {
            intent = new Intent(this, A4251_A4284.class);
            put_extr = 1;

        } else*/

        /*if (id == com.example.abdulsajid.mnchtraining.R.id.nav_lang_e) {
            preferences.setlanguage("en", "US");
            Toast.makeText(this, "Application Language Changed to English", Toast.LENGTH_LONG).show();

        } else if (id == com.example.abdulsajid.mnchtraining.R.id.nav_lang_u) {
            preferences.setlanguage("ur","PK");
            Toast.makeText(this, "Application Language Changed to Urdu", Toast.LENGTH_LONG).show();
        }

        if (id == R.id.pending_interviews) {

            intent = new Intent(this, SurveyPendingActivity.class);
            startActivity(intent);
        }*/
        //Commented BY SAJID


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}