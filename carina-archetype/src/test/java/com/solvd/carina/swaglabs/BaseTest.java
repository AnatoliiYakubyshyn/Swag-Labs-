package com.solvd.carina.swaglabs;

import org.testng.annotations.BeforeMethod;

import com.solvd.carina.demo.utils.MobileContextUtils;
import com.zebrunner.carina.core.AbstractTest;
public class BaseTest extends AbstractTest {

    @BeforeMethod
    public void setUp() {
        MobileContextUtils contextUtils = new MobileContextUtils();
        contextUtils.switchMobileContext(MobileContextUtils.View.NATIVE);
    }
}
