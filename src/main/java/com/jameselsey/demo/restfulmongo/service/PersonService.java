package com.jameselsey.demo.restfulmongo.service;

import com.jameselsey.demo.restfulmongo.domain.Person;

import java.util.List;

public interface PersonService
{
    public void createPerson(Person person);

    public List<Person> findPeople();
}
