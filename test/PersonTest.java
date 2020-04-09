

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.Assert;

/**
 * Person Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Feb 2, 2020</pre>
 */
public class PersonTest {

  // create Field used for testing Person class
  @InjectMocks
  private Person person1;
  private Person person2;

  @Mock
  private AddressBook mockAddressBook;

  @BeforeEach
  public void steUp() throws Exception {
    // Initialize fields used for testing
    person1 = new Person("Johnny", "Appleseed", "555 AppleTree Road",
        "Bonita Springs", "FL", "33908", "(239) 999-9999");

    person2 = new Person("test", "test", "", "", "", "", "");
  }

  @AfterEach
  public void teardown() throws Exception {
    // Set all fields to null after each test
    person1 = null;
    person2 = null;
  }

  /**
   * Method: getFirstName()
   */
  @Test
  public void testGetFirstName() throws Exception {
//TODO: Test goes here...
    // Test to see if the correct first name is returned
    Assert.assertEquals("Johnny", person1.getFirstName());
    // Test the exception handling when initializing a person object
    Assert.assertThrows(IllegalArgumentException.class, () -> {
      // Test for valid input
      Person person3 = new Person("test", "test", "", "", "", "", "");
      // Test for empty firstName field
      Person person4 = new Person("", "test", "", "", "", "", "");
      // Test for null firstName field
      Person person5 = new Person(null, "test", "", "", "", "", "");
    });
  }

  /**
   * Method: getLastName()
   */
  @Test
  public void testGetLastName() throws Exception {
//TODO: Test goes here...
    // Test to see if the correct last name is returned
    Assert.assertEquals("Appleseed", person1.getLastName());
    Assert.assertThrows(IllegalArgumentException.class, () -> {
      // Test for valid input
      Person person3 = new Person("test", "test", "", "", "", "", "");
      // Test for empty lastName field
      Person person4 = new Person("test", "", "", "", "", "", "");
      // Test for null lastName field
      Person person5 = new Person("test", null, "", "", "", "", "");
    });
  }

  /**
   * Method: getAddress()
   */
  @Test
  public void testGetAddress() throws Exception {
//TODO: Test goes here...
    // Test to ensure that correct address is returned from a person object
    Assert.assertEquals("555 AppleTree Road", person1.getAddress());

  }

  /**
   * Method: getCity()
   */
  @Test
  public void testGetCity() throws Exception {
//TODO: Test goes here...
    // Test to ensure that correct city is returned from a person object
    Assert.assertEquals("Bonita Springs", person1.getCity());

  }

  /**
   * Method: getState()
   */
  @Test
  public void testGetState() throws Exception {
//TODO: Test goes here...
    // Test to ensure that correct state is returned from a person object
    Assert.assertEquals("FL", person1.getState());

  }

  /**
   * Method: getZip()
   */
  @Test
  public void testGetZip() throws Exception {
//TODO: Test goes here...
    // Test to ensure that correct zip code is returned from a person object
    Assert.assertEquals("33908", person1.getZip());

  }

  /**
   * Method: getPhone()
   */
  @Test
  public void testGetPhone() throws Exception {
//TODO: Test goes here...
    // Test to ensure that correct phone number is returned from a person object
    Assert.assertEquals("(239) 999-9999", person1.getPhone());

  }

  /**
   * Method: toString()
   */
  @Test
  public void testToString() throws Exception {
//TODO: Test goes here...
    // Test to ensure that correct last and first name is returned from a person object
    Assert.assertEquals("Appleseed, Johnny", person1.toString());
  }

  /**
   * Method: containsString(String findMe)
   */
  @Test
  public void testContainsString() throws Exception {
//TODO: Test goes here...
    // Test ensure all fields are correctly returned from a person object upon
    // entering characters that are within each field
    Assert.assertTrue(person1.containsString("Apple"));
    Assert.assertTrue(person1.containsString("Johnny"));
    Assert.assertTrue(person1.containsString("Appletree"));
    Assert.assertTrue(person1.containsString("Bonita"));
    Assert.assertTrue(person1.containsString("339"));
    Assert.assertTrue(person1.containsString("F"));
    Assert.assertTrue(person1.containsString("(239) 999-9999"));
  }

  /**
   * Method: getField(int field)
   */
  @Test
  public void testGetField() throws Exception {
//TODO: Test goes here...
    // Test to ensure all fields return correct inputs
    Assert.assertEquals("Appleseed", person1.getField(0));
    Assert.assertEquals("Johnny", person1.getField(1));
    Assert.assertEquals("555 AppleTree Road", person1.getField(2));
    Assert.assertEquals("Bonita Springs", person1.getField(3));
    Assert.assertEquals("FL", person1.getField(4));
    Assert.assertEquals("33908", person1.getField(5));
    Assert.assertEquals("(239) 999-9999", person1.getField(6));
    Assert.assertThrows(IllegalArgumentException.class, () -> {
      // test exception handling for if the index is out of bounds
      person1.getField(7);
    });
  }
} 
