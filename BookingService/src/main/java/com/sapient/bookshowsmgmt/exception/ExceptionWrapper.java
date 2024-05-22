package com.sapient.bookshowsmgmt.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@ToString
@EqualsAndHashCode
public class ExceptionWrapper {
	String cause;
	StackTraceElement[] stackTrace;
	String localizedMessage;
	String message;
	String[] suppressed;
}
