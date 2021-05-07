package com.company.page.personnelmatters;

import org.openqa.selenium.By;

public class BecomeNormalManagement {

    public static By InformalMember = By.xpath("//*[@id=\"tab-first\"]"); // 待转正标签
    public static By fullMember = By.xpath("//*[@id=\"tab-second\"]"); // 已转正标签
    public static By name = By.xpath("//label[text()='姓名']//following-sibling::div//input"); //
    public static By query = By.xpath("//span[text()='查询']"); //
    public static By reset = By.xpath("//span[text()='重置']"); //
    public static By employmentApply = By.xpath("//*[@id=\"pane-first\"]/div/div[3]/div[1]/div[5]/div[2]/table/tbody/tr/td[12]/div/button/span"); //
    public static By appraise = By.xpath("//label[text()='转正评价']//following-sibling::div//textarea"); // 评价
    public static By submit = By.xpath("//*[@id=\"pane-first\"]//span[text()='确 定']"); //
    public static By firstQueryName = By.xpath("//*[@id=\"pane-second\"]/div/div[3]/div[1]/div[4]/div[2]/table/tbody/tr[1]/td[1]/div/button/span"); // 查询结果第一条

}
