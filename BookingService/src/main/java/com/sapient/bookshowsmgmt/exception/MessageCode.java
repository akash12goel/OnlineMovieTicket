package com.sapient.bookshowsmgmt.exception;

/*The purpose of this enumeration is to return a message code for every exception thrown so that the API consuming the data understands
	what actually is the issue */
public enum MessageCode {

	BAD_REQUEST_MISSING_REQUEST_FIELD("E100", "Missing Mandatory Request Field"),

	BAD_REQUEST_MISSING_REQUEST_HEADER("E101", "Missing Mandatory Request Header Field"),

	UNSUPPORTED_MEDIA_TYPE("E103", "Content Type Mismatch"),

	UNAUTHORIZED("E104", "Authentication Information Missing"),

	BAD_REQUEST_FIELD_FORMAT_INVALID("E105", "Field Format Is Invalid"),

	INTERNAL_SERVER_ERROR_INFORMATION_NOT_DM("E200", "Requested Information Is Not Avaliable"),

	INTERNAL_SERVER_ERROR_UNPROCESS("E201", "Unable To Process The Request"),

	RESPONSE_DATA_EMPTY("S204", "Request has been processed successfully with no data found"),

	SUCCESSFUL_RESPONSE("S200", "Request has been processed successfully");

	private final String value;

	private final String reasonPhrase;

	MessageCode(String value, String reasonPhrase) {
		this.value = value;
		this.reasonPhrase = reasonPhrase;
	}

	public String value() {
		return this.value;
	}

	public String getReasonPhrase() {
		return this.reasonPhrase;
	}

}
