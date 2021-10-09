package com.acechat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acechat.model.User;
import com.acechat.service.UserService;

@RestController("userController")
@RequestMapping("/user")
public class UserController {
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;	
	}
	
	
	@PostMapping(path ="/newaccount",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void newuser(@RequestBody User user) {
		this.userService.save(user);
	}
	
	@PostMapping(path="/login",consumes=MediaType.APPLICATION_JSON_VALUE)
	public int login(@RequestBody User user) {
		user=this.userService.findByUsernameAndPassword(user);
		return user.getUserid();
	}
	
	@PostMapping(path="/updateaccount",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void updateaccount(@RequestBody User user) {
		this.userService.merge(user);
	}
	
	@GetMapping(path ="/searchusers",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> searchusers(@RequestBody User user) {
		return this.userService.searchusers(user);
	}
	
	@GetMapping(path ="/getall",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getall() {
		return this.userService.getall();
	}
	
	@GetMapping(path ="/getone",produces = MediaType.APPLICATION_JSON_VALUE)
	public User getone(@RequestBody User user) {
		return this.userService.getone(user);
	}
}
