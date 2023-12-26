package br.com.infnet.assessment.controller;

import br.com.infnet.assessment.exception.ResourceNotFoundException;
import br.com.infnet.assessment.model.Aluno;
import br.com.infnet.assessment.model.Pintura;
import br.com.infnet.assessment.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/pintura")

public class AlunoController {
    @Autowired
    AlunoService alunoService;
    @GetMapping
    public List<Aluno> getAll(){
        List<Aluno> alunos = alunoService.getAll();
        return alunos;
    }
    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        try{
           Aluno aluno = alunoService.getById(id);
           return  ResponseEntity.ok(aluno);
        }catch (ResourceNotFoundException ex){
            return  ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public void create(@RequestBody Aluno aluno){
        alunoService.create(aluno);
    }




    @DeleteMapping("/{id}")
   public void delete(@PathVariable Long id) {
        alunoService.deleteById(id);

    }


@PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Aluno atualizado){
        alunoService.update(id,atualizado);
}

    }

