package com.globant.challange.peoplemanagement.data;

import com.globant.challange.peoplemanagement.model.Person;

public class LinkedPersonList implements PersonList{
  private PersonNode head;
  private int size;

  public LinkedPersonList() {
    this.head = null;
    this.size = 0;
  }

  public void add(Person person) {
    PersonNode newNode = new PersonNode(person);
    if (head == null) {
      head = newNode;
    } else {
      PersonNode current = head;
      while (current.getNext() != null) {
        current = current.getNext();
      }
      current.setNext(newNode);
    }
    size++;
  }

  public void remove(Person person) {
    if (head == null) {
      return;
    }
    if (head.getPerson().equals(person)) {
      head = head.getNext();
      size--;
      return;
    }
    PersonNode current = head;
    while (current.getNext() != null) {
      if (current.getNext().getPerson().equals(person)) {
        current.setNext(current.getNext().getNext());
        size--;
        return;
      }
      current = current.getNext();
    }
  }

  @Override
  public PersonIterator iterator() {
    return new PersonIterator(head);
  }
}