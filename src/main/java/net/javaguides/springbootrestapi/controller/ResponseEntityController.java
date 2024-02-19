package net.javaguides.springbootrestapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springbootrestapi.entity.Coders;

@RestController
@RequestMapping("/response")
public class ResponseEntityController {
	
	//http://localhost:8080/response/getData
	@GetMapping("/getData")
	public ResponseEntity<Coders> getCoder()
	{
		return new ResponseEntity<>(new Coders("aman","Ranchi"),HttpStatus.OK);
	}
	
	//	http://localhost8080/response/feedData
	@PostMapping("/feedData")
	public ResponseEntity<Coders> createCoders(@RequestBody Coders cs)
	{
		return ResponseEntity.ok().header("Custom Header", "Aman").body(cs);
	}
	
	// http://localhost:8080/response/Swaraj/update
	
	@PutMapping("/{nom}/update")
	public ResponseEntity<Coders> updateData(@RequestBody Coders cs,@PathVariable("nom") String name)
	{
		cs.setName(name);
		return ResponseEntity.ok(cs);
	}

}
