package com.acechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
	
	//TODO logout talk to alex
}
