package com.acechat.test.service;

import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Mockito.times;

import com.acechat.model.Friend;
import com.acechat.model.User;
import com.acechat.repository.FriendRepository;
import com.acechat.service.FriendService;

@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest
@AutoConfigureMockMvc
public class TestFriendService {

	@InjectMocks
	private FriendService friendService;
	@Mock
	private FriendRepository friendRepository;
	@Autowired
	private MockMvc mockMvc;

	@BeforeAll
	public void setup() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(friendService).build();
	}
	
	@Test
	public void testRequest() {
		User u1 = new User( "user", "pass", "name", "pic", 1);
		User u2 = new User("user2", "pass2", "name", "pic", 2);
		Friend friend = new Friend(1,u2,u1,"");
		friend.setStatus("Pending");
		friendService.request(friend);
		
		Assertions.assertEquals("Pending", friend.getStatus());
		verify(friendRepository, times(1)).save(friend);
	}
	
	@Test
	public void testRequestUpdate() {
		User u1 = new User( "user", "pass", "name", "pic", 1);
		User u2 = new User("user2", "pass2", "name", "pic", 2);
		Friend friend = new Friend(1,u2,u1,"");
		
		friend.setStatus("Friends");
		friendService.requestupdate(friend);
		
		Assertions.assertEquals("Friends", friend.getStatus());
		verify(friendRepository, times(1)).setFriendInfoById("Friends", friend.getFriendtableid());
	}
	
	@Test
	public void testDeletefriend() {
		User u1 = new User( "user", "pass", "name", "pic", 1);
		User u2 = new User("user2", "pass2", "name", "pic", 2);
		Friend friend = new Friend(1,u2,u1,"");
		
		friendService.deletefriend(friend);
		
		verify(friendRepository, times(1)).deleteByFriendtableid(friend.getFriendtableid());
			
	}
	
}
