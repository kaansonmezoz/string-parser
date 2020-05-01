package com.kaansonmezoz.objectutils.setter.primitive;

import java.lang.reflect.Field;

class DoubleSetter extends PrimitiveFieldSetter {

    DoubleSetter() {
        super(double.class);
    }

    @Override
    public void set(Object object, Field field, String value) throws IllegalAccessException {
        field.setDouble(object, Double.parseDouble(value));
    }
}
