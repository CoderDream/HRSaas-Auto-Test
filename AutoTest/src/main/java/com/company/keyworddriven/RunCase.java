package com.company.keyworddriven;

import com.company.operation.LogOperation;
import com.company.operation.PageGetOperation;
import com.company.operation.PageOperation;
import com.company.utils.exception.TextCheckException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import static com.company.keyworddriven.LoadCase.runOneCase;
import static com.company.utils.StringUtils.isEmpty;

/**
 * 执行用例
 */
public class RunCase {

    public static void runStep(CaseStep step, WebDriver driver, Map<String, String> localParameterMap) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException, InterruptedException, TextCheckException {
        String desc = step.getStepDescription();
        String attribute = step.getAttribute();
        String objectName = step.getObjectName();
        String stepOperation = step.getStepOperation();
        String operationValue = step.getOperationValue();
        String expectedValue = step.getExpectedValue();
        LogOperation.log("step " + step.getStepNum() + " " + desc);
        // 两个不为空 为元素层操作
        if (!isEmpty(attribute) && !isEmpty(objectName) && !isEmpty(stepOperation)) {
            step.setElement(getWebElement(driver, attribute, objectName));
            if (stepOperation.startsWith("get")) {
                PageGetOperation.getOperation(step, localParameterMap);
            } else {
                PageOperation.objectOperation(driver, step, localParameterMap);
            }
        } else if (isEmpty(attribute) && !isEmpty(stepOperation)) {
            if (stepOperation.equalsIgnoreCase("callAction") && !isEmpty(operationValue)) {
                runOneCase(driver, localParameterMap.get("actionPath") + operationValue + ".xlsx", localParameterMap.get("pagePath"), localParameterMap);
            } else if (stepOperation.equalsIgnoreCase("setVariable") && !isEmpty(operationValue)) {
                String[] values = operationValue.split("=");
                localParameterMap.put(values[0], values[1]);
            } else if (stepOperation.equalsIgnoreCase("wait") && !isEmpty(operationValue)) {
                LogOperation.log("暂停操作，等待 " + operationValue);
                Thread.sleep(Integer.parseInt(operationValue) * 1000);
            } else {
                //  通过反射执行方法
                Class<?> threadClazz = Class.forName("com.company.operation.BrowserOperation");
                Method method = threadClazz.getMethod(stepOperation, WebDriver.class, CaseStep.class);
                method.invoke(null, driver, step);
            }
        }
    }

    public static WebElement getWebElement(WebDriver driver, By by) {
        List<WebElement> we = driver.findElements(by);
        if (1 == we.size()) {
            return we.get(0);
        } else {
            LogOperation.log(by.toString()+ " 发现多个元素对象，尝试查找当前可操作的");
            for (WebElement element : we) {
                if (element.isDisplayed() && element.isEnabled()) {
                    return element;
                }
            }
        }

        if (we.size() > 0) {
            return we.get(0);
        }

        return null;
    }

    private static WebElement getWebElement(WebDriver driver, String attribute, String objectName) {
        try {
            List<WebElement> we = null;
            attribute = attribute.toLowerCase();
            // 处理WebElement对象定位
            switch (attribute) {
                case "id":
                    we = driver.findElements(By.id(objectName));
                    break;
                case "name":
                    we = driver.findElements(By.name(objectName));
                    break;
                case "xpath":
                    we = driver.findElements(By.xpath(objectName));
                    break;
                case "linktext":
                    we = driver.findElements(By.linkText(objectName));
                    break;
                case "tagname":
                    we = driver.findElements(By.tagName(objectName));
                    break;
                case "class":
                    we = driver.findElements(By.className(objectName));
                    break;
                case "cssselector":
                    we = driver.findElements(By.cssSelector(objectName));
                default:
                    break;
            }

            if (1 == we.size()) {
                return we.get(0);
            } else {
                LogOperation.log("发现多个元素对象，尝试查找当前可操作的");
                for (WebElement element : we) {
                    if (element.isDisplayed() && element.isEnabled()) {
                        return element;
                    }
                }
            }

        } catch (Exception e) {
            LogOperation.log("当前对象定位失败！");
            e.printStackTrace();
            return null;
        }
        return null;
    }

}
