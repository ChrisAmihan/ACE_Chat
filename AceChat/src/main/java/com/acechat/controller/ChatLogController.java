package com.acechat.controller;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acechat.model.ChatLog;
import com.acechat.model.User;
import com.acechat.service.ChatLogService;

@RestController("ChatLogController")
@RequestMapping("/chatlog")
public class ChatLogController {
private ChatLogService chatlogservice;
	
	@Autowired
	public ChatLogController(ChatLogService chatlogservice) {
		this.chatlogservice = chatlogservice;	
	}
	
	
	@PostMapping(path="/newmessage", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void newmessage(@RequestBody ChatLog chatlog) {
		chatlog.setSenttime(Timestamp.from(Instant.now()));
		this.chatlogservice.newmessage(chatlog);
	}
	
	@GetMapping(path ="/getallchatlogs",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ChatLog> getallchatlogs(@RequestBody ChatLog chatlog) {
		return this.chatlogservice.getallchatlogs(chatlog);
	}
	//TODO notification
	@GetMapping(path ="/notification",produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean notification(@RequestBody ChatLog chatlog) {
		return this.chatlogservice.notification(chatlog);
	}
}
