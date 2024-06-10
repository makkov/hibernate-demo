package org.example;

import org.example.entity.Account;
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
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Account.class);

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
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            Author author = session.get(Author.class, 101);

            session.remove(author);

            session.getTransaction().commit();
        }
    }

}
