package com.estudo.publication.service;

import java.util.List;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.estudo.publication.domain.Comment;

@Service
public class RedisService {

    private static final String KEY = "Comments";

    private RedisTemplate<String, Object> redisTemplate;

    public RedisService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void save(List<Comment> comments, String id) {
        redisTemplate.opsForHash().put(KEY, id, comments);
    }

    public List<Comment> findById(String id) {
        return (List<Comment>) redisTemplate.opsForHash().get(KEY, id);
    }

}
