/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.goumen.xiwan.utils;

import java.lang.reflect.Field;


public abstract class ReflectionField {

    public static void setProperty(Object target, String name, Object value) throws Exception {

        for (Class cls = target.getClass(); cls != Object.class; cls = cls.getSuperclass()) {

            for (Field f : cls.getDeclaredFields()) {
                f.setAccessible(true);
                if (name.equals(f.getName())) {
                    f.setAccessible(true);

                    f.set(target, value);
                    return;
                }

            }

        }

    }

}
