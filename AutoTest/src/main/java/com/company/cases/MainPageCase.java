package com.company.cases;

import com.company.action.LoginPageAction;
import com.company.action.MainPageAction;
import com.company.listenner.TestFailListener;
import com.company.operation.DriverHelper;
import com.company.utils.exception.TextCheckException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestFailListener.class})
public class MainPageCase extends BaseCase{
    WebDriver driver;

    @BeforeClass
    public void BeforeClass() {
        driver = DriverHelper.getInstance();
    }

    @Test(description = "工作台快捷方式文本验证")
    public void testMainPage() throws TextCheckException {
        new LoginPageAction(driver).loginAction();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MainPageAction mainPageAction = new MainPageAction(driver);
        mainPageAction.toThisPage();
        mainPageAction.ShortcutTextCheck();

    }

}
