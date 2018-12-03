package utils;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Umeed-e-Nau on 12/23/2016.
 */
public class QuestionModel {

    /*
     * Key = section like a, c, d, f, g etc..
     * Value = HashMap<String, List>
     * --- Key == question number like f1,f2, f3, ...
     * --  Value[0] = type of view like
     * -- radio for radioButton
     * -- range for RangeBar
     * -- text for editText
     * -- check for CheckBox
     * --Value[1+] answers of the question
     *
     * */
    public static HashMap<String, HashMap<String, List<String>>> quest = new HashMap<>();

}
