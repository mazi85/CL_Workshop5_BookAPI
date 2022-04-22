package pl.mazi85.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.mazi85.model.Book;
import pl.mazi85.services.MockBookService;
import pl.mazi85.services.Service;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    Service<Book> mockBookService;

    @Autowired
    public BookController(Service<Book> mockBookService) {
        this.mockBookService = mockBookService;
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Book> readBooks() {
        return mockBookService.readAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Book readBook(@PathVariable Integer id) {
        return mockBookService.read(id);
    }




}

