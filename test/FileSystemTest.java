import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

/**
 * FileSystem Tester.
 *
 * @author <Allen Telson>
 * @version 1.0
 * @since <pre>Apr 18, 2020</pre>
 */
public class FileSystemTest {

  private FileSystem fileSystem;
  private AddressBook addressBook;
  private Person testPerson;
  private File testFile;

  @BeforeEach
  public void setUp() {
    fileSystem = new FileSystem();

    testPerson = new Person("Test", "Test", "Test", "Test",
        "FL", "33976", "(239)-999-9999");
    addressBook = new AddressBook();
    //addressBook.add(person);
    testFile = new File("$TEST");
  }

  @AfterEach
  public void tearDown() throws Exception {
    fileSystem = null;
    testFile = null;
    testPerson = null;
  }

  /**
   * Method: readFile(AddressBook addressBook, File file)
   */
  @Test
  public void testReadFile() {
    // Test whether the file is an SQL DB or not
    Assertions.assertThrows(SQLException.class, () -> {
      fileSystem.readFile(addressBook, new File("$TEST.txt"));
    });

    // Test whether the file is found or not
    Assertions.assertThrows(FileNotFoundException.class, () -> {
      fileSystem.readFile(addressBook, new File(""));
    });

    try {
      // call function with respective params
      fileSystem.readFile(addressBook, testFile);
      // Test to see if the method was successful at reading from the DB
      Assert.assertEquals(testPerson.getLastName(), addressBook.get(0).getLastName());
    } catch (Exception e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  /**
   * Method: saveFile(AddressBook addressBook, File file)
   */
  @Test
  public void testSaveFile() throws Exception {

    Person testPerson2 = new Person("Stacy", "Campbell",
        "347 Eagle Drive", "Miami", "FL", "33301", "(305)-999-9999");

    addressBook.add(testPerson);
    addressBook.add(testPerson2);

    // call save method to store what is currently in the addressBook
    fileSystem.saveFile(addressBook, testFile);
    //clear the current addressBook
    addressBook.clear();
    // read from DB and add contacts to addressBook
    fileSystem.readFile(addressBook, testFile);

    // Check to see if save method was successful
    Assert.assertEquals(
        Arrays.toString(new Person[]{testPerson, testPerson2}),
        Arrays.toString(addressBook.getPersons()));
  }
} 
