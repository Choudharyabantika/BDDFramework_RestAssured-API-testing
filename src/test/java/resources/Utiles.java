package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utiles {
	
			public RequestSpecification requestSpecification() throws IOException 
			{
				PrintStream log = new PrintStream(new FileOutputStream("C:\\Users\\2303514\\eclipse-workspace\\BDDFramework\\target\\logging.txt"));
				RequestSpecification req= new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
						.addFilter(RequestLoggingFilter.logRequestTo(log))
						.addFilter(RequestLoggingFilter.logRequestTo(log))
						.addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
				return req;
			}
			
			public static String getGlobalValue(String key) throws IOException {
				Properties prop = new Properties();
				FileInputStream file=new FileInputStream("C:\\Users\\2303514\\eclipse-workspace\\BDDFramework\\src\\test\\java\\resources\\global.properties");
				prop.load(file);
				return prop.getProperty(key);
				
			}
			public String getJsonPath(Response response ,String key) {
				String res=response.asString();
				JsonPath js = new JsonPath(res);
				
				return js.get(key).toString();
				
			}
			
			
}
