package com.techevents.infrastructure.repositories;

import com.techevents.domain.models.Category;
import com.techevents.domain.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface IEventRepository extends JpaRepository <Event, Long> {
    List<Event> findByHighlightTrueOrderByEventDateAsc();
    @Query("select s from Event s where s.category.id = ?1")
    List<Event> findByCategory_Id(@PathVariable Long id);


    List<Event> findByInscribedUsers_User_Id(Long id);






}
