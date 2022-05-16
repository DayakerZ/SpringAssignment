package com.assignment.root.Assignment.service;

import com.assignment.root.Assignment.dao.BookRepository;
import com.assignment.root.Assignment.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository theBookRepository){
        bookRepository = theBookRepository;
    }

    public BookServiceImpl(){

    }
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int theId) {
        Optional<Book> result = bookRepository.findById(theId);

       Book book = null;

        if (result.isPresent()) {
            book = result.get();
        }
        else {
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return book;
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteById(int theId) {
        bookRepository.deleteById(theId);
    }


}
