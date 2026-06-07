package com.example.shorturl;

public class ShorturlResponce {
    private String long_url;

    public ShorturlResponce()
    {

    }

    public ShorturlResponce(String long_url) {
        this.long_url = long_url;
    }

    public String getLong_url() {
        return long_url;
    }

    public void setLong_url(String long_url) {
        this.long_url = long_url;
    }
}
