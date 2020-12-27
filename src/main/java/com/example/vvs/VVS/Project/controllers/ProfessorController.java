package com.example.vvs.VVS.Project.controllers;

import com.example.vvs.VVS.Project.models.Disciplina;
import com.example.vvs.VVS.Project.models.Professor;
import com.example.vvs.VVS.Project.repository.DisciplinaRepository;
import com.example.vvs.VVS.Project.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;


@Controller
@RequestMapping("professor")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @InitBinder
    private void dateBinder(WebDataBinder binder) {
        //The date format to parse or output your dates
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        //Create a new CustomDateEditor
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        //Register it as custom editor for the Date type
        binder.registerCustomEditor(LocalDateTime.class, editor);
    }




    @GetMapping(value = "/cadastrarProfessor")
    public String form(){
        return "professor/formProfessor";
    }

    @PostMapping(value = "/cadastrarProfessor")
    public String form(Professor p){
        professorRepository.save(p);
        return "redirect:listarProfessores";
    }

    @PostMapping(value = "/cadastrarProfessor{id}")
    public String form(@PathVariable("id") long id, Professor p){

        professorRepository.save(p);
        return "redirect:listarProfessores";

    }

    @GetMapping(value = "/listarProfessores")
    public ModelAndView listaProfessores(){
        ModelAndView modelAndView = new ModelAndView("professor/listarProfessores");
        Iterable<Professor> professores = professorRepository.findAll();
        modelAndView.addObject("professores", professores);
        return modelAndView;
    }

    @GetMapping("/professor_edit{id}")
    public ModelAndView edit(@PathVariable("id") long id){

        ModelAndView modelAndView = new ModelAndView("professor/editarProfessor");
        Professor professor = professorRepository.findById(id).get();
        modelAndView.addObject("professor", professor);

        return modelAndView;
    }

    @GetMapping("/professor_delete{id}")
    public String delete(@PathVariable("id") long id){
        Professor professor = professorRepository.findById(id).get();
        professorRepository.delete(professor);
        return "redirect:listarProfessores";

    }



}
