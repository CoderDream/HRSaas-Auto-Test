package com.company.page;

import org.openqa.selenium.By;

/**
 * 工作台
 */
public class MainPage  {
    /*
    员工花名册
     */
    public static String employeeRosterText = "员工花名册";
    public static By employeeRosterPath = By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div[2]/div[1]/p");

    public static String PersonnelMattersAddText = "新增员工";
    public static By PersonnelMattersAddPath = By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div[2]/div[2]/p");

    public static String employeeRosterEntryText = "入职管理";
    public static By employeeRosterEntryPath = By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div[2]/div[3]/p");

    public static String employeeRosterPayCardText = "工资卡查询";
    public static By employeeRosterPayCardPath = By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div[2]/div[4]/p");

    public static String attendanceRulesText = "考勤规则设置";
    public static By attendanceRulesPath = By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div[2]/div[5]/p");

    public static String attendanceAdjustText = "员工考勤规则调整";
    public static By attendanceAdjustPath = By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div[2]/div[6]/p");

    public static String salaryRulesText = "计薪规则设置";
    public static By salaryRulesPath = By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div[2]/div[7]/p");

    public static String regulationAdjustmentText = "员工计薪规则调整";
    public static By regulationAdjustmentPath = By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div[2]/div[8]/p");

    public static String socialFundAdjustManagementText = "员工社保公积金调整";
    public static By socialFundAdjustManagementPath = By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div[2]/div[9]/p");

//    public static String noticeListText = "发布企业公告";
//    public static By noticeListPath = By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div[2]/a/div/p");

    public static String orgManaText = "组织机构管理";
    public static By orgManaPath = By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div[2]/div[10]/p");
}
