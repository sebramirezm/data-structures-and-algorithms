package com.globant.challange.peoplemanagement.data;


import com.globant.challange.peoplemanagement.model.Person;
import lombok.Getter;

@Getter
public class PersonNode {
  private Person person;
  private PersonNode next;

  public PersonNode(Person person) {
    this.person = person;
    this.next = null;
  }

  public void setNext(PersonNode next) {
    this.next = next;
  }
}