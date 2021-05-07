package com.company.listenner;

import com.company.operation.DriverHelper;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestFailListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result) {
        takePhoto();
    }

    @Attachment(value = "screen shot", type = "image/png")
    public byte[] takePhoto() {
        byte[] screenshotAs = ((TakesScreenshot) DriverHelper.getInstance()).getScreenshotAs(OutputType.BYTES);
        return screenshotAs;
    }
}