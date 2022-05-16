package com.assignment.root.assignment.controller;

import com.assignment.root.assignment.dao.BookRepository;
import com.assignment.root.assignment.service.BookService;
import com.assignment.root.assignment.service.BookServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookControllerTest {


    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private BookController bookController;


    private MockMvc mockMvc;


    @Before
    public void setup() {
        bookController = new BookController(bookService);
        bookService = new BookServiceImpl(bookRepository);
        mockMvc= MockMvcBuilders.standaloneSetup(bookController).build();
    }


    @Test
    void contextLoads() throws Exception {

        setup();
        assertThat(bookController).isNotNull();

        assertThat(mockMvc).isNotNull();
    }

    @Test
    public void getAllBooksFromDatabaseTest() throws Exception {

        setup();
        assertThat(mockMvc).isNotNull();
        mockMvc.perform(MockMvcRequestBuilders.get("/library/booksList"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("/books/books-collection"));
    }


}