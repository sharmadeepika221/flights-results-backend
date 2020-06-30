package com.cgi.assignement.flightProject.controller;

import com.cgi.assignement.flightProject.exception.ResourceNotFoundException;
import com.cgi.assignement.flightProject.model.RestErrorInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * This class is used for global handling of the exceptions in HTTP request
 *
 */
@ControllerAdvice
public class AbstractRestHandler extends ResponseEntityExceptionHandler  {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * Handler for the exception related to resource not found
     * @param ex
     * @param request
     * @return ResponseEntity<RestErrorInfo>
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public
    final ResponseEntity<RestErrorInfo> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        log.info("ResourceNotFoundException handler:" + ex.getMessage());
        RestErrorInfo errorInfo = new RestErrorInfo(ex,ex.getMessage(),request.getDescription(false),HttpStatus.NOT_FOUND);
        return new ResponseEntity<RestErrorInfo>(errorInfo,HttpStatus.NOT_FOUND);
    }

}