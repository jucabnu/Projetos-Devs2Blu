/*
INSERT INTO GENERO(descricao) VALUES ('Aventura');
INSERT INTO GENERO(descricao) VALUES ('Fantasia');
INSERT INTO GENERO(descricao) VALUES ('Ficção');
INSERT INTO GENERO(descricao) VALUES ('Drama');
INSERT INTO GENERO(descricao) VALUES ('Ação');

INSERT INTO RESTRICAO(descricao,idade) VALUES ('Livre', 0);
INSERT INTO RESTRICAO(descricao,idade) VALUES ('10 anos', 10);
INSERT INTO RESTRICAO(descricao,idade) VALUES ('12 anos', 12);
INSERT INTO RESTRICAO(descricao,idade) VALUES ('14 anos', 14);
INSERT INTO RESTRICAO(descricao,idade) VALUES ('16 anos', 16);
INSERT INTO RESTRICAO(descricao,idade) VALUES ('18 anos', 18);
INSERT INTO RESTRICAO(descricao,idade) VALUES ('18 anos', 18);
*/

INSERT INTO FILME(titulo, genero_id, restricao_id, favorito) value ('Ready Player One', 1, 1, 1);
INSERT INTO FILME(titulo, genero_id, restricao_id, favorito) value ('O Senhor dos Anéis', 1, 1, 0);
INSERT INTO FILME(titulo, genero_id, restricao_id, favorito) value ('Matrix', 1, 1, 1);