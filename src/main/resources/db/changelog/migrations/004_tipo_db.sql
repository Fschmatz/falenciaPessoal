-- noinspection SqlNoDataSourceInspectionForFile

-- noinspection SqlDialectInspectionForFile

--liquibase formatted sql

--changeset fernando:1
CREATE TABLE IF NOT EXISTS tipo(
  id_tipo SERIAL PRIMARY KEY,
  descricao TEXT NOT NULL
);
--rollback DROP TABLE tipo;