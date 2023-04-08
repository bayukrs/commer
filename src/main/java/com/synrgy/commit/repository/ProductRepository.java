package com.synrgy.commit.repository;

import com.synrgy.commit.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findBySold(Boolean sold);
}
