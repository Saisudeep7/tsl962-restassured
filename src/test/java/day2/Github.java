package day2;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;
public class Github {
	@BeforeTest
	public void beforeTest() {
		baseURI="https://api.github.com/user/repos";
		authentication=oauth2("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");
	}
  @Test(enabled=true)
  public void gettingAllRepositeries() {
	  given()
	  
	  .when()
	  .get("")
	  .then()
	  .log()
	  .body()
	  .statusCode(200); 
  }
  
  @Test(enabled=true)
  public void createRepositeries() {
	  JSONObject data= new JSONObject();
	  data.put("name", "restAssuredCreations1");
	  data.put("description", "I am created by restAssuredTool");
	  data.put("homepage","https://github.com/Saisudeep7");
	 
	  
	  given()
	  .header("Content-Type", "application/json")
	  .body(data.toJSONString())
	  .when()
	  .post("https://api.github.com/user/repos")
	  .then()
	  .log()
	  .body()
	  .statusCode(201)
	  .time(Matchers.lessThan(8000L), TimeUnit.MILLISECONDS);
}
}