package com.estudo.publication.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.estudo.publication.repository.entity.PublicationEntity;

@Repository
public interface PublicationReporitory extends MongoRepository<PublicationEntity, String> {
    
}
