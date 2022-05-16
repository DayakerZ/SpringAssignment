package com.assignment.root.assignment.dao;


import com.assignment.root.assignment.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {


}