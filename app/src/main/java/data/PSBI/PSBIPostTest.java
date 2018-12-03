package data.PSBI;

public class PSBIPostTest {
    public static String TABLE_NAME = "PSBIPostTest";

    public static String getCreateQuery() {
        String query;
        query = "CREATE TABLE '" + TABLE_NAME + "' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, " +

                Global.PSBI.PSBIPostTest.fk_id + " TEXT," +
                Global.PSBI.PSBIPostTest.cnic_no + " TEXT," +
                Global.PSBI.PSBIPostTest.psbiposttest_date + " TEXT," +
                Global.PSBI.PSBIPostTest.psbiposttest_time + " TEXT," +
                Global.PSBI.PSBIPostTest.psbiposttestq1 + " TEXT," +
                Global.PSBI.PSBIPostTest.psbiposttestq2 + " TEXT," +
                Global.PSBI.PSBIPostTest.psbiposttestq3 + " TEXT," +
                Global.PSBI.PSBIPostTest.psbiposttestq4 + " TEXT," +
                Global.PSBI.PSBIPostTest.psbiposttestq5 + " TEXT," +
                Global.PSBI.PSBIPostTest.psbiposttestq6 + " TEXT," +
                Global.PSBI.PSBIPostTest.psbiposttestq7 + " TEXT," +
                Global.PSBI.PSBIPostTest.posttest_result + " TEXT," +
                Global.PSBI.PSBIPostTest.STATUS + " TEXT" +

                ')';
        return query;
    }
}
