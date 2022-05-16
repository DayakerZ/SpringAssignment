package com.assignment.root.Assignment.dao;


import com.assignment.root.Assignment.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

}