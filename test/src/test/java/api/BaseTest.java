package api;

import com.team.api.properties.PropertiesHandler;
import com.team.api.properties.Settings;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.io.IOException;

@Listeners(Listener.class)
public class BaseTest {
    private Logger logger;
    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;

    @BeforeTest
    public void setUp() throws IOException {
        PropertiesHandler.readProperties();
        logger = LogManager.getLogger(this.getClass());
        this.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON).setBaseUri(Settings.AUT)
                .build();
        this.responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200).expectContentType(ContentType.JSON)
                .build();
    }

    @AfterTest
    public void tearDown() {
    }

    public Logger getLogger() {
        return logger;
    }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }

    public ResponseSpecification getResponseSpecification() {
        return responseSpecification;
    }
}
