package org.turkcell.customerservice.core.utilities;

import org.springframework.http.HttpStatus;
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

}
