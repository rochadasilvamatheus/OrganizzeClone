package com.android.matheusrocha.organizze.helper;

import java.text.SimpleDateFormat;

public class DateCustom {

    public static String dataAtual() {

        long date = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataString = simpleDateFormat.format(date);

        return dataString;
    }

    public static String mesAnoDataEscolhida(String data) {

        String returnData[] = data.split("/");
        String mesAno = returnData[1] + returnData[2];

        return mesAno;
    }
}
