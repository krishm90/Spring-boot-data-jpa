create table users (username varchar(20) not null, email varchar(30), password varchar(20), primary key (username));
alter table users add constraint UKfnranlqhubvw04boopn028e6 unique (username, email);
