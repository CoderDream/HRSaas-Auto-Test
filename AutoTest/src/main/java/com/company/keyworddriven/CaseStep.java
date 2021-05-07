package com.company.keyworddriven;


import org.openqa.selenium.WebElement;

/**
 * 测试用例步骤
 */
public class CaseStep {

    /**
     * 步骤数
     */

    private Integer stepNum;

    /**
     * 测试用例描述
     */
    private String stepDescription;

    /**
     * 识别属性
     */
    private String attribute;

    /**
     * 对象名称
     */
    private String objectName;

    /**
     * 操作
     */
    private String stepOperation;


    /**
     * 操作值
     */
    private String operationValue;


    /**
     * 预期值
     */
    private String expectedValue;

    /**
     * analytic
     * @return
     */
    private boolean analyticResult;

    /**
     * web 元素对象
     * @return
     */
    private WebElement element;

    /**
     * 执行是否成功
     * @return
     */
    private boolean stepResult;

    /**
     * 执行结果信息
     * @return
     */
    private String stepLogInfo;

    public boolean isStepResult() {
        return stepResult;
    }

    public void setStepResult(boolean stepResult) {
        this.stepResult = stepResult;
    }

    public String getStepLogInfo() {
        return stepLogInfo;
    }

    public void setStepLogInfo(String stepLogInfo) {
        this.stepLogInfo = stepLogInfo;
    }

    public WebElement getElement() {
        return element;
    }

    public void setElement(WebElement element) {
        this.element = element;
    }

    public Integer getStepNum() {
        return stepNum;
    }

    public void setStepNum(Integer stepNum) {
        this.stepNum = stepNum;
    }

    public boolean AnalyticResult() {
        return analyticResult;
    }

    public void setAnalyticResult(boolean analyticResult) {
        this.analyticResult = analyticResult;
    }

    public String getStepDescription() {
        return stepDescription;
    }

    public void setStepDescription(String stepDescription) {
        this.stepDescription = stepDescription;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getStepOperation() {
        return stepOperation;
    }

    public void setStepOperation(String stepOperation) {
        this.stepOperation = stepOperation;
    }

    public String getOperationValue() {
        return operationValue;
    }

    public void setOperationValue(String operationValue) {
        this.operationValue = operationValue;
    }

    public String getExpectedValue() {
        return expectedValue;
    }

    public void setExpectedValue(String expectedValue) {
        this.expectedValue = expectedValue;
    }
}
