package com.kaansonmezoz.objectutils.setter.primitive;

import com.kaansonmezoz.objectutils.setter.Setter;

import java.lang.reflect.Field;

class ByteSetter extends PrimitiveFieldSetter {

    protected ByteSetter() {
        super(byte.class);
    }

    @Override
    protected void set(Object object, Field field, String value) throws IllegalAccessException {
        //todo: Primitive Types int, boolean, char, byte, float, double, long, short

    }
}
