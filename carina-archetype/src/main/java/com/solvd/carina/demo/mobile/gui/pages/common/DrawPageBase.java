package com.solvd.carina.demo.mobile.gui.pages.common;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

public abstract class DrawPageBase extends AbstractPage implements ICommonContent, IMobileUtils {
    public DrawPageBase(WebDriver driver) {
        super(driver);
    }

    protected abstract ExtendedWebElement getPictureElement();

    public void drawCircle() {
        double radius = 150;
        for (double i = 0; i <= 2 * Math.PI; i += 0.05) {
            double x = getDriver().manage().window().getSize().getWidth() * 0.5 + radius * Math.cos(i);
            double y = getDriver().manage().window().getSize().getHeight() * 0.5 + radius * Math.sin(i);
            tap((int) x, (int) y, 10);
        }
    }

    public boolean isPictureCorrect() {
        return getPictureElement().isPresent();
    }
}
