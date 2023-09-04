package com.team.selenium;

import com.team.selenium.properties.PropertiesHandler;
import com.team.selenium.properties.Settings;

public class DriverHandler {

    public DriverHandler() {
    }

    public void startDriver() throws Exception {
        PropertiesHandler.readProperties();
        new WebDriverFactory().openNewWebDriver(Settings.BrowserType);
        BrowserAction browserAction = new BrowserAction();
        CdpRegistration cdpRegistration = new CdpRegistration();
        cdpRegistration.browserLogsRegistration();
        browserAction.maximize();
        browserAction.goToUrl(Settings.AUT);
    }

    public void closeDriver() {
        DriverPool.getInstance().closeDriver(Thread.currentThread().getId());
    }

}
