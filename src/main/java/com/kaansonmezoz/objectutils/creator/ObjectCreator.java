package com.kaansonmezoz.objectutils.creator;

import com.kaansonmezoz.objectutils.setter.Setter;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class ObjectCreator {
    private final Setter setter;

    public ObjectCreator(Setter setter) {
        this.setter = setter;
    }

    public <T> T create(HashMap<String, String> fieldValuePairs, Class<T> targetClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        T object = targetClass.getDeclaredConstructor().newInstance();
        setter.setAllFields(fieldValuePairs, object);
        return object;
    }
}
