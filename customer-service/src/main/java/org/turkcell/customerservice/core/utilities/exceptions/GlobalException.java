package org.turkcell.customerservice.core.utilities.exceptions;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Map<String, String> globalValidException(MethodArgumentNotValidException e){
        Map<String, String> errors=new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((objectError -> {
            String fieldError=((FieldError)objectError).getField();
            String errorMessage=objectError.getDefaultMessage();
            errors.put(fieldError,errorMessage);
        }));
        return errors;
    }
    @ExceptionHandler(InvalidFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handleInvalidFormatException(InvalidFormatException e) {
        Map<String, String> errorResponse = new HashMap<>();
        String fieldName = e.getPath().get(0).getFieldName();
        String invalidValue = e.getValue().toString();
        String message = String.format("Invalid value '%s' for field '%s'", invalidValue, fieldName);
        errorResponse.put("message", message);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public String getBusinessException(BusinessException e){
        return e.getMessage();
    }

}
