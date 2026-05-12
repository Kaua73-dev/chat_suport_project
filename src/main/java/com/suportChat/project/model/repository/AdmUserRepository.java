package com.suportChat.project.model.repository;

import com.suportChat.project.model.entity.AdmUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdmUserRepository extends JpaRepository<AdmUser, Integer> {

    Optional<AdmUser> findByEmail(String email);

}
