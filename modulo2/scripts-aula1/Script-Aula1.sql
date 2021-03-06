/* CREATE USER VEM_SER IDENTIFIED BY oracle;

GRANT CONNECT TO VEM_SER;

GRANT CONNECT, RESOURCE, DBA TO VEM_SER;

GRANT CREATE SESSION TO VEM_SER;

GRANT DBA TO VEM_SER;

GRANT CREATE VIEW, CREATE PROCEDURE
, CREATE SEQUENCE TO VEM_SER;

GRANT UNLIMITED TABLESPACE TO VEM_SER;

GRANT CREATE MATERIALIZED VIEW TO VEM_SER;

GRANT CREATE TABLE TO VEM_SER;

GRANT GLOBAL QUERY REWRITE TO VEM_SER;

GRANT SELECT ANY TABLE TO VEM_SER; */

CREATE TABLE pessoa(
	id_pessoa NUMBER NOT NULL,
	nome VARCHAR2(255) NOT NULL,
	data_nascimento DATE NOT NULL,
	telefone VARCHAR2(14), --+55999999999
	idade NUMBER(3) NOT NULL,
	altura DECIMAL(4,2) NOT NULL,
	cpf CHAR(11) UNIQUE NOT NULL,
	PRIMARY KEY(id_pessoa)
);


SELECT * FROM VEM_SER.PESSOA;

SELECT id_pessoa, cpf, nome FROM VEM_SER.PESSOA;


INSERT INTO VEM_SER.PESSOA
(ID_PESSOA, NOME, DATA_NASCIMENTO, TELEFONE, IDADE, ALTURA, CPF)
VALUES(2, 'Joao', '31/01/2017', '+6199999999', 5, 1.05, '022222222');

INSERT INTO VEM_SER.PESSOA
(ID_PESSOA, NOME, DATA_NASCIMENTO, TELEFONE, IDADE, ALTURA, CPF)
VALUES (3, 'Grasi', '09/02/1989', '+6199999999', 32, 1.70, '033333333');

INSERT INTO VEM_SER.PESSOA
(ID_PESSOA, NOME, DATA_NASCIMENTO, TELEFONE, IDADE, ALTURA, CPF)
VALUES (4, 'Ester', '14/09/2020', '+6199999999', 1, 0.80, '044444444');

SELECT * FROM VEM_SER.PESSOA;

UPDATE VEM_SER.PESSOA
SET IDADE=36
WHERE ID_PESSOA = 1;

UPDATE VEM_SER.PESSOA
SET IDADE=6
WHERE ID_PESSOA = 2;

UPDATE VEM_SER.PESSOA
SET IDADE=33
WHERE ID_PESSOA = 3;

UPDATE VEM_SER.PESSOA
SET IDADE=2
WHERE ID_PESSOA = 4;

DELETE vem_ser.pessoa
WHERE id_pessoa = 4;

SELECT * FROM VEM_SER.PESSOA;

