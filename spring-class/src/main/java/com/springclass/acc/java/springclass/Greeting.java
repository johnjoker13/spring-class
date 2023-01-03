package com.springclass.acc.java.springclass;

public class Greeting {
	private final long _id;
	private final String _content;
	
	public Greeting(long id, String content) {
		this._id = id;
		this._content = content;
	}
	
	public long getId() {
		return _id;
	}
	
	public String getContent() {
		return _content;
	}
	
	
}
