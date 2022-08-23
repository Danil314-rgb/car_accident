create table types
(
    id   serial primary key,
    name text
);

insert into types (id, name) values (1, 'Столкновение');
insert into types (id, name) values (2, 'Опрокидывание');
insert into types (id, name) values (3, 'Наезд на препятствие');
insert into types (id, name) values (4, 'Наезд на пешехода');
insert into types (id, name) values (5, 'Наезд на велосипедиста');
insert into types (id, name) values (6, 'Наезд на животное');
insert into types (id, name) values (7, 'Наезд на гужевой транспорт');
insert into types (id, name) values (8, 'Наезд на стоящее транспортное средство');
insert into types (id, name) values (9, 'Прочие происшествия');

create table accidents
(
    id      serial primary key,
    name    text,
    text    text,
    address text,
    type_id int references types (id)
);

create table users
(
    id       serial primary key,
    name     text,
    email    text not null unique,
    password text not null
);

insert into users (id, name, email, password) values (1, 'Admin', 'Admin', 'Admin');