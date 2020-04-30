package com.kaansonmezoz.objectutils.setter.primitive;

import com.kaansonmezoz.objectutils.setter.FieldSetter;

import java.lang.reflect.Field;
import java.util.HashMap;

public class PrimitiveSetter implements FieldSetter {
    private final HashMap<Class, PrimitiveFieldSetter> setters;

    public PrimitiveSetter() {
        this.setters = null;
    }

    @Override
    public void set(Object object, Field field, String value) throws IllegalAccessException {
        setters.get(field.getType()).set(object, field, value);
    }
}
