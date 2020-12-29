package com.example.vvs.VVS.Project.conversor;

import com.example.vvs.VVS.Project.models.Disciplina;
import com.example.vvs.VVS.Project.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StringToDisciplinaConverter implements Converter<List<String>, List<Disciplina>> {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Override
    public List<Disciplina> convert(List<String> source) {

        List<Disciplina> disciplinas = new ArrayList();

        if(!(source.size()>0)){
            return null;
        }
        for ( String item: source) {

        }
        return null;
    }
}
