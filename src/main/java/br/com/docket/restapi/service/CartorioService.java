package br.com.docket.restapi.service;

import br.com.docket.restapi.model.Cartorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartorioService {
    List<Cartorio> findAll();

    Cartorio findById(Integer id);

    void deleteById(Integer id);

    Cartorio update(Cartorio cartorio);

    Cartorio save(Cartorio cartorio);
}
