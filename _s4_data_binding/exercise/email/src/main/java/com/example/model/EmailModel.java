package com.example.model;

public class EmailModel {
    private String language;
    private String pageSize;
    private String spamsFilter;
    private String signature;

    public EmailModel(String language,
                      String pageSize,
                      String spamsFilter,
                      String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.spamsFilter = spamsFilter;
        this.signature = signature;
    }

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

    public String getSpamsFilter() {
        return spamsFilter;
    }

    public void setSpamsFilter(String spamsFilter) {
        this.spamsFilter = spamsFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}