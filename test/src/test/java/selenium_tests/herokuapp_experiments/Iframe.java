package selenium_tests.herokuapp_experiments;


import com.team.selenium.DriverPool;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Iframe  {

    @Test
    public void iframe_html_inside_html() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));

        webDriver.get("https://the-internet.herokuapp.com/nested_frames");
        WebElement frame = webDriver.findElement(By.className("tox-edit-area__iframe"));
        //*
        webDriver.switchTo().frame(frame);
        webDriver.findElement(By.id("tinymce")).clear();
        webDriver.findElement(By.id("tinymce")).sendKeys("hello");
        //*
        webDriver.switchTo().parentFrame();
    }

    @Test
    public void frames_inside_frames_top_middle() {
        WebDriver webDriver = DriverPool.getInstance().getDriver(Thread.currentThread().getId());
        webDriver.get("https://the-internet.herokuapp.com/nested_frames");

        //*top_middle frame
        WebElement topElementFrame = webDriver.findElement(By.name("frame-top"));
        webDriver.switchTo().frame(topElementFrame);

        //top frame
        WebElement topMiddleElementFrame = webDriver.findElement(By.name("frame-middle"));
        webDriver.switchTo().frame(topMiddleElementFrame);

        //middle frame inside top
        WebElement middle = webDriver.findElement(By.id("content"));
        System.out.println(middle.getText());
        webDriver.switchTo().parentFrame().switchTo().parentFrame();
    }

    @Test
    public void frames_inside_frames_bottom() {
        WebDriver webDriver = DriverPool.getInstance().getDriver(Thread.currentThread().getId());
        webDriver.get("https://the-internet.herokuapp.com/nested_frames");
        //*bottom frame
        WebElement bottomFrameElement = webDriver.findElement(By.name("frame-bottom"));
        webDriver.switchTo().frame(bottomFrameElement);
        WebElement frameBottomElement = webDriver.findElement(By.tagName("body"));
        String bottom = frameBottomElement.getText();
        System.out.println(bottom);
        webDriver.switchTo().parentFrame();
    }
}
