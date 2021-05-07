package com.company.operation;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * 驱动管理
 */
public class DriverHelper {
    private static WebDriver driver = null;

    private DriverHelper() {

    }

    public static synchronized WebDriver getInstance() {
        if (driver == null) {
            //设置系统变量,并设置chromedriver的路径为系统属性值
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            ChromeOptions chromeOptions = new ChromeOptions();
            Dimension dimension = new Dimension(1920, 1080);
            // 设置后台静默模式启动浏览器
             chromeOptions.addArguments("--headless");
            //实例ChromeDriver
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().setSize(dimension);
        }
        return driver;
    }

    public static void closeDriver() {
        if (null != driver) {
            driver.close();
            driver.quit();
            driver = null;
        }
    }
}
