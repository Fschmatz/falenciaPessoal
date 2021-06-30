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

--changeset fernando:7
CREATE TABLE IF NOT EXISTS testeApresentacao(
     id_teste SERIAL PRIMARY KEY,
     nome TEXT NOT NULL
);
--rollback DROP TABLE testeApresentacao;



