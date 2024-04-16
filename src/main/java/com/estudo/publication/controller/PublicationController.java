package com.estudo.publication.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.estudo.publication.controller.request.PublicationRequest;
import com.estudo.publication.domain.Publication;
import com.estudo.publication.mapper.PublicationMapper;
import com.estudo.publication.service.PublicationService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/v1/publications")
public class PublicationController {

    private PublicationService publicationService;
    private PublicationMapper publicationMapper;

    public PublicationController(PublicationService publicationService, PublicationMapper publicationMapper) {
        this.publicationService = publicationService;
        this.publicationMapper = publicationMapper;
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@Valid @RequestBody PublicationRequest publicationRequest) {
        publicationService.insert(publicationMapper.to(publicationRequest));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Publication> findAll() {
        return publicationService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Publication findById(@PathVariable("id") String id) {
        return publicationService.findById(id);
    }

}
