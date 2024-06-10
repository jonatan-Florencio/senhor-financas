SET SQL_SAFE_UPDATES = 0;
DROP DATABASE IF EXISTS dbcarros;
CREATE DATABASE dbcarros;
USE dbcarros;

create table montadora (
id int not null auto_increment primary key,
nome varchar (180),
pais_fundacao varchar (180),
nome_presidente varchar (180),
data_fundacao date
);

create table carro (
id int not null auto_increment primary key,
modelo varchar (100),
placa char (9),
idmontadora int not null,
ano int,
valor decimal,
foreign key (idmontadora) references montadora(id)

);


insert into montadora (Nome, pais_fundacao, nome_presidente, data_fundacao) values
    ("Toyota", "Japão", "Akio Toyoda", "1937-08-28"),
    ("Ford", "Estados Unidos", "Jim Farley", "1903-06-16"),
    ("Volkswagen", "Alemanha", "Herbert Diess", "1937-05-28"),
    ("GM", "Estados Unidos", "Mary Barra", "1908-09-16"),
    ("Honda", "Japão", "Toshihiro Mibe", "1948-09-24"),
    ("Nissan", "Japão", "Makoto Uchida", "1933-12-26");

insert into carro ( modelo, placa, idmontadora, ano, valor ) values
	("corolla", "TOY-0001",1 , 2024, 150000.0),
    ("bandeirante", "TOY-0002",1 ,1984 , 21000.0),
    ("focus", "FOR-0001", 2 ,2020 ,80000.0 ),
    ("golf", "VWB-0001",3 ,2024 , 180000.0),
    ("fusca", "VWB-0002",3 ,1970 ,5000.0 ),
    ("kombi", "VWB-0003", 3,1980 ,3500.0 );


	SELECT * FROM montadora;
    
    
    -- inner join para verificar se a chave estrangeira
    -- da tabela carro está apontando para a montadora correta.
    
    select *
from
	carro
    inner join montadora on
    carro.idmontadora = montadora.id;