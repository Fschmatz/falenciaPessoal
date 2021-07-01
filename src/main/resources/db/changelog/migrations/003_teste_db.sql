-- noinspection SqlNoDataSourceInspectionForFile

-- noinspection SqlDialectInspectionForFile

--liquibase formatted sql

--changeset fernando:1
CREATE TABLE IF NOT EXISTS testeAp1(
  id_teste SERIAL PRIMARY KEY,
  descricao TEXT NOT NULL
);
--rollback DROP TABLE categoria;