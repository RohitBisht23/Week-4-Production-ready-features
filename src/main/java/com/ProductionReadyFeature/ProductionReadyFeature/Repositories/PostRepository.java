package com.ProductionReadyFeature.ProductionReadyFeature.Repositories;


import com.ProductionReadyFeature.ProductionReadyFeature.Entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

}
