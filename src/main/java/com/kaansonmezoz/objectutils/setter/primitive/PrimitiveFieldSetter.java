package com.kaansonmezoz.objectutils.setter.primitive;

import com.kaansonmezoz.objectutils.setter.FieldSetter;
import lombok.Getter;

@Getter
abstract class PrimitiveFieldSetter implements FieldSetter {
    private final Class fieldType;

    PrimitiveFieldSetter(Class fieldType) {
        this.fieldType = fieldType;
    }
}