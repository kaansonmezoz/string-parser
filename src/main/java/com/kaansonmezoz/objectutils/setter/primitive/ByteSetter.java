package com.kaansonmezoz.objectutils.setter.primitive;

import java.lang.reflect.Field;

class ByteSetter extends PrimitiveFieldSetter {

    protected ByteSetter() {
        super(byte.class);
    }

    @Override
    public void set(Object object, Field field, String value) throws IllegalAccessException {
        field.setByte(object, Byte.parseByte(value));
    }
}
