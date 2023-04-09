create database cadastromusicas;

use cadastromusicas;

create table usuario(
id int auto_increment,
nome varchar(60),
login varchar(60),
senha varchar(60),
primary key(id)
);

create table artista(
id int auto_increment,
usuario_id int,
nome varchar(60),
foreign key (usuario_id) references usuario(id),
primary key(id)
);

create table album(
id int auto_increment,
titulo varchar(60),
artista_id int,
foreign key (artista_id) references artista(id),
primary key (id)
);

create table musica(
id int auto_increment,
nome varchar(60),
album_id int,
foreign key (album_id) references album(id),
primary key(id)
);