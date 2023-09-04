package com.team.selenium_pages.pages;


import com.team.selenium.BrowserAction;
import com.team.selenium.DriverPool;
import com.team.selenium.ElementWait;
import com.team.selenium.controls.api.ControlFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public abstract class BasePage {
    private final Logger logger;
    private final WebDriver webDriver;
    private final BrowserAction browserAction;

    private final ElementWait elementWait;

    public BasePage() {
        logger = LogManager.getLogger(this.getClass());
        this.webDriver = DriverPool.getInstance().getDriver(Thread.currentThread().getId());
        ControlFactory.initElements(this.webDriver, this);
        this.browserAction = new BrowserAction();
        this.elementWait = new ElementWait();
    }

    public <T extends BasePage> T goToPage(Class<T> tPageClass) throws IllegalAccessException, InstantiationException {
        return tPageClass.newInstance();
    }


    public Actions getActions() {
        return new Actions(webDriver);
    }

    public Logger getLogger() {
        return logger;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public BrowserAction getBrowserActions() {
        return browserAction;
    }

    public ElementWait getElementWait() {
        return elementWait;
    }


}
