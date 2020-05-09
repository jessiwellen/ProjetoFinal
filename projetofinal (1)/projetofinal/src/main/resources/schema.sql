drop table if exists evento;

create table evento(
  id_evento bigint auto_increment,
  organizador varchar(100) not null,
  email varchar(100) not null,
  contato varchar (14) not null,
  cidade varchar(20) not null,
  estado varchar(2) not null,
  tipodeevento varchar(50) not null,
  primary key(id_evento)
);