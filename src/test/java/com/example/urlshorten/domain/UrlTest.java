package com.example.urlshorten.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UrlTest {

    @Test
    @DisplayName("shorten url")
    void shorten() {
        //given
        Url url = new Url("https://www.google.com");
        //when
        String shorten = url.shorten();
        //then
        assertThat(shorten).isEqualTo("http://codetest.smk/uHc1I");

    }
}
