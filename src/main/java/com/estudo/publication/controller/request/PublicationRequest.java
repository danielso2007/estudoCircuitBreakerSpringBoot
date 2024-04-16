package com.estudo.publication.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicationRequest {

    @NotBlank
    private String title;

    private String imageUrl;

    @NotBlank
    private String text;
    
}
