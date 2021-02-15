package br.com.satyan.tdd.demo.service;

import br.com.satyan.tdd.demo.model.entity.PreVenda;
import br.com.satyan.tdd.demo.repository.PreVendaRepository;
import br.com.satyan.tdd.demo.service.impl.PrePostagemServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class PrePostagemServiceTest {

    PrePostagemService service;

    @MockBean
    PreVendaRepository preVendaRepository;

    @BeforeEach
    public void setUp(){
        this.service = new PrePostagemServiceImpl(preVendaRepository);
    }

    @Test
    @DisplayName("deve salvar uma pre postagem")
    public void salvarPrePostagemSevice(){
        //cenario
        PreVenda preVenda = PreVenda.builder()
                .codigoObjeto("3021")
                .destinatario("Satyan Stering Saita")
                .remetente("Migrely feliz")
                .pesoAferido("20.30")
                .build();

        PreVenda preVendaSalva = PreVenda.builder()
                .id(1)
                .codServico("3021")
                .destinatario("Satyan Stering Saita")
                .remetente("Migrely feliz")
                .pesoAferido("20.30")
                .build();

        Mockito.when(preVendaRepository.save(preVenda)).thenReturn(preVendaSalva);


        //execucao
        preVendaSalva = service.save(preVenda);

        //verificacoes
        assertThat(preVendaSalva.getId()).isNotNull();
        assertThat(preVendaSalva.getCodServico()).isEqualTo("3021");
        assertThat(preVendaSalva.getDestinatario()).isEqualTo("Satyan Stering Saita");
        assertThat(preVendaSalva.getRemetente()).isEqualTo("Migrely feliz");
        assertThat(preVendaSalva.getPesoAferido()).isEqualTo("20.30");
    }
}
