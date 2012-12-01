package com.jameselsey.demo.restfulmongo.domain;

import static java.lang.String.format;

public class Person
{
    private final String name;
    private final int age;

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString()
    {
        return format("%s %d", name, age);
    }
}
