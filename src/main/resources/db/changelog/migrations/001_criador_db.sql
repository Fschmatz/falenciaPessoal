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
CREATE TABLE IF NOT EXISTS perfil (
    id_perfil SERIAL PRIMARY KEY,
    nome_perfil VARCHAR(30) NOT NULL
    );
--rollback DROP TABLE perfil;

--changeset fernando:4
CREATE TABLE IF NOT EXISTS usuario_perfil (
    usuario_id_usuario INT NOT NULL,
    perfil_id_perfil  INT NOT NULL,
    FOREIGN KEY (usuario_id_usuario) REFERENCES usuario(id_usuario),
    FOREIGN KEY (perfil_id_perfil) REFERENCES perfil(id_perfil)
    );
--rollback DROP TABLE usuario_perfil;

--changeset fernando:5
CREATE TABLE IF NOT EXISTS despesa (
    id_despesa SERIAL PRIMARY KEY,
    nome TEXT NOT NULL,
    valor NUMERIC(10,2) NOT NULL,
    id_categoria INTEGER NOT NULL,
    FOREIGN KEY(id_categoria) REFERENCES categoria(id_categoria)
);
--rollback DROP TABLE despesa;

--changeset fernando:6
CREATE TABLE IF NOT EXISTS receita (
    id_receita SERIAL PRIMARY KEY,
    nome TEXT NOT NULL,
    valor NUMERIC(10,2) NOT NULL,
    id_categoria INTEGER NOT NULL,
    FOREIGN KEY(id_categoria) REFERENCES categoria(id_categoria)
);
--rollback DROP TABLE receita;

-- noinspection SqlNoDataSourceInspection

--changeset fernando:7
INSERT INTO usuario(nome,login,senha) VALUES ('admin','admin','$2a$10$1CP08AI0.cmKOgxCuteUeuvBwCZmmhAye3u9TyjJSHJBZLMWGreru');
--roolback DELETE FROM usuario WHERE id_usuario=id_usuario;

--changeset fernando:8
INSERT INTO perfil(nome_perfil) values('ROLE_ADMIN');
INSERT INTO perfil(nome_perfil) values('ROLE_USER');
--roolback DELETE FROM perfil WHERE id_perfil=id_perfil;

--changeset fernando:9
INSERT INTO usuario_perfil(usuario_id_usuario,perfil_id_perfil) values(1,1);
--roolback DELETE FROM usuario_perfil WHERE id_perfil=id_perfil;

--changeset fernando:10
INSERT INTO categoria(descricao) values('Alimentação');
--roolback DELETE FROM categoria WHERE id_categoria=1;

--changeset fernando:11
INSERT INTO categoria(descricao) values('Gasolina');
--roolback DELETE FROM categoria WHERE id_categoria=2;

--changeset fernando:12
INSERT INTO categoria(descricao) values('Criação de Chinchilas');
--roolback DELETE FROM categoria WHERE id_categoria=3;

--changeset fernando:13
INSERT INTO categoria(descricao) values('Melindres e Trambiques');
--roolback DELETE FROM categoria WHERE id_categoria=3;

--changeset fernando:14
INSERT INTO receita(nome,valor,id_categoria) values('Vendas de Peles de Chinchila',5000.00,4);
--roolback DELETE FROM categoria WHERE id_categoria=3;

--changeset fernando:15
INSERT INTO receita(nome,valor,id_categoria) values('Venda do Chevette',500.00,4);
--roolback DELETE FROM categoria WHERE id_categoria=3;

--changeset fernando:16
INSERT INTO despesa(nome,valor,id_categoria) values('Sushi',100.00,1);
--roolback DELETE FROM categoria WHERE id_categoria=3;

--changeset fernando:17
INSERT INTO despesa(nome,valor,id_categoria) values('Ração',1000.00,3);
--roolback DELETE FROM categoria WHERE id_categoria=3;
