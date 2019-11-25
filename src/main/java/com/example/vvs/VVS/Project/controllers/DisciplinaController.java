package com.example.vvs.VVS.Project.controllers;

import com.example.vvs.VVS.Project.models.Disciplina;
import com.example.vvs.VVS.Project.models.Professor;
import com.example.vvs.VVS.Project.repository.DisciplinaRepository;
import com.example.vvs.VVS.Project.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DisciplinaController {

    @Autowired
    private DisciplinaRepository DisciplinaRepository;


    @RequestMapping(value = "/cadastrarDisciplina", method = RequestMethod.GET)
    public String form(){
        return "disciplina/formDisciplina";
    }

    @RequestMapping(value = "/cadastrarDisciplina", method = RequestMethod.POST)
    public String form(Disciplina d){

        DisciplinaRepository.save(d);
        return "redirect:/listarDisciplinas";
    }

    @RequestMapping(value = "/listarDisciplinas")
    public ModelAndView listaDisciplinas(){
        ModelAndView modelAndView = new ModelAndView("disciplina/listarDisciplinas");
        Iterable<Disciplina> disciplinas = DisciplinaRepository.findAll();
        modelAndView.addObject("disciplinas", disciplinas);
        return modelAndView;
    }
}
