package backTrack;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.*;
/*
题目就是flatten json to a list of map, 有一段json，比如说如下：
{
    "uuid": "abc",
    "properties": {
    "sessionName": "Test session name"
    "waypoints": [
    {"uuid": "def", "properties": {"latitude": 3}}
    ]
}
}
把它转化成List<Map>， map里面uuid是key, properties是value。 所以结果应该像下面
[
{“uuid”: “abc”, “properties”: {“sessionName”: “Test session name”, “waypoints”: [“def”]}},
{“uuid”: “def”, “properties”: {“latitude”: 3}},
        …
        ]
其实就是recursion求，每次把一个object放进map以后，要用一个recursive的function 处理一下每个attribute。如果是array的话要recursive的把array里的所有object都放进res里面，并且对每个object再进行recursion
*/
public class flattenJason {

    public static List<Map<String, Object>> flatternJSON(String jsonString) throws Exception {
        JSONParser parser = new JSONParser();
        List<Map<String, Object>> res = new ArrayList<Map<String, Object>>();// res is a ArrayList of Map
        JSONObject jObj = (JSONObject) parser.parse(jsonString); // convert input to jsonObject
        /*
        Map<String, Object> map = new HashMap<String, Object>();//create one map
        String key = (String) jObj.get("uuid");
        System.out.println(key);
        Object value = jObj.get("properties");
        map.put(key, jObj); //
        */
        recursiveProcess(jObj, res);
        return res;
    }

    private static void recursiveProcess(JSONObject jObj, List<Map<String, Object>> res) {
        Iterator iter = jObj.keySet().iterator();
        System.out.println(jObj.keySet());
        while(iter.hasNext()) {
            String key = (String) iter.next();
            System.out.println("key="+key);
            Object obj = jObj.get(key);
            if (obj instanceof String) {
                System.out.println("key="+key+" is String");
                continue;
            } else if (obj instanceof JSONArray) {
                System.out.println("key="+key+" is JSONArray");
                JSONArray array = (JSONArray)obj;
                Iterator arrIter = array.iterator();
                JSONArray newArray = new JSONArray();
                while(arrIter.hasNext()) {
                    JSONObject o = (JSONObject) arrIter.next();
                    newArray.add(o.get("uuid"));
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put((String) o.get("uuid"), obj);
                    res.add(map);
                    recursiveProcess(o, res);
                }
                jObj.put(key, newArray);
            } else {
                System.out.println("key="+key+" need to recursive");
                recursiveProcess((JSONObject) obj, res);
                System.out.println("key=" + key + " end of recursive");
            }
        }
    }
    public static void main(String[] args) throws  Exception{
        String s= "{\"uuid\": \"abc\",\"properties\": {\"sessionName\": \"Test session name\",\"waypoints\":[{\"uuid\": \"def\", \"properties\": {\"latitude\": \"3\"}}]}}";
        System.out.println(flatternJSON(s) );
    }
}
