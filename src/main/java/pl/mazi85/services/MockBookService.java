package pl.mazi85.services;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import pl.mazi85.exceptions.NoSuchBookException;
import pl.mazi85.model.Book;

import java.util.ArrayList;
import java.util.List;

@Component
public class MockBookService implements Service<Book> {
    private static Long nextId = 4L;
    private List<Book> list;

    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thiniking in Java", "Bruce Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa Java.", "Sierra Kathy,	Bates Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy", "Cay Horstmann, Gary Cornell", "Helion",
                "programming"));
    }

    @Override
    public List<Book> readAll() {
        return list;
    }

    @Override
    public void create(Book book) {
        if (validateBook(book)) {
            book.setId(nextId++);
            list.add(book);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "book parameters are invalid"
            );
        }
    }

    @Override
    public Book read(long id) {
        Book book = list.stream()
                .filter(b -> b.getId() == id)
                .findAny().orElseThrow(() -> {
                    throw new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "entity not found"
                    );
                });
        return book;
    }

    @Override
    public void update(Book book) {
        Book bookForUpd = read(book.getId());
        int indexOf = list.indexOf(bookForUpd);
        if (validateBook(book)) {
            list.remove(bookForUpd);
            list.add(indexOf, book);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "book parameters are invalid"
            );
        }
    }

    @Override
    public void delete(int id) {
        Book book = read(id);
        list.remove(book);

    }

    private boolean validateBook(Book book) {
        if (book.getIsbn() == null || book.getAuthor() == null || book.getPublisher() == null
                || book.getType() == null || book.getTitle() == null) {
            return false;
        }
        return true;
    }


}
