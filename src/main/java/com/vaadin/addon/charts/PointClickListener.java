package com.vaadin.addon.charts;

import java.io.Serializable;

/**
 * Created by bpupadhyaya on 1/1/16.
 */
public interface PointClickListener extends Serializable {
    /**
     * Called when a data point is clicked by the user.
     *
     * @param event
     *            a {@link PointClickEvent} containing information on the click
     */
    public void onClick(PointClickEvent event);

}
