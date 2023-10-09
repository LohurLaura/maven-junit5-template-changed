package org.example;

public class Person {
    String name;
    int age;
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void celebrateBirthday() {
        age++;
    }

    public void changeName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
