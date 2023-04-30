package com.AngelaLee.SchoolMS.exceptions;

import org.springframework.dao.DataAccessException;
/**
 * custom exception
 * */
public class CustomDataAccessException extends DataAccessException {

    public CustomDataAccessException(String message, Throwable cause) {
        super(message, cause);
    }

}

