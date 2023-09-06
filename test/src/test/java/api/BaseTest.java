package api;

import com.team.api.properties.PropertiesHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.io.IOException;

@Listeners(Listener.class)
public class BaseTest {
    private Logger logger;

    @BeforeTest
    public void setUp() throws IOException {
        PropertiesHandler.readProperties();
        logger = LogManager.getLogger(this.getClass());
    }

    @AfterTest
    public void tearDown() {

    }

    public Logger getLogger() {
        return logger;
    }
}
