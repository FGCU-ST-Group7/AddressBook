import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

/**
 * AddressBook Tester.
 *
 * @author <Authors Allen Telson>
 * @version 1.0
 * @since <pre>Feb 8, 2020</pre>
 */
public class AddressBookTest {

  // Fields used to test AddressBook class
  private AddressBook underTest;

  private Person person1;
  private Person person2;


  @BeforeEach
  public void setUp() {

    underTest = new AddressBook();

    person1 = new Person("Johnny", "Appleseed", "555 AppleTree Road",
        "Bonita Springs", "FL", "33908", "(239) 999-9999");

    person2 = new Person("Johnny", "Appleseed", "555 AppleTree Road",
        "Bonita Springs", "FL", "33908", "(239) 999-9999");
  }

  @AfterEach
  public void teardown() {
    // set all fields to null after each test
    underTest = null;
    person1 = null;
    person2 = null;
  }

  @Test
  public void testGetPersons() {
    // add two people into the addressBook under test
    underTest.add(person1);
    underTest.add(person2);

    // check to see if the getPersons() function returns a list of persons
    Assert.assertEquals(underTest.getPersons(), new Person[]{person1, person2});
  }

  @Test
  void add() {
    // add person to addressBook
    underTest.add(person1);
    // check if object returned from AddressBook is person1 that was just added
    Assert.assertEquals(underTest.get(0), person1);
  }


  @Test
  void set() {
    // add two people in the addressBook
    underTest.add(person1);
    underTest.add(person2);
    // move person 2 to the first position
    underTest.set(0, person2);
    // check to make sure the first person in the list is person 2
    Assert.assertEquals(underTest.get(0), person2);
  }

  /**
   * Method: remove(int index)
   */
  @Test
  public void testRemove() {
    // initialize the persons arrayList
    List<Person> persons = new ArrayList<>();
    // Add testPerson2 into persons
    persons.add(person2);
    // remove the first contact within the addressBook
    underTest.add(person1);
    underTest.add(person2);

    underTest.remove(0);
    // Test to see if the persons array is the same as the addressBook in terms of
    // existing entries
    Assert.assertEquals(persons.toArray(), underTest.getPersons());
  }

  /**
   * Method: get(int index)
   */
  @Test
  public void testGet() {
    // add two people to the addressBook
    underTest.add(person1);
    underTest.add(person2);
    // Test to see if the addressBook returns testPerson1
    Assert.assertEquals(person2, underTest.get(1));
  }

  /**
   * Method: clear()
   */
  @Test
  public void testClear() {
    // add a person to the addressBook
    underTest.add(person1);
    // Clear the addressBook
    underTest.clear();
    // Clear the addressBook again to test clearing an already empty addressBook
    underTest.clear();
    // Test to see if the addressBook is indeed empty
    Assert.assertEquals(0, underTest.getPersons().length);
  }

  /**
   * Method: getRowCount()
   */
  @Test
  public void testGetRowCount() {
    // add two to the addressBook
    underTest.add(person1);
    underTest.add(person2);
    // Test to see if the addressBook returns the correct amount of entries
    Assert.assertEquals(2, underTest.getRowCount());
  }

  /**
   * Method: getColumnCount()
   */
  @Test
  public void testGetColumnCount() {
    // add a person to the addressBook
    underTest.add(person2);
    // Test to see if the addressBook returns the correct number of fields in a contact
    Assert.assertEquals(7, underTest.getColumnCount());
  }

  @Test
  void testGetValueAt() {
    // add a person to the addressBook
    underTest.add(person1);
    // test method to make sure proper String is returned
    Assert.assertEquals("FL", underTest.getValueAt(0, 4));
  }

  /**
   * Method: getColumnName(int column)
   */
  @Test
  public void testGetColumnName() {
    // add a person to the addressBook
    underTest.add(person1);
    // Test to see if the name of a field is returned for a specific field in the addressBook
    Assert.assertEquals("Address", underTest.getColumnName(2));
  }
}
