package br.com.satyan.tdd.demo.model.request;

import lombok.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PrePostagemRequest {

    private long id;

    @NotNull(message = "O remetente não pode ser nulo")
    private String remetente;

    @NotNull(message = "O destinatario não pode ser nulo")
    private String destinatario;

    private String codigoObjeto;

    @NotNull(message = "O codServico não pode ser nulo")
    private String codServico;

    private String pesoAferido;

}
