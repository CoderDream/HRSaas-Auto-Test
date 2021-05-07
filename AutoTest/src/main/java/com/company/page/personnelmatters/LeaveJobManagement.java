package com.company.page.personnelmatters;

import org.openqa.selenium.By;

public class LeaveJobManagement {

    public static By InformalMember = By.xpath("//*[@id=\"tab-first\"]"); //	待离职标签
    //	已离职标签
    public static By fullMember = By.xpath("//*[@id=\"tab-second\"]");
    public static By name = By.xpath("//label[text()='姓名']//following-sibling::div//input"); //
    public static By name3 = By.xpath("(//label[text()='姓名']//following-sibling::div//input)[3]"); //
    public static By query = By.xpath("//span[text()='查询']"); //
    public static By query2 = By.xpath("(//span[text()='查询'])[2]"); //
    public static By reset = By.xpath("//span[text()='重置']"); //
    public static By leaveJobApply = By.xpath("//span[text()='办理离职']"); //	办理离职
    public static By leaveReason = By.xpath("//label[text()='离职原因']//following-sibling::div//textarea"); //	评价
    public static By submit = By.xpath("//*[@id=\"pane-first\"]//span[text()='确 定']"); //
    public static By submit2 = By.xpath("(//span[text()='确 定'])[2]"); //
    public static By submit3 = By.xpath("(//span[text()='确 定'])[3]"); //
    public static By firstQueryName = By.xpath("//*[@id=\"pane-second\"]/div/div[3]/div[1]/div[4]/div[2]/table/tbody/tr[1]/td[2]/div/button/span"); //	查询结果第一条
    public static By nameQueryButton = By.xpath("//*[@id=\"pane-first\"]/div/div[4]/div/div[2]/form/div[1]/div[1]/div/div/div/div/button"); //
    public static By firstQueryLine = By.xpath("/html/body/div[4]/div/div[2]/div[2]/div[1]/div[3]/table/tbody/tr/td[2]/div"); //
    public static By leaveDate = By.xpath("(//label[text()='离职日期']//following-sibling::div//input)[3]"); //	离职日期
    public static By salarySettlement = By.xpath("//label[text()='薪资结算日期']//following-sibling::div//input"); //	薪资结算日期
    public static By leaveType = By.xpath("//label[text()='离职类别']//following-sibling::div//input"); //	离职类别
    public static By passiveResignation = By.xpath("//span[text()='被动离职']"); //	被动离职
    public static By voluntaryResignation = By.xpath("//span[text()='主动离职']"); //	主动离职
    public static By cancelLeaveProcess3 = By.xpath("(//span[text()='放弃离职'])[3]"); //	放弃离职

}
