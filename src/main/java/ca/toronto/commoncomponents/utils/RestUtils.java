package ca.toronto.commoncomponents.utils;

import org.springframework.web.client.RestTemplate;


public class RestUtils {

	
	private RestTemplate restTemplate;

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
}
