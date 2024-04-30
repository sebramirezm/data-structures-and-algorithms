package com.globant.challange.peoplemanagement.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
  private static int count = 0;
  private final int id;
  private final String name;

  public Person(String name) {
    this.id = ++count;
    this.name = name;
  }

}