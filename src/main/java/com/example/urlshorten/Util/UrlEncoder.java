package com.example.urlshorten.Util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UrlEncoder {
    private static final String CODEC = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int CODEC_SIZE = CODEC.toCharArray().length;

    public static String encode(String originalUrl) {
        // hashCode 사용
        int hashCode = 0;
        if (originalUrl.length() > 0) {
            char origin[] = originalUrl.toCharArray();
            for (int i = 0; i < originalUrl.length(); i++) {
                hashCode = ((hashCode << 5) - hashCode) + origin[i];
            }
            log.info("hashcode : " + hashCode);
            hashCode = hashCode & 0x7fffffff;
        }

        String encodeStr = encodeStr(hashCode);
        log.info("Result of encoding the original URL : " + originalUrl + " -> " + encodeStr);
        return encodeStr;
    }

    private static String encodeStr(Integer value) {
        StringBuilder sb = new StringBuilder();
        while (value > 0) {
            sb.append(CODEC.charAt(value % CODEC_SIZE));
            value /= CODEC_SIZE;
        }
        return sb.toString();
    }
}
