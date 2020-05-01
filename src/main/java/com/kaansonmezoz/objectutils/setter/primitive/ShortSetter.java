package com.kaansonmezoz.objectutils.setter.primitive;

import java.lang.reflect.Field;

class ShortSetter extends PrimitiveFieldSetter{
    ShortSetter() {
        super(short.class);
    }

    @Override
    public void set(Object object, Field field, String value) throws IllegalAccessException {
        field.setShort(object, Short.parseShort(value));
    }
}
