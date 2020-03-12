
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

/**
 * AddressBook Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Feb 8, 2020</pre>
 */
public class AddressBookTest {

  // Fields used to test AddressBook class
  private AddressBook addressBook;
  private List<Person> persons;
  private Person testPerson1;
  private Person testPerson2;

  @BeforeEach
  public void setUp() throws Exception {
    // Initialize all fields
    addressBook = new AddressBook();
    testPerson1 = new Person("Johnny", "Appleseed", "555 AppleTree Road",
        "Bonita Springs", "FL", "33908", "(239) 999-9999");

    testPerson2 = new Person("test2", "test2", "", "", "", "", "");

    // add people into the addressBook
    addressBook.add(testPerson1);
    addressBook.add(testPerson2);
  }

  @AfterEach
  public void after() throws Exception {
    // set all fields to null after each test
    testPerson1 = null;
    testPerson2 = null;
    persons = null;
    addressBook = null;
  }

  /**
   * Method: getPersons()
   */
  @Test
  public void testGetPersons() throws Exception {
//TODO: Test goes here...
    // Declare and initialize an array that holds two people
    Person[] people = new Person[]{testPerson1, testPerson2};
    // Test to see if the addressBook holds the same people as the people Array
    Assert.assertArrayEquals(addressBook.getPersons(), people);
  }

  /**
   * Method: add(Person p)
   */
  @Test
  public void testAdd() throws Exception {
//TODO: Test goes here...
    // Create a new person
    Person testPerson3 = new Person("test", "test", "", "", "", "", "");
    // add new person into the addressBook
    addressBook.add(testPerson3);
    // Test to see if the address book has the testPerson3 entry
    Assert.assertEquals(addressBook.get(2), testPerson3);
  }

  /**
   * Method: set(int index, Person person)
   */
  @Test
  public void testSet() throws Exception {
//TODO: Test goes here...
    // Set the first person on the addressBook as the second person in the addressBook
    addressBook.set(0, testPerson2);
    // Check to see if testPerson2 is the first person in the addressBook
    Assert.assertEquals(addressBook.get(0), testPerson2);
  }

  /**
   * Method: remove(int index)
   */
  @Test
  public void testRemove() throws Exception {
//TODO: Test goes here...
    // initialize the persons arrayList
    persons = new ArrayList<>();
    // Add testPerson2 into persons
    persons.add(testPerson2);
    // remove the first contact within the addressBook
    addressBook.remove(0);
    // Test to see if the persons array is the same as the addressBook in terms of
    // existing entries
    Assert.assertArrayEquals(persons.toArray(), addressBook.getPersons());
  }

  /**
   * Method: get(int index)
   */
  @Test
  public void testGet() throws Exception {
//TODO: Test goes here...
    // Test to see if the addressBook returns testPerson1
    Assert.assertEquals(testPerson1, addressBook.get(0));
  }

  /**
   * Method: clear()
   */
  @Test
  public void testClear() throws Exception {
//TODO: Test goes here...
    // Clear the addressBook
    addressBook.clear();
    // Clear the addressBook again to test clearing an already empty addressBook
    addressBook.clear();
    // Test to see if the addressBook is indeed empty
    Assert.assertEquals(0, addressBook.getPersons().length);
  }

  /**
   * Method: getRowCount()
   */
  @Test
  public void testGetRowCount() throws Exception {
//TODO: Test goes here...
    // Test to see if the addressBook returns the correct amount of entries
    Assert.assertEquals(2, addressBook.getRowCount());
  }

  /**
   * Method: getColumnCount()
   */
  @Test
  public void testGetColumnCount() throws Exception {
//TODO: Test goes here...
    // Test to see if the addressBook returns the correct number of fields in a contact
    Assert.assertEquals(7, addressBook.getColumnCount());
  }

  /**
   * Method: getValueAt(int row, int column)
   */
  @Test
  public void testGetValueAt() throws Exception {
//TODO: Test goes here...
    // Test to see if the value returned for a specific field in a person entry within an
    // addressBook is valid
    Assert.assertEquals("FL", addressBook.getValueAt(0, 4));
  }

  /**
   * Method: getColumnName(int column)
   */
  @Test
  public void testGetColumnName() throws Exception {
//TODO: Test goes here...
    // Test to see if the name of a field is returned for a specific field in the addressBook
    Assert.assertEquals("Address", addressBook.getColumnName(2));
  }
} 
