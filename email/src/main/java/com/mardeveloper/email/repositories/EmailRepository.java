package com.mardeveloper.email.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mardeveloper.email.enitities.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email,Long> {
}

