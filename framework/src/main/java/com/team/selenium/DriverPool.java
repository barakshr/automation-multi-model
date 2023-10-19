package com.team.selenium;

import org.openqa.selenium.WebDriver;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class DriverPool {

    private static final Object mutex = new Object();
    private static DriverPool driverPool = null;
    private final Map<Long, WebDriver> driversMap = new ConcurrentHashMap<>();

    private DriverPool() {
    }

    public static DriverPool getInstance() {
        if (driverPool == null) {
            synchronized (mutex) {
                if (driverPool == null) {
                    driverPool = new DriverPool();
                }
            }
        }
        return driverPool;
    }

    public void setDriver(Long threadId, WebDriver webDriver) {
        driversMap.put(threadId, webDriver);
    }

    public WebDriver getDriver(Long threadId) {
        return driversMap.get(threadId);
    }

    public void closeDriver(Long threadId) {
        driversMap.get(threadId).quit();
    }
}
