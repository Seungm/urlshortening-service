package com.example.urlshorten.service;

import com.example.urlshorten.domain.Url;
import com.example.urlshorten.dto.UrlResponse;
import com.example.urlshorten.exception.UrlException;
import com.example.urlshorten.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UrlService {

    private final UrlRepository urlRepository;

    public UrlResponse generateShortenUrl(String originUrl) {
        if (validUrl(originUrl)) throw new UrlException("'" + originUrl + "'은 잘못된 URL 타입입니다.");
        // new
        Optional<Url> byOriginalUrl = urlRepository.findByOriginalUrl(originUrl);
        if (!byOriginalUrl.isPresent()) {
            String shorten = new Url(originUrl).shorten();

            Url url = new Url(originUrl, shorten);
            urlRepository.save(url);

            return new UrlResponse(url);
        } else{
            return new UrlResponse(byOriginalUrl.get());
        }
    }

    private boolean validUrl(String originUrl) {
        try {
            URL validUrl = new URL(originUrl);
            URLConnection connection = validUrl.openConnection();
            connection.connect();
        } catch (IOException e) {
            return true;
        }
        return false;
    }

    public Url redirectUrl(String shortenUrl) {
        return urlRepository.findByShortenUrl(shortenUrl)
                .orElseThrow(() -> new UrlException("'" + shortenUrl + "'은 등록되지 않은 SHORTEN URL 타입입니다."));
    }
}
