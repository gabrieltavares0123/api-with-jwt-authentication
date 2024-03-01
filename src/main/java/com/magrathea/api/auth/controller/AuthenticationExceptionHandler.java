package com.magrathea.api.auth.controller;

import com.magrathea.api.auth.exception.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;

@ControllerAdvice
public class AuthenticationExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @ExceptionHandler(UserNameIsBlankException.class)
    public ResponseEntity<ExceptionDto> userNameIsBlankHandler(UserNameIsBlankException ex) {
        logger.error(ex.getHttpStatus().getReasonPhrase());
        logger.error(ex.getErrorMessage());
        logger.trace(Arrays.toString(ex.getStackTrace()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ExceptionDto(ex.getHttpStatus(), ex.getErrorMessage())
        );
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionDto> userNotFoundHandler(UserNotFoundException ex) {
        logger.error(ex.getHttpStatus().getReasonPhrase());
        logger.error(ex.getErrorMessage());
        logger.trace(Arrays.toString(ex.getStackTrace()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ExceptionDto(ex.getHttpStatus(), ex.getErrorMessage())
        );
    }

    @ExceptionHandler(UserPasswordIsBlankException.class)
    public ResponseEntity<ExceptionDto> userPasswordIsEmptyHandler(UserPasswordIsBlankException ex) {
        logger.error(ex.getHttpStatus().getReasonPhrase());
        logger.error(ex.getErrorMessage());
        logger.trace(Arrays.toString(ex.getStackTrace()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ExceptionDto(ex.getHttpStatus(), ex.getErrorMessage())
        );
    }

    @ExceptionHandler(UserRoleIsNullException.class)
    public ResponseEntity<ExceptionDto> userRoleIsNullHandler(UserRoleIsNullException ex) {
        logger.error(ex.getHttpStatus().getReasonPhrase());
        logger.error(ex.getErrorMessage());
        logger.trace(Arrays.toString(ex.getStackTrace()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ExceptionDto(ex.getHttpStatus(), ex.getErrorMessage())
        );
    }

    @ExceptionHandler(TokenCreationException.class)
    public ResponseEntity<ExceptionDto> tokenCreationHandler(TokenCreationException ex) {
        logger.error(ex.getHttpStatus().getReasonPhrase());
        logger.error(ex.getErrorMessage());
        logger.trace(Arrays.toString(ex.getStackTrace()));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new ExceptionDto(ex.getHttpStatus(), ex.getErrorMessage())
        );
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDto> runtimeHandler(RuntimeException ex) {
        logger.error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        logger.error(ex.getMessage());
        logger.trace(Arrays.toString(ex.getStackTrace()));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new ExceptionDto(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage())
        );
    }
}
