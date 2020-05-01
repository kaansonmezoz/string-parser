package com.kaansonmezoz.objectutils.setter;

import com.kaansonmezoz.objectutils.parser.annotation.PlaceHolder;
import com.kaansonmezoz.objectutils.setter.object.ObjectSetter;
import com.kaansonmezoz.objectutils.setter.primitive.PrimitiveSetter;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Setter {
    private final HashMap<Boolean, FieldSetter> fieldSetters;

    protected Setter() {
        fieldSetters = new HashMap<>();
        addObjectSetter();
        addPrimitiveSetter();
    }

    private void addPrimitiveSetter() {
        FieldSetter primitiveSetter = new PrimitiveSetter();
        fieldSetters.put(true, primitiveSetter);
    }

    private void addObjectSetter() {
        FieldSetter objectSetter = new ObjectSetter();
        fieldSetters.put(true, objectSetter);

    }

    private void setField(Object object, Field field, String value) throws IllegalAccessException {
        boolean accessible = field.isAccessible();

        field.setAccessible(true);
        fieldSetters.get(field.getType().isPrimitive()).set(object, field, value);
        field.setAccessible(accessible);
    }

    public void setAllFields(Map<String, String> fieldValuePairs, Object object) throws IllegalAccessException {
        String value;
        String fieldPlaceHolder;

        for (Field field : fieldsArray(object)) {
            fieldPlaceHolder = extractTextProperty(field);

            if (fieldValuePairs.containsKey(fieldPlaceHolder)) {
                value = fieldValuePairs.get(fieldPlaceHolder);
                setField(object, field, value);
            }
        }
    }

    private Field[] fieldsArray(Object object) {
        return object.getClass().getDeclaredFields();
    }

    private String extractTextProperty(Field field) {
        PlaceHolder annotation = field.getAnnotation(PlaceHolder.class);

        if (annotation == null) {
            return field.getName();
        }

        return annotation.value();
    }
}
