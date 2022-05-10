INSERT INTO usuario ( `email`, `login`, `senha`) VALUES ('chuck@gmail.com', 'chuck', 'norris',1,1,'Chuck Norris');
INSERT INTO usuario ( `email`, `login`, `senha`) VALUES ('jucabnu@gmail.com', 'juca', 'bnu',0,1,'Juca Bala');
INSERT INTO usuario ( `email`, `login`, `senha`) VALUES ('neo@gmail.com', 'neo', 'matrix',0,1,'Neo Matrix');
INSERT INTO usuario ( `email`, `login`, `senha`) VALUES ('norris@gmail.com', 'norris', 'chuck',0,1,'Norris Chuck');

INSERT INTO contrato (`saldo`, `total_co2`, `unidades_geradoras`, `id_usuario`) VALUES (100, '150', '5', 1);
INSERT INTO contrato (`saldo`, `total_co2`, `unidades_geradoras`, `id_usuario`) VALUES (200, '200', '10', 2);
INSERT INTO contrato (`saldo`, `total_co2`, `unidades_geradoras`, `id_usuario`) VALUES (300, '300', '8', 3);
INSERT INTO contrato (`saldo`, `total_co2`, `unidades_geradoras`, `id_usuario`) VALUES (400, '100', '9', 4);

INSERT INTO transacao (`data`,`lancamento`,`id_contrato`) VALUES (20220610, 100, 1);
INSERT INTO transacao (`data`,`lancamento`,`id_contrato`) VALUES (20220710, -50, 1);

INSERT INTO transacao (`data`,`lancamento`,`id_contrato`) VALUES (20220810, 300, 2);
INSERT INTO transacao (`data`,`lancamento`,`id_contrato`) VALUES (20220910, -150, 2);

INSERT INTO transacao (`data`,`lancamento`,`id_contrato`) VALUES (20221010, 300, 3);
INSERT INTO transacao (`data`,`lancamento`,`id_contrato`) VALUES (20221110, -300, 3);

INSERT INTO transacao (`data`,`lancamento`,`id_contrato`) VALUES (20220710, 1250, 4);
INSERT INTO transacao (`data`,`lancamento`,`id_contrato`) VALUES (20220810, -1000, 4);