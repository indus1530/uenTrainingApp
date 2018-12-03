package data.Diarrhea;

public class DiarrheaPostTest {
    public static String TABLE_NAME = "DiarrheaPostTest";

    public static String getCreateQuery() {
        String query;
        query = "CREATE TABLE '" + TABLE_NAME + "' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, " +

                Global.Diarrhea.DiarrheaPostTest.fk_id + " TEXT," +
                Global.Diarrhea.DiarrheaPostTest.cnic_no + " TEXT," +
                Global.Diarrhea.DiarrheaPostTest.diarrheaposttest_date + " TEXT," +
                Global.Diarrhea.DiarrheaPostTest.diarrheaposttest_time + " TEXT," +
                Global.Diarrhea.DiarrheaPostTest.diarrheaposttestq1 + " TEXT," +
                Global.Diarrhea.DiarrheaPostTest.diarrheaposttestq2 + " TEXT," +
                Global.Diarrhea.DiarrheaPostTest.diarrheaposttestq3 + " TEXT," +
                Global.Diarrhea.DiarrheaPostTest.diarrheaposttestq4 + " TEXT," +
                Global.Diarrhea.DiarrheaPostTest.diarrheaposttestq5 + " TEXT," +
                Global.Diarrhea.DiarrheaPostTest.diarrheaposttestq6 + " TEXT," +
                Global.Diarrhea.DiarrheaPostTest.diarrheaposttestq7 + " TEXT," +
                Global.Diarrhea.DiarrheaPostTest.diarrheaposttestq8 + " TEXT," +
                Global.Diarrhea.DiarrheaPostTest.diarrheaposttestq9 + " TEXT," +
                Global.Diarrhea.DiarrheaPostTest.diarrheaposttestq10 + " TEXT," +
                Global.Diarrhea.DiarrheaPostTest.posttest_result + " TEXT," +
                Global.Diarrhea.DiarrheaPostTest.STATUS + " TEXT" +

                ')';
        return query;
    }
}
