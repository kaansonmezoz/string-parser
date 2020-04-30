package com.kaansonmezoz.objectutils.parser;


import com.kaansonmezoz.objectutils.creator.ObjectCreator;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;

@Setter
public class StringParser {
    private String fieldDelimiter;
    private String assignmentSymbol;
    private final ObjectCreator objectCreator;

    public StringParser(String fieldDelimiter, String assignmentSymbol, ObjectCreator objectCreator) {
        this.fieldDelimiter = fieldDelimiter;
        this.assignmentSymbol = assignmentSymbol;
        this.objectCreator = objectCreator;
    }

    public StringParser(String fieldDelimiter, ObjectCreator objectCreator) {
        this(fieldDelimiter, "=", objectCreator);
    }

    public <T> T parse(String string, Class<T> targetClass) {
        HashMap<String, String> fieldValuePairs = extractFieldValuePairs(string);
        try {
            return objectCreator.create(fieldValuePairs, targetClass);
        } catch (NoSuchMethodException e) { // TODO: 30.04.2020 Add custom exceptions
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    private HashMap<String, String> extractFieldValuePairs(String string) {
        String[] fieldValuePairs = splitFieldValuePairs(string);
        return convertToFieldValueHashMap(fieldValuePairs);
    }

    private HashMap<String, String> convertToFieldValueHashMap(String[] fieldValuePairs) {
        HashMap<String, String> fieldValueMap = new HashMap<>();

        Arrays.stream(fieldValuePairs).forEach((pair) -> {
            String[] fieldAndValue = extractFieldAndValue(pair);
            fieldValueMap.put(fieldAndValue[0], fieldAndValue[1]);
        });

        return fieldValueMap;
    }

    private String[] splitFieldValuePairs(String string) {
        return Arrays.stream(string.split(fieldDelimiter))
                .filter(s -> StringUtils.isNotEmpty(s))
                .toArray(String[]::new);
    }

    private String[] extractFieldAndValue(String fieldValue) {
        String[] fieldValuePair = fieldValue.split(assignmentSymbol);

        if (fieldValuePair.length == 2) {
            return fieldValuePair;
        }

        return new String[]{fieldValuePair[0], ""};
    }
}
