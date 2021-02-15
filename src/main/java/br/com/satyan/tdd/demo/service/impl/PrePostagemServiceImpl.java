package br.com.satyan.tdd.demo.service.impl;

import br.com.satyan.tdd.demo.model.entity.PreVenda;
import br.com.satyan.tdd.demo.repository.PreVendaRepository;
import br.com.satyan.tdd.demo.service.PrePostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrePostagemServiceImpl implements PrePostagemService {

    private PreVendaRepository preVendaRepository;

    public PrePostagemServiceImpl(PreVendaRepository preVendaRepository){
        this.preVendaRepository = preVendaRepository;
    }

    @Override
    public PreVenda save(PreVenda preVenda) {
        return preVendaRepository.save(preVenda);
    }
}
