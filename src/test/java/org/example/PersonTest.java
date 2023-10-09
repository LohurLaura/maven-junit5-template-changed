package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class PersonTest {
@Test public void testChangeAgeSuccessful(){
    Person person = new Person("Bob", 25);
    person.changeName("Mart");
    assertEquals("Mart", person.getName());

}
@Test public void testCelebrateBirthday(){

    Person person = new Person("Charlie", 35);
    person.celebrateBirthday();
    assertEquals(person.getAge(), 36);
}
}
