--Exerc?cio 1

SELECT * FROM  VEM_SER.PESSOA WHERE ID_PESSOA =:1 AND CPF =:2; --Comando do DBeaver

SELECT * FROM dual;


CREATE TABLE VEM_SER.PAIS(
	id_pais NUMBER(38) PRIMARY KEY NOT NULL,
	nome VARCHAR2(50) UNIQUE NOT NULL
);

CREATE TABLE VEM_SER.ESTADO(
	id_estado NUMBER(38) PRIMARY KEY NOT NULL,
	id_pais NUMBER(38) NOT NULL,
	nome VARCHAR2(50),
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
                NUMERO number(38) NOT NULL,
                COMPLEMENTO VARCHAR2(100),
                CEP CHAR(9),
                PRIMARY KEY (ID_ENDERECO),
                CONSTRAINT FK_ENDERECO_BAIRRO FOREIGN KEY (ID_BAIRRO, ID_CIDADE) REFERENCES BAIRRO (ID_BAIRRO, ID_CIDADE)
                
);

CREATE TABLE VEM_SER.BAIRRO(
	id_bairro NUMBER(38) NOT NULL,
	id_cidade NUMBER(38) NOT NULL,
	id_estado NUMBER(38) NOT NULL,
	nome VARCHAR2(50) NOT NULL,
	PRIMARY KEY (ID_BAIRRO, ID_CIDADE),
	CONSTRAINT FK_BAIRRO_CIDADE FOREIGN KEY (ID_CIDADE, ID_ESTADO) REFERENCES CIDADE (ID_CIDADE, ID_ESTADO)
);

CREATE TABLE VEM_SER.CIDADE(
	id_cidade NUMBER(38) NOT NULL,
	id_estado NUMBER(38) NOT NULL,
	nome VARCHAR2(50) NOT NULL,
	PRIMARY KEY (ID_CIDADE, ID_ESTADO),
	CONSTRAINT FK_id_estado FOREIGN KEY (id_estado) REFERENCES estado(id_estado)
);

--Exerc?cio 2

ALTER TABLE "Estado" ADD CONSTRAINT "Estado_fk0" FOREIGN KEY ("id_pais") REFERENCES "Pais"("id_pais");

ALTER TABLE "Cidade" ADD CONSTRAINT id_cidade PRIMARY KEY REFERENCES (id_cidade, id_estado);

ALTER TABLE "Bairro" ADD CONSTRAINT "Bairro_fk0" FOREIGN KEY ("id_cidade") REFERENCES "Cidade"("id_cidade");

ALTER TABLE "Endereco" ADD CONSTRAINT "Endereco_fk0" FOREIGN KEY ("id_bairro") REFERENCES "Bairro"("id_bairro");

-- DROP SEQUENCE vem_ser.seq_pais

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

-- DROP SEQUENCE vem_ser.seq_estado

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

-- DROP SEQUENCE vem_ser.seq_cidade

CREATE SEQUENCE VEM_SER.SEQ_CIDADE
START WITH 1
INCREMENT BY 1
nocache nocycle;

INSERT INTO VEM_SER.CIDADE 
(ID_CIDADE, ID_ESTADO, NOME)
VALUES(seq_cidade.nextval, 1, 'S?o Gabriel');

INSERT INTO VEM_SER.CIDADE 
(ID_CIDADE, ID_ESTADO, NOME)
VALUES(seq_cidade.nextval, 1, 'Salvador');

INSERT INTO VEM_SER.CIDADE 
(ID_CIDADE, ID_ESTADO, NOME)
VALUES(seq_cidade.nextval, 2, 'Bras?lia');

INSERT INTO VEM_SER.CIDADE 
(ID_CIDADE, ID_ESTADO, NOME)
VALUES(seq_cidade.nextval, 2, 'Ceilandia');

INSERT INTO VEM_SER.CIDADE 
(ID_CIDADE, ID_ESTADO, NOME)
VALUES(seq_cidade.nextval, 3, 'Porto Alegre');

INSERT INTO VEM_SER.CIDADE 
(ID_CIDADE, ID_ESTADO, NOME)
VALUES(seq_cidade.nextval, 3, 'Caxias');

