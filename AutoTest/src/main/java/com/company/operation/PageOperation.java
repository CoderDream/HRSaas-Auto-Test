package com.company.operation;

import com.company.keyworddriven.CaseStep;
import com.company.keyworddriven.RunCase;
import com.company.keyworddriven.VariableOperation;
import com.company.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Map;

/**
 * 页面操作类
 */
public class PageOperation {

    WebDriver driver;

    public PageOperation(WebDriver driver) {
        this.driver = driver;
    }


    public void click(By by) {
        WebElement element = RunCase.getWebElement(driver, by);
        click(element);
    }

    public  void click(By by, long millis) {
        LogOperation.log(String.format("click %s after %d ms", by.toString(), millis));
        try {
            Thread.sleep(millis);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement element = RunCase.getWebElement(driver, by);
        click(element);
    }

    public static void click(WebElement element) {
        if (!element.isDisplayed() || !element.isEnabled()) {
            LogOperation.log(String.format("element is not displayed or enabled, wait %d ms", Constants.defaultTimeOut));
            try {
                Thread.sleep(Constants.defaultTimeOut);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        click(element, 0L);
    }

    public static void click(WebElement element, long millis) {
        LogOperation.log(String.format("click %s after %d ms", element.toString(), millis));
        try {
            Thread.sleep(millis);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        element.click();
    }

    public static void sendKeys(WebElement element, String data) {
        LogOperation.log(String.format("sendKey %s to %s ", data, element.toString()));
        element.sendKeys(data);
    }

    public static void sendKeys(CaseStep step, Map<String, String> variableMap) {
        String value = VariableOperation.getVariableValue(step.getOperationValue(), variableMap);
        sendKeys(step.getElement(), value);
    }

    public static void sendKeysWithClear(WebElement element, String data) {
        clear(element);
        sendKeys(element, data);
    }

    public void sendKeyWithClear(By by, String str) {
        WebElement element = RunCase.getWebElement(driver, by);
        sendKeysWithClear(element, str);
    }

    public void sendKeys(By by, String str) {
        WebElement element = RunCase.getWebElement(driver, by);
        sendKeys(element, str);
    }


    public static void clear(WebElement element) {
        LogOperation.log(String.format("clear content %s ", element.toString()));
        element.clear();
    }


    /**
     * 在自动化过程中加入点击显示效果
     */
    public static void highLightElement(WebDriver driver, WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            /*调用js将传入参数的页面元素对象的背景颜色和边框颜色分别设定为黄色和红色*/
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "background: green; border:2px solid red;");
        } catch (JavascriptException e) {
            e.printStackTrace();
        }
    }


    /**
     * 鼠标悬停
     *
     * @param driver
     * @param step
     */
    public static void mouseOnElement(WebDriver driver, CaseStep step) {
        LogOperation.log("mouseOnElement");
        Actions actions = new Actions(driver);
        actions.moveToElement(step.getElement()).perform();
    }


    public static void objectOperation(WebDriver driver, CaseStep step, Map<String, String> variableMap) {
        String result = "";
        // 处理WebElement对象操作
        switch (step.getStepOperation().toLowerCase()) {
            case "click":
                click(step.getElement());
                break;
            case "sendkeys":
                sendKeys(step, variableMap);
                break;
            case "clear":
                step.getElement().clear();
                break; // 清空输入框
            case "mouseonelement":
                mouseOnElement(driver, step);
                break; // 清空输入框
            case "gotoframe":
                driver.switchTo().frame(step.getElement());
                break;
            case "isenabled":
                LogOperation.log("获取到的值是【" + step.getElement().isEnabled() + "】");
                break;
            case "isdisplayed":
                LogOperation.log("获取到的值是【" + step.getElement().isDisplayed() + "】");
                break;
            case "exjsob":
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                Object obj = jse.executeScript(step.getOperationValue(), step.getElement());
                if (null != obj) {
                    String tmp = obj.toString();
                    result = (100 < tmp.length()) ? tmp.substring(0, 100) + "..." : tmp;
                    LogOperation.log("获取到的值是【" + result + "】");
                } else {
                    LogOperation.log("执行JS...【" + step.getOperationValue() + "】");
                }
                break;
            case "scrollto":
                Point location = step.getElement().getLocation();
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(" + location.getX() + ", " + location.getY() + ")");
                break;
            case "scrollintoview":
                // 此方法可以用执行js命令来代替
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(" + step.getOperationValue() + ")", step.getElement());
                break;
            default:
                break;
        }
    }

    public String getTextByElement(By element) {
        return RunCase.getWebElement(driver, element).getText();
    }


}
