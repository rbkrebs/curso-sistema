package com.example.vvs.VVS.Project;


import com.example.vvs.VVS.Project.models.Professor;
import com.example.vvs.VVS.Project.repository.ProfessorRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ProfessorTest {


    @Autowired
    private ProfessorRepository professorRepository;


    @Before
    public void setUp() {
        Professor p1 = new Professor(1L, "p1", 1);
        professorRepository.save(p1);
        Professor p2 = professorRepository.findById(1L).get();
        assertEquals(p1.getNome(), p2.getNome());


    }

    @Test
    public void testPegaOPrimeiroCadastro(){


    // when
    Professor p1 =  professorRepository.findById(1L).get();

    // then
    assertThat(p1.getNome()).isEqualTo("p1");



    }

}
