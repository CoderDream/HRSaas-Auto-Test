package com.company.cases.personnelmatters;

import com.company.action.LoginPageAction;
import com.company.action.personnelmatters.BecomeNormalManagementPageAction;
import com.company.cases.BaseCase;
import com.company.operation.DriverHelper;
import com.company.utils.exception.TextCheckException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BecomeNormalManagementPageCase extends BaseCase {

    WebDriver driver;
    BecomeNormalManagementPageAction action;

    @BeforeClass
    public void BeforeClass() {
        driver = DriverHelper.getInstance();
        new LoginPageAction(driver).loginAction();
        action = new BecomeNormalManagementPageAction(driver);
        action.toThisPage();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(description = "员工转正操作")
    public void testBecomeNormalEmployee() {
        action.searchByName();
        action.becomeNormalOperation();
    }

    @Test(description = "员工转正后到已转正标签页验证")
    public void testCheckBecomeNormalEmployee() throws TextCheckException {
        action.checkNormalTabl();
    }


}
