package com.company.cases.personnelmatters;


import com.company.action.LoginPageAction;
import com.company.action.personnelmatters.PersonnelMattersAddPageAction;
import com.company.cases.BaseCase;
import com.company.operation.DriverHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PersonnelMattersAddPageCase extends BaseCase {

    WebDriver driver;

    @BeforeClass
    public void BeforeClass() {
        driver = DriverHelper.getInstance();
    }

    @Test(description = "添加新员工测试")
    @Step("创建新员工")
    public void testEntryNewEmployees() {
        new LoginPageAction(driver).loginAction();

        PersonnelMattersAddPageAction action = new PersonnelMattersAddPageAction(driver);
        action.toThisPage();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        action.entryBasicInformation();
        action.entryPersonalInformation();
        action.entryJobInformation();
        action.entryBankCardInformation();
        action.saveData();

    }


}
