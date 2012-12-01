package com.jameselsey.demo.restfulmongo.dao;

import com.jameselsey.demo.restfulmongo.domain.Person;

import java.util.List;

public interface PersonDao
{
    public void save(Person thePerson);

    public List<Person> findPeople();
}
