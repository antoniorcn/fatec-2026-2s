-- CREATE DATABASE poo_noite_contato;
SHOW DATABASES;

USE poo_noite_contato;

CREATE TABLE contatos ( 
    id int AUTO_INCREMENT,
    nome varchar(100),
    email varchar(100),
    telefone varchar(30),
    PRIMARY KEY( id )
);

INSERT INTO contatos (nome, email, telefone) VALUES ('Joao Silva', 'joao@teste.com', '(11) 1111-1111');

SELECT * FROM contatos;

-- DELETE FROM contato;