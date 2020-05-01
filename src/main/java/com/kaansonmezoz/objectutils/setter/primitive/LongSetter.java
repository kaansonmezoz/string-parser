package com.kaansonmezoz.objectutils.setter.primitive;

import java.lang.reflect.Field;

class LongSetter extends PrimitiveFieldSetter{
    public LongSetter() {
        super(long.class);
    }

    @Override
    public void set(Object object, Field field, String value) throws IllegalAccessException {
        field.setLong(object, Long.parseLong(value));
    }
}
