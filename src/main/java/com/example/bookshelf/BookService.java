package com.example.bookshelf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book createBook(Book book){

        if (book.getStatus() == null || book.getStatus().isEmpty()) {
            book.setStatus("reading");
        }

        return bookRepository.save(book);
    }

    public boolean deleteBook(String id){
        Optional<Book> book = bookRepository.findById(id);

        if (book.isPresent()){
            bookRepository.deleteById(id);
            return true;
        }
        return false;

    }

}
