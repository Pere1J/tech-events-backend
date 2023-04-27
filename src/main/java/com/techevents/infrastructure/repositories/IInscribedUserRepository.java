package com.techevents.infrastructure.repositories;

import com.techevents.domain.models.InscribedUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInscribedUserRepository extends JpaRepository<InscribedUser, Long> {


}
