package com.sofisticat.stockmanagerbackend.model.sale;

public enum SaleTimeInterval {
    ONE_HOUR("ONE_HOUR"),
    ONE_DAY("ONE_DAY"),
    ONE_WEEK("ONE_WEEK"),
    ONE_MONTH("ONE_MONTH");
    private String value;

    public static SaleTimeInterval getTimeInterval(String timeInterval) {
        if (timeInterval.equals(ONE_HOUR.value)) return ONE_HOUR;
        if (timeInterval.equals(ONE_DAY.value)) return ONE_DAY;
        if (timeInterval.equals(ONE_MONTH.value)) return ONE_MONTH;
        if (timeInterval.equals(ONE_WEEK.value)) return ONE_WEEK;
        return ONE_DAY;
    }

    SaleTimeInterval(String value) {
        this.value = value;
    }
}