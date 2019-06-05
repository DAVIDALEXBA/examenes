create table materia(
    id integer auto_increment primary key,
    nombre varchar(64) not null

);

create table materia_preguntas(
    id integer auto_increment primary key,
    pregunta text not null,
    respuestas text not null,
    indice integer not null,
    materia_id integer not null,
    foreign key(materia_id) references materia(id)

);

insert into materia(nombre) values("Matematicas");
insert into materia(nombre) values("Filosofia");
insert into materia(nombre) values("Laboratorio de Aplicaciones Empresariales");