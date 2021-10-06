create table aluno(
	matricula varchar(50) not null unique,
    nomeA varchar(50) not null,
    status char not null
);
create table contato(
	telefone varchar(50) not null unique,
    email varchar(50) not null unique
);
create table endereco(
	bairro varchar(50) not null,
    rua varchar(50) not null,
    numero varchar(5) not null
);
create table turma(
	idTurma int not null unique auto_increment,
    datapl varchar(50),
    semana1 char not null,
    semana2 char not null,
    semana3 char not null,
    semana4 char not null
);
create table turma_aluno(
	matriculaT varchar(50) not null unique,
    idTurmaT int not null,
    foreign key (matriculaT) references aluno (matricula),
    foreign key (idTurmaT) references turma (idTurma)
    );
create table usuario(
	id int not null unique auto_increment,
    cpf varchar(50) not null unique,
    nome varchar(50) not null,
    nome varchar(50) not null,
    idContatou int,
    idEnderecou int,
    foreign key (idContatou) references contato (idContato),
    foreign key (idEnderecou) references endereco (idEndereco)
);
create table usuario_aluno(
	cpfR varchar(50) not null,
    matriculaR varchar(50) not null,
    foreign key (cpfR) references usuario (cpf),
    foreign key (matriculaR) references aluno (matricula)
);
------------------------------------------------------------------------
select * from aluno;
select * from contato;
select * from endereco;
select * from turma;
select * from turma_aluno;
select * from usuario;
select * from usuario_aluno;
------------------------------------------------------------------------
insert into aluno(matricula,nomeA,status)values('1234','LIZ WEBBER','A');
insert into aluno(matricula,nomeA,status)values('5678','DANIEL HARTMAN','N');
insert into aluno(matricula,nomeA,status)values('8765','THIAGO FRITZ','A');
insert into aluno(matricula,nomeA,status)values('4321','CESAR COHEN','A');
insert into aluno(matricula,nomeA,status)values('1010','ERIN PARKER','N');
insert into aluno(matricula,nomeA,status)values('2020','ARTHUR CERVERO','A');
insert into contato(email,telefone)values('teste@teste.com','gggg-gggg');
insert into contato(email,telefone)values('testeG@teste.com','pppp-pppp');
insert into endereco(bairro,rua,numero)values('centro','rua do teste','7');
insert into endereco(bairro,rua,numero)values('centro','rua do testeG','8');
insert into turma(semana1,semana2,semana3,semana4)values('S','N','S','N');
insert into turma(semana1,semana2,semana3,semana4)values('N','S','N','S');
insert into turma_aluno(idTurmaT,matriculaT)values(1,'1234');
insert into turma_aluno(idTurmaT,matriculaT)values(1,'5678');
insert into turma_aluno(idTurmaT,matriculaT)values(2,'8765');
insert into turma_aluno(idTurmaT,matriculaT)values(2,'4321');
insert into turma_aluno(idTurmaT,matriculaT)values(1,'1010');
insert into turma_aluno(idTurmaT,matriculaT)values(2,'2020');
insert into usuario(nome,cpf,senha,idContatou,idEnderecou,tipo)values('Diretor','testeDiretor','teste',1,1,1);
insert into usuario(nome,cpf,senha,idContatou,idEnderecou,tipo)values('Porteiro','testePorteiro','teste',2,2,2);