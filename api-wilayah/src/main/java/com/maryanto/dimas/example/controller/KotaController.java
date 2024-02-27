package com.maryanto.dimas.example.controller;

import com.maryanto.dimas.example.model.Kota;
import com.maryanto.dimas.example.service.KotaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.*;
import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@RestController
@RequestMapping("/api/kota")
public class KotaController {

    public KotaService kotaService;

    @Autowired
    public KotaController(KotaService kotaService) {
        this.kotaService = kotaService;
    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Kota> findAll() {
        log.info("Getting list of kota");
        return this.kotaService.findAll();
    }

    @GetMapping(value = "/findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findByIndex(@PathVariable("id") String name) {
        log.info("Getting kota by id is {}", name);
        Optional<Kota> option = this.kotaService.findByIndex(name);
        if (option.isPresent()) {
            return ok(option.get());
        } else {
            return noContent().build();
        }
    }
}
