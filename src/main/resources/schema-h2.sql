create table cliente (
    id identity primary key,
    dni varchar(100) not null,
    nombres varchar(100) not null,
    apellidos varchar(100) not null,
    email varchar(100) not null,
    telefono varchar(100) not null,
    password varchar(100) not null,
    estado varchar(2) not null,
    direccion varchar(100) not null
);
