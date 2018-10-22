package com.goumen.xiwan.utils;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ListPropertyEditor extends CustomCollectionEditor {

    public ListPropertyEditor(Class<? extends Collection> collectionType) {

        super(collectionType);
    }

    public ListPropertyEditor() {

        super(List.class);
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        if (StringUtils.isEmpty(text)) {
            return;
        }
        String[] array = text.split(",");
        List<String> list = Arrays.asList(array);
        this.setValue(list);
    }
}
