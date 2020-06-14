package com.example.urlshorten.service;

import com.example.urlshorten.domain.Url;
import com.example.urlshorten.repository.UrlRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@SpringBootTest
class UrlServiceTest {

    @Mock
    private UrlRepository repository;

    @InjectMocks
    UrlService urlService;

    @Test
    @DisplayName("새로운 URL 입력")
    void generateShortenUrl() {
        //given
        when(repository.findByOriginalUrl(anyString())).thenReturn(Optional.empty());
        //when
        assertThat(urlService.generateShortenUrl("https://github.com/Seungm/urlshortening-service").getShortenUrl()).isEqualTo("http://codetest.smk/YNdOTb");
    }

    @Test
    @DisplayName("기 URL 입력")
    void generateShortenUrl_new() {
        //given
        Url url = new Url("https://github.com/Seungm/urlshortening-service", "http://codetest.smk/YNdOTb");
        when(repository.findByOriginalUrl(anyString())).thenReturn(Optional.of(url));
        // when
        assertThat(urlService.generateShortenUrl("https://github.com/Seungm/urlshortening-service").getShortenUrl()).isEqualTo("http://codetest.smk/YNdOTb");
    }
}
