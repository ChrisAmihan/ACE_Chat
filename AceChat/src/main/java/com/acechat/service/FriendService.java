package com.acechat.service;

import java.util.List;

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
		friend.setStatus("Pending");
		this.friendRepository.save(friend);
	}
	
	public void requestupdate(Friend friend) {
		friend.setStatus("Friends");
		this.friendRepository.setFriendInfoById("Friends",friend.getFriendtableid());
	}
	
	public void deletefriend(Friend friend) {
		this.friendRepository.deleteByFriendtableid(friend.getFriendtableid());
	}
	
	public List<Friend> getall(Friend friend){
		List<Friend> f= this.friendRepository.findByRequesteridOrRequesteeid(friend.getRequesterid(), friend.getRequesteeid());
		for(int i =0; i<f.size();i++) {
			f.get(i).getRequesterid().setPassword(null);
			f.get(i).getRequesterid().setUsername(null);
			f.get(i).getRequesteeid().setPassword(null);
			f.get(i).getRequesteeid().setUsername(null);
		}
		return f;
	}

}
