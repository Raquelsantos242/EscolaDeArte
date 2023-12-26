package br.com.infnet.assessment;

import br.com.infnet.assessment.Util.PinturaUtil;
import br.com.infnet.assessment.exception.ResourceNotFoundException;
import br.com.infnet.assessment.model.Aluno;
import br.com.infnet.assessment.model.Pintura;
import br.com.infnet.assessment.service.AlunoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ContextConfiguration(locations = "/test-context.xml")

@SpringBootTest
public class AllTests {

    @Autowired
    AlunoService alunoService;

    @Test
    @DisplayName("Deve retornar todos os alunos")
    void retornaTodosOsAlunos() {
        List<Aluno> alunos = alunoService.getAll();
        assertEquals(3, alunos.size());
    }

    @Test
    @DisplayName("Deve retornar um aluno pelo ID")
    void retornaUmAlunoPeloId() {
        Aluno aluno = alunoService.getById(1L);
        assertEquals(aluno.getNome(), "Leonardo");
        assertEquals(aluno.getMatricula(), "125");

       assertThrows(ResourceNotFoundException.class, ()->{
           alunoService.getById(-5);
        });

    }

    @Test
    @DisplayName("Deve remover um aluno pelo ID")
    void testaRemove() {
        alunoService.deleteById(2L);
        List<Aluno> clientes = alunoService.getAll();
        assertEquals(4, clientes.size());
    }
    @Test
    @DisplayName("Deve ataualizar um valor no Map")
    void testaUpdate() {
        Aluno leonardo = new Aluno(1L, "Leonardo", "125");
        alunoService.update(1L, leonardo);
        Aluno atualizado = alunoService.getById(1L);
        assertEquals("Leonardo", atualizado.getNome());
    }

    @Test
    @DisplayName("Deve Inserir um cliente")
    void testaInsere() {
        Aluno maria = Aluno.builder()
                .nome("Maria")
                .matricula("126")
                .build();
        Aluno ostara = Aluno.builder()
                .nome("Ostara")
                .matricula("127")
                .build();
        alunoService.create(maria);

        List<Aluno> all = alunoService.getAll();
        Aluno retornado = alunoService.getById(4);
        assertEquals(4, all.size());
        assertEquals("Maria", retornado.getNome());
        alunoService.create(ostara);

        all = alunoService.getAll();
        retornado = alunoService.getById(5);
        assertEquals(5, all.size());
        assertEquals("Ostara", retornado.getNome());

    }
    @Test
    @DisplayName("Deve retornar uma pintura pelo ID")
    public void retornaPinturaPeloId(){
        PinturaUtil pinturaUtil = new PinturaUtil();
        Pintura pintura = pinturaUtil.getById(129884);
       Assertions.assertEquals("Starry Night and the Astronauts", pintura.getTitle());
        Assertions.assertEquals("1972", pintura.getDate_end());

        assertThrows(ResourceNotFoundException.class, ()->{
            alunoService.getById(-5);
        });
    }
}