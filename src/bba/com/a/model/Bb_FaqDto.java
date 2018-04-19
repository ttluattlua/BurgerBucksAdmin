package bba.com.a.model;

import java.io.Serializable;

public class Bb_FaqDto implements Serializable {
	
/*	DROP TABLE BB_FAQ
	CASCADE CONSTRAINT;

	DROP SEQUENCE BB_FAQ_SEQ;

	
	CREATE TABLE BB_FAQ(
		SEQ NUMBER(10) PRIMARY KEY,
		TITLE VARCHAR2(200) NOT NULL,
		CONTENTS VARCHAR2(300) NOT NULL,
	    CATEGORIES NUMBER(5) NOT NULL,
		READCOUNT NUMBER(10) NOT NULL,
		STEP NUMBER(10) NOT NULL,
		GROUPS NUMBER(10) NOT NULL,
	    STATUS NUMBER(1) NOT NULL,
	    REGDATE DATE,
		DEL NUMBER(1) NOT NULL
	)
	CREATE SEQUENCE BB_FAQ_SEQ
	START WITH 1
	INCREMENT BY 1;
	 */
	
	private int seq;		//시퀀스
	private String title;	//제목
	private String contents;	//내용
	private int categories;		//카테고리
	private int readcount;		//조회수
	private int step;			//열(답변일경우 1)
	private int groups;			//그룹(답변일경우 리더(?)글의 seq/아닌경우 0
	private int status;			//답변이 달렸는지 아닌지
	private String regdate;		//등록 날짜
	private int del;			//삭제여부 
	
	public Bb_FaqDto() {}

	public Bb_FaqDto(int seq, String title, String contents, int categories, int readcount, int step, int groups,
			int status, String regdate, int del) {
		super();
		this.seq = seq;
		this.title = title;
		this.contents = contents;
		this.categories = categories;
		this.readcount = readcount;
		this.step = step;
		this.groups = groups;
		this.status = status;
		this.regdate = regdate;
		this.del = del;
	}
	
	

	public Bb_FaqDto(String title, String contents, int categories) {
		super();
		this.title = title;
		this.contents = contents;
		this.categories = categories;
	}
	
	public Bb_FaqDto(int seq, String title, String contents, int categories, int step, int groups) {
		super();
		this.seq = seq;
		this.title = title;
		this.contents = contents;
		this.categories = categories;
		this.step = step;
		this.groups = groups;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getCategories() {
		return categories;
	}

	public void setCategories(int categories) {
		this.categories = categories;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getGroups() {
		return groups;
	}

	public void setGroups(int groups) {
		this.groups = groups;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}


	@Override
	public String toString() {
		return "{\"seq\":" + seq + ", \"title\":\"" + title + "\", \"contents\":\"" + contents + "\", \"categories\":"
				+ categories + ", \"readcount\":" + readcount + ", \"step\":" + step + ", \"groups\":"
				+ groups + ", \"status\":" + status + ", \"regdate\":\"" + regdate + "\", \"del\":" + del + " }";
	}
	
	
}
