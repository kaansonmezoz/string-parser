package com.kaansonmezoz.objectutils.setter.primitive;

import java.lang.reflect.Field;

public class BooleanSetter implements PrimitiveFieldSetter {
    private final Class fieldType;

    BooleanSetter() {
        fieldType = boolean.class;
    }

    public Class getFieldType(){
        return this.fieldType;
    }

    @Override
    public void set(Object object, Field field, String value) throws IllegalAccessException {

    }
}
