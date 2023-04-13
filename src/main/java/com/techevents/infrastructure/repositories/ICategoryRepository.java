package com.techevents.infrastructure.repositories;

import com.techevents.domain.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository <Category, Long> {
}
