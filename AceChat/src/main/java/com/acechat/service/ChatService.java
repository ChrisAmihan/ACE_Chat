package com.acechat.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acechat.model.Chat;
import com.acechat.model.User;
import com.acechat.repository.ChatRepository;

@Transactional
@Service("ChatService")
public class ChatService {
	private ChatRepository chatRepository;

	@Autowired
	public ChatService(ChatRepository chatRepository) {
		this.chatRepository = chatRepository;
	}
	
	public List<Chat> getall(){
		List<Chat> chat = this.chatRepository.findAll();
		List<Chat> chat2 = null;
		Chat c = null;
		for(int i =0;i<chat.size();i++) {
			c.setGroupname(chat.get(i).getGroupname());
			chat2.add(c);
		}
		return chat2;
		
	}
	
	public void newchat(List<Chat> chat) {
		this.chatRepository.saveAll(chat);
	}
	
	public void deletechat(Chat chat) {
		this.chatRepository.deleteByChatid(chat.getChatid());
	}
	
	public void mutestatus(Chat chat) {
		this.chatRepository.setChatInfoById(chat.getStatus(), chat.getChatid());
	}
	
	public List<Chat> getallchats(User user){
		System.out.println(user);
		return this.chatRepository.findByUserid(user.getUserid());
	}
	
	public List<Chat> chatsearch(Chat chat){
		return this.chatRepository.findByGroupnameContainingAndUserid(chat.getGroupname(),chat.getUserid());
	}
}
