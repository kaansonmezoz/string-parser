package com.kaansonmezoz.objectutils.exception;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class ExceptionMapper {
    private final HashMap<Class<? extends Exception>, ExceptionCreator<Throwable, Class, ObjectCreatorException>> constructors;

    public ExceptionMapper() {
        this.constructors = new HashMap<>();

        constructors.put(NoSuchMethodException.class, (Throwable cause, Class source) -> new DefaultConstructorNotFound(cause, source));
        constructors.put(IllegalAccessException.class, (Throwable cause, Class source) -> new AccessModifierException(cause, source));
        constructors.put(InvocationTargetException.class, (Throwable cause, Class source) -> new DefaultConstructorNotFound(cause, source)); // TODO: 1.05.2020 buralar değişecek
        constructors.put(InstantiationException.class, (Throwable cause, Class source) -> new DefaultConstructorNotFound(cause, source)); // TODO: 1.05.2020 buralar değişecek
        constructors.put(Exception.class, (Throwable cause, Class source) -> new DefaultException(cause, source));
    }

    public ObjectCreatorException map(Exception cause, Class source) {
        return getConstructor(cause.getClass()).create(cause, source);
    }

    private ExceptionCreator<Throwable, Class, ObjectCreatorException> getConstructor(Class source) {
        return constructors.getOrDefault(source, constructors.get(Exception.class));
    }
}
