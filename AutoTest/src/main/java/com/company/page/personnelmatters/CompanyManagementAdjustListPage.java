package com.company.page.personnelmatters;

import org.openqa.selenium.By;

public class CompanyManagementAdjustListPage {
    public static By noWorkTab = By.xpath("//*[@id=\"tab-first\"]"); //	未上工标签页
    public static By workTab = By.xpath("//*[@id=\"tab-second\"]"); //	已上工标签页
    public static By setWorkBatch = By.xpath("//span[text()='批量上工']"); //	批量上工按钮
    public static By setWorkButton = By.xpath("//span[text()=' 上工 ']"); //	上工
    public static By setNoWorkButton = By.xpath("//span[text()='下工']"); //	下工
    public static By selectButton = By.xpath("//span[text()='选择']"); //	选择上工单位
    public static By seachWorkInput = By.xpath("//*[@id=\"pane - first\"]/div/div[6]/div/div/div[2]/div/div/div[1]/input"); //	上工单位搜索框
    public static By submitButton = By.xpath("//span[text()='确 定']"); //	搜索确认按钮
    public static By setReson = By.xpath("//label[text()='调整原因']//following-sibling::div//textarea"); //	调整原因
    public static By effectiveDate = By.xpath("//label[text()='生效日期']//following-sibling::div//input"); //	生效日期
    public static By nameSearchInput = By.xpath("//label[text()='姓名']//following-sibling::div//input"); //	姓名搜索框
    public static By searchButton = By.xpath("//span[text()='查询']"); //	查询按钮

}
