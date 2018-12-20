package com.sam.demo.service;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Stopwatch;
import com.sam.demo.manager.BookManager;
import com.sam.demo.model.Book;
import static com.sam.demo.util.SleepUtility.sleep;

@RefreshScope
@RestController
public class BookController {
	
	@Autowired
	BookManager bookManager;

	@Value("${app-creator}")
	String app_creator;
	
	@RequestMapping(value="/{author}/book", method=RequestMethod.GET)
	public List<Book> getBookByAuthor(@PathVariable(value="author") String author)
	{
		Stopwatch timer = Stopwatch.createStarted();
		List<Book> books = bookManager.getByAuthor(author);
		bookManager.printMe(author, books);
		System.out.println("Method took: " + timer.stop());
		return books;
	}
	
	@RequestMapping(value="/info", method=RequestMethod.GET)
	public String getInfo()
	{
		//sleep();
		return "App By : " + app_creator;
	}
	
	
}
