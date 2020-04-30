package com.kaansonmezoz.objectutils.setter.primitive;

import com.kaansonmezoz.objectutils.setter.Setter;

import java.lang.reflect.Field;

public class CharSetter extends Setter {
    protected CharSetter() {
        super(boolean.class, fieldSetters);
    }

    @Override
    protected void set(Object object, Field field, String value) throws IllegalAccessException {

    }
}
