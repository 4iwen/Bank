package org.delta.person;

import org.delta.serialization.PersonJsonSerializationObject;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

public class PersonService {

    private final Map<String, Person> persons = new HashMap<>();
    @Inject
    private PersonService personFactory;

    public Person createPerson(String id, String firstName, String lastName) {
        Person person = new Person(id, firstName, lastName);
        this.persons.put(person.getFirstName(), person);
        return person;
    }

    public Person createPerson(PersonJsonSerializationObject personJsonSerializationObject) {
        Person person = this.personFactory.createPerson(personJsonSerializationObject);
        this.persons.put(person.getFirstName(), person);
        return person;
    }

    public Person[] getPersons() {
        return persons.values().toArray(new Person[0]);
    }

    public Person findPersonById(String id) {
        return persons.get(id);
    }
}
