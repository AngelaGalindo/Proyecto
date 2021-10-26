create table usuario(
identificacion varchar(15) not null primary key,
nombre varchar(150) not null,
tipodeidentificacion varchar(10) not null,
correo varchar(30) not null,
telefono varchar(20) not null
);

create table destino(
id integer not null primary key auto_increment,
nombre varchar(150) not null
);

create table reserva(
id integer not null primary key auto_increment,
usuario varchar(15) not null references usuario.identificacion,
destino integer not null references destino.id,
fechadesalida varchar(15) not null,
fechadellegada varchar(15) not null,
numeroDeHabitacion integer not null,
numeroDePersonas integer not null
);