package br.com.satyan.tdd.demo.exception;

import lombok.Data;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

@Data
public class ApiErros {

    private List<String> erros;

    public ApiErros(BindingResult bidiBindingResult){
        this.erros = new ArrayList();
        bidiBindingResult.getAllErrors().forEach( error -> this.erros.add(error.getDefaultMessage()));
    }
}
