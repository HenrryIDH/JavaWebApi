drop database if exists negocioWeb;
create database negocioWeb;
use negocioWeb;

create table articulos(
    id int primary key,
    descripcion varchar(25),
    precio float
);

--alter table articulos add zona varchar(25) after descripcion;

select * from articulos;
