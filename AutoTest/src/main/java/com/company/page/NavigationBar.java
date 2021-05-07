package com.company.page;

import org.openqa.selenium.By;

/**
 * 导航栏
 */
public class NavigationBar {
    /**
     * 工作台
     */
    public static By WebMainPage = By.xpath("//*[@id=\"topMenu\"]/li[1]");

    /**
     * 人事管理
     */
    public static By webPersonnelManagement= By.xpath("//*[@id=\"topMenu\"]/li[2]");

    /**
     * 考勤管理
     */
    public static By webAttendance = By.xpath("//*[@id=\"topMenu\"]/li[3]");

    /**
     * 薪酬管理
     */
    public static By webPayManage = By.xpath("//*[@id=\"topMenu\"]/li[4]");

    /**
     * 企业设置
     */
    public static By webPersonnelMattersEmployeeInfo = By.xpath("//*[@id=\"topMenu\"]/li[5]");
}
