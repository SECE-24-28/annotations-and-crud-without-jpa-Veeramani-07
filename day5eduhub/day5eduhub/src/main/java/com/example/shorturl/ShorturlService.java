package com.example.shorturl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class ShorturlService {

    @Autowired
    RedisTemplate<String, Object> template;

    private String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String toBase62(Long n)
    {
        StringBuilder sb = new StringBuilder();
        while (n > 0)
        {
            sb.insert(0, chars.charAt((int)(n % 62)));
            n = n / 62;
        }

        return sb.toString();
    }

    public ShorturlResponce CreateShortUrl(ShorturlRequest long_url)
    {
        if(!long_url.isValid()) return new ShorturlResponce("Invalid Url");
        Long index = template.opsForValue().increment("shortUrl:cnt");

        String code = toBase62(index);
        template.opsForValue().set(code, long_url.getLong_url(), long_url.getExpires());

        return new ShorturlResponce(code);
    }

    public ShorturlResponce getLongUrl(String code)
    {
        if(!template.hasKey(code)) return new ShorturlResponce(null);

        return new ShorturlResponce((String) template.opsForValue().get(code));
    }

}
