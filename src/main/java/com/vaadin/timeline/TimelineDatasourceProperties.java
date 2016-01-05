package com.vaadin.timeline;

import com.vaadin.addon.charts.model.style.SolidColor;
import com.vaadin.data.Container;

import java.io.Serializable;

/**
 * Created by bpupadhyaya on 1/4/16.
 */
public class TimelineDatasourceProperties implements Serializable {

    private final Container.Indexed datasource;

    private Object timestampProperty = Timeline.PropertyId.TIMESTAMP;

    private Object valueProperty = Timeline.PropertyId.VALUE;

    private boolean visible = true;

    private SolidColor color = SolidColor.BLACK;

    private SolidColor fillColor = new SolidColor(0, 0, 0, 0);

    private String caption = "Unknown graph";

    private SolidColor browserColor = new SolidColor(0x00, 0x67, 0xDD);

    private SolidColor browserFillColor = new SolidColor(0xED, 0xF7, 0xFF);

    private String legendUnit = "";

    private double thickness = 2;

    private boolean capsVisible = false;

    public TimelineDatasourceProperties(Container.Indexed datasource) {
        this.datasource = datasource;
    }

    public Container.Indexed getDatasource() {
        return datasource;
    }

    public Object getTimestampProperty() {
        return timestampProperty;
    }

    public void setTimestampProperty(Object timestampProperty) {
        this.timestampProperty = timestampProperty;
    }

    public Object getValueProperty() {
        return valueProperty;
    }

    public void setValueProperty(Object valueProperty) {
        this.valueProperty = valueProperty;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public SolidColor getColor() {
        return color;
    }

    public void setColor(SolidColor color) {
        this.color = color;
    }

    public SolidColor getFillColor() {
        return fillColor;
    }

    public void setFillColor(SolidColor fillColor) {
        this.fillColor = fillColor;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public SolidColor getBrowserColor() {
        return browserColor;
    }

    public void setBrowserColor(SolidColor browserColor) {
        this.browserColor = browserColor;
    }

    public SolidColor getBrowserFillColor() {
        return browserFillColor;
    }

    public void setBrowserFillColor(SolidColor browserFillColor) {
        this.browserFillColor = browserFillColor;
    }

    public String getLegendUnit() {
        return legendUnit;
    }

    public void setLegendUnit(String legendUnit) {
        this.legendUnit = legendUnit;
    }

    public double getThickness() {
        return thickness;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    public boolean isCapsVisible() {
        return capsVisible;
    }

    public void setCapsVisible(boolean capsVisible) {
        this.capsVisible = capsVisible;
    }

}