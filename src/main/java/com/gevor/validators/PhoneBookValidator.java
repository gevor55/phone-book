package com.gevor.validators;

import com.gevor.domain.Record;

public class PhoneBookValidator {

    public static final String DASH_SEPARATOR = "-";
    public static final String COLON_SEPARATOR = ":";
    public static final String SEPARATOR_VALIDATION_MESSAGE = " separator should be `:` or `-`";
    public static final String PHONE_NUMBER_VALIDATION_MESSAGE = " phone number should be 9 digits";
    public static final String EMPTY_STRING = "";
    public static final String COMMA = ",";

    public static String validatePhoneNumber(Record record) {
        if (record.getPhoneNumber() == null || record.getPhoneNumber().length() != 9) {
            return PHONE_NUMBER_VALIDATION_MESSAGE;
        }
        return EMPTY_STRING;
    }

    public static String validateSeparator(Record record) {
        if (record.getLineRepresentation().contains(DASH_SEPARATOR) ||
                record.getLineRepresentation().contains(COLON_SEPARATOR)) {
            return EMPTY_STRING;
        }
        if (record.getSeparator() == null ||
                !(record.getSeparator().equals(DASH_SEPARATOR) ||
                        record.getSeparator().equals(COLON_SEPARATOR))) {
            return SEPARATOR_VALIDATION_MESSAGE;
        }
        return EMPTY_STRING;
    }
}
