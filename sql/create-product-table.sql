CREATE DATABASE 'demo';
USE demo;

create table products (
	id  int(3) NOT NULL AUTO_INCREMENT,
	name varchar(120) NOT NULL,
	description varchar(220) NOT NULL,
	price int(3),
	PRIMARY KEY (id)
);

