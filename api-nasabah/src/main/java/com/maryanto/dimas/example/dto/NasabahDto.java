package com.maryanto.dimas.example.dto;

import com.maryanto.dimas.example.model.Kota;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


public class NasabahDto {

    @Data
    public static class RegisterNasabah {
        @NotNull
        @NotEmpty
        private String nik;
        @NotNull
        @NotEmpty
        private String namaLengkap;
        @NotNull
        @NotEmpty
        private String idKota;
        private String alamat;
    }
}
