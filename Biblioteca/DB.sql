CREATE TABLE cliente (

id serial NOT NULL,
nome varchar(200) NOT NULL,
telefone varchar(15) NOT NULL

PRIMARY KEY (id)

);

CREATE TABLE livro (

id serial NOT NULL,
nome varchar(100) NOT NULL,
ISBN varchar(13) NOT NULL,
autores varchar(100) NOT NULL,
editora varchar(100) NOT NULL,
anoPublicacao int NOT NULL

PRIMARY KEY (id)

);

CREATE TABLE movimentacao (

id serial NOT NULL,
idCliente int NOT NULL,
dataRetirada date DEFAULT CURRENT_DATE,
dataPrevistaDevolucao date,

PRIMARY KEY (id),
FOREIGN KEY (idCliente) REFERENCES cliente

);

CREATE TABLE movLivro (

id serial NOT NULL,
idMovimentacao int NOT NULL,
idLivro int NOT NULL,
dataDevolucao date NULL,

PRIMARY KEY (id),
FOREIGN KEY (idMovimentacao) REFERENCES movimentacao,
FOREIGN KEY (idLivro) REFERENCES livro

);

INSERT INTO cliente ( nome, telefone )
VALUES ( 'André', '(51)0000-0000' ), -- 1
	   ( 'Bruno', '(51)1111-1111' ), -- 2
	   ( 'Carlos', '(51)2222-2222' ), -- 3
	   ( 'Denilson', '(51)3333-3333' ), -- 4
	   ( 'Eduardo', '(51)4444-4444' ), -- 5
	   ( 'Fábio', '(51)5555-5555' ), -- 6
	   ( 'Gustavo', '(51)6666-6666' ); -- 7

INSERT INTO livro ( nome, ISBN, autores, editora, anoPublicacao )
VALUES ( 'A Droga da Obediência', '8516045390', 'Pedro Bandeira', 'Editora Moderna', 2009), -- 1
	   ( 'Harry Potter e a Pedra Filosofal', '8532511015', 'J. K. Rowling', 'Rocco', 2000), -- 2
	   ( 'O Guia do Mochileiro das Galáxias', '8599296574', 'Douglas Adams', 'Arqueiro', 2009), -- 3
	   ( 'O Pequeno Príncipe', '8522031444', 'Antoine de Saint-Exupery', 'Agir', 2015), -- 4
	   ( 'As Crônicas de Gelo e Fogo, Livro 1: A Guerra dos Tronos', '8544102921', 'George R. R. Martin', 'Leya Brasil', 2015), -- 5
	   ( 'The Walking Dead: O Caminho para Woodbury', '8501401870', 'Robert Kirkman, Jay Bonansinga', 'Galera Record', 	2013), -- 6
	   ( 'Assassins Creed: Renascença', '8501091332', 'Oliver Bowden', 'Galera Record', 2011); -- 7

INSERT INTO movimentacao ( idCliente, dataRetirada, dataPrevistaDevolucao )
VALUES ( 3, '26/05/2016', '02/06/2016' ), -- 1
	   ( 7, '26/05/2016', '02/06/2016' ), -- 2
	   ( 2, '27/05/2016', '03/06/2016' ), -- 3
	   ( 5, '07/06/2016', '14/06/2016' ); -- 4

INSERT INTO movLivro ( idMovimentacao, idLivro, dataDevolucao )
VALUES ( 1, 2, '30/05/2016' ), -- 1
	   ( 1, 3, '30/05/2016' ), -- 2
	   ( 1, 6, '30/05/2016' ), -- 3
	   ( 2, 1, '02/06/2016' ), -- 4
	   ( 3, 4, '02/06/2016' ), -- 5
	   ( 3, 5, '04/06/2016' ), -- 6
	   ( 4, 7, NULL ), -- 7
	   ( 4, 1, NULL ), -- 8
	   ( 4, 3, NULL ); -- 9