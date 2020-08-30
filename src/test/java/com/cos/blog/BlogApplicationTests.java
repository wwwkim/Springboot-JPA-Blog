package com.cos.blog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class BlogApplicationTests {

	@Test
	public void hashPassword() {
		String encPassword=new BCryptPasswordEncoder().encode("aaaa");
		System.out.println("aaaa hash:"+encPassword);
	}

}
 