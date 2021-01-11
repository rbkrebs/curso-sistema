package com.example.vvs.VVS.Project.controllers;

import com.example.vvs.VVS.Project.DTO.ProfessorDTO;
import com.example.vvs.VVS.Project.models.Disciplina;
import com.example.vvs.VVS.Project.models.Professor;
import com.example.vvs.VVS.Project.repository.DisciplinaRepository;
import com.example.vvs.VVS.Project.repository.ProfessorRepository;
import com.example.vvs.VVS.Project.services.DisciplinaService;
import com.example.vvs.VVS.Project.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;
    @Autowired
    private DisciplinaService disciplinaService;

    private List<Disciplina> disciplinas;

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
    public String form(Model model){

        ProfessorDTO professorDTO = new ProfessorDTO();
        //disciplinaService.findAll().forEach(professorDTO :: addDisciplina);
        model.addAttribute("professor", professorDTO);
        return "professor/formProfessor";
    }

    @PostMapping(value = "/cadastrarProfessor")
    public String save(@ModelAttribute ProfessorDTO professor){

        Professor p = new Professor();
        p.setCargaHoraria(professor.getCargaHoraria());
        p.setNome(professor.getNome());
        p.setDataAdmissao(professor.getDataAdmissao());
        p.setDisciplinas(professor.getDisciplinas());

        professorService.save(p);
        return "redirect:listarProfessores";
    }

    @PostMapping(value = "/cadastrarProfessor{id}")
    public ModelAndView form(@PathVariable("id") long id, Professor professor,
                             @RequestParam(name="disciplina", required = false) Long idDisdiciplina) {

        System.out.println(idDisdiciplina);
        System.out.println(professor);

        if(idDisdiciplina == null){

            Professor p = professorService.findById(id);
            p.setDisciplinas(professor.getDisciplinas());
            p.setCargaHoraria(professor.getCargaHoraria());
            p.setNome(professor.getNome());
            p.setDataAdmissao(professor.getDataAdmissao());
            professorService.save(p);
            return this.edit(id);

        }

            Professor p = professorService.findById(id);
            //p.getDisciplinas().forEach(professor.getDisciplinas():: add);
            p.setCargaHoraria(professor.getCargaHoraria());
            p.setNome(professor.getNome());
            p.setDataAdmissao(professor.getDataAdmissao());
            professorService.save(p);
            return this.edit(id);





    }

    @GetMapping(value = "/listarProfessores")
    public ModelAndView listaProfessores(){

        ModelAndView modelAndView = new ModelAndView("professor/listarProfessores");
        List<Professor> professores = professorService.findAll();
        modelAndView.addObject("professores", professores);
        return modelAndView;
    }

    @GetMapping("/professor_edit{id}")
    public ModelAndView edit(@PathVariable("id") long id){

        ModelAndView modelAndView = new ModelAndView("professor/editarProfessor");
        Professor professor = professorService.findById(id);
        modelAndView.addObject("professorEdit", professor);

        return modelAndView;
    }

    @GetMapping("/professor_delete{id}")
    public String delete(@PathVariable("id") long id){

        professorService.delete(id);
        return "redirect:listarProfessores";

    }

    @ModelAttribute("disciplinas")
    public List<Disciplina> listaDisciplinas(){
        List<Disciplina> disciplinas = new ArrayList();
        disciplinaService.findAll().forEach(disciplinas::add);
        return disciplinas;
    }



}
