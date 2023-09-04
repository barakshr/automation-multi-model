package selenium_tests;


import com.team.selenium.DriverHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(Listener.class)
public abstract class BaseTest {
    private DriverHandler driverHandler;
    private Logger logger;

    @BeforeMethod
    public void setUp() throws Exception {
        logger = LogManager.getLogger(this.getClass());
        this.driverHandler = new DriverHandler();
        driverHandler.startDriver();
    }

    @AfterMethod
    public void tearDown() {
        driverHandler.closeDriver();
    }

    public Logger getLogger() {
        return logger;
    }


}
