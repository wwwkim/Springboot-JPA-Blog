package com.cos.blog.test;

import java.util.List;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;


@RestController // Data return
public class DummyControllerTest {
	@Autowired // DI
	private UserRepository userRepository;
	
	@DeleteMapping("/dummy/user/{id}")
	public String delete(@PathVariable int id) {
		try {
			userRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return " Deleted successfully id:"+id;
		
	}

	@Transactional//Dirty checking : update without using save() 
	@PutMapping("/dummy/user/{id}")// email,password update
	public User updateUser(@PathVariable int id, @RequestBody User requestUser) {

		User user = userRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("Update fail");
		});
		user.setPassword(requestUser.getPassword());
		user.setEmail(requestUser.getEmail());
		
		
		//userRepository.save(user);

		return user;

	}

	@GetMapping("/dummy/users")
	public List<User> list() {
		return userRepository.findAll();
	}

	// 2 item on 1 page
	@GetMapping("/dummy/user")
	public List<User> pageList(
			@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
		Page<User> pagingUser = userRepository.findAll(pageable);

//		if(pagingUser.isLast()) {
//			
//		}
		List<User> users = pagingUser.getContent();
		return users;

	}

	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
//		lamda
//		User user= userRepository.findById(id).orElseThrow(()->{
//			return new IllegalArgumentException("id:"+id+" does not exist");
//		}

		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				return new IllegalArgumentException("id:" + id + " does not exist");
			}
		});

		return user;// MassageConver call Jackson to chage from java object to json
	}

	@PostMapping("/dummy/join")
	public String join(User user) {
		user.setRole(RoleType.USER);
		userRepository.save(user);

		return "success join";
	}

}
