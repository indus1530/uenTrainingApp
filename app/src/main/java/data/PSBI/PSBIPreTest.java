package data.PSBI;

public class PSBIPreTest {
    public static String TABLE_NAME = "PSBIPreTest";

    public static String getCreateQuery() {
        String query;
        query = "CREATE TABLE '" + TABLE_NAME + "' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, " +

                Global.PSBI.PSBIPretest.fk_id + " TEXT," +
                Global.PSBI.PSBIPretest.cnic_no + " TEXT," +
                Global.PSBI.PSBIPretest.psbipretest_date + " TEXT," +
                Global.PSBI.PSBIPretest.psbipretest_time + " TEXT," +
                Global.PSBI.PSBIPretest.psbipretestq1 + " TEXT," +
                Global.PSBI.PSBIPretest.psbipretestq2 + " TEXT," +
                Global.PSBI.PSBIPretest.psbipretestq3 + " TEXT," +
                Global.PSBI.PSBIPretest.psbipretestq4 + " TEXT," +
                Global.PSBI.PSBIPretest.psbipretestq5 + " TEXT," +
                Global.PSBI.PSBIPretest.psbipretestq6 + " TEXT," +
                Global.PSBI.PSBIPretest.psbipretestq7 + " TEXT," +
                Global.PSBI.PSBIPretest.pretest_result + " TEXT," +
                Global.PSBI.PSBIPretest.STATUS + " TEXT" +

                ')';

        return query;
    }
}
