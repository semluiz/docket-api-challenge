package br.com.docket.restapi.controller;

import br.com.docket.restapi.model.Cartorio;
import br.com.docket.restapi.service.serviceImpl.CartorioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value = "cartorio-webservice")
public class CartorioController {
    @Autowired
    CartorioServiceImpl service;

    @GetMapping("/cartorios")
    public ModelAndView listCartorios(){
        ModelAndView mv = new ModelAndView("cartorios");
        List<Cartorio> cartorios = service.findAll();
        mv.addObject("cartorios", cartorios);
        return mv;
    }
}
