package com.company.page;

import org.openqa.selenium.By;

public class PersonnelMattersSubMenu {

    public static By employeeRoster = By.xpath("//*[@id=\"leftMenu\"]/li[1]/ul/li/ul/li[1]"); //	员工花名册
    public static By entryManagement = By.xpath("//*[@id=\"leftMenu\"]/li[1]/ul/li/ul/li[2]"); //	入职管理
    public static By becomeNormalManagement = By.xpath("//*[@id=\"leftMenu\"]/li[1]/ul/li/ul/li[3]"); //	转正管理
    public static By leaveJobManagement = By.xpath("//*[@id=\"leftMenu\"]/li[1]/ul/li/ul/li[4]"); //	离职管理
    public static By HRChangesSearch = By.xpath("//*[@id=\"leftMenu\"]/li[1]/ul/li/ul/li[5]"); //	人事异动查询
    public static By CompanyManagementList = By.xpath("//*[@id=\"leftMenu\"]/li[2]/ul/li/ul/li[1]"); //	用工单位管理
    public static By CompanyManagementAdjustList = By.xpath("//*[@id=\"leftMenu\"]/li[2]/ul/li/ul/li[2]"); //	员工用工单位调整

}
