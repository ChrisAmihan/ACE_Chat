package com.acechat.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="chatlogtable")
public class ChatLog {

	@Id
	@Column
	private int chatlogid;
	@Column
	private int userid;
	@Column
	private String message;
	@Column
	private Timestamp senttime;
	@Column
	private int chatid;
}
