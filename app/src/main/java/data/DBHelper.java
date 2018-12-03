package data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "mnchtraining.db";
    private static final int VERSION = 1;

    Context mContext;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.beginTransaction();

        db.execSQL(data.Session_Start.getCreateQuery());   // GPS Table created here
        db.execSQL(data.GDS.GDSPreTest.getCreateQuery());   // GDSPreTest created here
        db.execSQL(data.GDS.GDSPostTest.getCreateQuery());  // GDSPostTest created here
        db.execSQL(data.CDB.CDBPreTest.getCreateQuery());   // CDBPreTest created here
        db.execSQL(data.CDB.CDBPostTest.getCreateQuery());  // CDBPostTest created here
        db.execSQL(data.Diarrhea.DiarrheaPreTest.getCreateQuery());   // DiarrheaPreTest created here
        db.execSQL(data.Diarrhea.DiarrheaPostTest.getCreateQuery());  // DiarrheaPostTest created here
        db.execSQL(data.PSBI.PSBIPreTest.getCreateQuery());       // PSBIPreTest created here
        db.execSQL(data.PSBI.PSBIPostTest.getCreateQuery());      // PSBIPPostTest created here
        db.execSQL(data.Session_End.getCreateQuery());   // InterviewEnd Table created here
        db.setTransactionSuccessful();
        db.endTransaction();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String query;
        db.beginTransaction();


        query = "DROP TABLE IF EXISTS " + LogTable.TABLE_NAME;
        db.execSQL(query);

        db.setTransactionSuccessful();
        db.endTransaction();
    }

    public Cursor execRAW(String query) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = null;
        try {
            cursor = db.rawQuery(query, null);
        } catch (SQLiteException e) {
            e.printStackTrace();
            Log.d(DBHelper.class.getName(), " Exception while executing Query");
        }
        return cursor;
    }


    public Cursor getData1(String tableName, String cnic_no, int id) {

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor res = db.rawQuery("select * from " + tableName + " where cnic_no = " + "'" + cnic_no + "' AND id = " + "'" + id + "'", null);
        return res;
    }

    public Cursor getData2(String tableName, String cnic_no, int fk_id) {

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor res = db.rawQuery("select * from " + tableName + " where cnic_no = " + "'" + cnic_no + "' AND fk_id = " + "'" + fk_id + "'", null);
        return res;
    }

    public Cursor getData3(String tableName, String cnic_no, String training, String id) {

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor res = db.rawQuery("select * from " + tableName + " where cnic_no = " + "'" + cnic_no + "' AND training = " + "'" + training + "' AND id = " + "'" + id + "'", null);
        return res;
    }


}
