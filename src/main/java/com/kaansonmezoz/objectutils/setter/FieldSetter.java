package com.kaansonmezoz.objectutils.setter;

import java.lang.reflect.Field;

public interface FieldSetter {
    void set(Object object, Field field, String value) throws IllegalAccessException;
}
