package com.ProductionReadyFeature.ProductionReadyFeature.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostDTO {

    private Long id;
    private String title;
    private String description;
}
