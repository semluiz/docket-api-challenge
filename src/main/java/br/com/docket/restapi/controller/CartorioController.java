package br.com.docket.restapi.controller;

import br.com.docket.restapi.model.Cartorio;
import br.com.docket.restapi.service.serviceImpl.CartorioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CartorioController {
    @Autowired
    CartorioServiceImpl service;

    @GetMapping("/cartorios")
    public ModelAndView findCartorios() {
        ModelAndView mv = new ModelAndView("cartorios");
        List<Cartorio> cartorios = service.findAll();
        mv.addObject("cartorios", cartorios);
        return mv;
    }

    @GetMapping("/cartorio/{id}")
    public ModelAndView findCartorioById(@PathVariable("id") Integer id) {
        ModelAndView mv = new ModelAndView("cartorio");
        Cartorio cartorio = service.findById(id);
        mv.addObject("cartorio", cartorio);

        return mv;
    }

    @GetMapping("/novo-cartorio")
    public String getCartorio() {
        return "cartorio-form";
    }

    @PostMapping("/novo-cartorio")
    public String save(Cartorio cartorio, BindingResult errors) {
        if (errors.hasErrors()) {
            return "redirect:/cartorio-form";
        }
        service.save(cartorio);
        return "redirect:/cartorios";

    }

    @PostMapping(value = "/update-cartorio/{id}")
    public String update(Cartorio cartorio, BindingResult errors, @PathVariable("id") Integer id, Model model) {
        if (errors.hasErrors()) {
            cartorio.setId(id);
            return "/cartorio-form-edit";
        }
        service.save(cartorio);
        model.addAttribute("cartorios", service.findAll());
        return "redirect:/cartorios";

    }

    @GetMapping("/edit-cartorio/{id}")
    public String showUpdateForm(Model model, @PathVariable("id") Integer id) {
        Cartorio cartorio1 = service.findById(id);

        model.addAttribute("cartorio", cartorio1);
        return "cartorio-form-edit";


    }


    @GetMapping("/delete-cartorio/{id}")
    public String delete(@PathVariable("id") Integer id) {
        service.deleteById(id);
        return "redirect:/cartorios";

    }
}
