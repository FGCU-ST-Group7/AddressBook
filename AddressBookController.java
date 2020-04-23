
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;

/**
 * AddressController is used by the GUI in order to manipulate the data within the address book
 * which involve Person objects.
 */
public class AddressBookController {

  // AddressBookController will have an addressBook
  private AddressBook addressBook;

  // Default constructor that stores the address book that is passed in during initialization
  public AddressBookController(AddressBook addressBook) {
    this.addressBook = addressBook;
  }

  /***
   * Add function used to store a person object within an addressBook.
   * @param p - Person.
   */
  public void add(Person p) {
    addressBook.add(p);
  }

  /***
   * Set function is used to store a person in a specific spot within the address book.
   * It calls the function remove() in the addressBook object to do so.
   *
   * @param index - is the destination of where the person object will be stored.
   * @param person - person object that will be stored in that position.
   */
  public void set(int index, Person person) {
    addressBook.set(index, person);
  }

  /***
   * Remove function used to remove a person object from within an addressBook.
   * It calls the function remove() in the addressBook object to do so.
   * @param index - position of person to be removed.
   */
  public void remove(int index) {
    addressBook.remove(index);
  }

  /***
   * Get function used to get a person object from within an addressBook.
   * It calls the function get() in the addressBook object to do so.
   *
   * @param index - position of person to get.
   */
  public Person get(int index) {
    return addressBook.get(index);
  }

  /***
   * Method used to clear all objects from within an address book.
   * It calls the function clear() in the addressBook object to do so.
   */
  public void clear() {
    addressBook.clear();
  }

  /***
   *   Open method is used to open a file and read the information to store it into the addressBook.
   *
   * @param file - the file path where the database is located.
   */
  public void open(File file) throws FileNotFoundException, SQLException {
    new FileSystem().readFile(addressBook, file);
    addressBook.fireTableDataChanged();
  }

  /***
   *   Save method is used to save the contents within the addressBook into the database.
   *
   *
   * @param file - the file path where the database is located.
   */
  public void save(File file) throws SQLException {
    new FileSystem().saveFile(addressBook, file);
  }

  /***
   * Method used to return the addressBook.
   */
  public AddressBook getModel() {
    return addressBook;
  }
}