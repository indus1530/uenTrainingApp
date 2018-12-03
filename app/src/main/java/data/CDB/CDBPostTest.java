package data.CDB;

public class CDBPostTest {
    public static String TABLE_NAME = "CDBPostTest";

    public static String getCreateQuery() {
        String query;
        query = "CREATE TABLE '" + TABLE_NAME + "' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, " +

                Global.CDB.CDBPostTest.fk_id + " TEXT," +
                Global.CDB.CDBPostTest.cnic_no + " TEXT," +
                Global.CDB.CDBPostTest.cdbposttest_date + " TEXT," +
                Global.CDB.CDBPostTest.cdbposttest_time + " TEXT," +
                Global.CDB.CDBPostTest.cdbposttestq1 + " TEXT," +
                Global.CDB.CDBPostTest.cdbposttestq2 + " TEXT," +
                Global.CDB.CDBPostTest.cdbposttestq3 + " TEXT," +
                Global.CDB.CDBPostTest.cdbposttestq4 + " TEXT," +
                Global.CDB.CDBPostTest.cdbposttestq5 + " TEXT," +
                Global.CDB.CDBPostTest.cdbposttestq6 + " TEXT," +
                Global.CDB.CDBPostTest.cdbposttestq7 + " TEXT," +
                Global.CDB.CDBPostTest.cdbposttestq8 + " TEXT," +
                Global.CDB.CDBPostTest.cdbposttestq9 + " TEXT," +
                Global.CDB.CDBPostTest.cdbposttestq10 + " TEXT," +
                Global.CDB.CDBPostTest.posttest_result + " TEXT," +
                Global.CDB.CDBPostTest.STATUS + " TEXT" +

                ')';
        return query;
    }
}
