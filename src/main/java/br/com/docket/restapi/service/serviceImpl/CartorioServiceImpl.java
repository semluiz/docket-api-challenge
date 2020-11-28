package br.com.docket.restapi.service.serviceImpl;


import br.com.docket.restapi.model.Cartorio;
import br.com.docket.restapi.repository.CartorioRepository;
import br.com.docket.restapi.service.CartorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartorioServiceImpl implements CartorioService {

    @Autowired
    CartorioRepository repository;

    @Override
    public List<Cartorio> findAll() {
        return repository.findAll();
    }

    @Override
    public Cartorio findById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Cartorio update(Cartorio cartorio) {
        return repository.save(cartorio);
    }

    @Override
    public Cartorio save(Cartorio cartorio) {
        return  repository.save(cartorio);
    }
}
