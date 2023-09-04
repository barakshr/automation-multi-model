package ui.selenium;



//import io.qameta.allure.Allure;
import com.team.selenium.DriverPool;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.io.File;


public class Listener implements ITestListener, WebDriverListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(Listener.class.getName());


    @Override
    public void beforeFindElement(WebElement element, By locator) {
        LOGGER.info("finding element: {}", element.getText());
    }

    @Override
    public void beforeClick(WebElement element) {
        LOGGER.debug("clicking on  element: {}", element.getText());
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        WebDriver webDriver = DriverPool.getInstance().getDriver(Thread.currentThread().getId());
        try {
            takeSnapShot(webDriver);
        } catch (Exception e) {
            throw new RuntimeException("failure while taking screenshot");
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
    }

    private void takeSnapShot(WebDriver webdriver) throws Exception {
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        ByteArrayInputStream imageAsByteArrayIS = new ByteArrayInputStream(FileUtils.readFileToByteArray(srcFile));
     //   Allure.addAttachment("Some Screenshot", imageAsByteArrayIS);
    }
}
