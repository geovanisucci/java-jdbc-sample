create table produto 
(
	id int auto_increment,
    nome varchar(50) not null,
    descricao varchar(255),
    
    primary key(id))
    Engine = InnoDB;
    
insert into produto (nome, descricao) values ('Notebook', 'NOTEBOOK SAMSUNG');