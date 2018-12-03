package com.example.abdulsajid.mnchtraining;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class videoview_cdb extends AppCompatActivity {

    Button btn_video1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoview_cdb);


        String fileName = "breastfeeding";
        String filePlace = "android.resource://" + getPackageName() + "/raw/" + fileName;
        VideoView vv = findViewById(R.id.videoview1);
        vv.setVideoURI(Uri.parse(filePlace));
        vv.requestFocus();
        MediaController mediaController = new MediaController(this);
        vv.setMediaController(mediaController);

        mediaController.setAnchorView(vv);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        android.widget.LinearLayout.LayoutParams params = (android.widget.LinearLayout.LayoutParams) vv.getLayoutParams();
        params.width = metrics.widthPixels;
        params.height = metrics.heightPixels;
        params.leftMargin = 0;


        vv.setLayoutParams(params);
        vv.start();

    }
}
