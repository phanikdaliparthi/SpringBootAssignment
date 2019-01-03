package com.cognizant.iiht.boot.assignment.dataObjects;

import java.util.Set;

public class Book {
	String name;
	String Author;
	String subject;
	String subtitle;
	int durationInHours;
	int id;
	Set<Book> references;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public int getDurationInHours() {
		return durationInHours;
	}
	public void setDurationInHours(int durationInHours) {
		this.durationInHours = durationInHours;
	}
	public Set<Book> getReferences() {
		return references;
	}
	public void setReferences(Set<Book> references) {
		this.references = references;
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	
	@Override
	public boolean equals(Object obj) {
		
	  return obj.toString().equals(this.name);
	}
    @Override
    public int hashCode() {
    	return this.id;
    }
	
}
