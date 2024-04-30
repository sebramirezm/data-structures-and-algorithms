package com.globant.challange.peoplemanagement;

import com.globant.challange.peoplemanagement.data.PersonList;
import com.globant.challange.peoplemanagement.factory.PersonListFactory;
import com.globant.challange.peoplemanagement.model.Person;
import java.util.Scanner;

public class PersonManagementApplication {
  private static final Scanner scanner = new Scanner(System.in);
  private static PersonList personList;

  public static void main(String[] args) {
    System.out.print("Enter the number of people to manage: ");
    int numPeople = scanner.nextInt();
    scanner.nextLine();

    personList = PersonListFactory.createPersonList(numPeople);

    while (true) {
      System.out.println("\nPerson Management Application");
      System.out.println("1. Add Person");
      System.out.println("2. Remove Person");
      System.out.println("3. List People");
      System.out.println("4. Exit");
      System.out.print("Enter your choice: ");

      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1:
          addPerson();
          break;
        case 2:
          removePerson();
          break;
        case 3:
          listPeople();
          break;
        case 4:
          System.out.println("Exiting application...");
          return;
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    }
  }

  private static void addPerson() {
    System.out.print("Enter the name of the person: ");
    String name = scanner.nextLine();
    Person person = new Person(name);
    personList.add(person);
    System.out.println("Person added with ID: " + person.getId());
  }

  private static void removePerson() {
    System.out.print("Enter the ID of the person to remove: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    boolean found = false;
    for (Person person : personList) {
      if (person.getId() == id) {
        personList.remove(person);
        System.out.println("Person with ID " + id + " removed.");
        found = true;
        break;
      }
    }

    if (!found) {
      System.out.println("Person with ID " + id + " not found.");
    }
  }

  private static void listPeople() {
    System.out.println("List of people:");
    for (Person person : personList) {
      System.out.println("ID: " + person.getId() + ", Name: " + person.getName());
    }
  }
}
