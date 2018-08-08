package com.adbhut.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.adbhut.model.Destination;
import com.adbhut.model.Example;
import com.adbhut.model.Message;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/webhooks")
@Slf4j
public class PersonWebhookController {
	
	private RestTemplate restTemplate;
	
	public PersonWebhookController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@GetMapping(value = "/restClient", produces = MediaType.APPLICATION_JSON_VALUE)
	public Message restClientTesting() {
		log.info("searchMessage");
		Example  example  = restTemplate.getForObject("http://product.proxy.beeceptor.com/fakeProduct", Example.class);
		Destination destination = new Destination("no_where");
		Message message = new Message(example.toString(), MediaType.APPLICATION_JSON_VALUE, destination);
		return message;
	}
	
	
	@GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
	public Message searchMessage() {
		log.info("searchMessage");
		Example  example  = restTemplate.getForObject("http://product.proxy.beeceptor.com/fakeProduct", Example.class);
		Destination destination = new Destination("no_where");
		Message message = new Message(example.toString(), MediaType.APPLICATION_JSON_VALUE, destination);
		return message;
	}

	@PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Message createMessage() {
		log.info("searchMessage");
		Destination destination = new Destination("no_where");
		Message message = new Message("Hi", MediaType.APPLICATION_JSON_VALUE, destination);
		return message;
	}

}
