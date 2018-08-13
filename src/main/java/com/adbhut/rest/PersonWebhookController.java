package com.adbhut.rest;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.adbhut.model.Destination;
import com.adbhut.model.Example;
import com.adbhut.model.Message;

import io.vertx.core.Vertx;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.WebClientOptions;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/webhooks")
@Slf4j
public class PersonWebhookController {

	private RestTemplate restTemplate;

	private WebClientOptions options;

	public PersonWebhookController(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
		this.options = new WebClientOptions().setIdleTimeout(10000).setConnectTimeout(20000).setHttp2MaxPoolSize(20)
				.setKeepAlive(true);
	}

	@GetMapping(value = "/restClient", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Message restClientTesting() {
		log.info("searchMessage");
		Example example = restTemplate.getForObject("http://product.proxy.beeceptor.com/fakeProduct", Example.class);
		Destination destination = new Destination("no_where");
		Message message = new Message(example.toString(), MediaType.APPLICATION_JSON_VALUE, destination);
		return message;
	}

	@GetMapping(value = "/searchClientTest", produces = MediaType.APPLICATION_JSON_VALUE)
	public Message restClientFailed() {
		log.info("calling vertx rest client");

		Vertx vertx = Vertx.vertx();
		WebClient client = WebClient.create(vertx, options);

		client.getAbs("http://product.proxy.beeceptor.com/fakeProduct").send(ar -> {
			if (ar.succeeded()) {
				io.vertx.ext.web.client.HttpResponse<io.vertx.core.buffer.Buffer> response = ar.result();

				log.info("Received response with status code '{}' ", response.statusCode());
				log.info("Response body {}", response.bodyAsString());
				
			} else {
				log.info("Something went wrong '{}' ", ar.cause().getMessage());
			}
		});

		Example example = restTemplate.getForObject("http://product.proxy.beeceptor.com/fakeProduct", Example.class);
		Destination destination = new Destination("no_where");
		Message message = new Message(example.toString(), MediaType.APPLICATION_JSON_VALUE, destination);
		return message;
	}

	@GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
	public Message searchMessage() {
		log.info("searchMessage");
		Example example = restTemplate.getForObject("http://product.proxy.beeceptor.com/fakeProduct", Example.class);
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
