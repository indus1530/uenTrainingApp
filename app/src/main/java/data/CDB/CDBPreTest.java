package data.CDB;

public class CDBPreTest {
    public static String TABLE_NAME = "CDBPreTest";

    public static String getCreateQuery() {
        String query;
        query = "CREATE TABLE '" + TABLE_NAME + "' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, " +

                Global.CDB.CDBPreTest.fk_id + " TEXT," +
                Global.CDB.CDBPreTest.cnic_no + " TEXT," +
                Global.CDB.CDBPreTest.cdbpretest_date + " TEXT," +
                Global.CDB.CDBPreTest.cdbpretest_time + " TEXT," +
                Global.CDB.CDBPreTest.cdbpretestq1 + " TEXT," +
                Global.CDB.CDBPreTest.cdbpretestq2 + " TEXT," +
                Global.CDB.CDBPreTest.cdbpretestq3 + " TEXT," +
                Global.CDB.CDBPreTest.cdbpretestq4 + " TEXT," +
                Global.CDB.CDBPreTest.cdbpretestq5 + " TEXT," +
                Global.CDB.CDBPreTest.cdbpretestq6 + " TEXT," +
                Global.CDB.CDBPreTest.cdbpretestq7 + " TEXT," +
                Global.CDB.CDBPreTest.cdbpretestq8 + " TEXT," +
                Global.CDB.CDBPreTest.cdbpretestq9 + " TEXT," +
                Global.CDB.CDBPreTest.cdbpretestq10 + " TEXT," +
                Global.CDB.CDBPreTest.pretest_result + " TEXT," +
                Global.CDB.CDBPreTest.STATUS + " TEXT" +

                ')';

        return query;
    }
}
