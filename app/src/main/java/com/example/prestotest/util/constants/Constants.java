package com.example.prestotest.util.constants;

/**
 * Created by Darshan Patel 24/02/2020
 * Usage: list down all application constants here
 * How to call: call through class name and variable as all variable inside this class would be static
 */
public class Constants {
    public static final String CRASHLYTICS_KEY_PRIORITY = "priority";
    public static final String CRASHLYTICS_KEY_TAG = "tag";
    public static final String CRASHLYTICS_KEY_MESSAGE = "message";

    // Retrofit file cache name
    public static String retrofitCacheFile = "investerServiceCacheFile";

    public interface ApiEndpoints {
        String MAIN_API = "6c3je";
    }

    public interface ApiFields {
        String CONTENT_TYPE = "application";
    }

    public interface PrioritySearchDaysConstants {
        Integer PRIORITY_CONSTANT = 100;
        Integer PRIORITY_MONDAY = 6;
        Integer PRIORITY_TUESDAY = 5;
        Integer PRIORITY_WEDNESDAY = 4;
        Integer PRIORITY_THURSDAY = 3;
        Integer PRIORITY_FRIDAY = 2;
        Integer PRIORITY_SATURDAY = 1;
        Integer PRIORITY_SUNDAY = 7;
    }

    public interface DaysOfWeekString {
        String MONDAY = "monday";
        String TUESDAY = "tuesday";
        String WEDNESDAY = "wednesday";
        String THURSDAY = "thursday";
        String FRIDAY = "friday";
        String SATURDAY = "saturday";
        String SUNDAY = "sunday";

    }
}
