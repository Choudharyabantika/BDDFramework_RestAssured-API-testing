package resources;
//enum is special class which is collection of methods or constants
public enum APIResourcesEndpoints {
	addPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlace("/maps/api/place/delete/json");
	String resource;
	
	APIResourcesEndpoints(String resource)
	{
		this.resource=resource;
		
	}
	public String getResource() {
		return resource;
	}
}
