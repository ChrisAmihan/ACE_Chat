package com.acechat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.acechat.model.Friend;

public interface FriendRepository extends JpaRepository<Friend, Integer>{
	public <S extends Friend> S save(S friend);
	
	
	
	
	
	@Modifying
	@Query("update Friend f set f.status = ?1 where f.friendtableid =?2")
	void setFriendInfoById(String status, int friendtableid);
}
