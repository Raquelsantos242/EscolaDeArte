package br.com.infnet.assessment.service;

import br.com.infnet.assessment.exception.ResourceNotFoundException;
import br.com.infnet.assessment.model.Aluno;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AlunoService {
    private Map<Long, Aluno> alunos = initAlunos();
    private Long lastId = 3L;




    private Map<Long, Aluno> initAlunos() {
        Aluno joao = new Aluno(1L, "Joao", "123");
        Aluno pedro = new Aluno(2L, "Pedro", "124");
        Aluno jose = new Aluno(3L, "Jose", "125");

        Map<Long, Aluno> alunos = new HashMap<>();
        alunos.put(1L, joao);
        alunos.put(2L, pedro);
        alunos.put(3L, jose);

        return alunos;
    }

    public List<Aluno> getAll() {
        return alunos.values().stream().toList();
    }

    public List<Aluno> getAll(int start, int end) {
        List<Aluno> all = getAll();
        int count = count();
        if (end > count) end = count;
        return all.subList(start, end);
    }

   /* public List<Aluno> getByPage(int page, int size) {
        int qtdPaginas = getTotalPaginas(size);
        if (page > qtdPaginas) throw new InvalidParameterException("Page invalido");
        List<Aluno> all = getAll();
        int count = count();
        int start = (page - 1) * size;
        int end = size + start;
        if (end > count) end = count;
        return all.subList(start, end);
    }*/


    public int count() {
        return alunos.size();
    }

    public Aluno getById(long id) {
        Aluno aluno = alunos.get(id);
       if(aluno == null) throw new ResourceNotFoundException("Aluno não localizado");


        return aluno;
    }

    public void deleteById(long id) {
         alunos.remove(id);
    }

    public void update(long id, Aluno aluno) {
       aluno.setId(id);
        alunos.replace(id, aluno);
    }


    public Long getLastId() {
        return this.lastId;
    }

    public void incrementLastId() {
        this.lastId++;
    }

    public void create(Aluno aluno) {
        Long id = ++this.lastId;
        aluno.setId(id);
        alunos.put(aluno.getId(), aluno);
    }
}
