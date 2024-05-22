package com.sapient.bookshowsmgmt.configuration;

import java.time.Duration;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

	@Bean
	public RestTemplate restTemplate() {
		PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
		connectionManager.setMaxTotal(2000); // Max total connections
		connectionManager.setDefaultMaxPerRoute(2000); // Max connections per route

		CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connectionManager).build();

		return new RestTemplateBuilder().setConnectTimeout(Duration.ofMillis(1000))
				//.setReadTimeout(Duration.ofMillis(1000))
				.messageConverters(new StringHttpMessageConverter(), new MappingJackson2HttpMessageConverter())
				.requestFactory(() -> new HttpComponentsClientHttpRequestFactory(httpClient)).build();

	}
}
