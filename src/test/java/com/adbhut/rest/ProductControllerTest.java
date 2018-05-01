package com.adbhut.rest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.adbhut.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {
	
	@Autowired
	private TestRestTemplate restTemplate;

	@MockBean
	private ProductService productService;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testSetProductService() throws Exception {
	}

	@Test
	public void testList() throws Exception {
	}

	@Test
	public void testShowProduct() throws Exception {
	}

	@Test
	public void testSaveProduct() throws Exception {
	}

	@Test
	public void testUpdateProduct() throws Exception {
	}

	@Test
	public void testDelete() throws Exception {
	}

}
