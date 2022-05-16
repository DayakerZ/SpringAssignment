package com.assignment.root.Assignment.controller;

import com.assignment.root.Assignment.service.BookService;
import com.assignment.root.Assignment.service.BookServiceImpl;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private BookController bookController;

    @InjectMocks
    private BookService bookService = new BookServiceImpl();

    @BeforeEach
    public void setup()
    {
        mockMvc= MockMvcBuilders.standaloneSetup(bookController).build();
    }


    @Test
    public void contextLoads() throws Exception {
        assertThat(bookController).isNotNull();
    }

//    @Test
//    public void getAllBooksFromDatabaseTest() throws Exception {
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/library/booksList"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.view().name("/books/books-collection"));
//    }


}