package com.example.abdulsajid.mnchtraining;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import data.LocalDataManager;


public class SurveyPendingActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pending_interviews);

        List<String> list = new LocalDataManager(this).getLogListPending("0");


        if (list == null)
            return;

        Collections.sort(list);

        mRecyclerView = findViewById(R.id.list_survey_completed);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        mAdapter = new SurveyPendingCustomAdapter(this, list);
        mRecyclerView.setAdapter(mAdapter);
    }
}


class SurveyPendingCustomAdapter extends RecyclerView.Adapter {

    Context mContext;
    List<String> mList;

    public SurveyPendingCustomAdapter(Context context, List<String> list) {
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
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

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
                b.setTitle("Restart Interview");
                b.setMessage("Do you want to restart this interview");
                b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        String memberId = vh.textName.getText().toString();


                        String[] arrr = memberId.split("/");

                        String study_id = arrr[0];
                        int curentSection = Integer.valueOf(arrr[1]);
                        int interviewType = Integer.valueOf(arrr[2]);

                        //here call activity
                        Intent intent = null;
                        if (interviewType == 2) {

                            if (curentSection == 2) {

                                intent = new Intent(mContext, Gps.class);
                                intent.putExtra("study_id", study_id);
                                mContext.startActivity(intent);
                            }
                            if (curentSection == 3) {

                                intent = new Intent(mContext, Gps.class);
                                intent.putExtra("study_id", study_id);
                                mContext.startActivity(intent);
                            }
                            if (curentSection == 4) {

                                intent = new Intent(mContext, Gps.class);
                                intent.putExtra("study_id", study_id);
                                mContext.startActivity(intent);
                            }
                            if (curentSection == 5) {

                                intent = new Intent(mContext, Gps.class);
                                intent.putExtra("study_id", study_id);
                                mContext.startActivity(intent);
                            }
                            if (curentSection == 6) {

                                intent = new Intent(mContext, Gps.class);
                                intent.putExtra("study_id", study_id);
                                mContext.startActivity(intent);
                            }
                            if (curentSection == 7) {

                                intent = new Intent(mContext, Gps.class);
                                intent.putExtra("study_id", study_id);
                                mContext.startActivity(intent);
                            }
                            if (curentSection == 8) {

                                intent = new Intent(mContext, Gps.class);
                                intent.putExtra("study_id", study_id);
                                mContext.startActivity(intent);
                            }
                            if (curentSection == 9) {

                                intent = new Intent(mContext, Gps.class);
                                intent.putExtra("study_id", study_id);
                                mContext.startActivity(intent);
                            }
                            if (curentSection == 10) {

                                intent = new Intent(mContext, Gps.class);
                                intent.putExtra("study_id", study_id);
                                mContext.startActivity(intent);
                            }
                            if (curentSection == 11) {

                                intent = new Intent(mContext, Gps.class);
                                intent.putExtra("study_id", study_id);
                                mContext.startActivity(intent);
                            }

                            if (curentSection == 12) {

                                intent = new Intent(mContext, Gps.class);
                                intent.putExtra("study_id", study_id);
                                mContext.startActivity(intent);
                            }

                            if (curentSection == 13) {

                                intent = new Intent(mContext, Gps.class);
                                intent.putExtra("study_id", study_id);
                                mContext.startActivity(intent);
                            }
                        }

                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        // Intent intent = null;

                        //    intent = new Intent(this, SurveyPendingActivity.class);
                    }
                }).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return mList.size();
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