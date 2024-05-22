package com.sapient.bookshowsmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sapient.bookshowsmgmt.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}