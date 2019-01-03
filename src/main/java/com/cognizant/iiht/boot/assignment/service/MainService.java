package com.cognizant.iiht.boot.assignment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.cognizant.iiht.boot.assignment.dataObjects.Book;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component("mainService")
public class MainService {
	List<Book> BookList; 
GsonBuilder builder = new GsonBuilder(); 
	
	Gson gson = builder.create();
	public MainService() {
		 
		BookList = new ArrayList<Book>();
		for(int i=1; i<=10; i++) {
			Book b1 = new Book();
			b1.setAuthor("Auther"+i);
			b1.setName("Name"+i);
			b1.setSubject("Subject"+i);
			b1.setSubtitle("Subtitle"+i);
			b1.setDurationInHours(i*1000);
			b1.setId(i);
			BookList.add(b1);
		}
	}
	
	public String addBook(Book book) {
		if(book.getId()!= 0) {
			BookList.add(book);
			return ("this book has been added:"+gson.toJson(book));
		}else {
			return("the book entered is null");
		}
		
	}
	
	public String removeBook(int id) {
		
			  Optional<Book> b = searchByID(id);
		if(b.isPresent()) {
			BookList.remove(b.get());
			return ("this book has been deleted:"+gson.toJson(b.get()));
		}else {
			return("the book entered is not present.");
		}
	}
	
	public Optional<Book> searchSubject(String name) {
		 return  BookList.stream()
				         .filter(book->book.getName().equalsIgnoreCase(name))
                         .findFirst();
             
	}
	public Optional<Book> searchBook(int id){
		 return  searchByID(id);
	}
	
	public List<Book> getAllBooks(){
		return BookList;
	}

	public String updateBook(int id, Book newBook) {

        Optional<Book> b = searchByID(id);
		if(b.isPresent()) {
			   b.get().setId(id);
				b.get().setAuthor(newBook.getAuthor());
				b.get().setDurationInHours(newBook.getDurationInHours());
				b.get().setName(newBook.getName());
				return ("this book has been updated:"+gson.toJson(b.get()));
		} else {
			return("this Book with ["+id+"] is not present");
		}
     
        
	}
	
	private Optional<Book> searchByID(int id) {
		return BookList.stream()
        .filter(book->book.getId()==(id))
       .findFirst();
		
	}
}