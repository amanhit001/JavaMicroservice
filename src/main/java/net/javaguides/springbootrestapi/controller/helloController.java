package net.javaguides.springbootrestapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springbootrestapi.entity.Coders;

@RestController
public class helloController {

	// Rest Api to say hello

	// http://localhost:8080/
	@GetMapping("/")
	public String sayHello() {
		return "Hello Aman ! Good to see you working hard :-) ";
	}

	/*
	 * Rest API to return Java bean " http://localhost:8080/coders "
	 */

	@GetMapping("/coders")
	public Coders getCoderDetails() {
		Coders c1 = new Coders("Aman Kumar", "Ranchi"

		);
		return c1;
	}

	/*
	 * Rest API that return List of Coders " http://localhost:8080/allCoders "
	 */
	
	@GetMapping("/allCoders")
	public List<Coders> getAllCoders() {
		List<Coders> lc = new ArrayList<>();

		lc.add(new Coders("Ram", "Ayodhya"));
		lc.add(new Coders("Shyam", "Mathura"));
		lc.add(new Coders("Mahadev", "Kashi"));
		return lc;
	}
	
	/*
	 * Rest API that takes Values from Path Variable "http://localhost:8080/shyam"
	 */
	
	  @GetMapping("/{name}") 
	  public Coders getCoderName(@PathVariable("name") String na) 
	  { Coders cn = new Coders(na,"Bharat"); return cn; }
	 
	
	/*
	 * @GetMapping("/{name}") 
	 * public Coders getCoderName(@PathVariable String name)
	 * { Coders cn = new Coders(name,"Bharat"); return cn; }
	 */
	  
	  /*
		 * Rest API that takes Values from multiple Path Variable "http://localhost:8080/Mohan/Ranchi"
		 */
	 
	 @GetMapping("/{name}/{add}")
	 public Coders getCoders(@PathVariable("name") String name ,
			 @PathVariable("add") String address)
	 {
		 Coders cn = new Coders(name,address);
		 return cn;
	 }
	 
	 //Spring Boot Rest API with Request Param
	 //http://localhost:8080/query?name=suman&address=Canada
	 
	 @GetMapping("/query")
	 public Coders codersRequestVariable(@RequestParam String name ,@RequestParam String address)
	 {
		 return new Coders(name,address);
	 }
	
}
