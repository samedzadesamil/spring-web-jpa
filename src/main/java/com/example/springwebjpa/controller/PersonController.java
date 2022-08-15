package com.example.springwebjpa.controller;


import com.example.springwebjpa.entity.Person;
import com.example.springwebjpa.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;


    @PostMapping("/addPerson")
    public Person addPerson(@RequestBody Person person){
        return personService.insertPerson(person);
    }

    @PostMapping("/addPersons")
    public List<Person> addPerson(@RequestBody List<Person> person){
        return personService.insertPersonList(person);
    }
    @GetMapping("/getPerson/{id}")
    public Person getPerson(@PathVariable int id ){
        return personService.getPersonById(id);
    }

    @GetMapping("/getPersonList")
    public List<Person> getPersonList(){
        return personService.getPersonList();
    }

    @DeleteMapping("/deletePerson{id}")
    public String deletePerson( @PathVariable int id){
        return personService.deletePerson(id);
    }

    @PutMapping("/updatePerson")
    public Person updatePerson(@RequestBody Person person){
    return personService.updatePerson(person);
    }







}
