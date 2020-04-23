
import java.util.regex.Pattern;

/***
 * Person class is used to store contact information for each contact within an AddressBook.
 */
public class Person {

  // Field is used to identify properties within the Person class.
  public static final String[] fields =
      {
          "Last Name",
          "First Name",
          "Address",
          "City",
          "State",
          "ZIP",
          "Phone",
      };

  // Contact information
  private String firstName;
  private String lastName;
  private String address;
  private String city;
  private String state;
  private String zip;
  private String phone;

  // Regex used to provide patterns that will be used to identify valid or invalid code.
  private String NUM_REGEX = "^\\d+$";
  private String PHONE_REGEX = "((\\(\\d{3}\\) ?)|(\\d{3}-))?\\d{3}-\\d{4}";
  private String NAME_REGEX = "^[a-zA-Z]+(([',\\- ][a-zA-Z ])?[a-zA-Z]*)*$";
  private String ADDRESS_REGEX = "^\\d+\\s[A-z]+\\s[A-z]+";

  // Each pattern is responsible for validating user input
  private Pattern numberPattern = Pattern.compile(NUM_REGEX);
  private Pattern phoneNumberPattern = Pattern.compile(PHONE_REGEX);
  private Pattern namePattern = Pattern.compile(NAME_REGEX);
  private Pattern addressPattern = Pattern.compile(ADDRESS_REGEX);

  // Constructor for Person object.
  public Person(String firstName, String lastName, String address, String city, String state,
      String zip, String phone) {
    // Input validation to make sure that the data from each field being store is valid.
      if (firstName == null || firstName.isEmpty() || !namePattern.matcher(firstName).matches()) {
          throw new IllegalArgumentException("First name cannot be empty and must be a valid name");
      }
      if (lastName == null || lastName.isEmpty() || !namePattern.matcher(lastName).matches()) {
          throw new IllegalArgumentException("Last name cannot be empty and must be a valid name");
      }
      if (address.isEmpty() && !addressPattern.matcher(address).matches()) {
          throw new IllegalArgumentException("Address is invalid");
      }
      if (!city.isEmpty() && !namePattern.matcher(city).matches()) {
          throw new IllegalArgumentException("City is invalid");
      }
      if (!state.isEmpty() && !namePattern.matcher(state).matches()) {
          throw new IllegalArgumentException("State is invalid");
      }
      if (!zip.isEmpty() && !numberPattern.matcher(zip).matches()) {
          throw new IllegalArgumentException("Zip code is invalid");
      }
      if (!phone.isEmpty() && !phoneNumberPattern.matcher(phone).matches()) {
          throw new IllegalArgumentException("Phone number is invalid");
      }

    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.city = city;
    this.state = state;
    this.zip = zip;
    this.phone = phone;
  }


  /**
   * Returns this Person's first name.
   *
   * @return First name of this Person
   */
  public String getFirstName() {
    return firstName;
  }


    /**
     * Returns this Person's last name.
     *
     * @return First name of this Person
     */
  public String getLastName() {
    return lastName;
  }


    /**
     * Returns this Person's address.
     *
     * @return Address of this Person
     */
  public String getAddress() {
    return address;
  }


    /**
     * Returns this Person's city.
     *
     * @return City of this Person
     */
  public String getCity() {
    return city;
  }

    /**
     * Returns this Person's state.
     *
     * @return state of this Person
     */
  public String getState() {
    return state;
  }

  /**
   * Returns this Person's ZIP code.
   *
   * @return ZIP code of this Person
   */
  public String getZip() {
    return zip;
  }

  /**
   * Returns this Person's telephone number.
   *
   * @return Telephone number of this Person.
   */
  public String getPhone() {
    return phone;
  }

    /***
     * Overrides toString method to return the Person's first and last name.
     */
  @Override
  public String toString() {
    return lastName + ", " + firstName;
  }


    /**
     * containString method is used to check for patterns within the properties of a person,
     * returning the String that does.
     *
     * @return matched String from this Person
     */
  public boolean containsString(String findMe) {
    Pattern p = Pattern.compile(Pattern.quote(findMe), Pattern.CASE_INSENSITIVE);
    return p.matcher(firstName).find()
        || p.matcher(lastName).find()
        || p.matcher(address).find()
        || p.matcher(city).find()
        || p.matcher(state).find()
        || p.matcher(zip).find()
        || p.matcher(phone).find();
  }


    /**
     * Returns this Person's property depending on the index.
     *
     * @return field
     */
  public String getField(int field) {
    switch (field) {
      case 0:
        return lastName;
      case 1:
        return firstName;
      case 2:
        return address;
      case 3:
        return city;
      case 4:
        return state;
      case 5:
        return zip;
      case 6:
        return phone;
      default:
        throw new IllegalArgumentException("Field number out of bounds");
    }
  }
}