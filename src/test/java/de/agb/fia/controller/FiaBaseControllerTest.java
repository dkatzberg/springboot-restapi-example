/**
 * 
 */
package de.agb.fia.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author DanielKatzberg
 *
 */
@WebMvcTest(FiaBasicController.class)
public class FiaBaseControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void getAllEmployeesAPI() throws Exception {
		//Arrange
		
		//Act
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
				.get("/halloFia")
				.accept(MediaType.TEXT_PLAIN))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		//Assert
		assertEquals("Hi FIA", mvcResult.getResponse().getContentAsString());
	}

}
