package com.example.cs5610su19javaservercdesai.models;

public enum WidgetType {

    HEADING("HEADING"),
    PARAGRAPH("PARAGRAPH"),
    LIST("LIST"),
    LINK("LINK"),
    IMAGE("IMAGE");

    private String widgetType;

    WidgetType(String widgetType) {
        this.widgetType = widgetType;
    }

    public String getWidgetType() {
        return widgetType;
    }
}
