import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testng.Assert;

/**
 * AddressBook Integration Tester.
 *
 * @author <Authors Allen Telson>
 * @version 1.0
 * @since <pre>Feb 8, 2020</pre>
 *
 * This testing class uses a Person stub when testing
 */
@ExtendWith(MockitoExtension.class)
public class AddressBookIntegrationTest {

  @InjectMocks
  private AddressBook addressBook;

  @Mock
  private Person personStub;

  @BeforeEach
  void setUp() {
    addressBook = new AddressBook();

    personStub = mock(Person.class);
  }

  @AfterEach
  void tearDown() {
    addressBook = null;
    personStub = null;
  }

  @Test
  void getValueAtStub() {
    // add stub to the addressBook
    addressBook.add(personStub);
    // when getField(0) is called, return the String "Last Name"
    when(personStub.getField(0)).thenReturn("Last Name");
    // verify that the function in the person stub was called and returned the correct value
    Assert.assertEquals("Last Name", addressBook.getValueAt(0, 0));
  }
}
