package com.acechat.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acechat.model.Friend;
import com.acechat.repository.FriendRepository;

@Transactional
@Service("FriendService")
public class FriendService {
	private FriendRepository friendRepository;
	
	@Autowired
	public FriendService(FriendRepository friendRepository) {
		this.friendRepository = friendRepository;
	}
	
	
	public void request(Friend friend) {
		this.friendRepository.save(friend);
	}
	
	
	public void requestupdate(Friend friend) {
		this.friendRepository.setFriendInfoById("Friends",friend.getFriendtableid());
	}
}
