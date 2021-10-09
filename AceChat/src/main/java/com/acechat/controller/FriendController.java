package com.acechat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acechat.model.Friend;
import com.acechat.service.FriendService;

@RestController("FriendController")
@RequestMapping("/friend")
public class FriendController {

	private FriendService friendservice;
	
	@Autowired
	public FriendController(FriendService friendservice) {
		this.friendservice = friendservice;	
	}
	
	@PostMapping(path ="/request",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void request(@RequestBody Friend friend) {
		friend.setStatus("Pending");
		this.friendservice.request(friend);
	}
	
	@PostMapping(path ="/requestupdate",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void requestupdate(@RequestBody Friend friend) {
		this.friendservice.requestupdate(friend);
	}
	
	@PostMapping(path ="/deletefriend",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deletefriend(@RequestBody Friend friend) {
		this.friendservice.deletefriend(friend);
	}
	
	@GetMapping(path ="/getall",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Friend> getall(@RequestBody Friend friend) {
		return this.friendservice.getall(friend);
		
	}
	
}
