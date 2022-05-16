package com.assignment.root.assignment.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void isBookExistsById(){
        Boolean actualResult = bookRepository.existsById(3);
        assertThat(actualResult).isTrue();
    }
}
