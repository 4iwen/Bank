package org.delta.serialization;

import org.delta.person.Person;

public class PersonDeserializer {
    public Person deserialize(PersonJsonSerializationObject json) {
        return new Person(json.id, json.firstName, json.lastName);
    }
}
