package com.company.action.personnelmatters;


import com.company.action.BaseAction;
import com.company.operation.PageOperation;
import com.company.page.NavigationBar;
import com.company.page.PersonnelMattersSubMenu;
import com.company.page.personnelmatters.AddPage;
import com.company.page.personnelmatters.EntryManagementPage;
import org.openqa.selenium.WebDriver;

import static com.company.utils.Constants.millis_3k;
import static com.company.utils.StringUtils.getChinese;
import static com.company.utils.StringUtils.getEmail;
import static com.company.utils.StringUtils.getLandlineNum;
import static com.company.utils.StringUtils.getPhoneNum;
import static com.company.utils.StringUtils.getRandomNumStr;

public class PersonnelMattersAddPageAction implements BaseAction {
    PageOperation pageOperation;

    public PersonnelMattersAddPageAction(WebDriver driver) {
        this.pageOperation = new PageOperation(driver);
    }

    public void toThisPage() {
        pageOperation.click(NavigationBar.webPersonnelManagement);
        pageOperation.click(PersonnelMattersSubMenu.entryManagement);
        pageOperation.click(EntryManagementPage.secondTab,millis_3k);
        pageOperation.click(EntryManagementPage.newEntry);
    }

    public void entryBasicInformation() {
        // 输入姓名
        pageOperation.sendKeyWithClear(AddPage.name, "AutoBot001");

        pageOperation.sendKeyWithClear(AddPage.employeeId, getRandomNumStr(10));

        //输入手机号
        pageOperation.sendKeyWithClear(AddPage.phoneNum, getPhoneNum());

        //输入部门
        pageOperation.click(AddPage.department);
        pageOperation.click(AddPage.departmentMenu);

        //输入岗位
        pageOperation.click(AddPage.post);
        pageOperation.click(AddPage.postRe);

        //输入座机号
        pageOperation.sendKeyWithClear(AddPage.landlineNum, getLandlineNum());

        //工作邮件
        pageOperation.sendKeyWithClear(AddPage.workMail, getEmail());

        //备注
        pageOperation.sendKeyWithClear(AddPage.remark, getRandomNumStr((int) (Math.random()*100)));


        //面试时间
        pageOperation.sendKeys(AddPage.interviewTime, "2021-03-01");

    }


    public void entryPersonalInformation() {
        //输入身份证号码
        pageOperation.sendKeyWithClear(AddPage.idCardNum, "61082819420210373X");
        //身份证地址
        pageOperation.sendKeyWithClear(AddPage.idCardAddress,getChinese());
        // 民族
        pageOperation.click(AddPage.nation);
        pageOperation.click(AddPage.nationRe);
        // 未婚
        pageOperation.click(AddPage.unmarriedRadio);
        // 已育
        pageOperation.click(AddPage.haveChildRadio);
        // 政治面貌
        pageOperation.click(AddPage.political);
        pageOperation.click(AddPage.politicalRe);
        // 个人邮箱
        pageOperation.sendKeyWithClear(AddPage.personnelMail,getEmail());
        // 首次工作时间
        pageOperation.sendKeys(AddPage.firstWorkingTime, "2008-03-01");
        // 户籍城市
        pageOperation.sendKeyWithClear(AddPage.registeredResidenceCity,"湖北 武汉");
        // 户籍性质
        pageOperation.click(AddPage.registeredResidenceNature);
        pageOperation.click(AddPage.RegisteredResidenceNatureRe);

        //现住址
        pageOperation.sendKeyWithClear(AddPage.residentialAddress,getChinese());


    }

    public void entryJobInformation() {
        //纳税人身份
        pageOperation.click(AddPage.taxpayerStatus);
        pageOperation.click(AddPage.taxpayerStatusRe);

        //用工关系
        pageOperation.click(AddPage.employmentRelationship);
        pageOperation.click(AddPage.employmentRelationshipRe);

        //入职日期
        pageOperation.sendKeys(AddPage.entryDate, "2021-03-01");

        //员工类型
        pageOperation.click(AddPage.employeeType);
        pageOperation.click(AddPage.employeeTypeRe);

        //员工状态
        pageOperation.click(AddPage.employeeStatus);
        pageOperation.click(AddPage.employeeStatusRe);

        //试用期
        pageOperation.sendKeyWithClear(AddPage.probationPeriod, "3");

    }

    public void entryBankCardInformation() {
        pageOperation.sendKeyWithClear(AddPage.bankCard,getRandomNumStr(15));
        pageOperation.sendKeyWithClear(AddPage.bank,getChinese());

    }

    public void saveData() {
        pageOperation.click(AddPage.saveBtn);
    }

}
