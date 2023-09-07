package api.academy;

import api.BaseTest;
import com.team.api.properties.Param;
import com.team.api.properties.ParamBuilder;
import com.team.api.properties.Payload;
import com.team.api.properties.Settings;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class PlaceApiTests extends BaseTest {

    private final static String JsonFilePath = "placePayload.json";

    @Test
    public void testPostCommand() {
        executePostCommand()
                .then()
                .assertThat()
                .statusCode(200)
                .body("scope", equalTo("APP"))
                .header("server", "Apache/2.4.52 (Ubuntu)");

    }

    @Test
    public void testGetCommand() {
        //post
        Response postResponse = executePostCommand();
        String placeId = extractPlaceIdFromResponse(postResponse);

        //get
        String placeResponse = executeGetCommand(placeId)
                .then()
                .assertThat().log().all().statusCode(200)
                .extract().response().asString();
        JsonPath jsonPath = new JsonPath(placeResponse);
        String actualName = jsonPath.getString("name");

        //verify
        Assert.assertEquals(actualName, "Rahul Shetty Academy");
    }

    @Test(dataProvider = "params")
    public void testPutCommand(String key,String value) {
        //post
        Response postResponse = executePostCommand();
        String placeId = extractPlaceIdFromResponse(postResponse);

        //put
        List<Param> paramList = new ParamBuilder()
                .addParam(key, value)
                .getParamLists();
        String payload = Payload.getJsonPayload(JsonFilePath, paramList);
        String updateApiRecourse = "maps/api/place/update/json";
        given()
                .log().all()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .put(updateApiRecourse);

        //get
        String getResponse = executeGetCommand(placeId)
                .then().extract().body().asString();
        JsonPath jsonPath = new JsonPath(getResponse);
        String updatedActualAddress = jsonPath.getString("address");

        //verify
        Assert.assertEquals(updatedActualAddress, "New York");
    }

    @Test
    public void testDeleteCommand() {
        //post
        Response postResponse = executePostCommand();
        String placeId = extractPlaceIdFromResponse(postResponse);

        //delete
        String getApiRecourse = "maps/api/place/get/json";
        given()
                .log().all()
                .baseUri(Settings.AUT)
                .queryParam("key", "qaclick123")
                .queryParam("place_id", placeId)
                .when()
                .delete(getApiRecourse)
                .then()
                .assertThat().log().all().statusCode(200);

        //get
        executeGetCommand(placeId).then().assertThat().statusCode(404);
    }

    Response executeGetCommand(String placeId) {

        String getApiRecourse = "maps/api/place/get/json";
        return given()
                .log().all()
                .baseUri(Settings.AUT)
                .queryParam("key", "qaclick123")
                .queryParam("place_id", placeId)
                .when()
                .get(getApiRecourse);
    }


    private Response executePostCommand() {
        String postApiRecourse = "maps/api/place/add/json";
        String payload = Payload.getJsonPayload(JsonFilePath);
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

    @DataProvider(name="params")
    public Object[][] paramsProvider(){
        return  new Object[][] {
                {"%param_1","New York"}, //test1
                {"%param_1","Chicago"}}; //test2

    }

}
