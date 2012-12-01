package com.jameselsey.demo.restfulmongo.service;

import com.jameselsey.demo.restfulmongo.dao.PersonDao;
import com.jameselsey.demo.restfulmongo.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonServiceImpl implements PersonService
{
    private final PersonDao personDao;

    @Autowired
    public PersonServiceImpl(PersonDao personDao)
    {
        this.personDao = personDao;
    }

    @Override
    public void createPerson(Person person)
    {
        personDao.save(person);
    }

    @Override
    public List<Person> findPeople()
    {
        return personDao.findPeople();
    }
}
