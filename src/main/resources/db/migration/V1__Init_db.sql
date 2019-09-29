create table hibernate_sequence (next_val bigint) engine=MyISAM;
 insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );

create table new_sushi (
id bigint not null,
filename varchar(255),
name varchar(255) not null,
price double precision not null,
weight integer not null,
description varchar(255) not null,
primary key (id)
) engine=MyISAM;

 create table user (
 id bigint not null,
 activation_code varchar(255),
 active bit not null,
 email varchar(255),
 password varchar(255) not null,
 username varchar(255) not null,
 primary key (id)
 ) engine=MyISAM;

 create table user_role (
 user_id bigint not null,
 roles varchar(255)
 ) engine=MyISAM;

 alter table user_role
 add constraint user_role_user_fk
 foreign key (user_id) references user (id);


