package com.sam.demo.manager;

import static com.sam.demo.util.SleepUtility.sleep;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sam.demo.model.Book;

@Component
public class BookManager {

	private static List<Book> books = new ArrayList<>();
	static {
		books.add(new Book("Sam", "Sam-1"));
		books.add(new Book("Sam", "Sam-2"));

		books.add(new Book("Ajax", "Ajax-1"));

		books.add(new Book("Steve", "Steve-1"));

	}

	//@Cacheable("BookList")
	public List<Book> getByAuthor(String pAuthor) {
	
		List<Book> booksByAuthor = new ArrayList<>();
		for (Book b : books) {
			if (pAuthor.equalsIgnoreCase(b.getAuthor())) {
				booksByAuthor.add(b);
			}
		}
	
		sleep();

		return booksByAuthor;
	}
	
	@Async
	public void printMe(String author, List<Book> books)
	{
		sleep();
		System.out.println("Author : " + author + ", Books : " + books);
		
	}
	
	@Scheduled(fixedRate = 5000)
	public void fixedRate() {
		sleep();
		System.out.println("Fixed Rate @ " + new Date());
	}

	@Scheduled(fixedDelay = 5000)
	public void fixedDelay() {
		sleep();
		System.out.println("Fixed Delay @ " + new Date());
	}

}
