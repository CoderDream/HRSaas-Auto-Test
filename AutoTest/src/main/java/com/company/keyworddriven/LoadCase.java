package com.company.keyworddriven;


import com.company.operation.DriverHelper;
import com.company.operation.ExcelOperation;
import com.company.utils.exception.TextCheckException;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoadCase {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InterruptedException {
        DriverHelper.closeDriver();
        WebDriver driver = DriverHelper.getInstance();
        String casePath = "D:\\Projects\\AutoTest\\HRSaaS\\Case\\";
        List<String> cases = new ArrayList<String>(){
            {
//                add(casePath+"MainPageCase.xlsx");
//                add(casePath+"PersonnelMatters\\AddPageCase.xlsx");
//                add(casePath+"PersonnelMatters\\BecomeNormalManagementPageAction.xlsx");
//                add(casePath+"PersonnelMatters\\CompanyManagementListPageCase.xlsx");
//                add(casePath+"PersonnelMatters\\CompanyManagementAdjustListPageCase.xlsx");
//                add(casePath+"PersonnelMatters\\LeaveJobManagementPageCase.xlsx");
            }
        };
        try {
            String pagePath = "D:\\Projects\\AutoTest\\HRSaaS\\Page\\";
            String actionPath = "D:\\Projects\\AutoTest\\HRSaaS\\Action\\";
            // 局部变量存储
            Map<String, String> localParameterMap = new HashMap<>(5);
            localParameterMap.put("casePath", casePath);
            localParameterMap.put("pagePath", pagePath);
            localParameterMap.put("actionPath", actionPath);
            for(String path:cases){
                runOneCase(driver, path, pagePath, localParameterMap);
            }
        } catch (TextCheckException e) {
            e.printStackTrace();
        } finally {
//            DriverHelper.closeDriver();
        }
    }


    /**
     * 执行一个用例
     *
     * @param driver
     * @param casePath
     * @param pagePath
     * @param localParameterMap
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InterruptedException
     */
    public static void runOneCase(WebDriver driver, String casePath, String pagePath, Map<String, String> localParameterMap) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InterruptedException, TextCheckException {
        AnalyticCase analyticCase = new AnalyticCase(pagePath);
        List<CaseStep> stepsList = new ExcelOperation().getCaseStepsByExcel(casePath);
        for (CaseStep step : stepsList) {
            analyticCase.analyticCaseStep(step,localParameterMap);
            RunCase.runStep(step, driver, localParameterMap);
        }
    }
}