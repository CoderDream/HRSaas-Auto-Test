package com.company.cases;


import com.company.listenner.TestFailListener;
import com.company.operation.DriverHelper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;

@Listeners({TestFailListener.class})
public class BaseCase {

    @AfterClass
    public void closedChrome() {
        DriverHelper.closeDriver();
    }


}
