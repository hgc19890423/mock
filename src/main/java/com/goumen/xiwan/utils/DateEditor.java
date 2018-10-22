package com.goumen.xiwan.utils;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author hanguocai
 * @version V1.0
 * @ClassName: DateEditor
 */
public class DateEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text){
        try {
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
            Date parse = simpleDateFormat.parse(text);
            setValue(parse);
        }catch (Exception e){

        }

    }
}
