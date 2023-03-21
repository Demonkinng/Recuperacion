/**
*   Examen Recuperación
*   Base de datos
*/

-- revisar el entorno de trabajo
.version
.database
.show

.tables

DROP TABLE IF EXISTS USUARIO;

CREATE TABLE IF NOT EXISTS USUARIO
(
    PK_ID_USUARIO       INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT
    ,USUARIO            VARCHAR(50) UNIQUE NOT NULL
    ,CONTRASENA         VARCHAR(25) NOT NULL
);

SELECT * FROM USUARIO;

INSERT INTO USUARIO(USUARIO, CONTRASENA) 
       VALUES ('patmic', 'patmic')
            , ('pat_mic', 'pat_mic')
            , ('profe', '1234');