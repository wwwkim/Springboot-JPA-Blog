package com.cos.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cos.blog.model.User;
//DAO
//bean自動登録　
//@Repository省略可能
public interface UserRepository extends JpaRepository<User, Integer>{


}

// JPA Naming query
// SELECT * FROM user WHERE username=?AND password=?;
// User findByUsernameAndPassword(String username,String password);

//	@Query(value="SELECT * FROM user WHERE username=?AND password=? ",nativeQuery=true)
//	User login(String username,String password);