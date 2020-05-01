package com.kaansonmezoz.objectutils.setter.primitive;

import com.kaansonmezoz.objectutils.setter.Setter;

import java.lang.reflect.Field;

class IntSetter extends PrimitiveFieldSetter {

    public IntSetter() {
        super(int.class);
    }

    @Override
    protected void set(Object object, Field field, String value) throws IllegalAccessException {
        field.setInt(object, Integer.valueOf(value));
    }
}
