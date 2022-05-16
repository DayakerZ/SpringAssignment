package com.assignment.root.assignment.controller;

import com.assignment.root.assignment.service.BookService;
import com.assignment.root.assignment.service.BookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
    void contextLoads() throws Exception {
        assertThat(bookController).isNotNull();
    }




}