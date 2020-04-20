import java.util.regex.Pattern;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
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
  private Person person1;

  private Pattern numberPattern;
  private Pattern phoneNumberPattern;
  private Pattern namePattern;

  private String NUM_REGEX = "^\\d+$";
  private String PHONE_REGEX = "((\\(\\d{3}\\) ?)|(\\d{3}-))?\\d{3}-\\d{4}";
  private String NAME_REGEX = "^[a-zA-Z]+(([',\\- ][a-zA-Z ])?[a-zA-Z]*)*$";


  @BeforeEach
  public void steUp() throws Exception {
    // Initialize fields used for testing
    person1 = new Person("Johnny", "Appleseed", "555 AppleTree Road",
        "Bonita Springs", "FL", "33908", "(239) 999-9999");

    numberPattern = Pattern.compile(NUM_REGEX);
    phoneNumberPattern = Pattern.compile(PHONE_REGEX);
    namePattern = Pattern.compile(NAME_REGEX);
  }

  @AfterEach
  public void teardown() throws Exception {
    // Set all fields to null after each test
    person1 = null;
    numberPattern = null;
    phoneNumberPattern = null;
  }

  @ParameterizedTest
  @MethodSource("personGenerator")
  public void createPerson(String firstName, String lastName, String address, String city, String state, String zipCode, String phoneNumber){
    Assert.assertThrows(IllegalArgumentException.class, () -> {
      Person person = new Person(firstName, lastName, address, city, state, zipCode, phoneNumber);
    });
  }

  static Stream<Arguments> personGenerator(){
    return Stream.of(
        Arguments.arguments("Michael", "Jordan", "23 United Center", "Chicago", "IL", "23232", "(239) 999-9999"),
        Arguments.arguments("", "Jordan", "23 United Center", "Chicago", "IL", "23232", "(239) 999-9999"),
        Arguments.arguments("23", "Jordan", "23 United Center", "Chicago", "IL", "23232", "(239) 999-9999"),
        Arguments.arguments("Michael", "23", "23 United Center", "Chicago", "IL", "23232", "(239) 999-9999"),
        Arguments.arguments("Michael", "", "23 United Center", "Chicago", "IL", "23232", "(239) 999-9999"),
        Arguments.arguments("Michael", "Jordan", "23", "Chicago", "IL", "23232", "(239) 999-9999"),
        Arguments.arguments("Michael", "Jordan", "", "Chicago", "IL", "23232", "(239) 999-9999"),
        Arguments.arguments("Michael", "Jordan", "23 United Center", "23", "IL", "23232", "(239) 999-9999"),
        Arguments.arguments("Michael", "Jordan", "23 United Center", "", "IL", "23232", "(239) 999-9999"),
        Arguments.arguments("Michael", "Jordan", "23 United Center", "Chicago", "23", "23232", "(239) 999-9999"),
        Arguments.arguments("Michael", "Jordan", "23 United Center", "Chicago", "", "23232", "(239) 999-9999"),
        Arguments.arguments("Michael", "Jordan", "23 United Center", "Chicago", "IL", "Air Jordan", "(239) 999-9999"),
        Arguments.arguments("Michael", "Jordan", "23 United Center", "Chicago", "IL", "", "(239) 999-9999"),
        Arguments.arguments("Michael", "Jordan", "23 United Center", "Chicago", "IL", "23232", "(239)-999-MIKE"),
        Arguments.arguments("Michael", "Jordan", "23 United Center", "Chicago", "IL", "", "")
        );
  }

  /**
   * Method: getFirstName()
   */
  @Test
  public void testGetFirstName() throws Exception {
    // Validate the input to make sure that the name is actually a name
    Assert.assertTrue(namePattern.matcher(person1.getFirstName()).matches());
    // Test to see if the correct first name is returned
    Assert.assertEquals("Johnny", person1.getFirstName());

    // Test the exception handling when initializing a person object
    Assert.assertThrows(IllegalArgumentException.class, () -> {
      // Test for valid input
      Person person3 = new Person("test", "test", "", "",
          "", "", "");
      // Test for empty firstName field
      Person person4 = new Person("", "test", "", "",
          "", "", "");
      // Test for null firstName field
      Person person5 = new Person(null, "test", "", "",
          "", "", "");
    });
  }

  /**
   * Method: getLastName()
   */
  @Test
  public void testGetLastName() throws Exception {
    // Validate the input to make sure that the name is actually a name
    Assert.assertTrue(namePattern.matcher(person1.getLastName()).matches());
    // Test to see if the correct last name is returned
    Assert.assertEquals("Appleseed", person1.getLastName());

    Assert.assertThrows(IllegalArgumentException.class, () -> {
      // Test for valid input
      Person person3 = new Person("test", "test", "", "",
          "", "", "");
      // Test for empty lastName field
      Person person4 = new Person("test", "", "", "",
          "", "", "");
      // Test for null lastName field
      Person person5 = new Person("test", null, "", "",
          "", "", "");
    });
  }

  /**
   * Method: getAddress()
   */
  @Test
  public void testGetAddress() throws Exception {
    // Test to ensure that correct address is returned from a person object
    Assert.assertEquals("555 AppleTree Road", person1.getAddress());

  }

  /**
   * Method: getCity()
   */
  @Test
  public void testGetCity() throws Exception {
    // Validate the input to make sure that the city is actually a city
    Assert.assertTrue(namePattern.matcher(person1.getFirstName()).matches());
    // Test to ensure that correct city is returned from a person object
    Assert.assertEquals("Bonita Springs", person1.getCity());

  }

  /**
   * Method: getState()
   */
  @Test
  public void testGetState() throws Exception {
    // Test to ensure that correct state is returned from a person object
    Assert.assertEquals("FL", person1.getState());

  }

  /**
   * Method: getZip()
   */
  @Test
  public void testGetZip() throws Exception {
    // Check to make sure that the Zip code only consist of numbers.
    Assert.assertTrue(numberPattern.matcher(person1.getZip()).matches());
    // Test to ensure that correct zip code is returned from a person object
    Assert.assertEquals("33908", person1.getZip());

  }

  /**
   * Method: getPhone()
   */
  @Test
  public void testGetPhone() throws Exception {
    // Check to make sure that the phone number only contains numbers and the
    // parentheses with the area code between them.
    Assert.assertTrue(phoneNumberPattern.matcher(person1.getPhone()).matches());
    // Test to ensure that correct phone number is returned from a person object
    Assert.assertEquals("(239) 999-9999", person1.getPhone());
  }

  /**
   * Method: toString()
   */
  @Test
  public void testToString() throws Exception {
    // Test to ensure that correct last and first name is returned from a person object
    Assert.assertEquals("Appleseed, Johnny", person1.toString());
  }

  /**
   * Method: containsString(String findMe)
   */
  @ParameterizedTest
  @ValueSource(strings = {"Apple", "Johnny", "Appletree", "Bonita", "339", "F", "(239) 999-9999"})
  public void testContainsString(String characters) {
    // Test ensure all fields are correctly returned from a person object upon
    // entering characters that are within each field
    Assert.assertTrue(person1.containsString(characters));
  }

  /**
   * Method: getField(int field)
   */
  @ParameterizedTest
  @MethodSource("stringAndIntProvider")
  public void testGetField(String str, int num) {
    if (num == Person.fields.length) {
      Assert.assertThrows(IllegalArgumentException.class, () -> {
        // test exception handling for if the index is out of bounds
        person1.getField(num);
      });
    } else {
      Assert.assertEquals(str, person1.getField(num));
    }
  }

  /***
   * Method used by the testGetField test function that will supply the arguments to run the method.
   */
  static Stream<Arguments> stringAndIntProvider() {
    return Stream.of(
        Arguments.arguments("Appleseed", 0),
        Arguments.arguments("Johnny", 1),
        Arguments.arguments("555 AppleTree Road", 2),
        Arguments.arguments("Bonita Springs", 3),
        Arguments.arguments("FL", 4),
        Arguments.arguments("33908", 5),
        Arguments.arguments("(239) 999-9999", 6),
        Arguments.arguments("", 7)
    );
  }
} 
