package se.dsek.service.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import se.dsek.service.user.entity.UserDto;
import se.dsek.service.user.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	private static Logger log = LoggerFactory.getLogger(UserController.class);

	@GetMapping("/users")
	public List<UserDto> getUsers() {
		return service.getUsers();
	}

	@GetMapping("/user/{id}")
	public UserDto getUser(@PathVariable(name = "id", required = true) Integer id) {
		UserDto user = service.getUser(id);
		if (user == null) {
			log.warn("Unkown user id {}", id);
		}
		return user;
	}

	@PostMapping("/user")
	public UserDto createUser(@RequestBody UserDto user) {
		UserDto newUser = service.createUser(user);
		log.info("New user created, id:{}", user.getId());
		return newUser;
	}

}
