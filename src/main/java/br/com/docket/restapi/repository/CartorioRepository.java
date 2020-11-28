package br.com.docket.restapi.repository;

import br.com.docket.restapi.model.Cartorio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartorioRepository extends JpaRepository<Cartorio, Integer> {
}
