package com.example.demo.Repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Person;


public interface PersonRepository extends JpaRepository<Person, Integer> {

}
