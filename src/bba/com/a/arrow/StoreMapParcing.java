package bba.com.a.arrow;

import java.util.Map;

public class StoreMapParcing {

	public StoreMapParcing() {}
	
	public static String[] getMapParcing(Map<String, Object> map) {
		//(32.123, 234.123) > 32.123 , 234.123 각각 으로 파싱해주기 (DTO에 넣기위해)
		String latlngparser = (String)map.get("latlng");
		int latIndex  = latlngparser.indexOf(",");
		String latlng[] = new String[2];
		latlng[0] = latlngparser.substring(1, latIndex);
		latlng[1] = latlngparser.substring(latIndex+2, latlngparser.length()-1);
		System.out.println("lat:"+latlng[0]);
		System.out.println("lng:"+latlng[1]);
		return latlng;
		
		
	}
}
