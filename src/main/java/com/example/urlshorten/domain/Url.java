package com.example.urlshorten.domain;

import com.example.urlshorten.Util.UrlEncoder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table
@NoArgsConstructor
public class Url {
    private static final String prefix = "http://codetest.smk/";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String originalUrl;
    @Column
    private String shortenUrl;

    public Url(String originUrl) {
        this.originalUrl = originUrl;
    }

    public Url(String originUrl, String shortenUrl) {
        this.originalUrl = originUrl;
        this.shortenUrl = shortenUrl;
    }

    public String shorten() {
        return prefix + generateUrl();
    }

    public String generateUrl() { return UrlEncoder.encode(originalUrl); }

    @Override
    public String toString() {
        return "Url{" +
                "id=" + id +
                ", originalUrl='" + originalUrl + '\'' +
                ", shortenUrl='" + shortenUrl + '\'' +
                '}';
    }
}
