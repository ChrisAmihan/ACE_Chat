package com.acechat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acechat.model.Block;

@Repository
public interface BlockRepository extends JpaRepository<Block,Integer>{
	public <S extends Block> S save(S block);

	public void deleteByBlockusertableid(int blockusertableid);
}