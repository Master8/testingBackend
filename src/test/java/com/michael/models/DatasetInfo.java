package com.michael.models;

import java.util.List;

/**
 * Created by maste on 4/16/2017.
 */
public class DatasetInfo {

    private long Id;
    private String IdentificationNumber;
    private String Keywords;
    private long CategoryId;
    private String CategoryCaption;
    private long DepartmentId;
    private String DepartmentCaption;
    private String Caption;
    private String Description;
    private boolean ContainsGeodata;
    private double VersionNumber;
    private String VersionDate;
    private long ItemsCount;
    private List<Column> Columns;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getIdentificationNumber() {
        return IdentificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        IdentificationNumber = identificationNumber;
    }

    public String getKeywords() {
        return Keywords;
    }

    public void setKeywords(String keywords) {
        Keywords = keywords;
    }

    public long getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(long categoryId) {
        CategoryId = categoryId;
    }

    public String getCategoryCaption() {
        return CategoryCaption;
    }

    public void setCategoryCaption(String categoryCaption) {
        CategoryCaption = categoryCaption;
    }

    public long getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(long departmentId) {
        DepartmentId = departmentId;
    }

    public String getDepartmentCaption() {
        return DepartmentCaption;
    }

    public void setDepartmentCaption(String departmentCaption) {
        DepartmentCaption = departmentCaption;
    }

    public String getCaption() {
        return Caption;
    }

    public void setCaption(String caption) {
        Caption = caption;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public boolean isContainsGeodata() {
        return ContainsGeodata;
    }

    public void setContainsGeodata(boolean containsGeodata) {
        ContainsGeodata = containsGeodata;
    }

    public double getVersionNumber() {
        return VersionNumber;
    }

    public void setVersionNumber(double versionNumber) {
        VersionNumber = versionNumber;
    }

    public String getVersionDate() {
        return VersionDate;
    }

    public void setVersionDate(String versionDate) {
        VersionDate = versionDate;
    }

    public long getItemsCount() {
        return ItemsCount;
    }

    public void setItemsCount(long itemsCount) {
        ItemsCount = itemsCount;
    }

    public List<Column> getColumns() {
        return Columns;
    }

    public void setColumns(List<Column> columns) {
        Columns = columns;
    }
}
