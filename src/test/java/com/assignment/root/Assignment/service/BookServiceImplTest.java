package com.assignment.root.Assignment.service;

import com.assignment.root.Assignment.dao.BookRepository;
import com.assignment.root.Assignment.entity.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

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
    public void setup(){
        book = new Book(10,"tbat","daya",1);

        Book book1=new Book(11,"Temp Book 1","Rakesh",10);
        Book book2=new Book(12,"Temp Book 2","Mukesh",11);
        bookList.add(book1);
        bookList.add(book2);
    }

    @Test
    public void saveBook() {
        when(bookRepository.save(book)).thenReturn(book);
        bookService.save(book);
        verify(bookRepository,times(1)).save(book);
    }

    @Test
    public void findById() {
        when(bookRepository.findById(10)).thenReturn(Optional.of(book));
        Assertions.assertEquals(book,bookService.findById(10));
    }

    @Test
    public void deleteBook() {
        bookService.deleteById(10);
        verify(bookRepository,times(1)).deleteById(book.getId());
    }


    @Test
    public void getBookList() {
        when(bookRepository.findAll() ).thenReturn(bookList);
        Assertions.assertEquals(2,bookService.findAll().size());
    }
}
