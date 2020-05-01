package com.kaansonmezoz.objectutils.parser;


import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;

@Setter
public class StringParser {
    private String fieldDelimiter;
    private String assignmentSymbol;

    public StringParser(String fieldDelimiter, String assignmentSymbol) {
        this.fieldDelimiter = fieldDelimiter;
        this.assignmentSymbol = assignmentSymbol;
    }

    public StringParser(String fieldDelimiter) {
        this(fieldDelimiter, "=");
    }

    public HashMap<String, String> parse(String string) {
        return extractFieldValuePairs(string);
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
