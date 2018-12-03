package data.Diarrhea;

public class DiarrheaPreTest {
    public static String TABLE_NAME = "DiarrheaPreTest";

    public static String getCreateQuery() {
        String query;
        query = "CREATE TABLE '" + TABLE_NAME + "' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, " +

                Global.Diarrhea.DiarrheaPreTest.fk_id + " TEXT," +
                Global.Diarrhea.DiarrheaPreTest.cnic_no + " TEXT," +
                Global.Diarrhea.DiarrheaPreTest.diarrheapretest_date + " TEXT," +
                Global.Diarrhea.DiarrheaPreTest.diarrheapretest_time + " TEXT," +
                Global.Diarrhea.DiarrheaPreTest.diarrheapretestq1 + " TEXT," +
                Global.Diarrhea.DiarrheaPreTest.diarrheapretestq2 + " TEXT," +
                Global.Diarrhea.DiarrheaPreTest.diarrheapretestq3 + " TEXT," +
                Global.Diarrhea.DiarrheaPreTest.diarrheapretestq4 + " TEXT," +
                Global.Diarrhea.DiarrheaPreTest.diarrheapretestq5 + " TEXT," +
                Global.Diarrhea.DiarrheaPreTest.diarrheapretestq6 + " TEXT," +
                Global.Diarrhea.DiarrheaPreTest.diarrheapretestq7 + " TEXT," +
                Global.Diarrhea.DiarrheaPreTest.diarrheapretestq8 + " TEXT," +
                Global.Diarrhea.DiarrheaPreTest.diarrheapretestq9 + " TEXT," +
                Global.Diarrhea.DiarrheaPreTest.diarrheapretestq10 + " TEXT," +
                Global.Diarrhea.DiarrheaPreTest.pretest_result + " TEXT," +
                Global.Diarrhea.DiarrheaPreTest.STATUS + " TEXT" +

                ')';

        return query;
    }
}
