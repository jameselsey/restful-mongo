package com.jameselsey.demo.restfulmongo.dao;

import com.jameselsey.demo.restfulmongo.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonDaoImpl implements PersonDao
{
    private final MongoTemplate template;

    @Autowired
    public PersonDaoImpl(MongoTemplate template)
    {
        this.template = template;
    }

    @Override
    public void save(Person thePerson)
    {
        template.insert(thePerson);
    }

    @Override
    public List<Person> findPeople()
    {
        return template.findAll(Person.class);
    }
}
