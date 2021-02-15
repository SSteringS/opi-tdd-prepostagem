package br.com.satyan.tdd.demo;

import br.com.satyan.tdd.demo.model.entity.PreVenda;
import br.com.satyan.tdd.demo.model.request.PrePostagemRequest;
import br.com.satyan.tdd.demo.service.PrePostagemService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
class DemoApplicationTests {

	static String PREPOSTAGEM_API = "/api/prepostagem";

	@Autowired
	MockMvc mockMvc;

	@MockBean
	PrePostagemService service;

	@Test
	@DisplayName("Deve criar uma pre postagem")
	public void CriarPrePostagem() throws Exception {

		PrePostagemRequest prePostagemRequest = PrePostagemRequest.builder()
				.codServico("3021")
				.destinatario("Satyan Stering Saita")
				.remetente("Migrely feliz")
				.pesoAferido("20.30")
				.build();
		PreVenda preVendaSalva = PreVenda.builder()
				.id(1l)
				.codServico("3021")
				.destinatario("Satyan Stering Saita")
				.remetente("Migrely feliz")
				.pesoAferido("20.30")
				.build();
		String json = new ObjectMapper().writeValueAsString(prePostagemRequest);
		BDDMockito.given(service.save(Mockito.any(PreVenda.class))).willReturn(preVendaSalva);

		var request = MockMvcRequestBuilders
				.post(PREPOSTAGEM_API)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(json);

		mockMvc
				.perform(request)
				.andExpect(status().isCreated() )
				.andExpect( jsonPath("id").isNotEmpty());

	}

	@Test
	@DisplayName("Deve lançar erro de validação quando não houver dados suficientes para criação de uma pre postagem")
	public void CriarPrePostagemInvalida(){

	}
	@Test
	@DisplayName("Deve lançar erro de validação quando não houver dados suficientes para criação de uma pre postagem")
	void contextLoads() throws Exception {

		String json = new ObjectMapper().writeValueAsString(new PrePostagemRequest());

		var request = MockMvcRequestBuilders
				.post(PREPOSTAGEM_API)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(json);

		mockMvc.perform(request)
				.andExpect( status().isBadRequest() )
				.andExpect( jsonPath("erros", Matchers.hasSize(3)));
	}

}
