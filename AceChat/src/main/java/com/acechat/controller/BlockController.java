package com.acechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acechat.model.Block;
import com.acechat.service.BlockService;

@RestController("BlockController")
@RequestMapping("/block")
public class BlockController {
private BlockService blockService;
	
	@Autowired
	public BlockController(BlockService blockService) {
		this.blockService = blockService;	
	}
	
	@PostMapping(path ="/block",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void block(@RequestBody Block block) {
		this.blockService.block(block);
	}
	
	//TODO add way to unblock
	@PostMapping(path ="/unblock",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unblock(@RequestBody Block block) {
		this.blockService.unblock(block);
	}
}
