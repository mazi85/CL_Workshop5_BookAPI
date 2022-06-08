package pl.mazi85.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mazi85.model.Book;
import pl.mazi85.services.BookService;

import java.util.List;

@Controller
@RequestMapping("/admin/books")
public class ManageBookController {

    private final BookService bookService;

    public ManageBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public String showPosts(Model model) {
        List<Book> books = bookService.readAll();
        model.addAttribute("books", books);
        return "/books/all";
    }

    @GetMapping("/read/{id}")
    public String detailsView(Model model, @PathVariable Long id) {
        Book book = (Book)bookService.read(id);
        model.addAttribute("book", book);
        return "/books/detail";
    }

    @GetMapping("/add")
    public String prepareViewAddForm(Model model, @ModelAttribute (name = "book") Book book) {
        model.addAttribute("book", new Book());
        return "/books/add";
    }

    @PostMapping("/add")
    public String executeForm(@ModelAttribute (name = "book") Book book) {
        bookService.create(book);
        return "redirect:all";
    }

    @GetMapping("/edit/{id}")
    public String prepareViewEditForm(Model model, @PathVariable Long id) {
        Book book = (Book)bookService.read(id);
        model.addAttribute("book", book);
        return "/books/add";
    }

    @PostMapping("/edit/{id}")
    public String executeFormEdit(@ModelAttribute (name = "book") Book book) {
        bookService.update(book);
        return "redirect:/admin/books/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.delete(id);
        return "redirect:/admin/books/all";
    }


}

