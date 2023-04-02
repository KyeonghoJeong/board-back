package com.jeong.board.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Table(name = "tpinfo")
@Entity
public class BoardEntity {

	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "board_seq")
	@SequenceGenerator(name = "board_seq", sequenceName = "tpinfo_seq", allocationSize = 1)
	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "WRITER")
	private String writer;
	
	@Column(name = "CONTENT")
	private String content;
	
}