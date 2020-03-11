
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.testng.Assert;

/**
 * Person Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Feb 2, 2020</pre>
 */
public class PersonTest {

  private final Person person = new Person("Johnny", "Appleseed", "555 AppleTree Road",
      "Bonita Springs", "FL", "33908", "(239) 999-9999");

  @Before
  public void before() throws Exception {
  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: getFirstName()
   */
  @Test
  public void testGetFirstName() throws Exception {
//TODO: Test goes here...
    Assert.assertEquals(person.getFirstName(), "Johnny");
  }

  /**
   * Method: getLastName()
   */
  @Test
  public void testGetLastName() throws Exception {
//TODO: Test goes here...
    Assert.assertEquals(person.getLastName(), "Appleseed");
  }

  /**
   * Method: getAddress()
   */
  @Test
  public void testGetAddress() throws Exception {
//TODO: Test goes here...
    Assert.assertEquals(person.getAddress(), "555 AppleTree Road");
  }

  /**
   * Method: getCity()
   */
  @Test
  public void testGetCity() throws Exception {
//TODO: Test goes here...
    Assert.assertEquals(person.getCity(), "Bonita Springs");
  }

  /**
   * Method: getState()
   */
  @Test
  public void testGetState() throws Exception {
//TODO: Test goes here...
    Assert.assertEquals(person.getState(), "FL");
  }

  /**
   * Method: getZip()
   */
  @Test
  public void testGetZip() throws Exception {
//TODO: Test goes here...
    Assert.assertEquals(person.getZip(), "33908");
  }

  /**
   * Method: getPhone()
   */
  @Test
  public void testGetPhone() throws Exception {
//TODO: Test goes here...
    Assert.assertEquals(person.getPhone(), "(239) 999-9999");
  }

  /**
   * Method: toString()
   */
  @Test
  public void testToString() throws Exception {
//TODO: Test goes here...
    Assert.assertEquals(person.toString(), "Appleseed, Johnny");
  }

  /**
   * Method: containsString(String findMe)
   */
  @Test
  public void testContainsString() throws Exception {
//TODO: Test goes here...
    Assert.assertTrue(person.containsString("Apple"));
    Assert.assertTrue(person.containsString("Johnny"));
    Assert.assertTrue(person.containsString("Appletree"));
    Assert.assertTrue(person.containsString("Bonita"));
    Assert.assertTrue(person.containsString("339"));
    Assert.assertTrue(person.containsString("F"));
    Assert.assertTrue(person.containsString("999"));
  }

  /**
   * Method: getField(int field)
   */
  @Test
  public void testGetField() throws Exception {
//TODO: Test goes here...
    Assert.assertEquals(person.getField(0), "Appleseed");
  }
} 
