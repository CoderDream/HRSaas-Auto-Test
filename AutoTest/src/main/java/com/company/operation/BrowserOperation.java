package com.company.operation;

import com.company.keyworddriven.CaseStep;
import org.openqa.selenium.WebDriver;

/**
 * 浏览器操作
 */
public class BrowserOperation {
    WebDriver driver;

    public BrowserOperation(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * 打开浏览器
     *
     * @param driver
     * @param step
     */
    public static void open(WebDriver driver, CaseStep step) {
        LogOperation.log("Visit the website : " + step.getOperationValue());
        driver.get(step.getOperationValue());
    }

    /**
     * 打开浏览器并最大化
     *
     * @param driver
     * @param step
     */
    public static void openAndMax(WebDriver driver, CaseStep step) {
        open(driver, step);
        driver.manage().window().maximize();
    }


    public void openAndMax(String loginUrl) {
        driver.get(loginUrl);
        driver.manage().window().maximize();
    }
}
