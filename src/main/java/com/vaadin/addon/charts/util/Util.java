package com.vaadin.addon.charts.util;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by bpupadhyaya on 1/1/16.
 */
public class Util {
    public Util() {
    }

    public static long toHighchartsTS(Date date) {
        return date.getTime() - (long)(date.getTimezoneOffset() * '\uea60');
    }

    public static Date toServerDate(double rawClientSideValue) {
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        instance.setTimeInMillis((long)rawClientSideValue);
        instance.set(12, instance.get(12));
        instance.setTimeZone(TimeZone.getDefault());
        return instance.getTime();
    }
}
