package com.globant.challange.peoplemanagement.data;


import com.globant.challange.peoplemanagement.model.Person;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PersonIterator implements Iterator<Person> {
  private PersonNode current;

  public PersonIterator(PersonNode head) {
    this.current = head;
  }

  @Override
  public boolean hasNext() {
    return current != null;
  }

  @Override
  public Person next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    Person person = current.getPerson();
    current = current.getNext();
    return person;
  }
}