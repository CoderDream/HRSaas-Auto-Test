package com.company.action.personnelmatters;

import com.company.action.BaseAction;
import com.company.operation.AssertOperation;
import com.company.operation.PageOperation;
import com.company.page.NavigationBar;
import com.company.page.PersonnelMattersSubMenu;
import com.company.page.personnelmatters.LeaveJobManagement;
import com.company.utils.exception.TextCheckException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeaveJobManagementPageAction implements BaseAction {
    PageOperation pageOperation;

    public LeaveJobManagementPageAction(WebDriver driver) {
        this.pageOperation = new PageOperation(driver);
    }

    @Override
    public void toThisPage() {
        pageOperation.click(NavigationBar.webPersonnelManagement);
        pageOperation.click(PersonnelMattersSubMenu.leaveJobManagement);
    }

    public void searchByName() {
        pageOperation.sendKeyWithClear(LeaveJobManagement.name, "AutoBot001");
        pageOperation.click(LeaveJobManagement.query);
    }

    public void doLeaveJobApply() {
        pageOperation.click(LeaveJobManagement.leaveJobApply);
        pageOperation.click(LeaveJobManagement.nameQueryButton);
        pageOperation.sendKeyWithClear(LeaveJobManagement.name3, "AutoBot001");
        pageOperation.click(LeaveJobManagement.query2);
        pageOperation.click(LeaveJobManagement.firstQueryLine);
        pageOperation.click(LeaveJobManagement.submit3);
        pageOperation.sendKeys(LeaveJobManagement.leaveDate, "2021-04-01");
        pageOperation.sendKeys(LeaveJobManagement.salarySettlement, "2021-04-01");
        // 随便点击下，让时间弹窗消失
        pageOperation.click(By.xpath("//*[@id=\"pane-first\"]/div/div[4]/div/div[2]/form/div[1]/div[2]/div/div/div/input"));
        pageOperation.click(LeaveJobManagement.leaveType);
        pageOperation.click(LeaveJobManagement.passiveResignation);
        pageOperation.sendKeys(LeaveJobManagement.leaveReason, "办理离职");
        pageOperation.click(LeaveJobManagement.submit2);
    }

    public void checkLeaveTabl() throws TextCheckException {
        pageOperation.click(LeaveJobManagement.fullMember);
        searchByName();
        AssertOperation.textCheck("AutoBot001", pageOperation.getTextByElement(LeaveJobManagement.firstQueryName));
    }
}
