package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Transactional
	public void join(User user) {

		String rawPassword = user.getPassword();

		String encPassword = encoder.encode(rawPassword);

		user.setPassword(encPassword);
		user.setRole(RoleType.USER);

		userRepository.save(user);

	}

	@Transactional
	public void userUpdate(User user) {
		User persistance= userRepository.findById(user.getId()).orElseThrow(()->{
			return new IllegalArgumentException("Failed find user");
		});
		String rawPassward=user.getPassword();
		String encPassword=encoder.encode(rawPassward);
		persistance.setPassword(encPassword);
		persistance.setEmail(user.getEmail());
		
			

	}

}
