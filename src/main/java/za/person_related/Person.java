package za.person_related;

public class Person {
    private String firstName;
    private String lastName;
    private String email;
    private String idNumber;
    private int age;
    private String gender;
    private String citizenship;
    private String dateOfBirth;

    // Constructor to initialize fields
    public Person(String firstName, String lastName, String email, String idNumber) throws IllegalArgumentException {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        setIdNumber(idNumber);  // Set ID using the setter with validation
    }

    // Getter for firstName
    public String getFirstName() {
        return firstName;
    }

    // Setter for firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter for lastName
    public String getLastName() {
        return lastName;
    }

    // Setter for lastName
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email with validation
    public void setEmail(String email) {
        if (isValidEmail(email)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Invalid email address.");
        }
    }

    // Function to validate email format using regular expression
    public boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(emailRegex);
    }

    // Getter for idNumber
    public String getIdNumber() {
        return idNumber;
    }

    // Setter for idNumber with validation
    public void setIdNumber(String idNumber) throws IllegalArgumentException {
        IdAnalyser idAnalyser = new IdAnalyser(idNumber); // Validate ID number and extract details
        this.idNumber = idNumber;
        this.age = idAnalyser.getAge();
        this.gender = idAnalyser.getGender();
        this.citizenship = idAnalyser.getCitizenship();
        this.dateOfBirth = idAnalyser.getDateOfBirth();
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Getter for gender
    public String getGender() {
        return gender;
    }

    // Getter for citizenship
    public String getCitizenship() {
        return citizenship;
    }

    // Getter for dateOfBirth
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    // toString method for displaying person details
    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", citizenship='" + citizenship + '\'' +
                ", age=" + age +
                '}';
    }
}
