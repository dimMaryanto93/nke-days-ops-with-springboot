package com.maryanto.dimas.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "nasabah")
public class Nasabah {
    @Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    private String id;
    @Column(name = "cif")
    private String cif;
    @Column(name = "nama_lengkap")
    private String namaLengkap;
    @Column(name = "tgl_lahir")
    private LocalDate tanggalLahir;
    @Column(name = "saldo")
    private BigDecimal saldo;
}
