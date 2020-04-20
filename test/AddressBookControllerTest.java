import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

/***
 * In this class, the AddressBookController uses both
 * AddressBook and Person class as stubs in order to test
 * the add and remove functions.
 */
class AddressBookControllerTest {

  private AddressBookController addressBookController;

  private AddressBook addressBook;

  private Person person;
  private Person dbPerson1;
  private Person dbPerson2;

  private File file;


  @BeforeEach
  public void setUp() {
    person = new Person("Johnny", "Appleseed", "555 AppleTree Road",
        "Bonita Springs", "FL", "33908", "(239) 999-9999");

    dbPerson1 = new Person("Test", "Test", "Test", "Test",
        "FL", "33976", "(239) 999-9999");
    dbPerson2 = new Person("Stacy", "Campbell",
        "347 Eagle Drive", "Miami", "FL", "33301", "(305) 999-9999");

    addressBook = new AddressBook();
    addressBook.add(person);

    addressBookController = new AddressBookController(addressBook);

    file = new File("$TEST");

  }

  @AfterEach
  public void tearDown() {
    addressBookController = null;
    addressBook = null;
    person = null;
    file = null;
  }

  @Test
  void add() {
    Assert.assertEquals(person, addressBookController.get(0));
  }

  @Test
  void set() {
    // TODO: Under construction at the moment
    Person person2 = new Person("Johnny", "Appleseed", "555 AppleTree Road",
        "Bonita Springs", "FL", "33908", "(239) 999-9999");

    addressBookController.add(person2);
    addressBookController.set(0, person2);

    Assert.assertEquals(person2, addressBookController.get(0));
  }

  @Test
  void remove() {
    addressBookController.remove(0);
    Assert.assertEquals(addressBookController.getModel().getPersons().length, 0);
  }


  @Test
  void get() {
    Assert.assertEquals(person, addressBookController.get(0));
  }


  @Test
  void clear() {
    addressBookController.clear();
    Assert.assertEquals(addressBookController.getModel().getPersons().length, 0);
  }

  @Test
  void open() throws FileNotFoundException, SQLException {
    addressBookController.open(file);
    AddressBook addressBook1 = new AddressBook();
    addressBook1.add(dbPerson1);
    addressBook1.add(dbPerson2);
    Assert.assertEquals(Arrays.toString(addressBook.getPersons()),
        Arrays.toString(addressBook1.getPersons()));
  }

  @Test
  void save() throws SQLException, FileNotFoundException {
    addressBook = new AddressBook();
    addressBook.add(dbPerson1);
    addressBook.add(dbPerson2);
    addressBookController.save(file);

    addressBookController.open(file);

    Assert.assertEquals(Arrays.toString(addressBook.getPersons()),
        Arrays.toString(new Person[]{dbPerson1, dbPerson2}));
  }

  @Test
  void getModel() {
    Assert.assertEquals(addressBook, addressBookController.getModel());
  }
}