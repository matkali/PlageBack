package orsys.projet.controller.rest;

import java.time.LocalDate;

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

import orsys.projet.business.Locataire;
import orsys.projet.dto.LocataireDto;
import orsys.projet.dto.LocationDtoEx;
import orsys.projet.mapper.LocataireMapper;
import orsys.projet.service.LocationService;
import orsys.projet.service.UtilisateurService;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LocationRestControllerTest {

	// Ce mockMvc va imitier le comportement de Swagger, Postman ou Angular
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private LocationService locationService ;
	@Autowired
	private UtilisateurService utilisateurService ;
	@Autowired 
	private LocataireMapper locataireMapper;

	@Test
	@Order(1)
	void testerRecupererLocations() throws Exception {
		// On teste que les données initiales ont bien été ajoutées
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/locations");
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(5))
				// Le concessionnaire n'est pas encore alloué pour la première réservation
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].concessionnaire").doesNotExist())
				// Il y a 12 parasols dans la réservation 2
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].nbParasols").value(12))
				// Le locataire de la troisième réservation est FX
				.andExpect(MockMvcResultMatchers.jsonPath("$[2].locataire.nom").value("fx"))
				// La troisième réservation coute 24*10*3 euros pour toute la rangée 2 sur 3
				// jours
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

	@Test
	@Order(3)
	public void testRecupererLocation() throws Exception {
		long idTest = locationService.recupererLocation().get(0).getId();
		System.out.println(idTest);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/location").param("ID", String.valueOf(idTest));
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.jsonPath("$.montantAReglerEnEuros").value(225))
		.andExpect(MockMvcResultMatchers.jsonPath("$.parasols").isArray());
	}
	
	@Test
	@Order(4)
	public void testCreationLocation() throws Exception {
		Locataire lola = (Locataire) utilisateurService.recupererUtilisateursParPrenom("lola").get(0);
		LocataireDto lolaDto = locataireMapper.toDto(lola); 
		LocationDtoEx locationDto = new LocationDtoEx (LocalDate.now(), LocalDate.now(), 0, lolaDto, "j'ai faim", null, null,(byte) 0);
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/creationLocation", locationDto);
		mockMvc.perform(requestBuilder);
		MockHttpServletRequestBuilder requestBuilder2 = MockMvcRequestBuilders.get("/api/locations");
		//on vérifie qu'il y a une ligne de plus, et les paramètres de la dernière ligne
		mockMvc.perform(requestBuilder2).andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(6))
				// Le concessionnaire n'est pas encore alloué pour la première réservation
				.andExpect(MockMvcResultMatchers.jsonPath("$[5].concessionnaire").doesNotExist())
				// Il y a 12 parasols dans la réservation 2
				.andExpect(MockMvcResultMatchers.jsonPath("$[5].nbParasols").value(12))
				// Le locataire de la troisième réservation est FX
				.andExpect(MockMvcResultMatchers.jsonPath("$[5].locataire.nom").value("fx"))
				// La troisième réservation coute 24*10*3 euros pour toute la rangée 2 sur 3
				// jours
				.andExpect(MockMvcResultMatchers.jsonPath("$[5].montantAReglerEnEuros").value(720))
				.andDo(MockMvcResultHandlers.print());
	}
}
