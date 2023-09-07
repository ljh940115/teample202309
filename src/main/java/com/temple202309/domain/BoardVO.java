package com.temple202309.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardVO {

	private long bno;
	private String title;
	private String content;
	private String userid;
	private int visitcount;
	private Date regdate;
	private Date updatedate;
}
