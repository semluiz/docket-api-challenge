package br.com.docket.restapi.seeder;

import br.com.docket.restapi.model.Cartorio;
import br.com.docket.restapi.repository.CartorioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SeedCartorio {

    @Autowired
    CartorioRepository repository;


    @EventListener
    private void seedCartorio(ContextRefreshedEvent event){
        try{
            log.info("Criando cartórios.......");
            creatingCartorios();
        }catch (Exception e){
            e.getMessage();
        }

    }

    private void creatingCartorios() {


        Cartorio cartorio1 = new Cartorio();
        cartorio1.setNome("Cartorio Regional de cotia");
        cartorio1.setEndereco("Rua Moraes de abreu, centro-cotia");
        cartorio1.setTipoCertidao("Certidões de nascimento,casamento");
        repository.save(cartorio1);


        Cartorio cartorio2 = new Cartorio();
        cartorio2.setNome("Cartorio de Embu das Artes");
        cartorio2.setEndereco("Avenida Custódio silva, embu-centro");
        cartorio2.setTipoCertidao("Casamento, Nascimento, óbito");
        repository.save(cartorio2);


    }
}
