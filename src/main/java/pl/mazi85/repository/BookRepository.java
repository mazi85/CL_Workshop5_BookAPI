package pl.mazi85.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mazi85.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
