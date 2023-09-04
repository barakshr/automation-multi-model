package com.team.selenium;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.log.Log;
import org.openqa.selenium.edge.EdgeDriver;

public class CdpRegistration {

    private final static Logger logger = LogManager.getLogger(CdpRegistration.class);
    private final WebDriver webDriver;

    CdpRegistration() {
        this.webDriver = DriverPool.getInstance().getDriver(Thread.currentThread().getId());
    }

    public void browserLogsRegistration() {
        if (webDriver instanceof ChromeDriver) {
            cdpLogs(((ChromeDriver) webDriver).getDevTools());
        }

        if (webDriver instanceof EdgeDriver) {
            cdpLogs(((EdgeDriver) webDriver).getDevTools());
        }
    }

    private void cdpLogs(DevTools devTools) {
        devTools.createSession();
        devTools.send(Log.enable());
        devTools.addListener(Log.entryAdded(), logEntry -> {
            logger.info("--------Browser Console Log Start-------");
            logger.info("Level: " + logEntry.getLevel());
            logger.info("Text: " + logEntry.getText());
            logger.info("Broken URL: " + logEntry.getUrl());
            logger.info("--------Browser Console Log End---------");
        });
    }

}
