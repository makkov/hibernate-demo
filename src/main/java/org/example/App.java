package org.example;

import org.example.entity.Author;
import org.example.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Author.class)
                .addAnnotatedClass(Book.class);

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
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            Book newBook = new Book("First book");
            session.persist(newBook);

            session.getTransaction().commit();
        }

    }
}
