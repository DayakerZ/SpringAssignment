package com.assignment.root.Assignment.service;

import com.assignment.root.Assignment.entity.Book;

import java.util.List;

public interface BookService {

    public List<Book> findAll();

    public Book findById(int theId);

    public void save(Book theEmployee);

    public void deleteById(int theId);
}
