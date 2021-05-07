package com.company.operation;

import com.company.keyworddriven.CaseStep;
import com.company.keyworddriven.PageElement;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExcelOperation {

    private String[] CaseTitle = {"测试用例描述", "识别属性", "对象名称", "操作", "操作值", "预期值"};
    private String[] PageTitle = {"元素名称", "识别方式", "识别值", "备注"};

    /**
     * 读取 Case excel
     *
     * @param FilePath
     * @return
     * @throws IOException
     */
    public List<CaseStep> getCaseStepsByExcel(String FilePath) throws IOException {
        List<CaseStep> stepsList = new ArrayList<>();
        XSSFWorkbook workbook = new XSSFWorkbook(FilePath);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int rowNum = sheet.getPhysicalNumberOfRows();

        if (!checkExcelTitle(sheet, CaseTitle) || rowNum < 2) {
            return stepsList;
        }
        for (int rowIndex = 1; rowIndex < rowNum; rowIndex++) {
            XSSFRow row = sheet.getRow(rowIndex);
            CaseStep step = new CaseStep();
            // 设置步数
            step.setStepNum(rowIndex);
            for (int index = 0; index < CaseTitle.length; index++) {
                XSSFCell cell = row.getCell(index);
                String value = getCellValue(cell);
                switch (index) {
                    case 0:
                        step.setStepDescription(value);
                        break;
                    case 1:
                        step.setAttribute(value);
                        break;
                    case 2:
                        step.setObjectName(value);
                        break;
                    case 3:
                        step.setStepOperation(value);
                        break;
                    case 4:
                        step.setOperationValue(value);
                        break;
                    case 5:
                        step.setExpectedValue(value);
                    default:
                        break;
                }
            }
            stepsList.add(step);
        }
        return stepsList;
    }

    public List<PageElement> getPageByExcel(String FilePath) throws IOException {
        List<PageElement> stepsList = new ArrayList<>();
        XSSFWorkbook workbook = new XSSFWorkbook(FilePath);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int rowNum = sheet.getPhysicalNumberOfRows();
        if (!checkExcelTitle(sheet, PageTitle) || rowNum < 2) {
            return stepsList;
        }
        for (int rowIndex = 1; rowIndex < rowNum; rowIndex++) {
            XSSFRow row = sheet.getRow(rowIndex);
            PageElement pageElement = new PageElement();
            for (int index = 0; index < PageTitle.length; index++) {
                XSSFCell cell = row.getCell(index);
                String value = getCellValue(cell);
                switch (index) {
                    case 0:
                        pageElement.setElementName(value);
                        break;
                    case 1:
                        pageElement.setAttribute(value);
                        break;
                    case 2:
                        pageElement.setAttributeValue(value);
                        break;
                    case 3:
                        pageElement.setDescription(value);
                    default:
                        break;
                }
            }
            stepsList.add(pageElement);
        }
        return stepsList;
    }

    private boolean checkExcelTitle(XSSFSheet sheet, String[] title) {
        XSSFRow row = sheet.getRow(0);
        int cellNum = row.getPhysicalNumberOfCells();
        // 少于6列有问题
        if (title.length > cellNum) {
            return false;
        }
        for (int index = 0; index < title.length; index++) {
            XSSFCell cell = row.getCell(index);
            String value = getCellValue(cell);
            if (!title[index].equals(value)) {
                return false;
            }
        }
        return true;

    }


    public String getCellValue(XSSFCell cell) {
        String value = "";
        try {
            // 以下是判断数据的类型
            switch (cell.getCellType()) {
                case HSSFCell.CELL_TYPE_NUMERIC:
                    value = cell.getNumericCellValue() + "";
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        Date date = cell.getDateCellValue();
                        if (date != null) {
                            value = new SimpleDateFormat("yyyy-MM-dd").format(date);
                        } else {
                            value = "";
                        }
                    } else {
                        value = new DecimalFormat("0").format(cell.getNumericCellValue());
                    }
                    break;
                case HSSFCell.CELL_TYPE_STRING: // 字符串
                    value = cell.getStringCellValue();
                    break;
                case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
                    value = cell.getBooleanCellValue() + "";
                    break;
                case HSSFCell.CELL_TYPE_FORMULA: // 公式
                    value = cell.getCellFormula() + "";
                    break;
                case HSSFCell.CELL_TYPE_BLANK: // 空值
                    value = "";
                    break;
                case HSSFCell.CELL_TYPE_ERROR: // 故障
                    value = "非法字符";
                    break;
                default:
                    value = "未知类型";
                    break;
            }
        } catch (NullPointerException e) {
            return value;
        }
        return value;
    }

}
