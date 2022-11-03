package org.delta.action;

import org.delta.person.Person;
import org.delta.person.PersonService;

import javax.inject.Inject;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CreatePersonAction implements Action {

    @Inject
    private PersonService personService;

    @Override
    public void processAction() {
        String id, firstName, lastName;
        // read id, firstName, lastName from user input
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.print("Enter id: ");
        id = scanner.nextLine();
        System.out.print("Enter first name: ");
        firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        lastName = scanner.nextLine();
        // create person
        Person person = new Person(id, firstName, lastName);
        // add person to person service
        personService.addPerson(person);
        System.out.println("Person created - " + person.getFullName() + " - " + person.getId());
    }
}

