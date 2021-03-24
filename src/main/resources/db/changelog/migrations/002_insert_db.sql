-- noinspection SqlNoDataSourceInspectionForFile

-- noinspection SqlDialectInspectionForFile

--liquibase formatted sql

--changeset fernando:1
INSERT INTO usuario(nome,login,senha) VALUES ('admin','admin','$2a$10$1CP08AI0.cmKOgxCuteUeuvBwCZmmhAye3u9TyjJSHJBZLMWGreru');
--roolback DELETE FROM usuario WHERE id_usuario=id_usuario;

--changeset fernando:2
INSERT INTO perfil(nome_perfil) values('ROLE_ADMIN');
INSERT INTO perfil(nome_perfil) values('ROLE_USER');
--roolback DELETE FROM perfil WHERE id_perfil=id_perfil;

--changeset fernando:3
INSERT INTO usuario_perfil(usuario_id_usuario,perfil_id_perfil) values(1,1);
--roolback DELETE FROM usuario_perfil WHERE id_perfil=id_perfil;

--changeset fernando:4
INSERT INTO categoria(descricao) values('Alimentação');
--roolback DELETE FROM categoria WHERE id_categoria=1;

--changeset fernando:5
INSERT INTO categoria(descricao) values('Gasolina');
--roolback DELETE FROM categoria WHERE id_categoria=2;

--changeset fernando:12
INSERT INTO categoria(descricao) values('Criação de Chinchilas');
--roolback DELETE FROM categoria WHERE id_categoria=3;

--changeset fernando:6
INSERT INTO categoria(descricao) values('Melindres e Trambiques');
--roolback DELETE FROM categoria WHERE id_categoria=3;

--changeset fernando:7
INSERT INTO receita(nome,valor,id_categoria) values('Vendas de Peles de Chinchila',5000.00,4);
--roolback DELETE FROM categoria WHERE id_categoria=3;

--changeset fernando:8
INSERT INTO receita(nome,valor,id_categoria) values('Venda do Chevette',500.00,4);
--roolback DELETE FROM categoria WHERE id_categoria=3;

--changeset fernando:9
INSERT INTO despesa(nome,valor,id_categoria) values('Sushi',100.00,1);
--roolback DELETE FROM categoria WHERE id_categoria=3;

--changeset fernando:10
INSERT INTO despesa(nome,valor,id_categoria) values('Ração',1000.00,3);
--roolback DELETE FROM categoria WHERE id_categoria=3;