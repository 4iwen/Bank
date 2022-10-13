package org.delta.person;

import javax.inject.Singleton;

@Singleton
public class PersonFactory {

    public Person createPerson(String id, String name, String lastName) {
        return new Person(id, name, lastName);
    }

}
