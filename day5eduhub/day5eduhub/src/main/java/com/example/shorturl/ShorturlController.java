package com.example.shorturl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1")
public class ShorturlController {

    @Autowired
    private ShorturlService service;

    @GetMapping("/health")
    public String health()
    {
        return "Healthy";
    }

    @PostMapping("/create_short_url")
    public ShorturlResponce createShortUrl(@RequestBody ShorturlRequest long_url)
    {
        return service.CreateShortUrl(long_url);
    }
}
