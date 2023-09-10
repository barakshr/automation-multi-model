package api.zippopotam;


import api.BaseTest;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;


public class Zip extends BaseTest {

    @Test
    public void pathParam(){
      String body=  RestAssured.given()
              .log().all()
              .pathParams("key","90210").get("http://api.zippopotam.us/us/{key}")
              .then()
              .log().all()
              .extract().body().asString();
        JsonPath jsonPath= new JsonPath(body);
    }
}
