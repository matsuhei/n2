CREATE DATABASE testdb;
set client_encoding = 'UTF8';

\c testdb; 

create table users (
  ID serial primary key,
  name varchar not null,
  age integer not null,
  created_at timestamp NULL DEFAULT NULL,
  updated_at timestamp NULL DEFAULT NULL,
  deleted_at timestamp NULL DEFAULT NULL
);

insert into users(name, age) values 
  ('ichigo.chocomint', 99),
  ('banana.chocomint', 98),
  ('pinapple.chocomint', 97)
;
