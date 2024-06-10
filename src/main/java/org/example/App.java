package org.example;

import org.example.entity.Account;
import org.example.entity.Author;
import org.example.entity.Book;
import org.example.entity.PublishingHouse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Author.class)
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Account.class)
                .addAnnotatedClass(PublishingHouse.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

//        сохранение автора
//        try (Session session = sessionFactory.getCurrentSession()) {
//            session.beginTransaction();
//
//            Author newAuthor = new Author("First author");
//            session.persist(newAuthor);
//
//            session.getTransaction().commit();
//        }

//        сохранение книги
//        try (Session session = sessionFactory.getCurrentSession()) {
//            session.beginTransaction();
//
//            Book newBook = new Book("First book");
//            session.persist(newBook);
//
//            session.getTransaction().commit();
//        }

//        создание автора и его книги
//        try (Session session = sessionFactory.getCurrentSession()) {
//            session.beginTransaction();
//
//            Author newAuthor = new Author("Second author");
//            Book newBook = new Book("Second author's book", newAuthor);
//
////            если нужно, чтобы объект автор содержал книги
////            newAuthor.setBooks(new ArrayList<Book>(Collections.singleton(newBook)));
//
//            session.persist(newAuthor);
//            session.persist(newBook);
//
//            session.getTransaction().commit();
//        }

//        получение автора с книгами
//        try (Session session = sessionFactory.getCurrentSession()) {
//            session.beginTransaction();
//
//            Author author = session.get(Author.class, 1);
//            System.out.println(author);
//        }

//        удаление автора
//        try (Session session = sessionFactory.getCurrentSession()) {
//            session.beginTransaction();
//
//            Author author = session.get(Author.class, 101);
//
//            author.setName("new name 2");
////            session.detach(author); чтобы изменения не применились на БД
//
//            session.remove(author);
//            session.getTransaction().commit();
//        }

//        создание нового аккаунта для автора
//        try (Session session = sessionFactory.getCurrentSession()) {
//            session.beginTransaction();
//
//            Author author = session.get(Author.class, 1);
//            Account newAccount = new Account("acc/nb/2024-06-10", author);
//            session.persist(newAccount);
//
//            session.getTransaction().commit();
//        }
//    }

//        удаление с cascade
//        try (Session session = sessionFactory.getCurrentSession()) {
//            session.beginTransaction();
//
//            Author author = session.get(Author.class, 101);
//
//            session.remove(author);
//
//            session.getTransaction().commit();
//        }
//    }

//        many-to-many
//        try (Session session = sessionFactory.getCurrentSession()) {
//            session.beginTransaction();
//
//            PublishingHouse publishingHouse1 = new PublishingHouse("house 1");
//            PublishingHouse publishingHouse2 = new PublishingHouse("house 2");
//
//            Book book1 = new Book("book 1");
//            Book book2 = new Book("book 2");
//
//            publishingHouse1.setBooks(new ArrayList<>(Arrays.asList(book1, book2)));
//            publishingHouse2.setBooks(new ArrayList<>(Arrays.asList(book1, book2)));
//
//            session.persist(book1);
//            session.persist(book2);
//            session.persist(publishingHouse1);
//            session.persist(publishingHouse2);
//
//            session.getTransaction().commit();
//        }

//        рассмотрение Eager и Lazy
        try (Session session  = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            Author author = session.get(Author.class, 1);
            System.out.println(author);
            System.out.println(author.getBooks());
            /*
            LAZY:
            Hibernate: select a1_0.id,a1_0.name from authors a1_0 where a1_0.id=?
            Hibernate: select b1_0.author_id,b1_0.id,b1_0.name from books b1_0 where b1_0.author_id=?

            EAGER:
            Hibernate: select a1_0.id,a1_0.name,b1_0.author_id,b1_0.id,b1_0.name from authors a1_0 left join books b1_0 on a1_0.id=b1_0.author_id where a1_0.id=?
            * */
        }
    }
}
