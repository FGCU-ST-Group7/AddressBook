import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testng.Assert;

/***
 * In this class, the AddressBookController uses both
 * AddressBook and Person class as stubs in order to test
 * the add and remove functions.
 */
@ExtendWith(MockitoExtension.class)
class AddressBookControllerTest {

  // In Mockito, mocks can be represented for stub and driver
  @Mock
  private AddressBook addressBook;

  private Person person;

  // The class under testing
  @InjectMocks
  private AddressBookController underTest;

  @BeforeEach
  public void setUp() {
    addressBook = mock(AddressBook.class);
    person = new Person("Johnny", "Appleseed", "555 AppleTree Road",
        "Bonita Springs", "FL", "33908", "(239) 999-9999");

    underTest = new AddressBookController(addressBook);
  }

  @AfterEach
  public void tearDown() {
    addressBook = null;
    person = null;
    underTest = null;
  }

  @Test
  void add() {
    // when the getPersons function gets called from the mock, return
    // a list containing the mockPerson
    when(addressBook.getPersons()).thenReturn(new Person[]{person});
    // call the method under test
    underTest.add(person);
    // after adding a person, check and compare the size of the addressBook
    Assert.assertEquals(1, underTest.getModel().getPersons().length);
    // check to verify that the function within the addressBook mock was called
    verify(addressBook, atLeastOnce()).add(person);
  }

  @Test
  void set() {
    // TODO: Under construction at the moment
    Person person2 = new Person("Johnny", "Appleseed", "555 AppleTree Road",
        "Bonita Springs", "FL", "33908", "(239) 999-9999");

    underTest.add(person);
    underTest.add(person2);
  }

  @Test
  void remove() {
    // when the addressBook getPerson function gets called, return an
    // empty list of Person type array.
    when(addressBook.getPersons()).thenReturn(new Person[]{});
    // call the method under testing
    underTest.remove(0);
    // check and compare the size of the AddressBookController's addressBook
    Assert.assertEquals(0, underTest.getModel().getPersons().length);
    // check and verify that the addressBook function remove was called at least once
    verify(addressBook, atLeastOnce()).remove(0);
  }

  @Test
  void get() {
    when(addressBook.get(0)).thenReturn(person);
    Assert.assertEquals(person, underTest.get(0));

    verify(addressBook, atLeastOnce()).get(0);
  }

  @Test
  void clear() {
  }

  @Test
  void open() {
  }

  @Test
  void save() {
  }

  @Test
  void getModel() {
  }
}