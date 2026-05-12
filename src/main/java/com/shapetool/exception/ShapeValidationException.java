package com.shapetool.exception;

/**
 * Custom exception for shape validation errors.
 * This exception is thrown when input parameters fail validation.
 */
public class ShapeValidationException extends RuntimeException {

    private final String field;

    public ShapeValidationException(String message, String field) {
        super(message);
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
