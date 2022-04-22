package pl.mazi85.services;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
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
            list.add(book);
        }
        else {
            throw new NoSuchBookException("book parameters are invalid");
        }
    }

    @Override
    public Book read(int id) {
        Book book = list.stream()
                .filter(b->b.getId()==id)
                .findAny().orElseThrow();
        return book;
    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void delete(int id) {
        Book book = list.stream()
                .filter(b->b.getId()==id)
                .findAny().orElseThrow();
        list.remove(book);

    }

    private boolean validateBook(Book book) {
        if (book.getIsbn()==null || book.getAuthor()==null || book.getPublisher()==null
                || book.getType()==null || book.getTitle()==null){
            return false;
        }
        return true;
    }


}
