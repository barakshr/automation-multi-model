package api.academy;

import api.BaseTest;
import com.team.api.payload.Payload;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JsonPathTests  extends BaseTest {

    @Test
    public void jsonPathTest() {
        String payloadJson = Payload.getJsonPayload("coursePrice.json");
        JsonPath js = new JsonPath(payloadJson);
        int actualCount = js.getInt("courses.size()");
        String titleFirstCourse = js.get("courses[2].title");

        Assert.assertEquals(actualCount,4);
        Assert.assertEquals(titleFirstCourse,"RPA");
    }
}
