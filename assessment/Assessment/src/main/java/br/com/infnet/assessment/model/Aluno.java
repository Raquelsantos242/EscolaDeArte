package br.com.infnet.assessment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor@Builder
public class Aluno {

        private Long id;
        private String nome;
        private String matricula;

    }

