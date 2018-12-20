package com.sam.demo.model;

public class Book {

	private String author;
	private String name;

	public Book(String pAuthor, String pName) {
		super();
		author = pAuthor;
		name = pName;
	}

	@Override
	public String toString() {
		return "Book [author=" + author + ", name=" + name + "]";
	}


	public String getName() {
		return name;
	}

	public void setName(String pName) {
		name = pName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String pAuthor) {
		author = pAuthor;
	}

}
