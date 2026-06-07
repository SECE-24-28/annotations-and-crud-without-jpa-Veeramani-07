package com.example.shorturl;

import java.net.URI;
import java.net.URISyntaxException;

public class ShorturlRequest {
    private String long_url;
    private long expires;

    public ShorturlRequest()
    {

    }

    public ShorturlRequest(String long_url, long expires) {
        this.long_url = long_url;
        this.expires = expires;
    }

    public String getLong_url() {
        return long_url;
    }

    public void setLong_url(String long_url) {
        this.long_url = long_url;
    }

    public long getExpires() {
        return expires;
    }

    public void setExpires(long expires) {
        this.expires = expires;
    }

    public boolean isValid()
    {
        if(this.long_url == null || this.expires > 7200) return false;

        try {
            URI uri = new URI(this.long_url);
            String schema = uri.getScheme();

            return schema != null &&
                    (
                        schema.equals("https") ||
                        schema.equals("http") ||
                        schema.equals("ws") ||
                        schema.equals("wss")
                    );
        } catch (Exception e) {
            return false;
        }

    }
}
