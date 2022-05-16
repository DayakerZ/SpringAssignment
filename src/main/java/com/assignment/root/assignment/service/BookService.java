package com.assignment.root.assignment.service;

import com.assignment.root.assignment.entity.Book;
import com.assignment.root.assignment.exceptions.BookNotFoudException;

import java.util.List;

public interface BookService {

    public List<Book> findAll();

    public Book findById(int theId) throws BookNotFoudException;

    public void save(Book theEmployee);

    public void deleteById(int theId);
}
