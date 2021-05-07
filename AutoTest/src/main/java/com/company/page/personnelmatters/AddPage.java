package com.company.page.personnelmatters;

import org.openqa.selenium.By;

/**
 * 人事管理-入职管理
 */
public class AddPage {

    public static By name	=  By.xpath("//label[text()='姓名']//following-sibling::div//input"); //	姓名
    // 员工号
    public static By employeeId	=  By.xpath("//label[text()='员工号']//following-sibling::div//input"); //	姓名
    public static By phoneNum	=  By.xpath("//label[text()='手机号']//following-sibling::div//input"); //	手机号
    public static By department	=  By.xpath("//label[text()='部门']//following-sibling::div//input"); //	部门
    public static By departmentMenu	=  By.xpath("//span[text()='AutoBot Company']//preceding-sibling::label"); //	部门菜单
    public static By post	=  By.xpath("//label[text()='岗位']//following-sibling::div//input"); //	岗位
    public static By postRe	=  By.xpath("//span[text()='AutoBot Engineer']"); //	岗位菜单
    public static By landlineNum	=  By.xpath("//label[text()='座机号']//following-sibling::div//input"); //	座机号
    public static By workMail	=  By.xpath("//label[text()='工作邮箱']//following-sibling::div//input"); //	工作邮箱
    public static By remark	=  By.xpath("//label[text()='备注']//following-sibling::div//textarea"); //	备注
    // 面试时间
    public static By interviewTime =  By.xpath("//label[text()='面试时间']//following-sibling::div//input");
    public static By idCardNum	=  By.xpath("//label[text()='证件号码']//following-sibling::div//input"); //	身份证号码
    public static By idCardAddress	=  By.xpath("//label[text()='身份证地址']//following-sibling::div//input"); //	身份证地址
    public static By nation	=  By.xpath("//label[text()='民族']//following-sibling::div//input"); //	民族
    public static By nationRe	=  By.xpath("//span[text()='汉族']"); //
    public static By marriedRadio	=  By.xpath("//*[@id=\"roll1\"]/form/div[10]/div/div/label[1]/span[1]/span"); //	已婚
    public static By unmarriedRadio	=  By.xpath("//*[@id=\"roll1\"]/form/div[10]/div/div/label[2]/span[1]/span"); //	未婚
    public static By haveChildRadio	=  By.xpath("//*[@id=\"roll1\"]/form/div[11]/div/div/label[1]/span[1]/span"); //	已育
    public static By childlessRadio	=  By.xpath("//*[@id=\"roll1\"]/form/div[11]/div/div/label[2]/span[1]/span"); //	未育
    public static By political	=  By.xpath("//label[text()='政治面貌']//following-sibling::div//input"); //	政治面貌
    public static By politicalRe	=  By.xpath("//span[text()='中共党员']"); //
    public static By personnelMail	=  By.xpath("//label[text()='个人邮箱']//following-sibling::div//input"); //	个人邮箱
    public static By firstWorkingTime	=  By.xpath("//label[text()='首次工作日期']//following-sibling::div//input"); //	首次工作时间
    public static By registeredResidenceCity	=  By.xpath("//label[text()='户籍城市']//following-sibling::div//input"); //	户籍城市
    public static By registeredResidenceNature	=  By.xpath("//label[text()='户籍性质']//following-sibling::div//input"); //	户籍性质
    public static By RegisteredResidenceNatureRe	=  By.xpath("//span[text()='非农业户口']"); //
    public static By residentialAddress	=  By.xpath("//label[text()='现住址']//following-sibling::div//input"); //	居住地址
    public static By taxpayerStatus	=  By.xpath("//label[text()='纳税身份']//following-sibling::div//input"); //	纳税人身份
    public static By taxpayerStatusRe	=  By.xpath("//span[text()='中国税收居民']"); //
    public static By employmentRelationship	=  By.xpath("//label[text()='用工关系']//following-sibling::div//input"); //	用工关系
    public static By employmentRelationshipRe	=  By.xpath("//span[text()='劳动合同用工']"); //
    public static By entryDate	=  By.xpath("//label[text()='入职日期']//following-sibling::div//input"); //	入职日期
    public static By employeeType	=  By.xpath("//label[text()='员工类型']//following-sibling::div//input"); //	员工类型
    public static By employeeTypeRe	=  By.xpath("//span[text()='劳务外包']"); //
    public static By employeeStatus	=  By.xpath("//label[text()='员工状态']//following-sibling::div//input"); //	员工状态
    public static By employeeStatusRe	=  By.xpath("//span[text()='试用']"); //
    public static By probationPeriod	=  By.xpath("//label[text()='试用期(月)']//following-sibling::div//input"); //	试用期
    public static By bankCard	=  By.xpath("//label[text()='银行卡(一类卡)']//following-sibling::div//input"); //	银行卡
    public static By bank	=  By.xpath("//label[text()='开户行']//following-sibling::div//input"); //	银行
    public static By saveBtn	=  By.xpath("//span[text()='保存']"); //	保存按钮

}
