package ui.selenium;


import com.team.selenium.DriverHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(Listener.class)
public abstract class BaseTest {
    private Logger logger;

    @BeforeMethod
    public void setUp() throws Exception {
        logger = LogManager.getLogger(this.getClass());
        new DriverHandler().startDriver();

    }

    @AfterMethod
    public void tearDown() {
        new DriverHandler().closeDriver();

    }

    public Logger getLogger() {
        return logger;
    }


}
