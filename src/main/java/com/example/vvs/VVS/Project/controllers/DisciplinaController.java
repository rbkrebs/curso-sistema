package com.example.vvs.VVS.Project.controllers;

import com.example.vvs.VVS.Project.models.Disciplina;
import com.example.vvs.VVS.Project.models.Professor;
import com.example.vvs.VVS.Project.repository.DisciplinaRepository;
import com.example.vvs.VVS.Project.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DisciplinaController {

    @Autowired
    private DisciplinaRepository disciplinaRepository;


    @RequestMapping(value = "/cadastrarDisciplina", method = RequestMethod.GET)
    public String form(){
        return "disciplina/formDisciplina";
    }

    @RequestMapping(value = "/cadastrarDisciplina", method = RequestMethod.POST)
    public String form(Disciplina d){

        disciplinaRepository.save(d);
        return "redirect:/listarDisciplinas";

    }

    @RequestMapping(value = "/cadastrarDisciplina{id}", method = RequestMethod.POST)
    public String form(@PathVariable("id") long id, Disciplina d){

        disciplinaRepository.save(d);
        return "redirect:/listarDisciplinas";

    }


    @RequestMapping(value = "/listarDisciplinas")
    public ModelAndView listaDisciplinas(){
        ModelAndView modelAndView = new ModelAndView("disciplina/listarDisciplinas");
        Iterable<Disciplina> disciplinas = disciplinaRepository.findAll();
        modelAndView.addObject("disciplinas", disciplinas);
        return modelAndView;
    }

    @RequestMapping("/edit{id}")
    public ModelAndView edit(@PathVariable("id") long id){

        ModelAndView modelAndView = new ModelAndView("disciplina/editarDisciplina");
        Disciplina disciplina = disciplinaRepository.findById(id).get();
        modelAndView.addObject("disciplina", disciplina);

        return modelAndView;
    }

    @RequestMapping("/delete{id}")
    public String delete(@PathVariable("id") long id){
        Disciplina disciplina = disciplinaRepository.findById(id).get();
        disciplinaRepository.delete(disciplina);
        return "redirect:/listarDisciplinas";

    }
}
