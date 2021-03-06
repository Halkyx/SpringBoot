package manh.cong.bookstore.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import manh.cong.bookstore.model.Book;
import manh.cong.bookstore.repository.BookDao;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api")

public class RESTController {

    BookDao bookDao = new BookDao();

    @GetMapping("/books")
    public ResponseEntity<List<Book>> listBooks() {
        return ResponseEntity.ok().body(bookDao.getAll());
    }

    @GetMapping("/id")
    public ResponseEntity<Optional<Book>> getBookById(@RequestParam(value = "id") int id) {
        BookDao bookDao = new BookDao();
        return ResponseEntity.ok().body(bookDao.get(id));
    }

    @PostMapping("/booksAfterAdd")
    public ResponseEntity<List<Book>> addBooks(@RequestParam(value = "id") int id,
            @RequestParam(value = "title") String title, @RequestParam(value = "description") String description) {
        bookDao.add(new Book(id, title, description));
        return ResponseEntity.ok().body(bookDao.getAll());
    }

    @PutMapping("/booksAfterUpdate")
    public ResponseEntity<List<Book>> updateBook(@RequestParam(value = "id") int id,
            @RequestParam(value = "title") String title, @RequestParam(value = "description") String description) {
        bookDao.update(id, new Book(id, title, description));
        return ResponseEntity.ok().body(bookDao.getAll());
    }

    @DeleteMapping("/booksAfterDelete")
    public ResponseEntity<List<Book>> deleteBook(@RequestParam(value = "id") int id) {
        bookDao.deleteByID(id);
        return ResponseEntity.ok().body(bookDao.getAll());
    }

}
