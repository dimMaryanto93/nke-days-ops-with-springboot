create table nasabah
(
    id           character varying(64) primary key,
    cif          character varying(10)  not null unique,
    nama_lengkap character varying(100) not null,
    tgl_lahir    date                   not null,
    saldo        numeric(10, 2)         not null default 0,
    created_date timestamp
);