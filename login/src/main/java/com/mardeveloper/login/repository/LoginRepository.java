package com.mardeveloper.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mardeveloper.login.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
	
	Login getByUsername(@Param("username") String username);

}
