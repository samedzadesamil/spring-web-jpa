package com.example.springwebjpa.service;


import com.example.springwebjpa.entity.Person;
import com.example.springwebjpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public Person insertPerson(Person person){
        return personRepository.save(person);
    }

    public List<Person> insertPersonList(List<Person> list){
        return personRepository.saveAll(list);
    }
    public Person updatePerson(Person person){
        Person exsistPerson=personRepository.findById(person.getId()).orElse(null);
        exsistPerson.setName(person.getName());
        exsistPerson.setSurname(person.getSurname());
        return personRepository.save(exsistPerson);
        
    }

    public List<Person> getPersonList(){
        return personRepository.findAll();
    }

    public Person getPersonById(int id){
        return personRepository.findById(id).orElse(null);
    }
    public String deletePerson(int id){
         personRepository.deleteById(id);
         return "deleted person id: "+id;
    }



}
