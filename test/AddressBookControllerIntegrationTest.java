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
 * AddressBook as stub in order to test
 * the functions that depend on the AddressBook class (Testing integration)
 */
@ExtendWith(MockitoExtension.class)
class AddressBookControllerIntegrationTest {

  @InjectMocks
  private AddressBookController underTest;
  @Mock
  private AddressBook mockAddressBook;

  private Person person;


  @BeforeEach
  public void setUp() {
    mockAddressBook = mock(AddressBook.class);
    person = new Person("Johnny", "Appleseed", "555 AppleTree Road",
        "Bonita Springs", "FL", "33908", "(239) 999-9999");

    underTest = new AddressBookController(mockAddressBook);
  }

  @AfterEach
  public void tearDown() {
    mockAddressBook = null;
    person = null;
    underTest = null;
  }

  @Test
  void getFromMock() {
    // return person object when the get function from the mock object is called
    when(mockAddressBook.get(0)).thenReturn(person);
    // Test to make sure that the function was called and returned the expected value
    Assert.assertEquals(underTest.get(0), person);
  }

  @Test
  void clearMock() {
    // clear the controller
    underTest.clear();
    // check to make sure that the clear function within the addressBook mock was called at least
    // once
    verify(mockAddressBook, atLeastOnce()).clear();
  }

  @Test
  void addToAddressBookMock() {
    // call add function in the controller
    underTest.add(person);
    // check to verify that the function call "add"  in the addressBook was called at least once
    verify(mockAddressBook, atLeastOnce()).add(person);
  }

  @Test
  void removeFromAddressBookMock() {
    // call remove function in the controller
    underTest.remove(0);
    // check to verify that the function "remove" from the mock addressBook was called at least once
    verify(mockAddressBook, atLeastOnce()).remove(0);
  }

  @Test
  void setPersonsInMockAddressBook() {
    // create a new person object
    Person testPerson = new Person("Test", "Test", "555 AppleTree Road",
        "Bonita Springs", "FL", "33908", "(239) 999-9999");
    // add persons into the controller
    underTest.add(person);
    underTest.add(testPerson);
    // call controller function "set"
    underTest.set(0, testPerson);
    // check to verify that the function "set" in the mock addressBook was called at least once
    verify(mockAddressBook, atLeastOnce()).set(0, testPerson);
  }
}
