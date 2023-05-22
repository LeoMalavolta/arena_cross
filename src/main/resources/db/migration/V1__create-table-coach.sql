CREATE TABLE coachs(

                        id bigint not null auto_increment,
                        nome varchar(100) not null,
                        cref varchar(6) not null unique,
                        email varchar(100) not null unique,
                        telefone varchar(15) not null unique,
                        data_nascimento date not null,
                        logradouro varchar(100) not null,
                        bairro varchar(100) not null,
                        cep varchar(9) not null,
                        complemento varchar(100),
                        numero varchar(20),
                        uf char(2) not null,
                        cidade varchar(100) not null,

                        primary key(id)

);