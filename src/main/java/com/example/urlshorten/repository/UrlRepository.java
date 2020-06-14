package com.example.urlshorten.repository;

import com.example.urlshorten.domain.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url, Long> {
    Optional<Url> findByOriginalUrl(String originUrl);

    Optional<Url> findByShortenUrl(String shorten);
}
