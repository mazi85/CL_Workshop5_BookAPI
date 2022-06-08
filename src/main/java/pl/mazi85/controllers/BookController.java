package pl.mazi85.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.mazi85.model.Book;
import pl.mazi85.services.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

   private final BookService<Book> bookService;

    @Autowired
    public BookController(BookService<Book> bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Book> readBooks() {
        return bookService.readAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book readBook(@PathVariable Integer id) {
        return bookService.read(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void saveBook(@RequestBody Book book) {
            bookService.create(book);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateBook(@RequestBody Book book) {
        bookService.update(book);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable Integer id) {
        bookService.delete(id);
    }


}

