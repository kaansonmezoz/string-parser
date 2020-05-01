package com.kaansonmezoz.objectutils;

import com.kaansonmezoz.objectutils.creator.ObjectCreator;
import com.kaansonmezoz.objectutils.exception.ExceptionMapper;
import com.kaansonmezoz.objectutils.parser.StringParser;

import java.util.HashMap;

public class ObjectExtractor {
    private final ObjectCreator objectCreator;
    private final ExceptionMapper exceptionMapper;

    public ObjectExtractor(ObjectCreator objectCreator, ExceptionMapper exceptionMapper) {
        this.objectCreator = objectCreator;
        this.exceptionMapper = exceptionMapper;
    }

    public <T> T extractFromQueryParameter(String string, Class<T> target) {
        return extractFromPlainText(string, "&", "=", target);
    }

    public <T> T extractFromPlainText(String string, String fieldValuePairDelimiter, String fieldValueDelimiter, Class<T> target) {
        HashMap<String, String> fieldValuePairs = new StringParser(fieldValuePairDelimiter, fieldValueDelimiter).parse(string);
        try {
            return objectCreator.create(fieldValuePairs, target);
        } catch (Exception e){
            throw exceptionMapper.map(e, target);
        }
    }
}
