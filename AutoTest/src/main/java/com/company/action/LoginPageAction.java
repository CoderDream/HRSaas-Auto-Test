package com.company.action;

import com.company.operation.BrowserOperation;
import com.company.operation.OCROperation;
import com.company.operation.PageGetOperation;
import com.company.operation.PageOperation;
import com.company.keyworddriven.RunCase;
import com.company.page.common.LoginPage;
import com.company.utils.Constants;
import org.openqa.selenium.WebDriver;

public class LoginPageAction implements BaseAction {
    PageOperation pageOperation;
    BrowserOperation browserOperation;
    WebDriver driver;


    public LoginPageAction(WebDriver driver) {
        this.pageOperation = new PageOperation(driver);
        this.browserOperation = new BrowserOperation(driver);
        this.driver = driver;
    }

    /**
     * 输入用户名称
     */
    public void inputUserName() {
        pageOperation.sendKeyWithClear(LoginPage.usernameInput, Constants.user);
    }

    /**
     * 输入用户密码
     */
    public void inputPassWd() {
        pageOperation.sendKeyWithClear(LoginPage.passwordInput, Constants.passwd);
    }

    /**
     * 输入验证码
     */
    public void inputCheckCode() {
        String checkCode = OCROperation.ocrCheckCode(PageGetOperation.getScreenshot(RunCase.getWebElement(driver, LoginPage.checkCodeUrl)));

        pageOperation.sendKeyWithClear(LoginPage.checkCodeInput, checkCode);

    }

    public void clickLoginBtn() {
        pageOperation.click(LoginPage.loginButton);
    }



    public void loginAction() {
        toThisPage();
        inputUserName();
        inputPassWd();
        // 登录页面验证码操作
        inputCheckCode();
        clickLoginBtn();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void toThisPage() {
        browserOperation.openAndMax(Constants.LoginUrl);
    }
}
