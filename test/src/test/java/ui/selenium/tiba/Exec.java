package ui.selenium.tiba;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Exec extends BaseExperiment {

    @Test
    public void test() {
        getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
        getWebDriver().manage().window().fullscreen();
        getWebDriver().get("https://www.youtube.com");
        WebElement we = getWebDriver().findElement(By.xpath("//input[@id='search']"));
        we.sendKeys("I Will Survive - Alien song");
        getWebDriver().findElement(By.xpath("//*[@id='search-icon-legacy']/yt-icon/yt-icon-shape/icon-shape/div")).click();
        getWebDriver().findElement(By.xpath("//*[@id='filter-button']/ytd-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")).click();
        getWebDriver().findElement(By.xpath("//*[@id='options']/ytd-search-filter-group-renderer[2]/ytd-search-filter-renderer[1]/a/div")).click();
        getWebDriver().findElement(By.xpath("//*[@id='filter-button']/ytd-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")).click();
        getWebDriver().findElement(By.xpath("//*[@id='options']/ytd-search-filter-group-renderer[5]/ytd-search-filter-renderer[3]/a/div")).click();
        WebElement song = getWebDriver().findElements(By.xpath("//a[contains(@href, 'watch?v=ybXrrTX3LuI')]")).get(1);
        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].scrollIntoView();", song);
        String channelName = getWebDriver().findElement(with(By.xpath("//div[@class='text-wrapper style-scope ytd-video-renderer']")).near(song)).findElement(By.id("channel-info")).getText();
//
//
//        song.click();
//        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(8));
//        try {
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ytp-ad-text ytp-ad-skip-button-text-centered ytp-ad-skip-button-text']")));
//            WebElement skip = getWebDriver().findElement(By.xpath("//div[@class='ytp-ad-text ytp-ad-skip-button-text-centered ytp-ad-skip-button-text']"));
//            skip.click();
//        } catch (NoSuchElementException | TimeoutException ignore) {
//
//        }
//
//        getWebDriver().findElement(By.id("expand")).click();
//        String s = getWebDriver().findElement(By.className("yt-video-attribute-view-model__subtitle")).getText();
//        int y = 0;
    }
}
