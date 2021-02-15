package br.com.satyan.tdd.demo.repository;

import br.com.satyan.tdd.demo.model.entity.PreVenda;
import org.springframework.stereotype.Repository;

@Repository
public class PreVendaRepository {

    public PreVenda save(PreVenda preVenda){
        return PreVenda.builder()
                .codigoObjeto("3021")
                .destinatario("Satyan Stering Saita")
                .remetente("Migrely feliz")
                .pesoAferido("20.30")
                .build();
    }

}
