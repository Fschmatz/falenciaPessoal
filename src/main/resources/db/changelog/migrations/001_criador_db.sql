-- noinspection SqlNoDataSourceInspectionForFile

-- noinspection SqlDialectInspectionForFile

--liquibase formatted sql

--changeset fernando:1
CREATE TABLE IF NOT EXISTS categoria (
    id_categoria SERIAL PRIMARY KEY,
    descricao TEXT NOT NULL   
);
--rollback DROP TABLE categoria;

--changeset fernando:2
CREATE TABLE IF NOT EXISTS usuario (
    id_usuario SERIAL PRIMARY KEY,
    nome TEXT NOT NULL,
	login TEXT NOT NULL,
    senha TEXT NOT NULL
);
--rollback DROP TABLE usuario;

--changeset fernando:3
CREATE TABLE IF NOT EXISTS despesa (
    id_despesa SERIAL PRIMARY KEY,
    nome TEXT NOT NULL,
    valor NUMERIC(10,2) NOT NULL,
    id_categoria INTEGER NOT NULL,
    FOREIGN KEY(id_categoria) REFERENCES categoria(id_categoria)
);
--rollback DROP TABLE despesa;


--changeset fernando:4
CREATE TABLE IF NOT EXISTS receita (
    id_receita SERIAL PRIMARY KEY,
    nome TEXT NOT NULL,
    valor NUMERIC(10,2) NOT NULL,
    id_categoria INTEGER NOT NULL,
    FOREIGN KEY(id_categoria) REFERENCES categoria(id_categoria)
);
--rollback DROP TABLE receita;


-- noinspection SqlNoDataSourceInspection

--changeset fernando:5
INSERT INTO usuario(nome,login,senha) VALUES ('admin','admin','123456');
--roolback DELETE FROM usuario WHERE id_usuario=id_usuario;

--changeset fernando:6
INSERT INTO categoria(id_categoria,descricao) values(1,'Alimentação');
--roolback DELETE FROM categoria WHERE id_categoria=1;

--changeset fernando:7
INSERT INTO categoria(id_categoria,descricao) values(2,'Gasolina');
--roolback DELETE FROM categoria WHERE id_categoria=2;

--changeset fernando:8
INSERT INTO categoria(id_categoria,descricao) values(3,'Criação de Chinchilas');
--roolback DELETE FROM categoria WHERE id_categoria=3;

--changeset fernando:9
INSERT INTO categoria(id_categoria,descricao) values(4,'Melindres e Trambiques');
--roolback DELETE FROM categoria WHERE id_categoria=3;


--changeset fernando:10
INSERT INTO receita(id_receita,nome,valor,id_categoria) values(1,'Vendas de Peles de Chinchila',5000.00,4);
--roolback DELETE FROM categoria WHERE id_categoria=3;

--changeset fernando:11
INSERT INTO despesa(id_despesa,nome,valor,id_categoria) values(1,'Sushi',100.00,1);
--roolback DELETE FROM categoria WHERE id_categoria=3;

--changeset fernando:12
INSERT INTO despesa(id_despesa,nome,valor,id_categoria) values(2,'Ração',1000.00,3);
--roolback DELETE FROM categoria WHERE id_categoria=3;
