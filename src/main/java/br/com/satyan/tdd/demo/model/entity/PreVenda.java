package br.com.satyan.tdd.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PreVenda {

    private long id;
    private String remetente;
    private String destinatario;
    private String codigoObjeto;
    private String codServico;
    private String pesoAferido;

}
