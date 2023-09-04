package selenium_tests.herokuapp_experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExitIntent extends BaseExperiment {

    @Test
    public void exitIntent(){
        getWebDriver().get("https://the-internet.herokuapp.com/exit_intent");
        Actions actions= new Actions(getWebDriver());
        actions.keyDown(Keys.COMMAND).sendKeys("l").perform();
        WebElement webElement= getWebDriver().findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[3]/p"));
        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
