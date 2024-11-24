package za.person_related;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class IdAnalyser {

    private String idNumber;
    private String dateOfBirth;
    private String gender;
    private String citizenship;
    private int age;

    public IdAnalyser(String idNumber) throws IllegalArgumentException {
        if (idNumber.length() != 13 || !idNumber.matches("\\d+")) {
            throw new IllegalArgumentException("ID number must be 13 digits long and numeric");
        }
        this.idNumber = idNumber;
        parseIdNumber();
    }

    private void parseIdNumber() {
        // Parse date of birth (YYMMDD)
        String dob = idNumber.substring(0, 6);
        try {
            int year = Integer.parseInt(dob.substring(0, 2));
            int month = Integer.parseInt(dob.substring(2, 4));
            int day = Integer.parseInt(dob.substring(4, 6));

            // Adjust the year to 1900s or 2000s
            year += (year > 22) ? 1900 : 2000;

            // Create a LocalDate to validate date correctness
            LocalDate birthDate = LocalDate.of(year, month, day);
            this.dateOfBirth = birthDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            // Calculate the age based on the date of birth
            this.age = calculateAge(birthDate);

        } catch (DateTimeParseException | NumberFormatException e) {
            throw new IllegalArgumentException("Invalid date in ID number");
        }

        // Determine gender from the 7th digit
        int genderDigit = Character.getNumericValue(idNumber.charAt(6));
        this.gender = (genderDigit < 5) ? "Female" : "Male";

        // Determine citizenship from the 11th digit
        int citizenshipDigit = Character.getNumericValue(idNumber.charAt(10));
        this.citizenship = (citizenshipDigit == 1) ? "Citizen" : "Permanent Resident";

        // Validate the ID number using the Luhn algorithm
        if (!isValidLuhn(idNumber)) {
            throw new IllegalArgumentException("Invalid ID number checksum");
        }
    }

    // Calculate age based on birth date
    private int calculateAge(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }

    private boolean isValidLuhn(String number) {
        // Luhn algorithm: Validate South African ID number
        int sum = 0;
        boolean alternate = false;
        for (int i = number.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(number.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n -= 9;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
    }

    // Getter methods
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public int getAge() {
        return age;
    }

    public String getIdNumber() {
        return idNumber;
    }

    @Override
    public String toString() {
        return "ID Number: " + idNumber + "\n" +
                "Date of Birth: " + dateOfBirth + "\n" +
                "Gender: " + gender + "\n" +
                "Citizenship: " + citizenship + "\n" +
                "Age: " + age;
    }
}
