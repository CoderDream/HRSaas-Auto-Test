package com.company.operation;

import com.company.utils.Constants;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OCROperation {

    public static void main(String[] args) {
        File file = new File("D:\\2.png");
        System.out.println(ocrCheckCode(file));

    }

    public static String ocrCheckCode(File checkCodePic) {
        ITesseract instance = new Tesseract();
        instance.setTessVariable("user_defined_dpi", "2400");
        File file = new File("D:\\1.png");
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //设置训练库的位置
        instance.setDatapath(Constants.tessdataPath);
        instance.setLanguage("eng");//chi_sim ：简体中文， eng	根据需求选择语言库
        String result = null;
        try {
            result = instance.doOCR(bi);
        } catch (TesseractException e) {
            e.printStackTrace();
        }


        LogOperation.log("OCR result : " + result);

        Pattern pattern = Pattern.compile("^=\\d.*\\d");
        Matcher matcher = pattern.matcher(result);
        matcher.find();

        result = matcher.group();
        // 计算验证码结果
        int firstNum = Integer.parseInt(result.substring(1, 2));
        int secondNum = Integer.parseInt(result.substring(result.length() - 1));
        String operator = result.substring(2, result.length() - 1);
        if (operator.length() > 1 || operator.contains("x")) {
            return String.valueOf(firstNum * secondNum);
        } else if ("+".equals(operator)) {
            return String.valueOf(firstNum + secondNum);
        } else if ("-".equals(operator)) {
            return String.valueOf(firstNum - secondNum);
        }
        LogOperation.log("calculation result : " + result);
        return result;
    }

}
