
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

  private AddressBook addressBook;
  private List<Person> persons;
  private Person testPerson1;
  private Person testPerson2;

  @BeforeEach
  public void setUp() throws Exception {
    addressBook = new AddressBook();
    testPerson1 = new Person("Johnny", "Appleseed", "555 AppleTree Road",
        "Bonita Springs", "FL", "33908", "(239) 999-9999");

    testPerson2 = new Person("test2", "test2", "", "", "", "", "");
    addressBook.add(testPerson1);
    addressBook.add(testPerson2);
  }

  @AfterEach
  public void after() throws Exception {
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
    Person[] people = new Person[]{testPerson1, testPerson2};
    Assert.assertArrayEquals(addressBook.getPersons(), people);
  }

  /**
   * Method: add(Person p)
   */
  @Test
  public void testAdd() throws Exception {
//TODO: Test goes here...
    Person testPerson3 = new Person("test", "test", "", "", "", "", "");
    addressBook.add(testPerson3);
    Assert.assertEquals(addressBook.get(2), testPerson3);
  }

  /**
   * Method: set(int index, Person person)
   */
  @Test
  public void testSet() throws Exception {
//TODO: Test goes here...
    addressBook.set(0, testPerson2);
    Assert.assertEquals(addressBook.get(0), testPerson2);
  }

  /**
   * Method: remove(int index)
   */
  @Test
  public void testRemove() throws Exception {
//TODO: Test goes here...
    persons = new ArrayList<>();
    persons.add(testPerson2);
    addressBook.remove(0);
    Assert.assertArrayEquals(persons.toArray(), addressBook.getPersons());
  }

  /**
   * Method: get(int index)
   */
  @Test
  public void testGet() throws Exception {
//TODO: Test goes here...
    Assert.assertEquals(testPerson1, addressBook.get(0));
  }

  /**
   * Method: clear()
   */
  @Test
  public void testClear() throws Exception {
//TODO: Test goes here...
    addressBook.clear();
    addressBook.clear();
    Assert.assertEquals(0, addressBook.getPersons().length);
  }

  /**
   * Method: getRowCount()
   */
  @Test
  public void testGetRowCount() throws Exception {
//TODO: Test goes here...
    Assert.assertEquals(2, addressBook.getRowCount());
  }

  /**
   * Method: getColumnCount()
   */
  @Test
  public void testGetColumnCount() throws Exception {
//TODO: Test goes here...
    Assert.assertEquals(7, addressBook.getColumnCount());
  }

  /**
   * Method: getValueAt(int row, int column)
   */
  @Test
  public void testGetValueAt() throws Exception {
//TODO: Test goes here...
    Assert.assertEquals("FL", addressBook.getValueAt(0, 4));
  }

  /**
   * Method: getColumnName(int column)
   */
  @Test
  public void testGetColumnName() throws Exception {
//TODO: Test goes here...
    Assert.assertEquals("Address", addressBook.getColumnName(2));
  }

} 
