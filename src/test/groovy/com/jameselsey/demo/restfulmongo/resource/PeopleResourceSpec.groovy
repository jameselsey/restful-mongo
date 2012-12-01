package com.jameselsey.demo.restfulmongo.resource

import spock.lang.Specification

import com.jameselsey.demo.restfulmongo.domain.Person
import com.jameselsey.demo.restfulmongo.service.PersonService

@SuppressWarnings("GroovyPointlessArithmetic")
class PeopleResourceSpec extends Specification {

    PersonService service = Mock(PersonService)
    PeopleResource resource = new PeopleResource(service)

    def "it returns some People"(){

        given:
        def person1 = new Person("James", 26)
        def person2 = new Person("Meg", 20)
        def expected = [person1, person2]

        when:
        def result = resource.getAllPeople()

        then:
        1 * service.findPeople() >> expected
        result.size() == 2
        result[0].name == "James"
        result[0].age == 26
        result[1].name == "Meg"
        result[1].age == 20
    }

    def "it saves a person"(){
        given:
        Person p = new Person("Fred", 88)

        when:
        resource.savePerson(p.name, p.age.toString())

        then:
        1 * service.createPerson({it.name == p.name && it.age == p.age})
    }
}
