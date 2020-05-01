package com.kaansonmezoz.objectutils.setter.object;

import com.kaansonmezoz.objectutils.setter.FieldSetter;

import java.lang.reflect.Field;
import java.util.HashMap;

public class ObjectSetter implements FieldSetter {
    private final HashMap<Class, Converter> converters;

    public ObjectSetter() {
        this.converters = null;
    }

    @Override
    public void set(Object object, Field field, String value) throws IllegalAccessException {
        Object convertedValue = convertValue(field, value);
        field.set(object, convertedValue);
    }

    private Object convertValue(Field field, String value) {
        Class fieldType = field.getType();
        Converter converter = converters.get(fieldType); // TODO: 30.04.2020 böyle bir converter yoksa exception atmak gerekiyor
        return converter.convert(value, fieldType);
    }
}
