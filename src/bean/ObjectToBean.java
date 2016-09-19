package bean;

import net.sf.json.JSONObject;

public class ObjectToBean {
	public static Object getObj(String jsonString, Class clazz) {
	    JSONObject jsonObject = null;
	    try {
	        jsonObject = JSONObject.fromObject(jsonString);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return JSONObject.toBean(jsonObject, clazz);
	}
}
