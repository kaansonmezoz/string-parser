package com.kaansonmezoz.objectutils.setter.primitive;

import java.lang.reflect.Field;

class BooleanSetter extends PrimitiveFieldSetter {
    BooleanSetter() {
        super(boolean.class);
    }

    @Override
    public void set(Object object, Field field, String value) throws IllegalAccessException {
        field.setBoolean(object, Boolean.parseBoolean(value));
    }
}
