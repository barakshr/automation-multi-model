package api.zippopotam;


import api.BaseTest;
import io.restassured.RestAssured;
import org.testng.annotations.Test;


public class Zip extends BaseTest {

    @Test
    public void getZipCode(){
      String body=  RestAssured.given().get("http://api.zippopotam.us/us/90210").asString();
    }
}
