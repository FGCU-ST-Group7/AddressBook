import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.EventListenerList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testng.Assert;

/**
 * AddressBook Tester.
 *
 * @author <Authors Allen Telson>
 * @version 1.0
 * @since <pre>Feb 8, 2020</pre>
 *
 * This testing class uses a Person stub when testing
 */
@ExtendWith(MockitoExtension.class)
public class AddressBookTest {

  // Fields used to test AddressBook class
  @InjectMocks
  private AddressBook testAddressBook;

  private List<Person> persons;
  @Mock
  private Person mockPerson1;
  @Mock
  private Person mockPerson2;
  @Mock
  private EventListenerList listenerList;


  @BeforeEach
  public void setUp() throws Exception {
    // Initialize all fields

//        mockPerson1 = new Person("Johnny", "Appleseed", "555 AppleTree Road",
////        "Bonita Springs", "FL", "33908", "(239) 999-9999");
//
//    mockPerson2 = new Person("test2", "test2", "", "", "", "", "");

    testAddressBook = new AddressBook();
    mockPerson1 = mock(Person.class);
    mockPerson2 = mock(Person.class);
    // add people into the addressBook

  }

  @AfterEach
  public void teardown() throws Exception {
    // set all fields to null after each test
    mockPerson1 = null;
    mockPerson2 = null;
    testAddressBook = null;
  }

  /**
   * Method: getPersons()
   * Uses
   */
  @Test
  public void testGetPersons() {
//TODO: Test goes here...
    // add two mocks to the addressBook
    testAddressBook.add(mockPerson1);
    testAddressBook.add(mockPerson2);
    // Declare and initialize an array that holds two people
    Person[] people = new Person[]{mockPerson1, mockPerson2};
    // Test to see if the addressBook holds the same people as the people Array
    Assert.assertEquals(testAddressBook.getPersons(), people);
  }

  /**
   * Method: add(Person p)
   */
  @Test
  public void testAdd() {
//TODO: Test goes here...
    // add a person to addressBook
    testAddressBook.add(mockPerson1);
    // Test to see if the address book has the testPerson1 entry
    Assert.assertEquals(mockPerson1, testAddressBook.get(0));
  }

  /**
   * Method: set(int index, Person person)
   */
  @Test
  public void testSet() {
//TODO: Test goes here...
    testAddressBook.add(mockPerson1);
    testAddressBook.add(mockPerson2);
    // Set the first person on the addressBook as the second person in the addressBook
    testAddressBook.set(0, mockPerson2);
    // Check to see if testPerson2 is the first person in the addressBook
    Assert.assertEquals(testAddressBook.get(0), mockPerson2);

  }

  /**
   * Method: remove(int index)
   */
  @Test
  public void testRemove() {
//TODO: Test goes here...
    // initialize the persons arrayList
    persons = new ArrayList<>();
    // Add testPerson2 into persons
    persons.add(mockPerson2);
    // remove the first contact within the addressBook
    testAddressBook.add(mockPerson1);
    testAddressBook.add(mockPerson2);

    testAddressBook.remove(0);
    // Test to see if the persons array is the same as the addressBook in terms of
    // existing entries
    Assert.assertEquals(persons.toArray(), testAddressBook.getPersons());
  }

  /**
   * Method: get(int index)
   */
  @Test
  public void testGet() {
//TODO: Test goes here...
    testAddressBook.add(mockPerson1);
    testAddressBook.add(mockPerson2);
    // Test to see if the addressBook returns testPerson1
    Assert.assertEquals(mockPerson2, testAddressBook.get(1));
  }

  /**
   * Method: clear()
   */
  @Test
  public void testClear() {
//TODO: Test goes here...
    testAddressBook.add(mockPerson1);
    // Clear the addressBook
    testAddressBook.clear();
    // Clear the addressBook again to test clearing an already empty addressBook
    testAddressBook.clear();
    // Test to see if the addressBook is indeed empty
    Assert.assertEquals(0, testAddressBook.getPersons().length);
  }

  /**
   * Method: getRowCount()
   */
  @Test
  public void testGetRowCount() {
//TODO: Test goes here...
    testAddressBook.add(mockPerson1);
    testAddressBook.add(mockPerson2);
    // Test to see if the addressBook returns the correct amount of entries
    Assert.assertEquals(2, testAddressBook.getRowCount());
  }

  /**
   * Method: getColumnCount()
   */
  @Test
  public void testGetColumnCount() {
//TODO: Test goes here...
    testAddressBook.add(mockPerson2);
    // Test to see if the addressBook returns the correct number of fields in a contact
    Assert.assertEquals(7, testAddressBook.getColumnCount());
  }

  /**
   * Method: getValueAt(int row, int column)
   */
  @Test
  public void testGetValueAt() {
//TODO: Test goes here...
    testAddressBook.add(mockPerson1);
    // when the getField functions with 4 being passed in as an argument is called, return the
    // String "test"
    when(mockPerson1.getField(4)).thenReturn("test");
    // Test to see if the value returned for a specific field in a person entry within an
    // addressBook is valid
    Assert.assertEquals("test",testAddressBook.getValueAt(0, 4));
    // verify that the getField function was called at least once.
    verify(mockPerson1, atLeastOnce()).getField(4);
  }

  /**
   * Method: getColumnName(int column)
   */
  @Test
  public void testGetColumnName() {
//TODO: Test goes here...
    testAddressBook.add(mockPerson1);
    // Test to see if the name of a field is returned for a specific field in the addressBook
    Assert.assertEquals("Address", testAddressBook.getColumnName(2));
  }
}
