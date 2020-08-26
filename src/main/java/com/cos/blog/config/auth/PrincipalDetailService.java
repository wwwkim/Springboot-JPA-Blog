package com.cos.blog.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@Service
public class PrincipalDetailService implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;
	
	@Override // Spring securityがlogin処理する際に　usernameがDBにあるか確認する。
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User principal=userRepository.findByUsername(username)
				.orElseThrow(()->{
					return new UsernameNotFoundException("Could not find"+username);
				});
		
		return new PrincipalDetail(principal); // Security SessionにUser情報登録される。
	}

}
