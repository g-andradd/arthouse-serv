USE
ARTHOUSE;
CREATE TABLE PRODUTO
(
    ID_PRODUTO           INTEGER PRIMARY KEY AUTO_INCREMENT,
    NOME_PRODUTO         VARCHAR(100),
    DESC_PRODUTO         VARCHAR(250),
    CONT_PRODUTO         BLOB,
    ID_USUARIO_CRIACAO   INTEGER(10),
    DATA_CRIACAO         DATETIME,
    ID_USUARIO_ALTERACAO INTEGER(10),
    DATA_ALTERACAO       DATETIME,
    ID_TIPO_PRODUTO      INTEGER(10)
);

CREATE TABLE CORES_PRODUTO
(
    ID_COR_PRODUTO   INTEGER PRIMARY KEY AUTO_INCREMENT,
    NOME_COR_PRODUTO VARCHAR(100),
    DESC_COR_PRODUTO VARCHAR(200)
);

CREATE TABLE CARACTERISTICAS_PRODUTO
(
    ID_CARACTERISTICAS_PRODUTO   INTEGER PRIMARY KEY AUTO_INCREMENT,
    NOME_CARACTERISTICAS_PRODUTO VARCHAR(100)
);

CREATE TABLE TIPO_PRODUTO
(
    ID_TIPO_PRODUTO   INTEGER PRIMARY KEY AUTO_INCREMENT,
    NOME_TIPO_PRODUTO VARCHAR(100)
);

CREATE TABLE CORES_PRODUTO_PRODUTO
(
    ID_CORES_PRODUTO_PRODUTO INTEGER PRIMARY KEY AUTO_INCREMENT,
    ID_COR_PRODUTO           INTEGER,
    ID_PRODUTO               INTEGER,
    FOREIGN KEY (ID_COR_PRODUTO) REFERENCES CORES_PRODUTO (ID_COR_PRODUTO),
    FOREIGN KEY (ID_PRODUTO) REFERENCES PRODUTO (ID_PRODUTO)
);

CREATE TABLE CARACTERISTICA_PRODUTO_PRODUTO
(
    ID_CARACTERISTICA_PRODUTO_PRODUTO INTEGER PRIMARY KEY AUTO_INCREMENT,
    ID_CARACTERISTICAS_PRODUTO        INTEGER,
    ID_PRODUTO                        INTEGER,
    FOREIGN KEY (ID_CARACTERISTICAS_PRODUTO) REFERENCES CARACTERISTICAS_PRODUTO (ID_CARACTERISTICAS_PRODUTO),
    FOREIGN KEY (ID_PRODUTO) REFERENCES PRODUTO (ID_PRODUTO)

);

CREATE TABLE CLIENTE_LEAD
(
    ID_CLIENTE_LEAD      INTEGER PRIMARY KEY AUTO_INCREMENT,
    NOME_CLIENTE_LEAD    VARCHAR(100),
    ID_USUARIO_CRIACAO   INTEGER(10),
    DATA_CRIACAO         DATETIME,
    ID_USUARIO_ALTERACAO INTEGER(10),
    DATA_ALTERACAO       DATETIME
);


CREATE TABLE CONTATO_CLIENTE_LEAD
(
    ID_CONTATO_CLIENTE_LEAD INTEGER PRIMARY KEY AUTO_INCREMENT,
    EMAIL_CLIENTE_LEAD      VARCHAR(100),
    CELULAR_CLIENTE_LEAD    VARCHAR(30),
    ID_USUARIO_CRIACAO      INTEGER(10),
    DATA_CRIACAO            DATETIME,
    ID_USUARIO_ALTERACAO    INTEGER(10),
    DATA_ALTERACAO          DATETIME,
    ID_CLIENTE_LEAD         INTEGER(10)
);

ALTER TABLE PRODUTO
    ADD FOREIGN KEY (ID_TIPO_PRODUTO) REFERENCES TIPO_PRODUTO (ID_TIPO_PRODUTO);

ALTER TABLE CONTATO_CLIENTE_LEAD
    ADD FOREIGN KEY (ID_CLIENTE_LEAD) REFERENCES CLIENTE_LEAD (ID_CLIENTE_LEAD);


INSERT INTO TIPO_PRODUTO(NOME_TIPO_PRODUTO)
VALUES ('Papel de Parede');
INSERT INTO TIPO_PRODUTO(NOME_TIPO_PRODUTO)
VALUES ('Adesivo de Parede');

INSERT INTO CARACTERISTICAS_PRODUTO(NOME_CARACTERISTICAS_PRODUTO)
VALUES ('3D');
INSERT INTO CARACTERISTICAS_PRODUTO(NOME_CARACTERISTICAS_PRODUTO)
VALUES ('Normal');

INSERT INTO CORES_PRODUTO(NOME_COR_PRODUTO, DESC_COR_PRODUTO)
VALUES ('Azul', 'Tonalidade Aluzada');

INSERT INTO CORES_PRODUTO(NOME_COR_PRODUTO, DESC_COR_PRODUTO)
VALUES ('Preto', 'Tonalidade Preta')






