package com.estudo.publication.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.estudo.publication.domain.Comment;

@FeignClient(name = "Comments", url = "${client.comments.url}")
public interface CommentClient {

    @GetMapping("/api/v1/comments/{publicationId}")
    List<Comment> getComments(@PathVariable("publicationId") String publicationId);

}
