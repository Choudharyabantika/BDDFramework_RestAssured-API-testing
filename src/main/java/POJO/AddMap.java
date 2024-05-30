package POJO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddMap {
	@JsonProperty
	private Location location;
	@JsonProperty
	private int accuracy;
	@JsonProperty
	private String name;
	@JsonProperty
	private String address;
	@JsonProperty
	private List<String> type;
	@JsonProperty
	private String website;
	@JsonProperty
	private String language;
	@JsonProperty
	private String phonenumber;
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public int getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<String> getType() {
		return type;
	}
	public void setType(List<String> type) {
		this.type = type;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
}
