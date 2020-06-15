package com.example.urlshorten.api;

import com.example.urlshorten.domain.Url;
import com.example.urlshorten.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class UrlShortenController {

    private final UrlService urlService;

    @GetMapping("/")
    public String main (Model model) {
        return "main";
    }

    @GetMapping("/{shortenUrl}")
    public String redirect(HttpServletResponse response, @PathVariable String shortenUrl){
        shortenUrl = "http://codetest.smk/"+shortenUrl;
        Optional<Url> url1 = urlService.redirectUrl(shortenUrl);
        return url1.map(url -> "redirect:" + url.getOriginalUrl()).orElse("error/error");

    }
}
