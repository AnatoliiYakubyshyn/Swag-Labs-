package com.solvd.carina.demo.mobile.gui.pages.common;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

import java.time.Duration;

public abstract class DrawPageBase extends AbstractPage implements ICommonContent, IMobileUtils {
    public DrawPageBase(WebDriver driver) {
        super(driver);
    }

    protected abstract ExtendedWebElement getPictureElement();

    private void drawLine(int x, int y, int endx, int endy) {
        for (double t = 0; t <= 1; t += 0.2) {
            tap((int) (x + t * (endx - x)), (int) (y + t * (endy - y)), 15);
        }
    }

    public void drawCircle() {
        double radius = 100;
        for (double i = 0; i <= 2 * Math.PI; i += 0.3) {
            double x = getDriver().manage().window().getSize().getWidth() * 0.2 + 2 * radius + radius * Math.cos(i);
            double y = getDriver().manage().window().getSize().getHeight() * 0.21 + 2 * radius + radius * Math.sin(i);
            drawLine((int) (getDriver().manage().window().getSize().getWidth() * 0.2 + 2 * radius),
                    (int) (getDriver().manage().window().getSize().getHeight() * 0.21 + 2 * radius),
                    (int) x, (int) y);
        }
    }

    public boolean isPictureCorrect() {
        return getPictureElement().isPresent();
    }
}
