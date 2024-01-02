SET GLOBAL time_zone = '+3:00';
create database biblioteca;
create user bibliotecario identified by 'bibliotecario';
grant all privileges on biblioteca.* to 'bibliotecario';
use biblioteca;
create table libros (isbn INT(13) primary key, titulo varchar(30) not null, autor varchar(30) not null);
