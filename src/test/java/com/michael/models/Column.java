package com.michael.models;

import java.util.List;

/**
 * Created by maste on 4/16/2017.
 */
public class Column {

    private String Name;
    private String Caption;
    private boolean Visible;
    private String Type;
    private List<Column> SubColumns;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCaption() {
        return Caption;
    }

    public void setCaption(String caption) {
        Caption = caption;
    }

    public boolean isVisible() {
        return Visible;
    }

    public void setVisible(boolean visible) {
        Visible = visible;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public List<Column> getSubColumns() {
        return SubColumns;
    }

    public void setSubColumns(List<Column> subColumns) {
        SubColumns = subColumns;
    }
}
