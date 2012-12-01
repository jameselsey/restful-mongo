package com.jameselsey.demo.restfulmongo.resource;

import com.jameselsey.demo.restfulmongo.domain.Person;
import com.jameselsey.demo.restfulmongo.service.PersonService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static java.lang.String.format;

@Component
@Path("/people")
public class PeopleResource
{
    private final PersonService service;

    @Autowired
    public PeopleResource(PersonService service)
    {
        this.service = service;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPeople()
    {
        return service.findPeople();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public void savePerson(@FormParam("name") String name, @FormParam("age") String age)
    {

        System.out.println(format("Trying to save %s %s", name, age));
        Person thePerson = new Person(name, Integer.valueOf(age));
        service.createPerson(thePerson);
    }
}
