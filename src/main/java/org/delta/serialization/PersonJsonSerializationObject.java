package org.delta.serialization;

import org.delta.person.Person;

public class PersonJsonSerializationObject {

    public String firstName;
    public String lastName;
    public String id;

    public PersonJsonSerializationObject(Person owner) {
        this.firstName = owner.getFirstName();
        this.lastName = owner.getLastName();
        this.id = owner.getId();
    }
}
