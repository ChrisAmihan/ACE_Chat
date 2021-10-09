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
@Table(name="friendtable")
public class Friend {
	
	@Id
	@Column
	@GeneratedValue
	private int friendtableid;
	@Column
	private int requesterid;
	@Column
	private int requesteeid;
	@Column
	private String status;
	
	

}
