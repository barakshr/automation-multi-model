package ui.selenium.herokuapp_experiments;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class Tabs extends BaseExperiment {

    @Test
    public void windows_tabs() throws IOException, InterruptedException {
        getWebDriver().navigate().to("https://the-internet.herokuapp.com/windows");
        getWebDriver().findElement(By.xpath("//div[@id='content']/div/a")).click();
        Set<String> allWindowTabss= getWebDriver().getWindowHandles();
        Iterator<String> iterate = allWindowTabss.iterator();
        String mainFirstWindow = iterate.next();
        getWebDriver().switchTo().window(mainFirstWindow);
    }
}
