package br.com.infnet.assessment;

import lombok.Getter;
import org.springframework.boot.SpringApplication;
import br.com.infnet.assessment.model.Pintura;
import br.com.infnet.assessment.Util.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ImportResource;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class AssessmentApplication {
	public static final Logger LOGGER = LoggerFactory.getLogger(AssessmentApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AssessmentApplication.class, args);
boolean v1 = true;
		//129884
		do {
			getPintura();
		} while (v1 = true);


	}
	private static void getPintura() {
		Scanner scanner = new Scanner(System.in);
		PinturaUtil pinturaUtil = new PinturaUtil();
		LOGGER.debug("Digite o id da pintura");
		int Id = scanner.nextInt();
		Pintura pintura = pinturaUtil.getById(Id);


	}
}
