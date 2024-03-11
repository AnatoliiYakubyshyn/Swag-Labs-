package com.solvd.carina.demo.utils;

import java.lang.invoke.MethodHandles;
import java.time.Duration;
import java.util.Set;

import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.config.WebDriverConfiguration;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.ContextAware;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.decorators.Decorated;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zebrunner.carina.webdriver.DriverHelper;
import com.zebrunner.carina.webdriver.IDriverPool;

import io.appium.java_client.remote.SupportsContextSwitching;

public class MobileContextUtils implements IDriverPool {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    /**
     * Returns a pure driver without listeners
     */
    public WebDriver getPureDriver(WebDriver driver) {
        if (driver instanceof Decorated<?>) {
            driver = (WebDriver) ((Decorated<?>) driver).getOriginal();
        }
        return driver;
    }

    private boolean predicateForContext(WebDriver driver,
                                        View context, View exclude) {
        DriverHelper help = new DriverHelper();
        Set<String> contextHandles = help.performIgnoreException(((ContextAware) driver)::getContextHandles);
        for (String cont : contextHandles) {
            if (cont.contains(context.getView())) {
                if (exclude != null && cont.contains(exclude.getView())) {
                    continue;
                }
                return true;
            }
        }
        return false;
    }

    private void waitForMoreThanOneContextToAppear(WebDriver driver,
                                                   View context, View exclude
    ) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(Configuration.get(WebDriverConfiguration.Parameter.EXPLICIT_TIMEOUT).get())),
                Duration.ofMillis(100));
        wait.until(input -> predicateForContext(input, context, exclude));
    }

    public void switchMobileContext(View context) {
        switchMobileContext(context, null);
    }

    public void switchMobileContext(View context, View exclude) {
        WebDriver driver = getDriver();
        waitForMoreThanOneContextToAppear(driver, context, exclude);
        DriverHelper help = new DriverHelper();
        Set<String> contextHandles = help.performIgnoreException(((ContextAware) driver)::getContextHandles);
        String desiredContext = "";
        boolean isContextPresent = false;
        LOGGER.info("Existing contexts: ");
        for (String cont : contextHandles) {
            if (cont.contains(context.getView())) {
                if (exclude != null && cont.contains(exclude.getView())) {
                    continue;
                }
                desiredContext = cont;
                isContextPresent = true;
            }
            LOGGER.info(cont);
        }
        if (!isContextPresent) {
            throw new NotFoundException("Desired context is not present");
        }
        LOGGER.info("Switching to context : " + desiredContext);
        ((SupportsContextSwitching) driver).context(desiredContext);
    }

    public enum View {
        NATIVE("NATIVE_APP"),
        WEB_CARINA("WEBVIEW_com.solvd.carinademoapplication"),

        WEB_BROWSER("WEBVIEW"),

        WEB_CHROME("WEBVIEW_chrome"),

        WEB_SAFARI("WEB_safari");

        String viewName;

        View(String viewName) {
            this.viewName = viewName;
        }

        public String getView() {
            return this.viewName;
        }
    }

}
