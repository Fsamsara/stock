package com.metersbonwe.stock.beans.imexcel;

public class ExcelMappingBean implements Comparable<ExcelMappingBean> {

    private int    order;

    private String header;

    private String fieldName;

    private String fieldTypeName;

    public ExcelMappingBean(int order, String header, String fieldName, String fieldTypeName) {
        this.order = order;
        this.header = header;
        this.fieldName = fieldName;
        this.fieldTypeName = fieldTypeName;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldTypeName() {
        return fieldTypeName;
    }

    public void setFieldTypeName(String fieldTypeName) {
        this.fieldTypeName = fieldTypeName;
    }

    @Override
    public int compareTo(ExcelMappingBean bean) {
        return this.getOrder() - bean.getOrder();
    }

}
