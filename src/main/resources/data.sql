create table if not exists customer
(
    id       int auto_increment primary key,
    name     varchar(45),
    password varchar(45)
);

insert into customer (name, password)
values ('John Doe', 'qwerty'),
       ('Jane Doe', '123456');