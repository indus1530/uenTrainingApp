package data.GDS;

public class GDSPostTest {
    public static String TABLE_NAME = "GDSPostTest";

    public static String getCreateQuery() {
        String query;
        query = "CREATE TABLE '" + TABLE_NAME + "' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, " +

                Global.GDS.GDSPostTest.fk_id + " TEXT," +
                Global.GDS.GDSPostTest.cnic_no + " TEXT," +
                Global.GDS.GDSPostTest.gdsposttest_date + " TEXT," +
                Global.GDS.GDSPostTest.gdsposttest_time + " TEXT," +
                Global.GDS.GDSPostTest.gdsposttestq1 + " TEXT," +
                Global.GDS.GDSPostTest.gdsposttestq2 + " TEXT," +
                Global.GDS.GDSPostTest.gdsposttestq3 + " TEXT," +
                Global.GDS.GDSPostTest.gdsposttestq4 + " TEXT," +
                Global.GDS.GDSPostTest.gdsposttestq5 + " TEXT," +
                Global.GDS.GDSPostTest.gdsposttestq6 + " TEXT," +
                Global.GDS.GDSPostTest.gdsposttestq7 + " TEXT," +
                Global.GDS.GDSPostTest.gdsposttestq8 + " TEXT," +
                Global.GDS.GDSPostTest.gdsposttestq9 + " TEXT," +
                Global.GDS.GDSPostTest.gdsposttestq10 + " TEXT," +
                Global.GDS.GDSPostTest.posttest_result + " TEXT," +
                Global.GDS.GDSPostTest.STATUS + " TEXT" +

                ')';
        return query;
    }
}
