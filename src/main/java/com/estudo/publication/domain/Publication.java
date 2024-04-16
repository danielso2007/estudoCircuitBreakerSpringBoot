package com.estudo.publication.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Publication {
    
    private String id;
    private String title;
    private String imageUrl;
    private String text;
    private List<Comment> comments;

    public void addComments(Comment comment) {
        if (Objects.isNull(comments)) {
            this.comments = new ArrayList<>();
        }
        this.comments.add(comment);
    }

}
