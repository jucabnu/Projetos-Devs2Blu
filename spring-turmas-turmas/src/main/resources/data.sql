INSERT INTO pessoa (nome, idade, endereco, sexo) VALUES ('Ramon', 32, 'Rua Jumbotron, 35', 'M');
INSERT INTO pessoa (nome, idade, endereco, sexo) VALUES ('Juliano', 35, 'Rua Jumbotron, 666', 'M');
INSERT INTO pessoa (nome, idade, endereco, sexo) VALUES ('Henrique', 22, 'Rua Jumbotron, 567', 'F');
INSERT INTO pessoa (nome, idade, endereco, sexo) VALUES ('Profe', 31, 'Rua Jumbotron, 222', 'F');

INSERT INTO professor(pessoa_id) VALUES (4);

INSERT INTO aluno (ano, pessoa_id) VALUE (5 ,1);
INSERT INTO aluno (ano, pessoa_id) VALUE (5 ,2);
INSERT INTO aluno (ano, pessoa_id) VALUE (6 ,3);

INSERT INTO turma (nome, periodo, max_alunos, professor_id) VALUES ('Turma 1', 'Matutino', 20, 1);
INSERT INTO turma (nome, periodo, max_alunos, professor_id) VALUES ('Turma 2', 'Vespertino', 20, 1);
INSERT INTO turma (nome, periodo, max_alunos, professor_id) VALUES ('Turma 3', 'Noturno', 20, 1);