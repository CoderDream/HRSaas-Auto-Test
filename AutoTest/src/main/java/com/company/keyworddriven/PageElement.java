package com.company.keyworddriven;

public class PageElement {
    /**
     * 元素名称
     */
    private String elementName;

    /**
     * 识别方式
     */
    private String attribute;

    /**
     * 识别值
     */

    private String attributeValue;

    /**
     * 备注 描述
     */
    private String description;

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
