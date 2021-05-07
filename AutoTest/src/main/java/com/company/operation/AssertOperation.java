package com.company.operation;

import com.company.utils.exception.TextCheckException;
import org.testng.Assert;

/**
 * 断言验证类
 */
public class AssertOperation {

    public static void textCheck(String actualValue, String expectedValue) throws TextCheckException {
        // 断言会抛出Error 暂时捕获住
        try {
            LogOperation.log(String.format("assert string value %s and %s",actualValue,expectedValue));
            Assert.assertEquals(actualValue, expectedValue);
        } catch (Error a) {
            LogOperation.log(a.getMessage());
            throw new TextCheckException(a.getMessage());
        }
    }
}
