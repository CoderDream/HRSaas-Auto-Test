package com.company.page.personnelmatters;

import org.openqa.selenium.By;

public class CompanyManagementListPage {
    public static By addNewCompany = By.xpath("//span[text()='新增用工单位']"); //	新增用工单位
    public static By companyName = By.xpath("//label[text()='用工单位名称']//following-sibling::div//input"); //	用工单位名称
    public static By workPlace = By.xpath("//label[text()='用工单位地点']//following-sibling::div//input"); //	用工单位地点
    public static By addressDetail = By.xpath("//label[text()='详细地址']//following-sibling::div//input"); //	详细地址
    public static By postCode = By.xpath("//label[text()='邮政编码']//following-sibling::div//input"); //	邮政编码
    public static By newSubDepartment = By.xpath("//li[contains(@data-id,',\"name\":\"中国联通\",')]"); //	新增子机构
}
