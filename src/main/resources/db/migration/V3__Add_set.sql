create table sushi_set (
id bigint not null,
filename varchar(255),
name varchar(255) not null,
price double precision not null,
weight integer not null,
amount_piece integer not null,
consist varchar(255) not null,
primary key (id)
);

