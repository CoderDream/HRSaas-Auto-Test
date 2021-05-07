package com.company.operation;

import com.company.keyworddriven.CaseStep;
import com.company.keyworddriven.VariableOperation;
import com.company.utils.exception.TextCheckException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.Map;

import static com.company.operation.OCROperation.ocrCheckCode;
import static com.company.utils.StringUtils.isEmpty;

/**
 * 页面操作get类
 */
public class PageGetOperation {

    public static String getTextByElement(CaseStep step, Map<String, String> variableMap) throws TextCheckException {
        LogOperation.log(String.format("get text %s ", step.getElement().toString()));
        String text = step.getElement().getText();
        VariableOperation.variableAssignment(text,step.getOperationValue(),variableMap);
        String expectedValue = VariableOperation.getVariableValue(step.getExpectedValue(),variableMap);
        if(!isEmpty(step.getExpectedValue())){
            AssertOperation.textCheck(text,expectedValue);
        }
        return text;
    }

    public static File getScreenshot(WebElement element) {
        return element.getScreenshotAs(OutputType.FILE);
    }

    public static String getOCR(CaseStep step, Map<String, String> map) {
        File file = getScreenshot(step.getElement());
        String ocrResult = ocrCheckCode(file);
        VariableOperation.variableAssignment(ocrResult,step.getOperationValue(),map);
        return ocrResult;
    }

    public static String getOperation(CaseStep step, Map<String, String> variableMap) throws TextCheckException {

        // 获取对象处理
        switch (step.getStepOperation()) {
            case "getOCR":
                return getOCR(step, variableMap);
            case "getTextByElement":
                return getTextByElement(step,variableMap);
            default:
                break;
        }
        return "";
    }

}
