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

create table accounts
(
    id        int primary key,
    number    text,
    author_id int references authors (id) on delete cascade
);

create sequence accounts_sequence
    minvalue 1;

create table publishing_houses
(
    id   int primary key,
    name text
);

create sequence publishing_houses_sequence
    minvalue 1;

create table publishing_houses_books_jt (
    book_id int references books(id),
    publishing_house_id int references publishing_houses(id),
    primary key(book_id, publishing_house_id)
);
