package api.rahulshettyacademy;

import api.BaseTest;
import com.team.api.properties.Settings;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class ApiTests extends BaseTest {


    @Test
    public void assertPost() {
        postCommand()
                .then()
                .assertThat()
                .statusCode(200)
                .body("scope", equalTo("APP"))
                .header("server", "Apache/2.4.52 (Ubuntu)");

    }

    @Test
    public void assertGet() {
        Response postResponse = postCommand();
        String placeId = extractPlaceId(postResponse);
        String getApiRecourse = "maps/api/place/get/json";

        String getPlaceResponse = given()
                .log().all()
                .baseUri(Settings.AUT)
                .queryParam("key", "qaclick123")
                .queryParam("place_id", placeId)
                .when()
                .get(getApiRecourse)
                .then()
                .assertThat().log().all().statusCode(200)
                .extract().response().asString();
        JsonPath jsonPath = ReUsableMethods.rawToJson(getPlaceResponse);
        String actualAddress = jsonPath.getString("address");
        Assert.assertEquals(actualAddress, "29, side layout, cohen 09");
    }


    @Test
    public void assertPut() {
        Response postResponse = postCommand();
        String placeId = extractPlaceId(postResponse);
        String updateApiRecourse = "maps/api/place/update/json";


        String newAddress = "Summer Walk, Africa";
        String response = given()
                .log().all()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body("{\r\n" +
                        "\"place_id\":\"" + placeId + "\",\r\n" +
                        "\"address\":\"" + newAddress + "\",\r\n" +
                        "\"key\":\"qaclick123\"\r\n" +
                        "}")
                .when()
                .put(updateApiRecourse)
                .then()
                .assertThat().log().all().statusCode(200)
                .body("msg", equalTo("Address successfully updated"))
                .extract().body().asString();

        JsonPath jsonPath = new JsonPath(response);
        String updatedActualAddress = jsonPath.getString("address");
        Assert.assertEquals(updatedActualAddress, "Summer Walk, Africa");
    }

    private Response postCommand() {
        String postApiRecourse = "maps/api/place/add/json";
        return RestAssured.given()
                .baseUri(Settings.AUT)
                .log().all()
                .header(Settings.HeaderTypeKey, Settings.HeaderTypeValue)
                .queryParam("key", "qaclick123")
                .body(payload.AddPlace())
                .when()
                .post(postApiRecourse);
    }

    private String extractPlaceId(Response postResponse) {
        String stringResponse = postResponse.then().extract().response().asString();
        JsonPath js = new JsonPath(stringResponse); //for parsing Json
        return js.getString("place_id");

    }
}
