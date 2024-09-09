package com.eksad.authentication.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static Date stringToDate(String date) throws Exception {
        Date resultDate = null;
        if (date != null) {
            if (!date.isEmpty()) {
                resultDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            }
        }

        return resultDate;
    }
}
