package com.jameselsey.demo.restfulmongo.dao

import spock.lang.Specification
import org.springframework.data.mongodb.core.MongoTemplate

import com.mongodb.DBCollection

import com.jameselsey.demo.restfulmongo.domain.Person

@SuppressWarnings("GroovyPointlessArithmetic")
class PersonDaoImplSpec extends Specification {

    MongoTemplate mongoTemplate = Mock(MongoTemplate)
    DBCollection dbCollection = Mock(DBCollection)

    PersonDao dao

    def collectionName = "person"

    def setup() {
        mongoTemplate.getCollection(collectionName) >> dbCollection
        mongoTemplate.getCollectionName(Person.class) >> collectionName
        dao = new PersonDaoImpl(mongoTemplate)
    }

    def "it finds some people"(){
        given:
        def person1 = new Person("James", 26)
        def person2 = new Person("Meg", 20)
        def expected = [person1, person2]

        when:
        def result = dao.findPeople()

        then:
        1 * mongoTemplate.findAll(Person.class) >> expected
        result.size() == 2
        result.any {it.name == person1.name && it.age == person1.age}
        result.any {it.name == person2.name && it.age == person2.age}
    }

    def "it saves a new Person"(){

        given:
        Person person = new Person("Johnny", 69)

        when:
        dao.save(person)

        then:
        1 * mongoTemplate.insert(person)
    }
}
