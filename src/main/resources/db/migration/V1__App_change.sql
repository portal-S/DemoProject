create table overlords (
    id integer primary key auto_increment,
    name varchar(55) not null,
    age integer not null
);

create table planets (
    id integer primary key auto_increment,
    name varchar(55) not null,
    lord_id integer default null ,
    foreign key (lord_id) references overlords(id) on delete set null
);