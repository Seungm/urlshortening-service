package com.example.urlshorten.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class UrlShortenApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void beforeTest() {

    }

    @Test
    void generated() throws Exception {
        String originalUrl = "https://github.com/Seungm/urlshortening-service";
        mockMvc.perform(post("/api/generated")
                .contentType(MediaType.APPLICATION_JSON)
                .content(originalUrl))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.shortenUrl", is("http://codetest.smk/YNdOTb")));
        ;
    }

}
