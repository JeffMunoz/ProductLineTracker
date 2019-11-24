package productline;
// Author: Jeffry Munoz

/**
 * This class creates the employee objects that will allow for an audit trail of the production line
 * so that it records which employee recorded production.
 */
public class Employee {
  String name;
  String username;
  String password;
  String email;

  /**
   * This creates the employee objects.
   *
   * @param name the name of the employee.
   * @param password the password the employee creates.
   */
  public Employee(String name, String password) {
    this.name = name;
    checkName(name);
    if (isPasswordValid(password)) {
      this.password = password;
    } else {
      this.password = "pw";
    }
  }

  /**
   * This method Checks if the name the employee chose is valid for the creation of their user name
   * and email.
   *
   * @param nameToCheck the name the employee provided that will be checked.
   */
  private void checkName(String nameToCheck) {
    if (nameToCheck.indexOf(" ") > 0) {
      setUsername(nameToCheck);
      setEmail(nameToCheck);
    } else {
      setUsername("default");
      setEmail("user@oracleacademy.Test");
    }
  }

  /**
   * This method Checks if the password the employee chose is valid
   *
   * @param passToCheck the password the employee provided that will be checked.
   * @return it returns a true or false value based on whether or not the password passed the
   *     specified criteria.
   */
  public boolean isPasswordValid(String passToCheck) {
    // got some logic from
    // https://www.baeldung.com/java-lowercase-uppercase-special-character-digit-regex
    char charCheck;
    boolean lowerCase = false;
    boolean upperCase = false;
    boolean specialChar = false;
    for (int i = 0; i < passToCheck.length(); i++) {
      String specialChars = "~`!@#$%^&*()-_=+\\|[{]};:'\",<.>/?";
      charCheck = passToCheck.charAt(i);
      if (Character.isUpperCase(charCheck)) {
        upperCase = true;
      }
      if (Character.isLowerCase(charCheck)) {
        lowerCase = true;
      }
      if (specialChars.contains(String.valueOf(charCheck))) {
        specialChar = true;
      }
    }
    boolean valid = lowerCase && upperCase && specialChar;
    return valid;
  }

  /**
   * This method sets the username based on if the name of the employee is of the correct format.
   * @param username the username gets set to the incoming argument based on the checkName method.
   */
  public void setUsername(String username) {
    if (username.indexOf(" ") > 0) {
      String tempUser = username.substring(0, 1) + username.substring(username.indexOf(" ") + 1);
      this.username = tempUser.toLowerCase();
    } else {
      this.username = username;
    }
  }
  /**
   * This method sets the email based on if the name of the employee is of the correct format.
   * @param email the username gets set to the incoming argument based on the checkName method.
   */

  public void setEmail(String email) {
    if (email.indexOf(" ") > 0) {
      String tempEmail =
          email.substring(0, email.indexOf(" ")) + "." + email.substring(email.indexOf(" ") + 1);
      this.email = tempEmail.toLowerCase() + "@oracleacademy.Test";
    } else {
      this.email = email;
    }
  }

  @Override
  public String toString() {
    return "Employee Details \n"
        + "Name: "
        + name
        + "\n"
        + "Username: "
        + username
        + "\n"
        + "Email: "
        + email
        + "\n"
        + "Initial Password: "
        + password;
  }
}
