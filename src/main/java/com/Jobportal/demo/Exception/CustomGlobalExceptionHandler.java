package com.Jobportal.demo.Exception;

import com.Jobportal.demo.Exception.ReallyNeedException.InternalServerErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

   /* // Let Spring handle the exception, we just override the status code
    @ExceptionHandler(UserNotFoundException.class)
    public void springHandleNotFound(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }
    @ExceptionHandler(InsufficientMoneyException.class)
    public void springHandleBadRequest(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }*/

   @Autowired
   CustomErrorResponse errors;

    @ExceptionHandler(InsufficientMoneyException.class)
    public ResponseEntity<CustomErrorResponse> springHandleBadRequest() {
        errors.setError(ExceptionCodes.INSUFFICIENT_MONEY_REQUESTED.errMsg());
        errors.setStatus(ExceptionCodes.INSUFFICIENT_MONEY_REQUESTED.errCode());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> springHandleNotFound() {
        errors.setError(ExceptionCodes.USER_NOT_FOUND.errMsg());
        errors.setStatus(ExceptionCodes.USER_NOT_FOUND.errCode());
        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<CustomErrorResponse> UserAlreadyExistException1() {
        errors.setError(ExceptionCodes.USER_ALREADY_EXIST.errMsg());
        errors.setStatus(ExceptionCodes.USER_ALREADY_EXIST.errCode());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SubscriptionAlreadyExistException.class)
    public ResponseEntity<CustomErrorResponse> SubscriptionAlreadyExistException1() {
        errors.setError(ExceptionCodes.SUBSCRIPTION_ALREADY_EXIST.errMsg());
        errors.setStatus(ExceptionCodes.SUBSCRIPTION_ALREADY_EXIST.errCode());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public void springHandleBadRequest(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    }
