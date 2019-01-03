package com.cognizant.iiht.boot.assignment.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.iiht.boot.assignment.dataObjects.Book;
import com.cognizant.iiht.boot.assignment.service.MainService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@CrossOrigin("*")
@org.springframework.web.bind.annotation.RestController
public class RestController {
	@Autowired
	private MainService ms = new MainService();
	
	GsonBuilder builder = new GsonBuilder(); 
	
	Gson gson = builder.create();
	
	@RequestMapping("/books")
	public String getBooks() {
        List<Book> blist = new ArrayList<>();
        blist = ms.getAllBooks();
        String jsobBookList = gson.toJson(blist);
        return jsobBookList;
	}

	@GET
	@RequestMapping(value = "/id")
	@Produces("application/json")
	public String getBookbyID(@RequestParam("id") int Id) {
		if(ms.searchBook(Id).isPresent()) {
			Book b = ms.searchBook(Id).get() ;
			String jsonBook = gson.toJson(b);
			System.out.println("getBookbyID"+jsonBook);
			return jsonBook;
		}else {
			return "no Book is present";
		}
    }
	
	@GET
	@RequestMapping(value="/name")
	@Produces("application/json")
	
	public String getBookbyName(@RequestParam("name") String name){
		
		if(ms.searchSubject(name).isPresent()) {
			Book b = ms.searchSubject(name).get() ;
			String jsonBook = gson.toJson(b);
			System.out.println("getBookbyName"+jsonBook);
			return jsonBook;
		}else {
			return "no Book is present";
		}
	}
	
  @POST	
  @RequestMapping(value="/addBook")
  @Consumes("application/json")
  @Produces("application/json")
  public String addBook(@RequestBody Book b) {
	  
	
	 
	 System.out.println("addBook");
	  return( ms.addBook(b));
  }
  
  @PUT
  @RequestMapping(value="/updateBook/id")
  @Consumes("application/json")
  @Produces("application/json")
  public String updateBook(@RequestParam("id") int Id, @RequestBody Book b ) {
	  System.out.println("updateBook");
	  return(ms.updateBook(Id,b));
  }
  
  @DELETE
  @RequestMapping(value="/deleteBook/id")
  @Consumes("application/json")
  @Produces("application/json")
  @CrossOrigin("*")
  public String deleteBook(@RequestParam("id") int Id) {
	  System.out.println("deleteBook");
	  return(ms.removeBook(Id));
  }
  
  
  
}
