package com.sapient.bookshowsmgmt.response;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import lombok.Data;
import lombok.Generated;

@Data
public class RestResponse<T> {
	@Generated
	ResponseStatus status;
	@Generated
	private T data;
	@Generated
	private Map<String, String> custom;

	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@Generated
	private ZonedDateTime timestamp;

	public RestResponse() {
		timestamp = ZonedDateTime.now(ZoneOffset.UTC);
	}

	public RestResponse(ResponseStatus responseStatus) {
		this();
		this.status = responseStatus;
	}

	public RestResponse(HttpStatus status, Throwable ex) {
		this();
		ResponseStatus responseStatus = new ResponseStatus();
		responseStatus.setCode(status.value());
		responseStatus.setMessage("Unexpected error");
		custom.put("debugMessage", ex.getLocalizedMessage());
	}

	public RestResponse(HttpStatus status, String message, Throwable ex) {
		this();
		ResponseStatus responseStatus = new ResponseStatus();
		responseStatus.setCode(status.value());
		responseStatus.setMessage(message);
		custom.put("debugMessage", ex.getLocalizedMessage());
	}

	public ResponseStatus getStatus() {
		return status;
	}

	public void setStatus(ResponseStatus status) {
		this.status = status;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Map<String, String> getCustom() {
		return custom;
	}

	public void setCustom(Map<String, String> custom) {
		this.custom = custom;
	}

	public ZonedDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(ZonedDateTime timestamp) {
		this.timestamp = timestamp;
	}

}
