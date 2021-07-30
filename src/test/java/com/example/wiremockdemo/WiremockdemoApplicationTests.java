package com.example.wiremockdemo;

import com.example.wiremockdemo.model.User;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

import java.awt.*;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = {WireMockInit.class})
class WiremockdemoApplicationTests {

	@Autowired
	WebTestClient webTestClient;

	@Autowired
	private WireMockServer wireMockServer;


	@Test
	void createUsertest() {

		System.out.println("Creating stub");
		wireMockServer.stubFor(


				WireMock.post("")
				.willReturn(

						aResponse()
						    .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
						    .withBody("[]")
				)


		);


	byte[] temp =	webTestClient.post()
				     .uri("/user")
			.contentType(MediaType.APPLICATION_JSON)
			//.accept(MediaType.APPLICATION_JSON)
				     .body(BodyInserters.fromValue(createUser()))
				      .exchange()
				      .expectBody()
				     .returnResult()
				.getResponseBody();

	String s = new String(temp);

	System.out.println(s);





	}



	public User createUser()
	{
		return  User.builder()
				.firstName("neel")
				.age(32)
				.id(1234)
				.build();
	}


}
