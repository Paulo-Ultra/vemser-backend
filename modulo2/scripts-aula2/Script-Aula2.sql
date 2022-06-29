--Exerc�cio 1

SELECT * FROM  VEM_SER.PESSOA WHERE ID_PESSOA =:1 AND CPF =:2; --Comando do DBeaver

SELECT * FROM dual;


CREATE TABLE VEM_SER.PAIS(
	id_pais NUMBER(38) PRIMARY KEY NOT NULL,
	nome VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE VEM_SER.ESTADO(
	id_estado NUMBER(38) PRIMARY KEY NOT NULL,
	id_pais NUMBER(38) NOT NULL,
	nome VARCHAR(50),
	CONSTRAINT FK_id_pais FOREIGN KEY (id_pais) REFERENCES pais(id_pais)
);

DROP TABLE PAIS;
DROP TABLE ESTADO
DROP TABLE ENDERECO 
DROP TABLE CIDADE;
DROP TABLE "BAIRRO"; 


CREATE TABLE Endereco (
                ID_ENDERECO NUMBER(38) NOT NULL,
                ID_BAIRRO NUMBER(38) NOT NULL,
                ID_CIDADE NUMBER(38) NOT NULL,
                LOGRADOURO VARCHAR2(255) NOT NULL,
                NUMERO VARCHAR2(38) NOT NULL,
                COMPLEMENTO VARCHAR2(100),
                CEP CHAR(9),
                PRIMARY KEY (ID_ENDERECO),
                CONSTRAINT FK_ENDERECO_BAIRRO FOREIGN KEY (ID_BAIRRO, ID_CIDADE) REFERENCES BAIRRO (ID_BAIRRO, ID_CIDADE)
                
);

CREATE TABLE VEM_SER.BAIRRO(
	id_bairro NUMBER(38) NOT NULL,
	id_cidade NUMBER(38) NOT NULL,
	id_estado NUMBER(38) NOT NULL,
	nome VARCHAR(50) NOT NULL,
	PRIMARY KEY (ID_BAIRRO, ID_CIDADE),
	CONSTRAINT FK_BAIRRO_CIDADE FOREIGN KEY (ID_CIDADE, ID_ESTADO) REFERENCES CIDADE (ID_CIDADE, ID_ESTADO)
);

CREATE TABLE VEM_SER.CIDADE(
	id_cidade NUMBER(38) NOT NULL,
	id_estado NUMBER(38) NOT NULL,
	nome VARCHAR(50) NOT NULL,
	PRIMARY KEY (ID_CIDADE, ID_ESTADO),
	CONSTRAINT FK_id_estado FOREIGN KEY (id_estado) REFERENCES estado(id_estado)
);

--Exerc�cio 2

CREATE SEQUENCE VEM_SER.SEQ_PAIS
START WITH 1
INCREMENT BY 1
nocache nocycle;

INSERT INTO VEM_SER.PAIS 
(ID_PAIS, NOME)
VALUES(seq_pais.nextval, 'Brasil');

INSERT INTO VEM_SER.PAIS 
(ID_PAIS, NOME)
VALUES(seq_pais.nextval, 'Argentina');

CREATE SEQUENCE VEM_SER.SEQ_ESTADO
START WITH 1
INCREMENT BY 1
nocache nocycle;

INSERT INTO VEM_SER.ESTADO
(ID_ESTADO, ID_PAIS, NOME)
VALUES(seq_estado.nextval, 1, 'Bahia');

INSERT INTO VEM_SER.ESTADO
(ID_ESTADO, ID_PAIS, NOME)
VALUES(seq_estado.nextval, 1, 'Distrito Federal');

INSERT INTO VEM_SER.ESTADO
(ID_ESTADO, ID_PAIS, NOME)
VALUES(seq_estado.nextval, 2, 'Rio Grande do Sul');

INSERT INTO VEM_SER.ESTADO
(ID_ESTADO, ID_PAIS, NOME)
VALUES(seq_estado.nextval, 2, 'Santa Catarina');


CREATE SEQUENCE VEM_SER.SEQ_CIDADE
START WITH 1
INCREMENT BY 1
nocache nocycle;

INSERT INTO VEM_SER.CIDADE 
(ID_CIDADE, ID_ESTADO, NOME)
VALUES(seq_cidade.nextval, 1, 'S�o Gabriel');

INSERT INTO VEM_SER.CIDADE 
(ID_CIDADE, ID_ESTADO, NOME)
VALUES(seq_cidade.nextval, 1, 'Salvador');

CREATE SEQUENCE VEM_SER.SEQ_BAIRRO
START WITH 1
INCREMENT BY 1
nocache nocycle;

INSERT INTO VEM_SER.BAIRRO  
(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES(seq_bairro.nextval, 1, 1, 'Maria Candida');

INSERT INTO VEM_SER.BAIRRO  
(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES(seq_bairro.nextval, 2, 1, 'Avenida Rui Barbosa');

CREATE SEQUENCE VEM_SER.SEQ_ENDERECO
START WITH 1
INCREMENT BY 1
nocache nocycle;

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(seq_endereco.nextval, 1, 1, 'Rua Presidente Dutra', '11A', 'Esquina com Adalberto', '44915-000');

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(seq_endereco.nextval, 3, 2, 'Avenida Salvador', '1565', 'Apartamento', '44200-000');

SELECT * FROM PAIS;
SELECT * FROM ESTADO;
SELECT * FROM CIDADE;
SELECT * FROM BAIRRO;
SELECT * FROM ENDERECO

ALTER TABLE "Estado" ADD CONSTRAINT "Estado_fk0" FOREIGN KEY ("id_pais") REFERENCES "Pais"("id_pais");

ALTER TABLE "Cidade" ADD CONSTRAINT id_cidade PRIMARY KEY REFERENCES (id_cidade, id_estado);

ALTER TABLE "Bairro" ADD CONSTRAINT "Bairro_fk0" FOREIGN KEY ("id_cidade") REFERENCES "Cidade"("id_cidade");

ALTER TABLE "Endereco" ADD CONSTRAINT "Endereco_fk0" FOREIGN KEY ("id_bairro") REFERENCES "Bairro"("id_bairro");


