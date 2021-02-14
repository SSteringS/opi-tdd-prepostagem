package br.com.satyan.tdd.demo.rest;

import br.com.satyan.tdd.demo.model.entity.PreVenda;
import br.com.satyan.tdd.demo.model.request.PrePostagemRequest;
import br.com.satyan.tdd.demo.service.PrePostagemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prepostagem")
public class PrePostagemRest {

    @Autowired
    private PrePostagemService prePostagemService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping()
    public String teste(){
        return "teste";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PrePostagemRequest criarPrePostagem(@RequestBody PrePostagemRequest request){
        PreVenda preVenda = modelMapper.map(request, PreVenda.class);
        preVenda = prePostagemService.save(preVenda);
        return modelMapper.map(preVenda, PrePostagemRequest.class);
    }


}
