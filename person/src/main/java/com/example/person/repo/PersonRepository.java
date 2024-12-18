package com.example.person.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.person.model.Person;

public interface PersonRepository extends JpaRepository<Person,Long>{

}
