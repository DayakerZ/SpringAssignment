package com.assignment.root.assignment.service;

import com.assignment.root.assignment.dao.BookRepository;
import com.assignment.root.assignment.entity.Book;
import com.assignment.root.assignment.exceptions.BookNotFoudException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceImplTest {


    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService = new BookServiceImpl();

    private Book book;

    private List<Book> bookList = new ArrayList<>();

    @BeforeEach
    void setup(){
        book = new Book(10,"tbat","daya",1);

        Book book1=new Book(11,"Temp Book 1","Rakesh",10);
        Book book2=new Book(12,"Temp Book 2","Mukesh",11);
        bookList.add(book1);
        bookList.add(book2);
    }

    @Test
    void saveBook() {
        when(bookRepository.save(book)).thenReturn(book);
        bookService.save(book);
        verify(bookRepository,times(1)).save(book);
    }

    @Test
    void findById() throws BookNotFoudException {
        when(bookRepository.findById(10)).thenReturn(Optional.of(book));
        Assertions.assertEquals(book,bookService.findById(10));
    }

    @Test
    void deleteBook() {
        bookService.deleteById(10);
        verify(bookRepository,times(1)).deleteById(book.getId());
    }


    @Test
    void getBookList() {
        when(bookRepository.findAll() ).thenReturn(bookList);
        Assertions.assertEquals(2,bookService.findAll().size());
    }
}
