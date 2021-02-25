package sk.stuba.fei.uim.vsa;


import lombok.extern.slf4j.Slf4j;
import sk.stuba.fei.uim.vsa.domain.Book;
import sk.stuba.fei.uim.vsa.domain.BookRepository;
import sk.stuba.fei.uim.vsa.domain.BookRepositoryInterface;
import sk.stuba.fei.uim.vsa.service.BookService;
import sk.stuba.fei.uim.vsa.service.BookServiceInterface;

import java.sql.*;
import java.util.Optional;

@Slf4j
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Class.forName("com.mysql.jdbc.Driver");
        // Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/vsa", "root", "root");
        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection("jdbc:h2:file:./database;SCHEMA=PUBLIC;DATABASE_TO_UPPER=false", "", "");

        BookRepositoryInterface repository = new BookRepository(connection);
        BookServiceInterface service = new BookService(repository);





        Optional<Book> book = repository.findByTitle("john");
        service.zlava("john");
        Optional<Book> book1 = repository.findByTitle("john");
        System.out.println(book1);

        connection.close();
    }
}
