package org.delta.person;

import javax.inject.Singleton;

@Singleton
public class PersonFactory {

    public Person createPerson(String name, String lastName) {
        return new Person(name, lastName);
    }

}
