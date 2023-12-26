package br.com.infnet.assessment.Util;

import br.com.infnet.assessment.AssessmentApplication;
import br.com.infnet.assessment.model.Pintura;
import br.com.infnet.assessment.exception.NotFoundException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class PinturaUtil {
    public static final Logger LOGGER = LoggerFactory.getLogger(AssessmentApplication.class);

    public Pintura getById(int id) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .version(HttpClient.Version.HTTP_2)
                    .uri(new URI("https://api.artic.edu/api/v1/artworks/" + id))
                    .build();

            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


            if (response.statusCode() == 404) {
                throw new NotFoundException("pintura não encontrada");
            }

            ObjectMapper mapper = JsonMapper.builder().addModule(new JavaTimeModule()).build();
            Pintura pintura = mapper.readValue(response.body(), Pintura.class);
            return pintura;

        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }




}
