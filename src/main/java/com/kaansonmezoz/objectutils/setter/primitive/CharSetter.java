package com.kaansonmezoz.objectutils.setter.primitive;

import java.lang.reflect.Field;

class CharSetter extends PrimitiveFieldSetter {
    protected CharSetter() {
        super(boolean.class);
    }

    @Override
    public void set(Object object, Field field, String value) throws IllegalAccessException {
        if(value.length() != 1){
            throw new RuntimeException("Exception"); // TODO: 1.05.2020 bunun yerine custom bir exception fırlatmak gerekiyor
        }

        field.setChar(object, value.charAt(0));
    }
}
