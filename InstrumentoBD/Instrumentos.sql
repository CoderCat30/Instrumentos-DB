CREATE DATABASE Instrumentos;

use Instrumentos;

create table TipoInstrumento (
       codigo  varchar(10)  not null,
       nombre varchar(30) not null,
	   unidad  varchar(20),
       Primary Key (codigo)         
     );

insert into TipoInstrumento (codigo ,nombre, unidad) values('TER','Termómetro','Grados Celcius');