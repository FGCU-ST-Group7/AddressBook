import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/***
 * AddressBook class stores Person objects and allowing their properties to be accessible through
 * functions.
 *
 */
public class AddressBook extends AbstractTableModel {

  // AddressBook will contain a List of person objects. This is the contact list.
  private List<Person> persons = new ArrayList<>();

  /***
   * Method used to return a list of people from the contact list.
   */
  public Person[] getPersons() {
    return persons.toArray(new Person[0]);
  }


  /***
   * Method used to add a person to the contact list.
   */
  public void add(Person p) {
    // get the current index of people in the list
    int newIndex = persons.size();
    // add a person to the list
    persons.add(p);
    // update the UI
    fireTableRowsInserted(newIndex, newIndex);
  }

  /**
   * Sets the person at the given index to the Person specified.
   *
   * @param index Index to update.
   * @param person Person to replace the item with.
   */
  public void set(int index, Person person) {
    persons.set(index, person);
    fireTableRowsUpdated(index, index);
  }

  /***
   * Removes a person from the list of people.
   */
  public void remove(int index) {
    // use index to identify which person to remove.
    persons.remove(index);
    // update table
    fireTableRowsDeleted(index, index);
  }

  /***
   *    Returns a person from a given index.
   */
  public Person get(int index) {
    return persons.get(index);
  }

  /**
   * Clears this address book of person objects
   */
  public void clear() {
    if (persons == null || persons.size() == 0) {
      return;
    }
    // update table
    fireTableRowsDeleted(0, persons.size() - 1);
    persons.clear();
  }

  /***
   * Returns size of contact list.
   */
  @Override
  public int getRowCount() {
    return persons.size();
  }


  /***
   * Returns size of Person properties.
   */
  public int getColumnCount() {
    return Person.fields.length;
  }


  /***
   * Returns value from a given person and whatever field is being requested.
   */
  @Override
  public Object getValueAt(int row, int column) {
    return persons.get(row).getField(column);
  }

  /***
   * Returns the name of a column given the index of the column.
   */
  @Override
  public String getColumnName(int column) {
    return Person.fields[column];
  }
}