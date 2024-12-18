package com.example.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.person.model.Person;
import com.example.person.service.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@GetMapping
	public List<Person> getAllPersons(){
		return personService.getAllPersons();
	}
	
	@GetMapping("/{id}")
	public Person getPersonById(@PathVariable Long id) {
		return personService.getPersonById(id);
	}
	
	@PostMapping
	public Person Person(@RequestBody Person person) {
		return personService.savePerson(person);
	}
	
	
	@PutMapping("/{id}")
	public Person updatePerson(@PathVariable Long id,@RequestBody Person person) {
		Person existingPerson=personService.getPersonById(id);
		if(existingPerson!=null) {
			existingPerson.setName(person.getName());
			existingPerson.setEmail(person.getEmail());
			existingPerson.setDepartment(person.getDepartment());
			return personService.savePerson(existingPerson);
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void deletePerson(@PathVariable Long id) {
		 personService.deletePerson(id);
	}
	
}
