package com.vaadin.addon.charts;

import com.vaadin.addon.charts.model.Series;

/**
 * Created by bpupadhyaya on 1/1/16.
 */
public abstract class AbstractPointEvent extends com.vaadin.ui.Component.Event {

    private final String category;
    private final Series series;
    private int pointIndex;

    public AbstractPointEvent(Chart source, Series series, String category,
                              int pointIndex) {
        super(source);
        this.series = series;
        this.category = category;
        this.pointIndex = pointIndex;
    }


    /**
     * @return the series containing the point that was clicked
     */
    public Series getSeries() {
        return series;
    }

    /**
     * @return the name of the category for the point that was clicked.
     */
    public String getCategory() {
        return category;
    }

    /**
     * @return the index of the point in its series that was clicked
     */
    public int getPointIndex() {
        return pointIndex;
    }


}
