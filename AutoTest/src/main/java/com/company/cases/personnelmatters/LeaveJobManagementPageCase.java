package com.company.cases.personnelmatters;

import com.company.action.LoginPageAction;
import com.company.action.personnelmatters.LeaveJobManagementPageAction;
import com.company.cases.BaseCase;
import com.company.operation.DriverHelper;
import com.company.utils.exception.TextCheckException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LeaveJobManagementPageCase extends BaseCase {
    WebDriver driver;
    LeaveJobManagementPageAction action;

    @BeforeClass
    public void BeforeClass() {
        driver = DriverHelper.getInstance();
        new LoginPageAction(driver).loginAction();
        action = new LeaveJobManagementPageAction(driver);
        action.toThisPage();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 0 , description = "员工离职操作")
    public void testLeaveJobProcess() {
        action.doLeaveJobApply();
    }

    @Test(priority = 1 , description = "员工离职后已离职标签页验证")
    public void testCheckLeaveEmployee() throws TextCheckException {
        action.checkLeaveTabl();
    }

}
