-- CREATE DATABASE poo_tarde_contatos;

CREATE TABLE contatos ( 
    id int AUTO_INCREMENT,
    nome varchar(100),
    email varchar(100),
    telefone varchar(30),
    PRIMARY KEY(id)
);

INSERT INTO contatos (nome, email, telefone) VALUES ('Joao Silva', 'joao@teste.com', '1111');

SELECT * FROM contatos;