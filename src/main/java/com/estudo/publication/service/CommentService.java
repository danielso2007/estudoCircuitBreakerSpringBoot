package com.estudo.publication.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.estudo.publication.client.CommentClient;
import com.estudo.publication.domain.Comment;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CommentService {

    private CommentClient commentClient;
    private RedisService redisService;

    public CommentService(CommentClient commentClient, RedisService redisService) {
        this.commentClient = commentClient;
        this.redisService = redisService;
    }

    @CircuitBreaker(name = "comments", fallbackMethod = "getCommentsFallback")
    public List<Comment> getComments(String id) {
        var comments = commentClient.getComments(id);
        redisService.save(comments, id);
        return comments;
    }

    @SuppressWarnings({ "PMD.UnusedFormalParameter", "PMD.UnusedPrivateMethod" })
    private List<Comment> getCommentsFallback(String id, Throwable cause) {
        log.warn("[warn] fallback with id {}", id);
        return redisService.findById(id);
    }

}
