package org.turkcell.customerservice.core.utilities.exceptions;

public class BusinessException extends RuntimeException{
    public BusinessException(String message) {
        super(message);
    }
}
