package com.example.vvs.VVS.Project.controllers;

import com.example.vvs.VVS.Project.models.Professor;
import com.example.vvs.VVS.Project.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @RequestMapping(value = "/cadastrarProfessor", method = RequestMethod.GET)
    public String form(){
        return "professor/formProfessor";
    }

    @RequestMapping(value = "/cadastrarProfessor", method = RequestMethod.POST)
    public String form(Professor p){
        professorRepository.save(p);
        return "redirect:/cadastrarProfessor";
    }

    @RequestMapping(value = "/listarProfessores")
    public ModelAndView listaProfessores(){
        ModelAndView modelAndView = new ModelAndView("professor/listarProfessores");
        Iterable<Professor> professores = professorRepository.findAll();
        modelAndView.addObject("professores", professores);
        return modelAndView;
    }


}
