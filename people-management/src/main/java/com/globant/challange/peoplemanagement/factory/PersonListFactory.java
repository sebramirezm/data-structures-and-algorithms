package com.globant.challange.peoplemanagement.factory;

import com.globant.challange.peoplemanagement.data.CompositePersonList;
import com.globant.challange.peoplemanagement.data.LinkedPersonList;
import com.globant.challange.peoplemanagement.data.PersonList;

public class PersonListFactory {
  private static final int THRESHOLD = 10;

  public static PersonList createPersonList(int size) {
    if (size < THRESHOLD) {
      return new LinkedPersonList();
    } else {
      return new CompositePersonList();
    }
  }
}
