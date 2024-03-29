package com.fyp.ehb.controller;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.fyp.ehb.exception.EmpowerHerBizException;
import com.fyp.ehb.model.EmpowerHerBizErrorResponse;


@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
	
	Log logger = LogFactory.getLog(GlobalExceptionHandler.class);

	@ExceptionHandler(value = EmpowerHerBizException.class)
	public ResponseEntity<EmpowerHerBizErrorResponse> handleException(EmpowerHerBizException error) {
		
		StringWriter stack = new StringWriter();
		error.printStackTrace(new PrintWriter(stack));
		
		logger.info("Start logging chatbot integration Exception...");
		logger.error("Error Code :: "+error.getErrorCode());
		logger.error("Error Message :: "+error.getErrorMessage());
		logger.info("Logging Exception Details...");
		logger.info("Class Name :: "+error.getStackTrace()[0].getClassName());
		logger.info("Method Name :: "+error.getStackTrace()[0].getMethodName());
		logger.info("Line Number :: "+error.getStackTrace()[0].getLineNumber());
		logger.info("Done logging Ipay Exception...\n");
		
		EmpowerHerBizErrorResponse empError = new EmpowerHerBizErrorResponse();
		empError.setErrorCode(error.getErrorCode());
		empError.setErrorMessage(error.getErrorMessage());
		
		return new ResponseEntity<EmpowerHerBizErrorResponse>(empError , HttpStatus.BAD_REQUEST);
		
	}
}
