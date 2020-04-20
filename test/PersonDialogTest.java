import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JFrame;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Person Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>April 20, 2020</pre>
 */
class PersonDialogTest {

  Person person;
  JFrame jFrame;
  PersonDialog underTest;

  @BeforeEach
  public void setUp() {
    jFrame = new JFrame();
    person = new Person("Michael", "Jordan", "United Center", "Chicago", "IL",
        "23232", "(239) 999-9999");
    underTest = new PersonDialog(jFrame, person);
  }

  @AfterEach
  public void tearDown() {
    jFrame = null;
    person = null;
    underTest = null;
  }

  /***
   * Test used to verify whether the person in the PersonDialog is the same as
   * the person that was passed into it in the constructor.
   */
  @Test
  void getPersonsTest() {
    assertEquals(person.toString(), underTest.getPerson().toString());
  }
}