package com.kaansonmezoz.objectutils.setter.primitive;

import java.lang.reflect.Field;

class FloatSetter extends PrimitiveFieldSetter{
    public FloatSetter() {
        super(float.class);
    }

    @Override
    public void set(Object object, Field field, String value) throws IllegalAccessException {
        field.setFloat(object, Float.parseFloat(value));
    }
}
