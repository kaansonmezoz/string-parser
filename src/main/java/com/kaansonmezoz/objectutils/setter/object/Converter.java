package com.kaansonmezoz.objectutils.setter.object;

interface Converter<T> {
    <T> T convert(String value, Class<T> targetClass); // TODO: 1.05.2020 String to Double,BigDecimal, Integer vs gibi converterlar yazılmalı
}
