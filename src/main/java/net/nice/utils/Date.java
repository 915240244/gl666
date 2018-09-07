package net.nice.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public  class Date {
    public static String date(LocalDateTime date){
        String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(date);
        return dateStr;
    }
}
