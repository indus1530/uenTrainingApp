package data;

public class Session_End {

    public static String TABLE_NAME = "Session_End";

    public static String getCreateQuery() {
        String query;
        query = "CREATE TABLE '" + TABLE_NAME + "' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, " +

                Global.Session_End.fk_id + " TEXT," +
                Global.Session_End.cnic_no + " TEXT," +
                Global.Session_End.training + " TEXT," +
                Global.Session_End.pretest_result + " TEXT," +
                Global.Session_End.posttest_result + " TEXT," +
                Global.Session_End.posttest_percent + " TEXT," +
                Global.Session_End.Remarks + " TEXT," +
                Global.Session_End.next_session_date + " TEXT," +
                Global.Session_End.next_session_time + " TEXT," +
                Global.Session_End.training_status + " TEXT," +
                Global.Session_End.Session_End_Date + " TEXT," +
                Global.Session_End.Session_End_Time + " TEXT," +
                Global.Session_End.STATUS + " TEXT" +

                ')';


        return query;
    }
}
