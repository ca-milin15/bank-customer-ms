# bank-customer-ms

## Creacion de contenedor de la DB de customer:

docker run --name pichincha-postgres-customer-instance -e POSTGRES_PASSWORD=root -e POSTGRES_USER=root -e POSTGRES_DB=customer -p 5432:5432 -d postgres

tbl_customer_seq

CREATE SEQUENCE IF NOT EXISTS tbl_customer_id_seq START WITH 1;

create table tbl_customer(
    id SERIAL PRIMARY KEY,
    name varchar(100) not null,
    gender char(1) not null,
    age int not null,
    identification varchar(100) not null,
    address varchar(100) not null,
    phone varchar(25) not null,
    password varchar(200) not null,
status boolean not null
);

## Creacion del contenedor de rabbitMQ

docker run --name pichincha-rabbit-mq-instance -p 1996:1883 -p 5672:5672 -p 5671:5671 -p 15672:15672 -d cyrilix/rabbitmq-mqtt