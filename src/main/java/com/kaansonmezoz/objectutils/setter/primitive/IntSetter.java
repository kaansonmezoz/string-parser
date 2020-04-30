package com.kaansonmezoz.objectutils.setter.primitive;

import com.kaansonmezoz.objectutils.setter.Setter;

import java.lang.reflect.Field;

public class IntSetter extends Setter {

    public IntSetter() {
        super(int.class, fieldSetters);
    }

    @Override
    protected void set(Object object, Field field, String value) throws IllegalAccessException {
        field.setInt(object, Integer.valueOf(value));
    }
}
