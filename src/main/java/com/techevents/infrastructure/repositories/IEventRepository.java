package com.techevents.infrastructure.repositories;

import com.techevents.domain.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEventRepository extends JpaRepository <Event, Long> {
}
