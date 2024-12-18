package com.example.person.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.person.model.Person;
import com.example.person.repo.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	
	
	public List<Person> getAllPersons(){
		return personRepository.findAll();
	}
	
	public Person getPersonById(Long id) {
		return personRepository.getById(id);
	}
	
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}
	
	public void deletePerson(Long id) {
		personRepository.deleteById(id);
	}
	
	
}
