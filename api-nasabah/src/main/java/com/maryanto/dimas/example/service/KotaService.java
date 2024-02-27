package com.maryanto.dimas.example.service;

import com.maryanto.dimas.example.model.Kota;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class KotaService {

    private final String kotaServiceUrl;
    private RestTemplateBuilder restBuilder;

    public KotaService(RestTemplateBuilder restBuilder,
                       @Value("${clients.wilayah-service.url}") String kotaServiceUrl) {
        this.kotaServiceUrl = kotaServiceUrl;
        this.restBuilder = restBuilder;
    }

    public Optional<Kota> findKotaById(String id) {
        RestTemplate template = this.restBuilder.build();
        ResponseEntity<Kota> responseEntity = template.getForEntity(kotaServiceUrl + "/api/kota/findById/{id}", Kota.class, id);
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            return Optional.empty();
        }

        return Optional.ofNullable(responseEntity.getBody());
    }
}
