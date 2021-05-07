package com.company.action.personnelmatters;

import com.company.action.BaseAction;
import com.company.operation.AssertOperation;
import com.company.operation.PageOperation;
import com.company.page.NavigationBar;
import com.company.page.PersonnelMattersSubMenu;
import com.company.page.personnelmatters.BecomeNormalManagement;
import com.company.utils.exception.TextCheckException;
import org.openqa.selenium.WebDriver;

public class BecomeNormalManagementPageAction implements BaseAction {
    PageOperation pageOperation;

    public BecomeNormalManagementPageAction(WebDriver driver) {
        this.pageOperation = new PageOperation(driver);
    }


    @Override
    public void toThisPage() {
        pageOperation.click(NavigationBar.webPersonnelManagement);
        pageOperation.click(PersonnelMattersSubMenu.becomeNormalManagement);
    }

    public void searchByName(){
        pageOperation.sendKeyWithClear(BecomeNormalManagement.name,"AutoBot001");
        pageOperation.click(BecomeNormalManagement.query);
    }

    public void becomeNormalOperation(){
        pageOperation.click(BecomeNormalManagement.employmentApply);
        pageOperation.sendKeyWithClear(BecomeNormalManagement.appraise,"提前转正");
        pageOperation.click(BecomeNormalManagement.submit);
    }

    public void checkNormalTabl() throws TextCheckException {
        pageOperation.click(BecomeNormalManagement.fullMember);
        searchByName();
        AssertOperation.textCheck("AutoBot001",pageOperation.getTextByElement(BecomeNormalManagement.firstQueryName));
    }
}
