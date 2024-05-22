package com.sapient.bookshowsmgmt.configuration;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import jakarta.jms.Queue;

@EnableJms
@Configuration
public class QueueConfig {
	public static final String BOOKING_QUEUE = "booking.queue";
	public static final String NOTIFICATION_QUEUE = "notification.queue";

	@Bean
	public Queue bookingQueue() {
		return new ActiveMQQueue(BOOKING_QUEUE);
	}

	@Bean
	public Queue notificationQueue() {
		return new ActiveMQQueue(NOTIFICATION_QUEUE);
	}
}