INSERT INTO VEM_SER.CIDADE 
(ID_CIDADE, ID_ESTADO, NOME)
VALUES(seq_cidade.nextval, 4, 'Florian?polis');

INSERT INTO VEM_SER.CIDADE 
(ID_CIDADE, ID_ESTADO, NOME)
VALUES(seq_cidade.nextval, 4, 'S?o Jos?');

--DROP SEQUENCE vem_ser.seq_bairro

CREATE SEQUENCE VEM_SER.SEQ_BAIRRO
START WITH 1
INCREMENT BY 1
nocache nocycle;

INSERT INTO VEM_SER.BAIRRO  
(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES(seq_bairro.nextval, 1, 1, 'Maria Candida');

INSERT INTO VEM_SER.BAIRRO  
(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES(seq_bairro.nextval, 1, 1, 'Pra?a Barret?o');

INSERT INTO VEM_SER.BAIRRO  
(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES(seq_bairro.nextval, 2, 1, 'Governador Magalh?es');

INSERT INTO VEM_SER.BAIRRO  
(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES(seq_bairro.nextval, 2, 1, 'Farrol da Barra');

INSERT INTO VEM_SER.BAIRRO  
(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES(seq_bairro.nextval, 3, 2, 'Asa Sul');

INSERT INTO VEM_SER.BAIRRO  
(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES(seq_bairro.nextval, 3, 2, 'Asa Norte');

INSERT INTO VEM_SER.BAIRRO  
(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES(seq_bairro.nextval, 4, 2, 'Guariroba');

INSERT INTO VEM_SER.BAIRRO  
(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES(seq_bairro.nextval, 4, 2, '5 da Norte');

INSERT INTO VEM_SER.BAIRRO  
(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES(seq_bairro.nextval, 5, 3, 'Grenal');

INSERT INTO VEM_SER.BAIRRO  
(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES(seq_bairro.nextval, 5, 3, 'Barbaridade Tche');

INSERT INTO VEM_SER.BAIRRO  
(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES(seq_bairro.nextval, 6,3, 'Matias');

INSERT INTO VEM_SER.BAIRRO  
(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES(seq_bairro.nextval, 6, 3, 'Farias');

INSERT INTO VEM_SER.BAIRRO  
(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES(seq_bairro.nextval, 7, 4, 'Campesche');

INSERT INTO VEM_SER.BAIRRO  
(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES(seq_bairro.nextval, 7, 4, 'Praia dos Ricos');

INSERT INTO VEM_SER.BAIRRO  
(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES(seq_bairro.nextval, 8, 4, 'Getuli?o');

INSERT INTO VEM_SER.BAIRRO  
(ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME)
VALUES(seq_bairro.nextval, 8, 4, 'Quinxad? de Marangad?');

--DROP SEQUENCE vem_ser.seq_endereco

CREATE SEQUENCE VEM_SER.SEQ_ENDERECO
START WITH 1
INCREMENT BY 1
nocache nocycle;

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(seq_endereco.nextval, 1, 1, 'Rua Presidente Dutra', 11, 'Esquina com Adalberto', '44915-000');

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(seq_endereco.nextval, 1, 1, 'Rua Barreto Rocha', 55, 'Esquina com Adalberto', '44915-000');

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(seq_endereco.nextval, 2, 1, 'Avenida Salvador', 1565, 'Apartamento', '44200-000');

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(seq_endereco.nextval, 2, 1, 'Avenida Joaquim Grava', 99, 'Apartamento', '44200-000');

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(seq_endereco.nextval, 3, 2, 'Avenida Principal', 135, '', '44900-008');

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(seq_endereco.nextval, 3, 2, 'Alto Rio', 745, 'Centro', '44915-000');

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(seq_endereco.nextval, 4, 2, 'Rua dos Prazeres', 14, 'Centro', '44915-021');

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(seq_endereco.nextval, 4, 2, 'Pra?a Baianada', 88, 'Centro', '44915-000');

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(seq_endereco.nextval, 5, 3, 'SHS', 38, 'Asa Sul', '70210-000');

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(seq_endereco.nextval, 5, 3, 'SHSN', 126, 'Asa Sul', '71250-000');

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(seq_endereco.nextval, 6, 3, 'SHSS', 114, 'Asa Norte', '70250-133');

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(seq_endereco.nextval, 6, 3, 'SHSS', 85, 'Asa Norte', '71000-000');

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(seq_endereco.nextval, 7, 4, 'QNN 10, Conjunto H', 50, 'Do lado da esta??o Ceil?ndia Sul', '72900-120');

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(seq_endereco.nextval, 7, 4, 'QNM 10, Conjunto H', 10, 'Do lado do norte da Cei', '72750-120');

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(seq_endereco.nextval, 8, 4, 'QNP 32, Conjunto S', 10, 'PSUL', '72150-120');

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(seq_endereco.nextval, 8, 4, 'QNN 10, Conjunto C', 50, 'Do lado da esta??o Guatriroba', '72980-120');

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(seq_endereco.nextval, 9, 5, 'Avenida Barbaridade', 31, 'Do lado da Caxinilides', '35900-120');

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(seq_endereco.nextval, 9, 5, 'avenida Barbaridade2', 31, 'Do lado da Caxinilides', '34800-120');

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(seq_endereco.nextval, 9, 5, 'Rua dos Pampas', 77, 'B?', '35900-250');

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(seq_endereco.nextval, 10, 5, 'Rua da briga do Sul tch?', 88, 'Esquina com est?dio ol?mpico', '32900-120');

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(seq_endereco.nextval, 10, 5, 'Rua do Gaucho', 548, 'Do lado do vizim', '35400-120');

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(seq_endereco.nextval, 11, 6, 'Rua que rima com Caxias', 100, '', '35300-000');

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(seq_endereco.nextval, 11, 6, 'Avenida dos Seguros', 45, 'Pr?ximo ao Centro', '35312-000');

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(seq_endereco.nextval, 12, 6, 'Pra?a Caxianoloulo', 1, 'Pra?a', '34320-000');

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(seq_endereco.nextval, 12, 6, 'Rua sem conhecimento', 101, 'Longe do Centro', '34000-000');

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(seq_endereco.nextval, 13, 7, 'Praia dos surfistas', 19, 'Aqui do lado', '54000-000');

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(seq_endereco.nextval, 13, 7, 'Avenida Camps', 159, 'Principal', '54500-001');

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(seq_endereco.nextval, 14, 7, 'Rua Riqueza dos Ricos', 145, 'Centro', '54147-120');

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(seq_endereco.nextval, 14, 7, 'Avenida dos Milhion?rios', 67, 'Centro', '54500-000');

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(seq_endereco.nextval, 15, 8, 'Rua de S?o Jos?', 17, 'Centro', '59000-000');

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(seq_endereco.nextval, 15, 8, 'Avenida dos Milagres', 88, 'Centro', '54500-000');

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(seq_endereco.nextval, 16, 8, 'Avenida Quinxa', 987, 'Quix? 2', '54000-000');

INSERT INTO VEM_SER.ENDERECO
(ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES(seq_endereco.nextval, 16, 8, 'Rua Marangaga', 17, 'Centro', '54500-000');


SELECT * FROM PAIS;
SELECT * FROM ESTADO;
SELECT * FROM CIDADE;
SELECT * FROM BAIRRO;
SELECT * FROM ENDERECO

SELECT nome FROM PAIS 
ORDER BY nome DESC;

--SELECT logradouro, cep FROM ENDERECO
--WHERE UPPER(LOGRADOURO) LIKE 'A%';

SELECT LOGRADOURO, CEP
  FROM VEM_SER.ENDERECO
 WHERE LOGRADOURO LIKE 'A%' OR LOGRADOURO LIKE 'a%';

SELECT logradouro, cep FROM ENDERECO
WHERE trim(cep)  LIKE '%0';

SELECT * FROM ENDERECO
WHERE NUMERO BETWEEN 1 AND 100;

SELECT * FROM ENDERECO
WHERE UPPER(LOGRADOURO) LIKE 'RUA%';

SELECT COUNT(ID_ENDERECO) FROM ENDERECO

SELECT logradouro, cep FROM ENDERECO
ORDER BY ID_ENDERECO


