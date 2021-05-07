package com.company.page.personnelmatters;

import org.openqa.selenium.By;

public class EntryManagementPage {

    // 待入职标签
    public static By firstTab = By.xpath("//*[@id=\"tab-first\"]");

            // 已入职标签
    public static By secondTab = By.xpath("//*[@id=\"tab-second\"]");
    public static By newEntry = By.xpath("//span[text()='新增已入职']");

}
