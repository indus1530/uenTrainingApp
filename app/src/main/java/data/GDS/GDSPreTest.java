package data.GDS;


public class GDSPreTest {
    public static String TABLE_NAME = "GDSPreTest";

    public static String getCreateQuery() {
        String query;
        query = "CREATE TABLE '" + TABLE_NAME + "' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, " +

                Global.GDS.GDSPreTest.fk_id + " TEXT," +
                Global.GDS.GDSPreTest.cnic_no + " TEXT," +
                Global.GDS.GDSPreTest.gdspretest_date + " TEXT," +
                Global.GDS.GDSPreTest.gdspretest_time + " TEXT," +
                Global.GDS.GDSPreTest.gdspretestq1 + " TEXT," +
                Global.GDS.GDSPreTest.gdspretestq2 + " TEXT," +
                Global.GDS.GDSPreTest.gdspretestq3 + " TEXT," +
                Global.GDS.GDSPreTest.gdspretestq4 + " TEXT," +
                Global.GDS.GDSPreTest.gdspretestq5 + " TEXT," +
                Global.GDS.GDSPreTest.gdspretestq6 + " TEXT," +
                Global.GDS.GDSPreTest.gdspretestq7 + " TEXT," +
                Global.GDS.GDSPreTest.gdspretestq8 + " TEXT," +
                Global.GDS.GDSPreTest.gdspretestq9 + " TEXT," +
                Global.GDS.GDSPreTest.gdspretestq10 + " TEXT," +
                Global.GDS.GDSPreTest.pretest_result + " TEXT," +
                Global.GDS.GDSPreTest.STATUS + " TEXT" +

                ')';

        return query;
    }
}
