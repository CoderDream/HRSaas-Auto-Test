package com.company.action;


import com.company.operation.AssertOperation;
import com.company.operation.PageOperation;
import com.company.page.MainPage;
import com.company.utils.exception.TextCheckException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageAction implements BaseAction {
    PageOperation pageOperation;


    public MainPageAction(WebDriver driver) {
        this.pageOperation = new PageOperation(driver);
    }

    public void ShortcutTextCheck() throws TextCheckException {
        textCheck(MainPage.employeeRosterText,MainPage.employeeRosterPath);
        textCheck(MainPage.PersonnelMattersAddText,MainPage.PersonnelMattersAddPath);
        textCheck(MainPage.employeeRosterEntryText,MainPage.employeeRosterEntryPath);
        textCheck(MainPage.employeeRosterPayCardText,MainPage.employeeRosterPayCardPath);
        textCheck(MainPage.attendanceRulesText,MainPage.attendanceRulesPath);
        textCheck(MainPage.attendanceAdjustText,MainPage.attendanceAdjustPath);
        textCheck(MainPage.salaryRulesText,MainPage.salaryRulesPath);
        textCheck(MainPage.regulationAdjustmentText,MainPage.regulationAdjustmentPath);
        textCheck(MainPage.socialFundAdjustManagementText,MainPage.socialFundAdjustManagementPath);
//        textCheck(MainPage.noticeListText,MainPage.noticeListPath);
        textCheck(MainPage.orgManaText,MainPage.orgManaPath);
    }

    private void textCheck(String text, By element) throws TextCheckException {
        AssertOperation.textCheck(text,pageOperation.getTextByElement(element));
    }

    @Override
    public void toThisPage() {

    }
}
