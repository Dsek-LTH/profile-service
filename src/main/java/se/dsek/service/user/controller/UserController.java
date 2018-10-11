package se.dsek.service.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import se.dsek.service.user.entity.UserDto;
import se.dsek.service.user.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService service;

	@GetMapping("/users")
	public List<UserDto> getUsers() {
		return service.getUsers();
	}

	@GetMapping("/user/{id}")
	public UserDto getUser(@PathVariable(name = "id", required = true) Integer id) {
		return service.getUser(id);
	}

}
