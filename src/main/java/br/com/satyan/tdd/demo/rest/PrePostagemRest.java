package br.com.satyan.tdd.demo.rest;

import br.com.satyan.tdd.demo.model.request.PrePostagemResquest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prepostagem")
public class PrePostagemRest {



    @GetMapping()
    public String teste(){
        return "teste";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PrePostagemResquest criarPrePostagem(){
        PrePostagemResquest prePostagemResquest = PrePostagemResquest.builder()
                .id(1l)
                .codigoObjeto("3021")
                .destinatario("Satyan Stering Saita")
                .remetente("Migrely feliz")
                .pesoAferido("20.30")
                .build();
        return prePostagemResquest;
    }


}
