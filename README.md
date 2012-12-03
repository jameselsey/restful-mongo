restful-mongo
=============

An example Java web app with RESTful services provided by jersey and spring, along with mongoDB datastore

Prerequisites:
* Gradle http://www.gradle.org/ (tested on 1.0)
* Mongo http://www.mongodb.org/ (tested on 2.2.0)
* Git (obviously...)

Setup:
* Checkout code using `git clone https://github.com/jameselsey/restful-mongo.git`
* Start mongo DB by running `mongod`
* Run `gradle cleanIdea idea` (this will create the IntelliJ project file)
* Run `gradle clean build jettyRunWar` (this will build and test the project, then start it in an embedded Jetty instance)


Using the app
=============

## Create Person
POST `http://localhost:8080/RestfulMongo/people`

params:
* name: James
* age: 26

## List People
GET `http://localhost:8080/RestfulMongo/people`
Sample response:
```
[
  {
    "name": "James",
    "age": 26
  },
  {
    "name": "Meg",
    "age": 20
  }
]
```