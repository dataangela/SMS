package com.AngelaLee.SchoolMS.exceptions;

/**
 * custom exception
 * */
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}