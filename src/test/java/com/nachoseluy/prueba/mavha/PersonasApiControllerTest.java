package com.nachoseluy.prueba.mavha;


import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = PruebamavhaApp.class)
@ActiveProfiles(value =
	{ "test" })
@AutoConfigureMockMvc
public class PersonasApiControllerTest
{

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void personasPost() throws Exception
	{
		String url = "/pruebamavha/v1/personas/";

		JSONObject request = new JSONObject();
		request.put("dni", "35111222");
		request.put("nombre", "María");
		request.put("apellido", "Rosales");
		request.put("edad", 35);

		String requestStr = request.toString();

		mockMvc.perform(post(url).content(requestStr)
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$[*].nombre", hasSize(1)));
	}

	@Test
	@Sql("/config/sql/insert-personas-1.sql")
	public void personasIdPersonaGetTest() throws Exception
	{
		String url = "/pruebamavha/v1/personas/34745678";

		mockMvc.perform(get(url)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$[*].nombre", hasSize(1)));

	}

	@Test
	@Sql("/config/sql/insert-personas-2.sql")
	public void personasGet() throws Exception
	{
		String url = "/pruebamavha/v1/personas/";

		mockMvc.perform(get(url).param("edad", "28")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$[*].nombre", hasSize(2)));

	}
}
