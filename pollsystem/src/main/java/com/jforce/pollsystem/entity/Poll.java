package com.jforce.pollsystem.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Poll {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long pollid;
	
	String title;
	
	String description;
	
	List<String> option = new ArrayList<>();

	public Poll() {
		super();
		
		option.add("");
		option.add("");
		
	}

	public Poll(long pollid, String title, String description, List<String> option) {
		super();
		this.pollid = pollid;
		this.title = title;
		this.description = description;
		this.option = option;
	}

	public long getPollid() {
		return pollid;
	}

	public void setPollid(long pollid) {
		this.pollid = pollid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getOption() {
		return option;
	}

	public void setOption(List<String> option) {
		this.option = option;
	}
	
}
