package com.globant.challange.peoplemanagement.data;

import com.globant.challange.peoplemanagement.model.Person;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CompositePersonList implements PersonList {
  private final List<Person> people;
  private final List<CompositePersonList> children;

  public CompositePersonList() {
    this.people = new ArrayList<>();
    this.children = new ArrayList<>();
  }

  public void add(Person person) {
    people.add(person);
  }

  public void remove(Person person) {
    people.remove(person);
  }

  public int size() {
    int totalSize = people.size();
    for (CompositePersonList child : children) {
      totalSize += child.size();
    }
    return totalSize;
  }

  @Override
  public Iterator<Person> iterator() {
    return new PersonIterator(people, children);
  }

  private static class PersonIterator implements Iterator<Person> {
    private final Iterator<Person> peopleIterator;
    private final Iterator<CompositePersonList> childrenIterator;
    private Iterator<Person> currentChildIterator;

    public PersonIterator(List<Person> people, List<CompositePersonList> children) {
      this.peopleIterator = people.iterator();
      this.childrenIterator = children.iterator();
      this.currentChildIterator = null;
    }

    @Override
    public boolean hasNext() {
      if (peopleIterator.hasNext()) {
        return true;
      }
      if (currentChildIterator != null && currentChildIterator.hasNext()) {
        return true;
      }
      while (childrenIterator.hasNext()) {
        currentChildIterator = childrenIterator.next().iterator();
        if (currentChildIterator.hasNext()) {
          return true;
        }
      }
      return false;
    }

    @Override
    public Person next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      if (peopleIterator.hasNext()) {
        return peopleIterator.next();
      }
      if (currentChildIterator != null && currentChildIterator.hasNext()) {
        return currentChildIterator.next();
      }
      throw new IllegalStateException("No more elements");
    }
  }
}