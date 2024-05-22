package com.sapient.bookshowsmgmt.util;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sapient.bookshowsmgmt.exception.MessageCode;
import com.sapient.bookshowsmgmt.response.ResponseStatus;
import com.sapient.bookshowsmgmt.response.RestResponse;

//utility changes
public class ServiceUtil {

	private ServiceUtil() {

	}



	public static <T> ResponseEntity<RestResponse<T>> prepareSuccessResponse(T model) {
		RestResponse<T> restResponse1 = new RestResponse<>();
		ResponseStatus status1 = new ResponseStatus();

		if (Objects.isNull(model)) {
			status1.setCode(HttpStatus.NO_CONTENT.value());
			status1.setMessage(MessageCode.RESPONSE_DATA_EMPTY.getReasonPhrase());
			status1.setMessageCode(MessageCode.RESPONSE_DATA_EMPTY.value());

		} else {
			status1.setCode(HttpStatus.OK.value());
			status1.setMessage(MessageCode.SUCCESSFUL_RESPONSE.getReasonPhrase());
			status1.setMessageCode(MessageCode.SUCCESSFUL_RESPONSE.value());
		}

		restResponse1.setStatus(status1);
		restResponse1.setData(model);
		return new ResponseEntity<>(restResponse1, HttpStatus.OK);
	}

	public static <T> ResponseEntity<RestResponse<T>> prepareErrorResponse(T model) {
		RestResponse<T> restResponse = new RestResponse<>();
		ResponseStatus status = new ResponseStatus();
		status.setCode(HttpStatus.NO_CONTENT.value());
		status.setMessage(MessageCode.RESPONSE_DATA_EMPTY.getReasonPhrase());
		restResponse.setStatus(status);
		restResponse.setData(model);
		return new ResponseEntity<>(restResponse, HttpStatus.NO_CONTENT);

	}

	public static <T> ResponseEntity<RestResponse<T>> prepareSuccessResponse(T model, int code) {
		RestResponse<T> restResponse = new RestResponse<>();
		ResponseStatus status = new ResponseStatus();

		if (Objects.isNull(model)) {
			status.setCode(HttpStatus.NO_CONTENT.value());
			status.setMessage(MessageCode.RESPONSE_DATA_EMPTY.getReasonPhrase());
			status.setMessageCode(MessageCode.RESPONSE_DATA_EMPTY.value());

		} else {
			status.setCode(HttpStatus.OK.value());
			status.setMessage(MessageCode.SUCCESSFUL_RESPONSE.getReasonPhrase());
			status.setMessageCode(MessageCode.SUCCESSFUL_RESPONSE.value());
		}
		status.setCode(code);
		status.setMessage(MessageCode.SUCCESSFUL_RESPONSE.getReasonPhrase());
		restResponse.setStatus(status);
		restResponse.setData(model);
		return new ResponseEntity<>(restResponse, HttpStatus.OK);

	}

}
