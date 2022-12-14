package com.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	boolean existByMail();
}
