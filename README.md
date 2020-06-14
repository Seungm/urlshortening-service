# 소개
URL을 입력받아 짧게 줄여주고, Shortening된 URL을 입력하면 원래 URL로 리다이렉트하는 URL Shortening Service
예) https://en.wikipedia.org/wiki/URL_shortening => http://localhost/JZfOQNro

- URL 입력폼 제공 및 결과 출력
- URL Shortening Key는 8 Character 이내로 생성되어야 합니다.
- 동일한 URL에 대한 요청은 동일한 Shortening Key로 응답해야 합니다.
- 동일한 URL에 대한 요청 수 정보를 가져야 한다(화면 제공 필수 아님)
- Shortening된 URL을 요청받으면 원래 URL로 리다이렉트 합니다.
- Database 사용은 필수 아님

# 문제해결 전략
- URL String의 Hashcode 값을 이용하여 Base62로 인코딩
    * 같은 URL에 대한 동일한 key Character 값 제공 

# 실행 방법 명시

## 환경
* Java8
* Maven
* Spring Boot
* Github
--
## 프로젝트 빌드 및 실행
1) 소스 받기
```$xslt
# cloansource form Github
* git clone https://github.com/Seungm/urlshortening-service.git
    * OR Download
```
2) 소스 빌드
```$xslt
# move
cd urlshorten

# build
mvn package
```

3) 실행
```$xslt
cd target

#run 
java -jar urlshorten-0.0.1-SNAPSHOT.jar
```

## 환경
* Java8
* Maven
* Spring Boot
* Github
--
## 프로젝트 빌드 및 실행
1) 소스 받기
```$xslt
    # clone source form Github
    git clone https://github.com/Seungm/urlshortening-service.git
        * OR Download
```
2) 소스 빌드
```$xslt
    # move
    cd urlshorten

    # build
    mvn package
```

3) 실행
```$xslt
    # move
    cd target

    #run 
    java -jar urlshorten-0.0.1-SNAPSHOT.jar
```
