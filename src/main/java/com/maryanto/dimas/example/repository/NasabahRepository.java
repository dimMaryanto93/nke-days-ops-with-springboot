package com.maryanto.dimas.example.repository;

import com.maryanto.dimas.example.model.Nasabah;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NasabahRepository extends CrudRepository<Nasabah, String> {

    List<Nasabah> findAll();
}
