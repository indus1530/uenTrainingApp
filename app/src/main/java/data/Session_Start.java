package data;

public class Session_Start {

    public static String TABLE_NAME = "Session_Start";

    public static String getCreateQuery() {
        String query;
        query = "CREATE TABLE '" + TABLE_NAME + "' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'cnic_no' TEXT, " +


                Global.Session_Start.Session_Start_Date + " TEXT," +
                Global.Session_Start.Session_Start_Time + " TEXT," +
                Global.Session_Start.province + " TEXT," +
                Global.Session_Start.district + " TEXT," +
                Global.Session_Start.tehsil + " TEXT," +
                Global.Session_Start.Union_Council + " TEXT," +
                Global.Session_Start.facility_name + " TEXT," +
                Global.Session_Start.provider_name + " TEXT," +
                Global.Session_Start.qa_officer + " TEXT," +
                Global.Session_Start.attempt_no + " TEXT," +
                Global.Session_Start.contact_no + " TEXT," +
                Global.Session_Start.S_latitude + " TEXT," +
                Global.Session_Start.S_longitude + " TEXT," +
                Global.Session_Start.STATUS + " TEXT" +

                ')';
        return query;
    }
}
