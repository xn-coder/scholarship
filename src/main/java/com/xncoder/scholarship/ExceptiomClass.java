package com.xncoder.scholarship;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExceptiomClass extends RuntimeException {
	public ExceptiomClass(String msg) {
		super(msg);
	}
}
