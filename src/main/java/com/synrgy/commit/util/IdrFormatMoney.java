package com.synrgy.commit.util;

import java.text.NumberFormat;
import java.util.Locale;

public class IdrFormatMoney {
    public static String currencyIdr(String param) {
        double harga = Double.parseDouble(param);
        Locale locale = new Locale("id", "ID");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        numberFormat.setMaximumFractionDigits(0);
        String result = numberFormat.format(harga);
        return result;
    }

    public static String currencyIdrFromDouble(Long param) {
        Locale locale = new Locale("id", "ID");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        numberFormat.setMaximumFractionDigits(0);
        String result = numberFormat.format(param);
        return result;
    }
}
