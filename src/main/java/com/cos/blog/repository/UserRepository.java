package com.cos.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.blog.model.User;
//DAO
//bean自動登録　
//@Repository省略可能
public interface UserRepository extends JpaRepository<User, Integer>{
	
	

}
