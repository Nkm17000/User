package com.nitin.user.Error;

import com.nitin.user.Entity.ErrorHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> UserNotFoundException(Exception ex, WebRequest request) throws java.lang.Exception {
        ErrorHandler errorHandler= new ErrorHandler(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(errorHandler, HttpStatus.NOT_FOUND);
         }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws java.lang.Exception {
        ErrorHandler errorHandler= new ErrorHandler(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(errorHandler, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<java.lang.Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorHandler errorHandler= new ErrorHandler(new Date(), ex.getMessage(), ex.getBindingResult().toString());
        return new ResponseEntity(errorHandler, HttpStatus.BAD_REQUEST);
         }



}
