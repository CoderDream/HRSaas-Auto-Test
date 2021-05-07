package com.company.keyworddriven;

import com.company.operation.ExcelOperation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AnalyticCase {
    private String pagePath;
    private Map<String, List<PageElement>> pageInfoMap = new HashMap<>();

    public AnalyticCase(String pagePath) {
        this.pagePath = pagePath;
    }

    /**
     * 分析用例步骤
     * @param step
     * @throws IOException
     */
    public void analyticCaseStep(CaseStep step,Map<String, String> localParameterMap) throws IOException {
        // 获取用例信息 识别属性字段值
        String attribute = step.getAttribute();
        String objectName = step.getObjectName();
        // 如果时Page.开头代表需要读取Page信息
        if (attribute.startsWith("Page.")) {
            String pageName = step.getAttribute().substring(5);
            if (pageInfoMap.containsKey(pageName)) {
                List<PageElement> pageElementList = pageInfoMap.get(pageName);
                changeStepAttribute(step, pageElementList);
            } else {
                String filePath = pagePath + pageName.replace(".","/") + ".xlsx";
                List<PageElement> pageElementList = new ExcelOperation().getPageByExcel(filePath);
                pageInfoMap.put(pageName, pageElementList);
                changeStepAttribute(step, pageElementList);
            }
        }
        // 判断对象名称是否需要字符串处理
        if(objectName.contains("%s") && objectName.contains("|")){
            String[] values = objectName.split("\\|");
            List<String> valueList = new ArrayList<>();
            for(String value : values){
                valueList.add(VariableOperation.getVariableValue(value,localParameterMap));
            }
            step.setObjectName(String.format(valueList.get(0),valueList.subList(1,valueList.size()).toArray()));
        }
    }

    /**
     * 从 pageInfoMap 中转换元素
     * @param step
     * @param pageElementList
     * @throws IOException
     */
    private void changeStepAttribute(CaseStep step, List<PageElement> pageElementList) throws IOException {
        String objectName = step.getObjectName();
        Iterator<PageElement> iterator = pageElementList.listIterator();
        while (iterator.hasNext()) {
            PageElement pageElement = iterator.next();
            if (objectName.equalsIgnoreCase(pageElement.getElementName())) {
                step.setAttribute(pageElement.getAttribute());
                step.setObjectName(pageElement.getAttributeValue());
                return;
            }
        }
    }

}
