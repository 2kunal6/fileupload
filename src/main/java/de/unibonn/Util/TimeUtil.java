package de.unibonn.Util;

public class TimeUtil {
    public static double convertSecondsToHours(Long seconds) {
        return seconds / 3600.0;
    }

    public static Long convertHoursToSeconds(Double hours) {
        return Math.round(hours * 3600);
    }
}
