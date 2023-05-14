package com.leisson.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leisson.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User maria = new User("1", "maria", "maria@com");
		User maria1 = new User("2", "maria2", "maria@com");
		User maria2 = new User("3", "maria3", "maria@com");
		List<User> list = new ArrayList<>();
				list.addAll(Arrays.asList(maria, maria1, maria2));
	return ResponseEntity.ok().body(list);
	}

}
