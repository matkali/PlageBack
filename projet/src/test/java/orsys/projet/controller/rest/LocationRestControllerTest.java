package orsys.projet.controller.rest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LocationRestControllerTest {
	
	// Ce mockMvc va imitier le comportement de Swagger, Postman ou Angular
		@Autowired
		private MockMvc mockMvc;
		
		@Test
		@Order(1)
		public void testerRecupererLocations() throws Exception {

			MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/locations");
			mockMvc.perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(5))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].concessionnaire.role").value("concessionnaire"))
				.andDo(MockMvcResultHandlers.print());
		}

}
