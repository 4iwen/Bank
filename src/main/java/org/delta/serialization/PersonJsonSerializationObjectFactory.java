package org.delta.serialization;

import org.delta.person.Person;

import javax.inject.Singleton;

@Singleton
public class PersonJsonSerializationObjectFactory {
    public PersonJsonSerializationObject create(Person person) {
        PersonJsonSerializationObject personJsonSerializationObject = new PersonJsonSerializationObject(person);
        personJsonSerializationObject.firstName = person.getFirstName();
        personJsonSerializationObject.lastName = person.getLastName();
        return personJsonSerializationObject;
    }
}
