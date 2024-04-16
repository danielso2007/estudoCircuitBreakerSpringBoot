package com.estudo.publication.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.estudo.publication.domain.Publication;
import com.estudo.publication.lang.EntityNotFoundException;
import com.estudo.publication.mapper.PublicationMapper;
import com.estudo.publication.repository.PublicationReporitory;

@Service
public class PublicationService {

    private PublicationReporitory publicationReporitory;
    private PublicationMapper publicationMapper;
    private CommentService commentService;

    public PublicationService(PublicationReporitory publicationReporitory, PublicationMapper publicationMapper,
            CommentService commentService) {
        this.publicationReporitory = publicationReporitory;
        this.publicationMapper = publicationMapper;
        this.commentService = commentService;

    }

    public void insert(Publication publication) {
        publicationReporitory.save(publicationMapper.toEntity(publication));
    }

    public List<Publication> findAll() {
        var publications = publicationReporitory.findAll();
        return publications.stream().map(publicationMapper::to).toList();
    }

    public Publication findById(String id) {
        var publication = publicationReporitory.findById(id).map(publicationMapper::to)
                .orElseThrow(EntityNotFoundException::new);
        publication.setComments(commentService.getComments(id));
        return publication;
    }

    public void delete(String id) {
        publicationReporitory.delete(publicationReporitory.findById(id).orElseThrow(EntityNotFoundException::new));
    }

}
