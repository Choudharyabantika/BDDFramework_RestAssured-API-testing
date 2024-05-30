package POJO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetCourses {
	@JsonProperty
	private String url;
	@JsonProperty
	private String services;
	@JsonProperty
	private String expertise;
	@JsonProperty
	private Courses courses;
	@JsonProperty
	private String linkedIn;
	@JsonProperty
	private String instructor;
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public Courses getCourse() {
		return courses;
	}
	public void setCourse(Courses course) {
		courses = course;
	}
	public String getLinkedIn() {
		return linkedIn;
	}
	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}
	

}
