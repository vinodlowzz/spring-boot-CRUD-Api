package com.shanil.ts;

import org.springframework.data.jpa.repository.JpaRepository;



public interface LoginRepository extends JpaRepository<User,Integer> {

	public User findByEmailId(String emailId);
	public User findByEmailIdAndPassword(String emailId, String password);
}