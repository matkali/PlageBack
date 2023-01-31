package orsys.projet.controller.rest;

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
		// On teste que les données initiales ont bien été ajoutées
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/locations");
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(5))
				// Le concessionnaire n'est pas encore alloué pour la première réservation
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].concessionnaire").doesNotExist())
				// Il y a 12 parasols dans la réservation 2
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].nbParasols").value(12))
				// Le locataire de la troisième réservation est FX
				.andExpect(MockMvcResultMatchers.jsonPath("$[2].locataire.nom").value("fx"))
				// La troisième réservation coute 24*10*3 euros pour toute la rangée 2 sur 3 jours
				.andExpect(MockMvcResultMatchers.jsonPath("$[3].montantAReglerEnEuros").value(720))
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	@Order(2)
	public void testerRecupererLocationsEnAttente() throws Exception {
		// On teste que les données initiales ont bien été ajoutées
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/locations_en_attente");
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(1))
				// Le concessionnaire n'est pas encore alloué pour la première réservation
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].concessionnaire").doesNotExist())
				.andDo(MockMvcResultHandlers.print());
	}
}
