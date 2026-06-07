package com.example.shorturl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class RedirectController {

    @Autowired
    private ShorturlService service;

    @GetMapping("/{code}")
    public ResponseEntity<Void> getLongUrl(@PathVariable String code)
    {
        ShorturlResponce responce = service.getLongUrl(code);
        String long_url = responce.getLong_url();
        if(long_url == null) return ResponseEntity.notFound().build();

        URI uri = URI.create(long_url);

        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).location(uri).build();
    }
}
