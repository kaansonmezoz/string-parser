package com.kaansonmezoz.objectutils.setter.primitive;

import java.lang.reflect.Field;

class IntSetter extends PrimitiveFieldSetter {

    public IntSetter() {
        super(int.class);
    }

    @Override
    public void set(Object object, Field field, String value) throws IllegalAccessException {
        field.setInt(object, Integer.parseInt(value));
    }
}
