package com.jameselsey.demo.restfulmongo.service

import spock.lang.Specification
import com.jameselsey.demo.restfulmongo.domain.Person
import com.jameselsey.demo.restfulmongo.dao.PersonDao

@SuppressWarnings("GroovyPointlessArithmetic")
class PersonServiceImplSpec extends Specification {

    def personDao = Mock(PersonDao)
    def service = new PersonServiceImpl(personDao)

    def "it creates a user"(){
        given:
        Person thePerson = new Person('James', 26)

        when:
        service.createPerson(thePerson)

        then:
        1 * personDao.save({it.name == thePerson.name && it.age == thePerson.age})
    }

    def "it finds all users" (){
        given:
        def person1 = new Person("James", 26)
        def person2 = new Person("Meg", 20)
        def expected = [person1, person2]

        when:
        def result = service.findPeople()

        then:
        1 * personDao.findPeople() >> expected
        result.size() == 2
        result.any {it.name == person1.name && it.age == person1.age}
        result.any {it.name == person2.name && it.age == person2.age}
    }
}
