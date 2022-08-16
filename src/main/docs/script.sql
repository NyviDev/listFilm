create database listfilm;
use listfilm;

create table usuario (
	id int auto_increment,
    nome varchar(50),
    login varchar(20),
    senha varchar(20),
    primary key(id)
);

create table filme (
	id int auto_increment,
    titulo varchar(50),
    diretor varchar(30),
    ano_lancamento varchar(4),
    genero varchar(20),
    nacionalidade varchar(30),
    primary key(id)
);

create table assistido (
	id int auto_increment,
    id_filme int,
    id_usuario int,
    avaliacao float,
    data_exibicao date,
    primary key(id),
    foreign key(id_filme) references filme(id),
    foreign key(id_usuario) references usuario(id)
);

create table desejado (
	id int auto_increment,
    id_filme int,
    id_usuario int,
    primary key(id),
    foreign key(id_filme) references filme(id),
    foreign key(id_usuario) references usuario(id)
    );