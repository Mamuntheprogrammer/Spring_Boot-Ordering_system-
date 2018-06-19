package com.digital_order_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital_order_system.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByName1AndPassword(String name1, String password);
	User findByName1(String name1);
}
