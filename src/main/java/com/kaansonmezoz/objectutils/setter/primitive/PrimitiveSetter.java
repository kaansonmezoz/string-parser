package com.kaansonmezoz.objectutils.setter.primitive;

import com.kaansonmezoz.objectutils.setter.FieldSetter;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PrimitiveSetter implements FieldSetter {
    private final HashMap<Class, PrimitiveFieldSetter> setters;

    public PrimitiveSetter() {
        this.setters = new HashMap<>();
        createSetters().forEach((setter) -> setters.put(setter.getFieldType(), setter));
    }

    @Override
    public void set(Object object, Field field, String value) throws IllegalAccessException {
        setters.get(field.getType()).set(object, field, value);
    }

    private List<PrimitiveFieldSetter> createSetters() {
        return Arrays.asList(
                new BooleanSetter(),
                new ByteSetter(),
                new CharSetter(),
                new DoubleSetter(),
                new FloatSetter(),
                new IntSetter(),
                new LongSetter(),
                new ShortSetter()
        );
    }
}
