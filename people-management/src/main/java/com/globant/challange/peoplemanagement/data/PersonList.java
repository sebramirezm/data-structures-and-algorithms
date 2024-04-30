package com.globant.challange.peoplemanagement.data;

import com.globant.challange.peoplemanagement.model.Person;

public interface PersonList extends Iterable<Person> {
  void add(Person person);
  void remove(Person person);
}
