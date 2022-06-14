package com.anhduc.managecake;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class test {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String today = sdf.format(new Date());
        System.out.println(today);
    }
}
