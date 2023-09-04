package selenium_tests.herokuapp_experiments;

import io.restassured.RestAssured;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class BrokenImages extends BaseExperiment {

    @Test
    public void brokenImages() {
        getWebDriver().get("https://the-internet.herokuapp.com/broken_images");
        WebElement brokenWebElementImg = getWebDriver().findElement(By.xpath("//div[@id='content']/div/img[2]"));
        String brokenImagePath = brokenWebElementImg.getAttribute("src");
        RestAssured.get(brokenImagePath).then().assertThat().statusCode(404);
        WebElement webElement = getWebDriver().findElement(By.xpath("//div[@id='content']/div/img[3]"));
        String attVal = webElement.getAttribute("src");
        RestAssured.get(attVal).then().assertThat().statusCode(200);
    }


}
