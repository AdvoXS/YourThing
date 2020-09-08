package com.creation.core.utils.stringUtils;

public class ConverterName {

    /**
     * @param value значение
     * @param firstWordToLowerCase true - camelCase, false - CamelCase
     */
    public static String toCamelCase(String value, boolean firstWordToLowerCase) {
        boolean isPrevLowerCase = false, isNextUpperCase = !firstWordToLowerCase;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < value.length(); i++) {
            char currentChar = value.charAt(i);
            if (!Character.isLetterOrDigit(currentChar)) {
                isNextUpperCase = result.length() > 0 || isNextUpperCase;
            } else {
                result.append(
                        isNextUpperCase ? Character.toUpperCase(currentChar) :
                                isPrevLowerCase ? currentChar : Character.toLowerCase(currentChar)
                );
                isNextUpperCase = false;
            }
            isPrevLowerCase = result.length() > 0 && Character.isLowerCase(currentChar);
        }
        return result.toString();
    }

    public static String camelToSnakeCase(String name) {
        String regex = "([a-z])([A-Z]+)";
        String replacement = "$1_$2";
        return name.replaceAll(regex, replacement).toUpperCase();
    }
}
