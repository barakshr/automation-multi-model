package api.zippopotam;


import api.BaseTest;
import api.zippopotam.pojo.PlacesApi;
import api.zippopotam.pojo.ZipApi;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.util.Collections;

import static io.restassured.RestAssured.given;


public class ZipCode extends BaseTest {

    @Test
    public void pathParam() {
        String body = given()
                .log().all()
                .pathParams("key", "90210")
                .when()
                .get("http://api.zippopotam.us/us/{key}")
                .then()
                .log().all()
                .extract().body().asString();
        JsonPath jsonPath = new JsonPath(body);
    }


    @Test
    public void deserialize() {
        ZipApi zipApi = given()
                .log().all()
                .pathParams("key", "90210").get("http://api.zippopotam.us/us/{key}")
                .as(ZipApi.class);
    }

    @Test(enabled = false)
    public void serialize() {
        PlacesApi placesApi = new PlacesApi("1", "2", "3", "4", "5");
        ZipApi zipApi = new ZipApi("a", "b", "c", Collections.singletonList(placesApi));
        given()
                .log().all()
                .pathParams("key", "90210")
                .body(zipApi)
                .when().body("").post("http://api.zippopotam.us/us/{key}")
                .as(ZipApi.class);
    }

}
