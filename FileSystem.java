
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;

/***
 * FileSystem class is used to read from an an SQL database through JDBC.
 * THe FileSystem also can store people into the database.
 */
public class FileSystem {

  /**
   * readFile function uses jdbc to load an AddressBook with data from a database file.
   *
   */
  public void readFile(AddressBook addressBook, File file)
      throws SQLException, FileNotFoundException {
    // Check if the file exists or if it can be read
    if (!file.exists() || !file.canRead()) {
      throw new FileNotFoundException();
    }

    // establish a connection object that uses jdbc
    Connection connection = DriverManager.getConnection("jdbc:sqlite:" + file.getAbsolutePath());
    // Execute a query that will select the columns of the Person table
    ResultSet rs = connection.createStatement()
        .executeQuery("SELECT lastName, firstName, address, city, state, zip, phone FROM persons");
    // Clear the current AddressBook contents
    addressBook.clear();
    // Iterate through all the records, adding them to the AddressBook
    while (rs.next()) {
      Person p = new Person(
          rs.getString("firstName"),
          rs.getString("lastName"),
          rs.getString("address"),
          rs.getString("city"),
          rs.getString("state"),
          rs.getString("zip"),
          rs.getString("phone"));
      addressBook.add(p);
    }

    connection.close();
  }


  /**
   * Method is used to store all the information in an address book into the database.
   */
  public void saveFile(AddressBook addressBook, File file) throws SQLException {
    // establish a connection object that uses jdbc
    Connection connection = DriverManager.getConnection("jdbc:sqlite:" + file.getAbsolutePath());

    // Create a statement object to establish a query that will be executed.
    Statement statement = connection.createStatement();
    statement.execute("DROP TABLE IF EXISTS persons");
    statement.execute(
        "CREATE TABLE persons (firstName TEXT, lastName TEXT, address TEXT, city TEXT, state TEXT, zip TEXT, phone TEXT)");
    // Insert the data into the database
    PreparedStatement insert = connection.prepareStatement(
        "INSERT INTO persons (lastName, firstName, address, city, state, zip, phone) VALUES (?, ?, ?, ?, ?, ?, ?)");
    for (Person p : addressBook.getPersons()) {
      for (int i = 0; i < Person.fields.length; i++) {
        insert.setString(i + 1, p.getField(i));
      }
      insert.executeUpdate();
    }

    connection.close();
  }
}