package selenium_tests.herokuapp_experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class JqueryUI extends BaseExperiment {
    @Test
    public void jqueryUI() {
        getWebDriver().get("https://the-internet.herokuapp.com/jqueryui/menu");
        Actions actions = new Actions(getWebDriver());
        WebElement enabled = getWebDriver().findElement(By.xpath("//li[@id='ui-id-3']/a"));
        actions.moveToElement(enabled).perform();

        WebElement downloads = getWebDriver().findElement(By.xpath("//li[@id='ui-id-4']/a"));
        WebDriverWait webDriverWait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(2));
        webDriverWait.until(ExpectedConditions.visibilityOf(downloads));
        actions.moveToElement(downloads).perform();

        WebElement pdf = getWebDriver().findElement(By.xpath("//li[@id='ui-id-5']"));
        webDriverWait.until(ExpectedConditions.visibilityOf(pdf));
        pdf.click();

    }
}
