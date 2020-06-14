package com.example.urlshorten.dto;

import com.example.urlshorten.domain.Url;
import lombok.Getter;

@Getter
public class UrlResponse {
    private String originUrl;
    private String shortenUrl;

    public UrlResponse(Url url) {
        this.originUrl = url.getOriginalUrl();
        this.shortenUrl = url.getShortenUrl();
    }
}
