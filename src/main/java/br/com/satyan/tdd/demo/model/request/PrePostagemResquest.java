package br.com.satyan.tdd.demo.model.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PrePostagemResquest {

    private long id;
    private String remetente;
    private String destinatario;
    private String codigoObjeto;
    private String codServico;
    private String pesoAferido;

}
