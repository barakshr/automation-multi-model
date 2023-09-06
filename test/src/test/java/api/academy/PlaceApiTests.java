package api.academy;

import api.BaseTest;
import com.team.api.properties.Param;
import com.team.api.properties.Payload;
import com.team.api.properties.Settings;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class PlaceApiTests extends BaseTest {

    @Test
    public void fff() {
        String text = Payload.readPayloadJson("addPlacePayload.json");
    }

    @Test
    public void verifyPostCommand() {
        executePostCommand()
                .then()
                .assertThat()
                .statusCode(200)
                .body("scope", equalTo("APP"))
                .header("server", "Apache/2.4.52 (Ubuntu)");

    }

    @Test
    public void verifyGetCommand() {
        Response postResponse = executePostCommand();
        String placeId = extractPlaceIdFromResponse(postResponse);
        String getApiRecourse = "maps/api/place/get/json";
        String placeResponse = given()
                .log().all()
                .baseUri(Settings.AUT)
                .queryParam("key", "qaclick123")
                .queryParam("place_id", placeId)
                .when()
                .get(getApiRecourse)
                .then()
                .assertThat().log().all().statusCode(200)
                .extract().response().asString();
        JsonPath jsonPath = new JsonPath(placeResponse);
        String actualAddress = jsonPath.getString("address");
        Assert.assertEquals(actualAddress, "29, side layout, cohen 09");
    }

    @Test
    public void verifyPutCommand() {
        Response postResponse = executePostCommand();
        String placeId = extractPlaceIdFromResponse(postResponse);
        String updateApiRecourse = "maps/api/place/update/json";
        String payload = Payload.readPayloadJson("updatePlacePayload.json");
        String response = given()
                .log().all()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(payload)
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


    private Response executePostCommand() {
        String postApiRecourse = "maps/api/place/add/json";
        String payload = Payload.readPayloadJson("addPlacePayload.json");
        return RestAssured.given()
                .baseUri(Settings.AUT)
                .log().all()
                .header(Settings.HeaderTypeKey, Settings.HeaderTypeValue)
                .queryParam("key", "qaclick123")
                .body(payload)
                .when()
                .post(postApiRecourse);
    }

    private String extractPlaceIdFromResponse(Response postResponse) {
        String stringResponse = postResponse.then().extract().response().asString();
        JsonPath js = new JsonPath(stringResponse); //for parsing Json
        return js.getString("place_id");
    }

    @Test
    public void ffdfff() {
        Param param = new Param("%param_0", "string", 20);
         List<Param> params= new ArrayList<>();
         params.add(param);

           //     .addParam("{param_2}", "int", "hello");
        Payload.readPayloadJson("temp.json", params);

    }


}
