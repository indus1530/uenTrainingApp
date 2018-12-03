package data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class LocalDataManager {
    public static SQLiteDatabase database;
    Context mContext;

    public LocalDataManager(Context context) {

        this.mContext = context;
        database = new DBHelper(context).getWritableDatabase();
    }


    public List<String> getLogList(String status) {

        ArrayList<String> list = new ArrayList<>();

        try {

            String query = "select cnic_no, training, id from Session_End where STATUS = '%s' order by id ASC";
            query = String.format(query, status);

            database.beginTransaction();
            Cursor c = database.rawQuery(query, null);
            if (c != null) {
                if (c.moveToFirst()) {
                    do {
                        list.add(c.getString(0) + "/" + c.getString(1) + "/" + c.getString(2));
                    }

                    while (c.moveToNext());
                }
            }
        } finally {
            database.setTransactionSuccessful();
            database.endTransaction();
            database.close();
        }

        return list;
    }


    public List<String> getLogListPending(String status) {

        ArrayList<String> list = new ArrayList<>();

        try {

            String query = "select cnic_no, currentSection, interviewType from Session_Start where currentSection != 111 order by id ASC";
            query = String.format(query, status);

            database.beginTransaction();
            Cursor c = database.rawQuery(query, null);
            if (c != null) {
                if (c.moveToFirst()) {
                    do {

                        list.add(c.getString(0) + "/" + c.getString(1) + "/" + c.getString(2));
                    } while (c.moveToNext());
                }
            }
        } finally {
            database.setTransactionSuccessful();
            database.endTransaction();
            database.close();
        }
        return list;
    }
}
