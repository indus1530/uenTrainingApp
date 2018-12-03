package com.example.abdulsajid.mnchtraining;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class videact extends AppCompatActivity implements View.OnClickListener {

    Button btn_video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_videoview);


        String fileName = "breastfeeding";
        String filePlace = "android.resource://" + getPackageName() + "/raw/" + fileName;
        VideoView vv = findViewById(R.id.videoview1);
        vv.setVideoURI(Uri.parse(filePlace));
        vv.requestFocus();

        MediaController mediaController = new MediaController(this);
        vv.setMediaController(mediaController);

        mediaController.setAnchorView(vv);

        vv.start();

    }


    @Override
    public void onClick(View view) {


    }
}