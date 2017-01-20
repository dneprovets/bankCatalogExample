/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package hello;

import hello.domain.Business;
import hello.repository.BusinessRepository;
import hello.repository.EmployeeRepository;
import hello.repository.ProductRepository;
import hello.repository.ProductVersionRepository;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private BusinessRepository businessRepository;
	@Autowired
	private ProductVersionRepository productVersionRepository;

//	@Before
//	public void deleteAllBeforeTests() throws Exception {
//		productRepository.deleteAll();
//		employeeRepository.deleteAll();
//		businessRepository.deleteAll();
//		productVersionRepository.deleteAll();
//	}

	@Test
	@Ignore
	public void shouldReturnRepositoryIndex() throws Exception {

		mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(
				jsonPath("$._links.product").exists());
	}

	@Test
	@Ignore
	public void shouldProductCreateEntity() throws Exception {

		mockMvc.perform(post("/product").content(
				"{\"productName\": \"Frodo\", \"productType\":\"Baggins\"}")).andExpect(
						status().isCreated()).andExpect(
								header().string("Location", containsString("product/")));
	}

	@Test
	@Ignore
	public void shouldEmployeeCreateEntity() throws Exception {

		mockMvc.perform(post("/employee").content(
				"{\"firstName\": \"Frodo\", \"lastName\":\"Baggins\"}")).andExpect(
				status().isCreated()).andExpect(
				header().string("Location", containsString("employee/")));
	}


	@Test
	@Ignore
	public void shouldBusinessCreateEntity() throws Exception {

		mockMvc.perform(post("/business").content(
				"{\"name\": \"CEB\"}")).andExpect(
				status().isCreated()).andExpect(
				header().string("Location", containsString("business/")));
	}


	@Test
	@Ignore
	public void shouldProductVersionCreateEntity() throws Exception {

		mockMvc.perform(post("/productVersion").content(
				"{\"state\": \"a\"}")).andExpect(
				status().isCreated()).andExpect(
				header().string("Location", containsString("productVersion/")));
	}


	@Test
	@Ignore
	public void shouldRetrieveEntity() throws Exception {

		MvcResult mvcResult = mockMvc.perform(post("/product").content(
				"{\"productName\": \"Frodo\", \"productType\":\"Baggins\"}")).andExpect(
						status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");
		mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
				jsonPath("$.productName").value("Frodo")).andExpect(
						jsonPath("$.productType").value("Baggins"));
	}

	@Test
	@Ignore
	public void shouldQueryEntity() throws Exception {

		mockMvc.perform(post("/product").content(
				"{\"productName\": \"Frodo\", \"productType\":\"Baggins\"}")).andExpect(
						status().isCreated());

		mockMvc.perform(
				get("/product/search/findByProductName?name={name}", "Frodo")).andExpect(
						status().isOk()).andExpect(
								jsonPath("$._embedded.product[0].productName").value(
										"Frodo"));
	}

	@Test
	@Ignore
	public void shouldUpdateEntity() throws Exception {

		MvcResult mvcResult = mockMvc.perform(post("/product").content(
				"{\"productName\": \"Frodo\", \"productType\":\"Baggins\"}")).andExpect(
						status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");

		mockMvc.perform(put(location).content(
				"{\"productName\": \"Frodo\", \"productType\":\"Baggins\"}")).andExpect(
						status().isNoContent());

		mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
				jsonPath("$.productName").value("Frodo")).andExpect(
						jsonPath("$.productType").value("Baggins"));
	}

	@Test
	@Ignore
	public void shouldPartiallyUpdateEntity() throws Exception {

		MvcResult mvcResult = mockMvc.perform(post("/product").content(
				"{\"productName\": \"Frodo\", \"productType\":\"Baggins\"}")).andExpect(
						status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");

		mockMvc.perform(
				patch(location).content("{\"productName\": \"Bilbo Jr.\"}")).andExpect(
						status().isNoContent());

		mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
				jsonPath("$.productName").value("Bilbo Jr.")).andExpect(
						jsonPath("$.productType").value("Baggins"));
	}

	@Test
	@Ignore
	public void shouldDeleteEntity() throws Exception {

		MvcResult mvcResult = mockMvc.perform(post("/product").content(
				"{\"productName\": \"Frodo\", \"productType\":\"Baggins\"}")).andExpect(
						status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");
		mockMvc.perform(delete(location)).andExpect(status().isNoContent());

		mockMvc.perform(get(location)).andExpect(status().isNotFound());
	}
}