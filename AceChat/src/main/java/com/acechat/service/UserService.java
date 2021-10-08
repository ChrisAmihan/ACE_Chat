package com.acechat.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acechat.model.User;
import com.acechat.repository.UserRepository;

@Transactional
@Service("UserService")
public class UserService {
	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void save(User user) {
		this.userRepository.save(user);
	}
	
	public User findByUsernameAndPassword(User user) {
		return this.userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
	}
	
	public void merge(User user) {
		System.out.println(user.getUserid());
		this.userRepository.setUserInfoById(user.getName(),user.getPassword(),user.getProfilepic(),user.getUserid());;
	}
}