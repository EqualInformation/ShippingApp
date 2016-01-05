package com.equalinformation.shipping.poc.pi.views.view3;

import com.equalinformation.shipping.poc.pi.domain.Movie;
import com.equalinformation.shipping.poc.pi.domain.MovieRevenue;
import com.equalinformation.shipping.poc.pi.views.ShippingUI;
import com.vaadin.addon.charts.model.style.SolidColor;
import com.vaadin.data.Container;
import com.vaadin.data.Property;
import com.vaadin.event.ShortcutAction;
import com.vaadin.event.ShortcutListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Responsive;
import com.vaadin.timeline.Timeline;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.vaadin.maddon.ListContainer;

import java.util.*;
import java.util.Calendar;

/**
 * Created by bpupadhyaya on 12/29/15.
 */
public class View3View extends VerticalLayout implements View {

    private final Timeline timeline;
    private ComboBox movieSelect;

    private static final SolidColor[] COLORS = new SolidColor[] {
            new SolidColor(52, 154, 255), new SolidColor(242, 81, 57),
            new SolidColor(255, 201, 35), new SolidColor(83, 220, 164) };
    private static final SolidColor[] COLORS_ALPHA = new SolidColor[] {
            new SolidColor(52, 154, 255, 0.3),
            new SolidColor(242, 81, 57, 0.3),
            new SolidColor(255, 201, 35, 0.3),
            new SolidColor(83, 220, 164, 0.3) };
    private int colorIndex = -1;

    public View3View() {
        setSizeFull();
        addStyleName("sales");

        addComponent(buildHeader());

        timeline = buildTimeline();
        addComponent(timeline);
        setExpandRatio(timeline, 1);

        initMovieSelect();
        // Add first 4 by default
        List<Movie> subList = new ArrayList<Movie>(ShippingUI
                .getDataProvider().getMovies()).subList(0, 4);
        for (Movie m : subList) {
            addDataSet(m);
        }

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -2);
        if (timeline.getGraphDatasources().size() > 0) {
            timeline.setVisibleDateRange(calendar.getTime(), new Date());
        }
    }

    private void initMovieSelect() {
        Collection<Movie> movies = ShippingUI.getDataProvider().getMovies();
        Container movieContainer = new ListContainer<Movie>(Movie.class, movies);
        movieSelect.setContainerDataSource(movieContainer);
    }

    private Component buildHeader() {
        HorizontalLayout header = new HorizontalLayout();
        header.addStyleName("viewheader");
        header.setSpacing(true);
        Responsive.makeResponsive(header);

        Label titleLabel = new Label("Revenue by Movie");
        titleLabel.setSizeUndefined();
        titleLabel.addStyleName(ValoTheme.LABEL_H1);
        titleLabel.addStyleName(ValoTheme.LABEL_NO_MARGIN);
        header.addComponents(titleLabel, buildToolbar());

        return header;
    }

    private Component buildToolbar() {
        HorizontalLayout toolbar = new HorizontalLayout();
        toolbar.addStyleName("toolbar");
        toolbar.setSpacing(true);

        movieSelect = new ComboBox();
        movieSelect.setItemCaptionPropertyId("title");
        movieSelect.addShortcutListener(new ShortcutListener("Add",
                ShortcutAction.KeyCode.ENTER, null) {
            @Override
            public void handleAction(final Object sender, final Object target) {
                addDataSet((Movie) movieSelect.getValue());
            }
        });

        final Button add = new Button("Add");
        add.setEnabled(false);
        add.addStyleName(ValoTheme.BUTTON_PRIMARY);

        CssLayout group = new CssLayout(movieSelect, add);
        group.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        toolbar.addComponent(group);

        movieSelect.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(final Property.ValueChangeEvent event) {
                add.setEnabled(event.getProperty().getValue() != null);
            }
        });

        final Button clear = new Button("Clear");
        clear.addStyleName("clearbutton");
        clear.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(final Button.ClickEvent event) {
                timeline.removeAllGraphDataSources();
                initMovieSelect();
                clear.setEnabled(false);
            }
        });
        toolbar.addComponent(clear);

        add.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(final Button.ClickEvent event) {
                addDataSet((Movie) movieSelect.getValue());
                clear.setEnabled(true);
            }
        });

        return toolbar;
    }

    private Timeline buildTimeline() {
        Timeline result = new Timeline();
        result.setDateSelectVisible(false);
        result.setChartModesVisible(false);
        result.setGraphShadowsEnabled(false);
        result.setZoomLevelsVisible(false);
        result.setSizeFull();
        result.setNoDataSourceCaption("<span class=\"v-label h2 light\">Add a data set from the dropdown above</span>");
        return result;
    }

    private void addDataSet(final Movie movie) {
        movieSelect.removeItem(movie);
        movieSelect.setValue(null);

        Collection<MovieRevenue> dailyRevenue = ShippingUI.getDataProvider()
                .getDailyRevenuesByMovie(movie.getId());

        ListContainer<MovieRevenue> dailyRevenueContainer = new TempMovieRevenuesContainer(
                dailyRevenue);

        dailyRevenueContainer.sort(new Object[] { "timestamp" },
                new boolean[] { true });

        timeline.addGraphDataSource(dailyRevenueContainer, "timestamp",
                "revenue");
        colorIndex = (colorIndex >= COLORS.length - 1 ? 0 : ++colorIndex);
        timeline.setGraphOutlineColor(dailyRevenueContainer, COLORS[colorIndex]);
        timeline.setBrowserOutlineColor(dailyRevenueContainer,
                COLORS[colorIndex]);
        timeline.setBrowserFillColor(dailyRevenueContainer,
                COLORS_ALPHA[colorIndex]);
        timeline.setGraphCaption(dailyRevenueContainer, movie.getTitle());
        timeline.setEventCaptionPropertyId("date");
        timeline.setVerticalAxisLegendUnit(dailyRevenueContainer, "$");
    }

    @Override
    public void enter(final ViewChangeListener.ViewChangeEvent event) {
    }

    private class TempMovieRevenuesContainer extends
            ListContainer<MovieRevenue> {

        public TempMovieRevenuesContainer(
                final Collection<MovieRevenue> collection) {
            super(MovieRevenue.class, collection);
        }

        // This is only temporarily overridden until issues with
        // BeanComparator get resolved.
        @Override
        public void sort(final Object[] propertyId, final boolean[] ascending) {
            final boolean sortAscending = ascending[0];
            Collections.sort(getBackingList(), new Comparator<MovieRevenue>() {
                @Override
                public int compare(final MovieRevenue o1, final MovieRevenue o2) {
                    int result = o1.getTimestamp().compareTo(o2.getTimestamp());
                    if (!sortAscending) {
                        result *= -1;
                    }
                    return result;
                }
            });
        }

    }
}
