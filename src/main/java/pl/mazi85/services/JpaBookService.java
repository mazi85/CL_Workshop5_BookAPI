package pl.mazi85.services;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.mazi85.model.Book;
import java.util.List;


import pl.mazi85.repository.BookRepository;


@Service
@Primary
public class JpaBookService implements BookService<Book>  {

    private final BookRepository bookRepository;

    public JpaBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public List<Book> readAll() {
        return bookRepository.findAll();
    }

    @Override
    public void create(Book book) {
        if (validateBook(book)) {
            bookRepository.save(book);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "book parameters are invalid"
            );
        }
    }

    @Override
    public Book read(long id) {
        return bookRepository.findById(id).orElseThrow( ()-> {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found");
        });
    }

    @Override
    public void update(Book book) {
        if (validateBook(book) && read(book.getId())!=null) {
        bookRepository.save(book);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "book parameters are invalid"
            );
        }
    }

    @Override
    public void delete(int id) {
        bookRepository.delete(read(id));

    }

    private boolean validateBook(Book book) {
        if (book.getIsbn() == null || book.getAuthor() == null || book.getPublisher() == null
                || book.getType() == null || book.getTitle() == null) {
            return false;
        }
        return true;
    }
}
