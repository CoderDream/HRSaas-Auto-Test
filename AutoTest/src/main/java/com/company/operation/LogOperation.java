package com.company.operation;


import org.apache.log4j.Logger;

public class LogOperation {
    private static Logger logger = Logger.getLogger(LogOperation.class);

    public static void log(String s){
        logger.info(s);
    }
}
