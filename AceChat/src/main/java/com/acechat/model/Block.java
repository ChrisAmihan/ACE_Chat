package com.acechat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="blockusertable")
public class Block {

	@Id
	@Column
	@GeneratedValue
	private int blockusertableid;
	@Column
	private int blockerid;
	@Column
	private int blockeeid;
	
}
