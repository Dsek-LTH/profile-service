package se.dsek.service.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import se.dsek.service.user.entity.UserDto;

@Service
public class UserService {

	private ArrayList<UserDto> users;

	public UserService() {
		users = new ArrayList<>();
		mockData();
	}

	private void mockData() {
		{
			UserDto user = new UserDto();
			user.setFirstname("Lars");
			user.setLastname("Gustafson");
			user.setEmail("mezz@dsek.se");
			user.setId(4610);
			user.setStil("ada10lgu");
			users.add(user);
		}
		{
			UserDto user = new UserDto();
			user.setFirstname("Nils");
			user.setLastname("Ceberg");
			user.setEmail("nils@dsek.se");
			user.setId(6229);
			user.setStil("ni7228ce-s");
			users.add(user);
		}
	}

	public List<UserDto> getUsers() {
		return users;
	}

	public UserDto getUser(Integer id) {
		for (UserDto user : users) {
			if (user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}

}
