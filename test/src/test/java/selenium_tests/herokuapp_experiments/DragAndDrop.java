package selenium_tests.herokuapp_experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDrop extends BaseExperiment{

    @Test
    public void dragAndDrop() throws InterruptedException {
        getWebDriver().get("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement columnA = getWebDriver().findElement(By.id("column-a"));
        WebElement columnB = getWebDriver().findElement(By.id("column-b"));

        Actions actionBuilder= new Actions(getWebDriver());
        actionBuilder
                .clickAndHold(columnA)
                .moveToElement(columnB)
                .release(columnB)
                .perform();
        Thread.sleep(5000);
    }
}
