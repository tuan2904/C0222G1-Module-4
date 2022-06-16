package com.example.model;

public class EmailModel {
    private String language;
    private String pageSize;
    private Boolean spamsFilter;
    private String signature;

    public EmailModel() {

    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public Boolean getSpamsFilter() {
        return spamsFilter;
    }

    public void setSpamsFilter(Boolean spamsFilter) {
        this.spamsFilter = spamsFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
