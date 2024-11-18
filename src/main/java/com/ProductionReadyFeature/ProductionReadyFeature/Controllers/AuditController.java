package com.ProductionReadyFeature.ProductionReadyFeature.Controllers;

import com.ProductionReadyFeature.ProductionReadyFeature.Entities.PostEntity;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/audit")
public class AuditController {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    //getting the revision(all updates) of the post with id
    @GetMapping("/post/{postId}")
    public List<PostEntity> getPostRevision(@PathVariable Long postId) {
        AuditReader reader = AuditReaderFactory.get(entityManagerFactory.createEntityManager());

        List<Number> revisions = reader.getRevisions(PostEntity.class, postId);

        return revisions
                .stream()
                .map(revisonNumber -> reader.find(PostEntity.class, postId, revisonNumber))
                .collect(Collectors.toList());
    }
}
