package br.com.satyan.tdd.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
class DemoApplicationTests {

	static String PREPOSTAGEM_API = "/api/prepostagem";

	@Autowired
	MockMvc mockMvc;

	@Test
	@DisplayName("Deve criar uma pre postagem")
	public void CriarPrePostagem() throws Exception {

		String json = new ObjectMapper().writeValueAsString(null);

		var request = MockMvcRequestBuilders
				.post(PREPOSTAGEM_API)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(json);

		mockMvc
				.perform(request)
				.andExpect(MockMvcResultMatchers.status().isCreated() )
				.andExpect( MockMvcResultMatchers.jsonPath("id").isNotEmpty());

	}

	@Test
	@DisplayName("Deve lançar erro de validação quando não houver dados suficientes para criação de uma pre postagem")
	public void CriarPrePostagemInvalida(){

	}
	@Test
	void contextLoads() {
	}

}
