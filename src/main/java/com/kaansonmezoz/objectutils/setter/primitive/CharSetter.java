package com.kaansonmezoz.objectutils.setter.primitive;

import com.kaansonmezoz.objectutils.setter.Setter;

import java.lang.reflect.Field;

class CharSetter extends PrimitiveFieldSetter {
    protected CharSetter() {
        super(boolean.class);
    }

    @Override
    protected void set(Object object, Field field, String value) throws IllegalAccessException {

    }
}
