package com.maryanto.dimas.example.controller;

import com.maryanto.dimas.example.model.Nasabah;
import com.maryanto.dimas.example.repository.NasabahRepository;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nasabah/v1")
public class NasabahController {

    public NasabahRepository nasabahRepo;

    @Autowired
    public NasabahController(NasabahRepository nasabahRepo) {
        this.nasabahRepo = nasabahRepo;
    }

    @GetMapping("/list")
    public List<Nasabah> findAll() {
        return this.nasabahRepo.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Nasabah data) {
        try {
            data = this.nasabahRepo.save(data);
            return ResponseEntity.ok(data);
        } catch (DataException dex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") String id) {
        this.nasabahRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
