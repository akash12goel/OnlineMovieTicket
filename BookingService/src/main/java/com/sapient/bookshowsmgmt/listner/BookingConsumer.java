package com.sapient.bookshowsmgmt.listner;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.sapient.bookshowsmgmt.configuration.QueueConfig;

@Component
public class BookingConsumer {

	//@JmsListener(destination = QueueConfig.BOOKING_QUEUE)
	public void listener(String message) {
		// Reprocess the message
	}
}