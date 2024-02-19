package net.javaguides.springbootrestapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springbootrestapi.entity.Coders;

@RestController
@RequestMapping("/base")
public class DifferentMethodController {
	
	//GetMethod
	//http://localhost:8080/base/getcs
	
	@GetMapping("/getcs")
	public Coders getcoder()
	{
		return new Coders("shayam","UP");
	}
	
	//SpringBoot RestAPI for Post method
	//http://localhost:8080/base/create
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	
	public Coders createCoders(@RequestBody Coders cs)
	{
		System.out.println(cs.getName());
		System.out.println(cs.getAddress());
		return cs;
	}
	
	//SpringBoot RestAPI for Updating the existing resource
	//http://localhost:8080/base/aman/update
	
	@PutMapping("/{name}/update")
	public Coders upateCoders(@RequestBody Coders cs,@PathVariable("name") String nom )
	{	
		cs.setName(nom);
		return cs;
	}
	
	
	//Spring Boot Rest API that handles HTTP DELETE Request - Deleting the existing resource
	
	@DeleteMapping("/{name}/delete")
	public String deleteStudent(@PathVariable("name") String nom)
	{
		return "Student deleted successfully! ";
	}

}
