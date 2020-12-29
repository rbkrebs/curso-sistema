package com.example.vvs.VVS.Project.controllers;

import com.example.vvs.VVS.Project.models.Disciplina;
import com.example.vvs.VVS.Project.models.Professor;
import com.example.vvs.VVS.Project.repository.DisciplinaRepository;
import com.example.vvs.VVS.Project.repository.ProfessorRepository;
import com.example.vvs.VVS.Project.services.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;


    @GetMapping(value = "/cadastrarDisciplina")
    public String form(){
        return "disciplina/formDisciplina";
    }

    @PostMapping(value = "/cadastrarDisciplina")
    public String form(Disciplina d){

        disciplinaService.save(d);
        return "redirect:listarDisciplinas";

    }

    @PostMapping(value = "/cadastrarDisciplina{id}")
    public String form(@PathVariable("id") long id, Disciplina d){

        disciplinaService.save(d);
        return "redirect:listarDisciplinas";

    }


    @GetMapping(value = "/listarDisciplinas")
    public ModelAndView listaDisciplinas(){
        ModelAndView modelAndView = new ModelAndView("disciplina/listarDisciplinas");
        List<Disciplina> disciplinas = disciplinaService.findAll();
        modelAndView.addObject("disciplinas", disciplinas);
        return modelAndView;
    }

    @GetMapping("/disciplina_edit{id}")
    public ModelAndView edit(@PathVariable("id") long id){

        ModelAndView modelAndView = new ModelAndView("disciplina/editarDisciplina");
        Disciplina disciplina = disciplinaService.findById(id);
        modelAndView.addObject("disciplina", disciplina);

        return modelAndView;
    }

    @GetMapping("/disciplina_delete{id}")
    public String delete(@PathVariable("id") long id){

        disciplinaService.delete(id);
        return "redirect:listarDisciplinas";

    }
}
