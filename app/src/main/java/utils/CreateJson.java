package utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CreateJson {
    HashMap<String, List<String>> map;
    String houseId, memberId = "-1";

    public JSONArray houseMemberData(String id) {

        houseId = id;
        JSONArray jsonArray = new JSONArray();

        try {
            jsonArray.put(getHouseMemberJson());
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            return jsonArray;
        }
    }

    public JSONArray interviewData(String id)

    {

        memberId = id;
        JSONArray jsonArray = new JSONArray();

        try {
            jsonArray.put(interviewtoJson());
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            return jsonArray;
        }
    }


    /* PRIVATE METHODS  */

    private JSONObject interviewtoJson() throws JSONException {

        JSONObject mainObj = new JSONObject();

        //json-array for each member
        JSONArray jsonArray = new JSONArray();

        //json-object for each field of a member
        JSONObject jsonObject = new JSONObject();

        map = utils.QuestionModel.quest.get("f");
        if (map != null)
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                jsonObject.put(entry.getKey(), entry.getValue());
            }

        map = utils.QuestionModel.quest.get("g");
        if (map != null)
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                jsonObject.put(entry.getKey(), entry.getValue());
            }

        map = utils.QuestionModel.quest.get("h");
        if (map != null)
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                jsonObject.put(entry.getKey(), entry.getValue());
            }

        map = utils.QuestionModel.quest.get("i");
        if (map != null)
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                jsonObject.put(entry.getKey(), entry.getValue());
            }

        map = utils.QuestionModel.quest.get("ii");
        if (map != null)
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                jsonObject.put(entry.getKey(), entry.getValue());
            }

        map = utils.QuestionModel.quest.get("j");
        if (map != null)
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                jsonObject.put(entry.getKey(), entry.getValue());
            }

        map = utils.QuestionModel.quest.get("k");
        if (map != null)
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                jsonObject.put(entry.getKey(), entry.getValue());
            }

        map = utils.QuestionModel.quest.get("l");
        if (map != null)
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                jsonObject.put(entry.getKey(), entry.getValue());
            }

        map = utils.QuestionModel.quest.get("ws");
        if (map != null)
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                jsonObject.put(entry.getKey(), entry.getValue());
            }

        map = utils.QuestionModel.quest.get("hw");
        if (map != null)
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                jsonObject.put(entry.getKey(), entry.getValue());
            }

        jsonArray.put(jsonObject);
        mainObj.put(memberId, jsonArray);

        return mainObj;
    }

    private JSONObject getHouseMemberJson() throws JSONException {

        // main object for final json-array
        JSONObject mainObj = new JSONObject();


        //json-object for each field of a member
        JSONObject jsonObject = null;


        int i = 1;
        for (String name : HhMemberModel.names) {

            //json-array for each member
            JSONArray jsonArray = new JSONArray();
            jsonObject = new JSONObject();

            //jsonObject.put("location", new JSONArray().put("d1").put(i+""));
            jsonObject.put("hh_memeber_name", new JSONArray().put("d2").put(name));
            jsonObject.put("relationship_hh", new JSONArray().put("d3")
                    .put(HhMemberModel.relationshipWHH.get(name)));
            jsonObject.put("sex", new JSONArray().put("d4").put(HhMemberModel.sex.get(name)));
            jsonObject.put("father_name", new JSONArray().put("d5")
                    .put(HhMemberModel.father.get(name)));
            jsonObject.put("mother_name", new JSONArray().put("d6")
                    .put(HhMemberModel.mother.get(name)));
            jsonObject.put("dob", new JSONArray().put("d7").put(HhMemberModel.dob.get(name)));
            jsonObject.put("age", new JSONArray().put("d8").put(HhMemberModel.age.get(name)));
            jsonObject.put("education", new JSONArray().put("d9")
                    .put(HhMemberModel.education.get(name)));
            jsonObject.put("ocupation", new JSONArray().put("d10")
                    .put(HhMemberModel.occupation.get(name)));
            jsonObject.put("marital_status", new JSONArray().put("d11")
                    .put(HhMemberModel.martitalStatus.get(name)));


            //jsonObject.put("hh_id", new JSONArray().put(HhMemberModel.hhId));

            if (HhMemberModel.youngestChildMother == null
                    || !HhMemberModel.youngestChildMother.equals(name))
                jsonObject.put("b_m_y_child", new JSONArray().put("b_m_y_child").put("0"));
            else
                jsonObject.put("b_m_y_child", new JSONArray().put("b_m_y_child").put("1"));

            /*if(HhMemberModel.youngestChild == null
                    ||HhMemberModel.youngestChild.equals(name))
                jsonObject.put("b_y_child", new JSONArray().put(new String[]{"b_y_child", "0"}));
            else
                jsonObject.put("b_y_child", new JSONArray().put("1"));*/

            if (HhMemberModel.eligibleMember == null ||
                    !HhMemberModel.eligibleMember.contains(name))
                jsonObject.put("b_E1", new JSONArray().put("b_elg_interview").put("0"));
            else
                jsonObject.put("b_E1", new JSONArray().put("b_elg_interview").put("1"));

            if (HhMemberModel.childHadDiarrhea == null
                    || !HhMemberModel.childHadDiarrhea.equals(name))
                jsonObject.put("b_dharea", new JSONArray().put("b_dharea").put("0"));
            else
                jsonObject.put("b_dharea", new JSONArray().put("b_dharea").put("1"));


            if (HhMemberModel.childHadAri == null
                    || !HhMemberModel.childHadAri.equals(name))
                jsonObject.put("b_ari", new JSONArray().put("b_ari").put("0"));
            else
                jsonObject.put("b_ari", new JSONArray().put("b_ari").put("1"));


            if (HhMemberModel.respondent == null
                    || !HhMemberModel.respondent.equals(name))
                jsonObject.put("b_main_respondent", new JSONArray().put("0"));
            else
                jsonObject.put("b_main_respondent", new JSONArray().put("1"));

            try {  // put the server house_id here
                houseId = houseId.replace("\"", "");
                jsonObject.put("house_id", new JSONArray().put(houseId));
            } catch (Exception e) {
                e.printStackTrace();
            }

            jsonArray.put(jsonObject);
            // jsonArray.put(new JSONObject().put(name, new JSONArray().put(jsonObject)));
            mainObj.put(i + "", jsonArray);
            i++;
        }

        return mainObj;
    }
}
