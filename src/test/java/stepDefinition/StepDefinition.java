package stepDefinition;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResourcesEndpoints;
import resources.TestDataBuilder;
import resources.Utiles;

public class StepDefinition extends Utiles{
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	TestDataBuilder data;
	JsonPath js;
	static String place_id;
	
	@Given("Add place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
		data=new TestDataBuilder();
		 
		res=given().spec(requestSpecification()).body(data.addPlacePayload(name,language,address));
	}
	
	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
		APIResourcesEndpoints resourceAPI=APIResourcesEndpoints.valueOf(resource);
		resspec= new ResponseSpecBuilder().expectStatusCode(200).build();
		if(method.equalsIgnoreCase("POST")) {
			
			response= 	res.post(resourceAPI.getResource()).then().log().all().spec(resspec).extract().response();
		}
		else if(method.equalsIgnoreCase("GET")) {
			response= 		res.get(resourceAPI.getResource()).then().log().all().spec(resspec).extract().response();
		}
	}
	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(int code) {
		assertEquals(response.getStatusCode(),200);
	   
	}
	
	@Then("{string} in responses body is {string}")
	public void in_responses_body_is(String key, String value) {
		
		assertEquals(getJsonPath(response,key),value);
	}

	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {
		place_id=getJsonPath(response,"place_id");
		res=given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_calls_with_http_request(resource,"GET");
		String actualName=getJsonPath(response,"name");
		assertEquals(actualName,expectedName);
		
	}
	@Given("deletePlace payload")
	public void delete_place_payload() throws IOException {
		data=new TestDataBuilder();
	   res=given().spec(requestSpecification()).body(data.deletePayload(place_id));
	}
}
	

