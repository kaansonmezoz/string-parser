package com.kaansonmezoz.objectutils.converter;

public interface Converter<T> {
    <T> T convert(String value, Class<T> targetClass);
}
