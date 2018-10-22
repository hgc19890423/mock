package com.goumen.xiwan.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author hanguocai
 * @version V1.0
 * @ClassName: StringToDateConverter
 */
public class StringToDateConverter implements Converter<String, Date> {
    private String datePattern;

    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }

    @Override
    public Date convert(String s){
        SimpleDateFormat dateFormat=new SimpleDateFormat(this.datePattern);
        try {
            return  dateFormat.parse(s);
        }catch (Exception e){
         return  null;
        }
    }
}
