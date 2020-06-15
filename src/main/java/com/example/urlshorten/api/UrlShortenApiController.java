package com.example.urlshorten.api;

import com.example.urlshorten.domain.Url;
import com.example.urlshorten.dto.UrlResponse;
import com.example.urlshorten.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UrlShortenApiController {

    private final UrlService urlService;

    @PostMapping("/generated")
    public ResponseEntity<UrlResponse> generated(@RequestBody String originUrl){
        UrlResponse response = urlService.generateShortenUrl(originUrl);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping("/redirect")
    public ResponseEntity<String> redirect(@RequestParam String shortenUrl){
        Optional<Url> url = urlService.redirectUrl(shortenUrl);
        return new ResponseEntity<>(url.get().getOriginalUrl(), HttpStatus.OK);
    }

}
