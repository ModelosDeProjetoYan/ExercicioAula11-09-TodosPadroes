CREATE TABLE USUARIO(
    ID INTEGER  PRIMARY KEY GENERATED ALWAYS AS IDENTITY, 
    NOME VARCHAR (150)  NOT NULL, 
    MATRICULA VARCHAR (150)  NOT NULL,
    SITUACAO VARCHAR (150)  NOT NULL
);