package com.estudo.publication.mapper;

import org.mapstruct.Mapper;
import com.estudo.publication.controller.request.PublicationRequest;
import com.estudo.publication.domain.Publication;
import com.estudo.publication.repository.entity.PublicationEntity;

@Mapper(componentModel = "spring")
public interface PublicationMapper {
    
    PublicationEntity toEntity(Publication publication);

    Publication to(PublicationEntity publicationEntity);

    Publication to(PublicationRequest publicationRequest);

}
