package com.company.keyworddriven;

import java.util.Map;

/**
 * 变量赋值操作
 */
public class VariableOperation {
    /**
     * $=开头的需要赋值
     * @param value
     * @param operationValue
     * @param variableMap
     */
    public static void variableAssignment(String value, String operationValue, Map<String, String> variableMap){
        if (operationValue.startsWith("$=")) {
            String keyName = operationValue.substring(2);
            variableMap.put(keyName, value);
        }
    }

    public static String getVariableValue(String operationValue, Map<String, String> variableMap){
        String value = operationValue;
        if (operationValue.startsWith("@")) {
            String key = operationValue.substring(1);
            value = variableMap.get(key);
        }
        return value;
    }
}
