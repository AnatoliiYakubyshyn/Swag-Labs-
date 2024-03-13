package com.solvd.carina.swaglabs;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.solvd.carina.demo.mobile.enums.PageOption;
import com.solvd.carina.demo.mobile.services.LoginService;
import com.solvd.carina.demo.mobile.gui.pages.common.ProductsPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.DrawPageBase;
import com.zebrunner.agent.core.annotation.TestCaseKey;

public class DrawingTest extends BaseTest {

    @Test
    @TestCaseKey("AYA-10")
    public void drawTest() {
        ProductsPageBase productsPageBase = LoginService.login(initPage(LoginPageBase.class), false);
        DrawPageBase drawPageBase = (DrawPageBase) productsPageBase.getHeaderMenu().clickHamburgerIcon().choosePage(PageOption.DRAWING);
        drawPageBase.drawCircle();
        Assert.assertTrue(drawPageBase.isPictureCorrect());
    }
}
