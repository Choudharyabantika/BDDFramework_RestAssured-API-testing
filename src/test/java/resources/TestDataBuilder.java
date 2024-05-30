package resources;

import java.util.ArrayList;
import java.util.List;

import POJO.AddMap;
import POJO.Location;

public class TestDataBuilder {
	
	public AddMap addPlacePayload(String name, String language, String address) {
		AddMap ad=new AddMap();
		Location l=new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		ad.setLocation(l);
		ad.setAccuracy(50);
		ad.setAddress(address);
		ad.setLanguage(language);
		ad.setName(name);
		ad.setPhonenumber("(+91) 983 893 3937");
		ad.setWebsite("https://rahulshettyacademy.com");
		List<String> mylist=new ArrayList<String>();
		mylist.add("shoe park");
		mylist.add("shop");
		ad.setType(mylist);
		return ad;
	}
	public String deletePayload(String place_id) {
		return "{\r\n"
				+ "    \"place_id\":\""+place_id+"\"\r\n"
				+ "}";

		
	}

}
