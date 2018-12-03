package utils;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Umeed-e-Nau on 12/20/2016.
 */
public class HhMemberModel {

    public static ArrayList<String> names = new ArrayList<String>();
    public static HashMap<String, String> relationshipWHH = new HashMap<>();
    public static HashMap<String, String> father = new HashMap<>();
    public static HashMap<String, String> mother = new HashMap<>();
    public static HashMap<String, String> sex = new HashMap<>();

    public static HashMap<String, String> dob = new HashMap<>();
    public static HashMap<String, String> age = new HashMap<>();
    public static HashMap<String, String> education = new HashMap<>();
    public static HashMap<String, String> occupation = new HashMap<>();
    public static ArrayList<String> list_educated = new ArrayList<String>();
    public static HashMap<String, String> martitalStatus = new HashMap<>();


    public static ArrayList<String> eligibleMember = new ArrayList<>();
    public static ArrayList<String> marriedMember = new ArrayList<>();


    public static ArrayList<String> male = new ArrayList<>();
    public static ArrayList<String> female = new ArrayList<>();

    public static HashMap<String, String> childLT5 = new HashMap<>();
    // Key=Primery key yonqest child from tbl_hh_member_info Value=Name of child whose age<5 year


    public static String youngestChild;
    public static String youngestChildId;

    public static String youngestChildMother;
    public static String youngestChildMotherId;

    public static String respondent;
    public static String respondentId;

    public static String hhName;
    //  public static String  hhId;

    public static int houseInfoId;

    public static String childHadAri;
    public static String childHadDiarrhea;


}
