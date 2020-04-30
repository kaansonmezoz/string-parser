package com.kaansonmezoz.objectutils.setter.primitive;

import java.lang.reflect.Field;

public interface PrimitiveFieldSetter {
    void set(Object object, Field field, String value) throws IllegalAccessException;
}
