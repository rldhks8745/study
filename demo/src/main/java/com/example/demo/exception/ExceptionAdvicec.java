package com.example.demo.exception;

import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvicec {

	@ExceptionHandler(NoSuchElementException.class)
	public String exception(Exception e) {
		return e.getMessage();
	}
}
