create table authors
(
    id   int primary key,
    name text
);

create sequence authors_sequence
    minvalue 1;

create table books
(
    id        int primary key,
    name      text,
    author_id int references authors (id) on delete set null
);

create sequence books_sequence
    minvalue 1;
