package com.solvd.carina.swaglabs;

import com.solvd.carina.demo.mobile.gui.pages.common.ChoosePageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.solvd.carina.demo.mobile.enums.PageOption;
import com.solvd.carina.demo.mobile.services.LoginService;
import com.solvd.carina.demo.mobile.gui.pages.common.ProductListPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.DrawPageBase;
import com.zebrunner.agent.core.annotation.TestCaseKey;

public class DrawingTest extends BaseTest {

    @Test
    @TestCaseKey("AYA-10")
    public void drawTest() {
        ProductListPageBase productsPageBase = LoginService.login(initPage(LoginPageBase.class), false);
        ChoosePageBase choosePageBase = productsPageBase.getHeaderMenu().clickHamburgerIcon();
        DrawPageBase drawPageBase = (DrawPageBase) choosePageBase.choosePage(PageOption.DRAWING);
        drawPageBase.drawCircle();
        Assert.assertTrue(drawPageBase.isPictureCorrect());
    }
}
