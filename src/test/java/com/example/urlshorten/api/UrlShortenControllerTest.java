package com.example.urlshorten.api;

import com.example.urlshorten.service.UrlService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class UrlShortenControllerTest {

    @Autowired
    private UrlService urlService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        urlService.generateShortenUrl("https://www.google.com");
    }

    @Test
    void redirect() throws Exception {
        mockMvc.perform(get("/uHc1I"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("https://www.google.com"));
    }
}
