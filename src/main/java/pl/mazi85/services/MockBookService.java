package pl.mazi85.services;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import pl.mazi85.model.Book;

import java.util.ArrayList;
import java.util.List;

@Component
public class MockBookService {
    private static Long nextId = 4L;
    private List<Book> list;
    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }


    public List<Book> readAll(){
        return list;
    }
    public void create(){}
    public void read(){}
    public void update(){}
    public void delete(){}




}
