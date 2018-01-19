package demo.trukker.com.volleyexample;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * Created by Belal on 9/22/2015.
 */
public class ParseJSON {
    public static String[] ids;
    public static String[] names;
    public static String[] emails;
 
    public static final String JSON_ARRAY = "message";
    public static final String KEY_ID = "load_inquiry_no";
    public static final String KEY_NAME = "shipper_name";
    public static final String KEY_EMAIL = "email_id";
 
    private JSONArray users = null;
 
    private String json;
 
    public ParseJSON(String json){
        this.json = json;
    }
 
    protected void parseJSON(){
        JSONObject jsonObject=null;
        try {
            try {
                json = new JSONTokener(json).nextValue().toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY);
 
            ids = new String[users.length()];
            names = new String[users.length()];
            emails = new String[users.length()];
 
            for(int i=0;i<users.length();i++){
                JSONObject jo = users.getJSONObject(i);
                ids[i] = jo.getString(KEY_ID);
                names[i] = jo.getString(KEY_NAME);
                emails[i] = jo.getString(KEY_EMAIL);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}