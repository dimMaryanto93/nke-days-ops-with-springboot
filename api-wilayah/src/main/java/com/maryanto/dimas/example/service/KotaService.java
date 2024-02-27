package com.maryanto.dimas.example.service;

import com.maryanto.dimas.example.model.Kota;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class KotaService {

    List<Kota> list = Arrays.asList(Kota.builder()
                    .id("01")
                    .nama("Kab. Bandung")
                    .provinsi("Jawa Barat")
                    .build(),
            Kota.builder()
                    .id("02")
                    .nama("Jakarta Pusat")
                    .provinsi("DKI Jakarta")
                    .build(),
            Kota.builder()
                    .id("03")
                    .nama("Jakarta Selatan")
                    .provinsi("DKI Jakarta")
                    .build()
    );

    public List<Kota> findAll() {
        return list;
    }

    public Optional<Kota> findByIndex(String name) {
        Optional<Kota> optional = this.list.stream()
                .filter(kota -> kota.getId().equals(name))
                .findFirst();
        return optional;
    }
}
