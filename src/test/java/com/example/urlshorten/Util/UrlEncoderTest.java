package com.example.urlshorten.Util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
class UrlEncoderTest {

    @Test
    @DisplayName("original url을 encode")
    void encode() {
        //given
        String url1 = "https://www.google.com";
        String url2 = "https://www.naver.com";
        String url3 = "https://github.com/Seungm/urlshortening-service";

        //when
        String encode1 = UrlEncoder.encode(url1);
        String encode2 = UrlEncoder.encode(url2);
        String encode3 = UrlEncoder.encode(url3);

        //then
        assertThat(encode1).isEqualTo("uHc1I");
        assertThat(encode1).hasSizeLessThanOrEqualTo(8);
        assertThat(encode2).isEqualTo("N5Uetb");
        assertThat(encode2).hasSizeLessThanOrEqualTo(8);
        assertThat(encode3).isEqualTo("YNdOTb");
        assertThat(encode3).hasSizeLessThanOrEqualTo(8);
    }
}
