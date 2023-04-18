import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    private String lastName;
    private String firstName;
    private String middleName;
    private String dateOfBirth;
    private long phoneNumber;
    private char gender;

    // Конструктор класса Person
    public Person(String lastName, String firstName, String middleName, String dateOfBirth, long phoneNumber, char gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    // Геттеры и сеттеры
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    // validation and parsing methods
    public static Person parsePersonData(String data) throws ParseException {
        String[] dataArray = data.split(" ");
        if (dataArray.length != 6) {
            throw new ParseException("Incorrect number of data elements", 0);
        }

        String lastName = dataArray[0];
        String firstName = dataArray[1];
        String middleName = dataArray[2];
        String dateOfBirth = dataArray[3];
        long phoneNumber = Long.parseLong(dataArray[4]);
        char gender = dataArray[5].charAt(0);

        if (!validateDateOfBirth(dateOfBirth)) {
            throw new ParseException("Invalid date of birth format", 3);
        }

        if (!validateGender(gender)) {
            throw new ParseException("Invalid gender", 5);
        }

        return new Person(lastName, firstName, middleName, dateOfBirth, phoneNumber, gender);
    }

    private static boolean validateDateOfBirth(String dateOfBirth) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        sdf.setLenient(false);

        try {
            Date dob = sdf.parse(dateOfBirth);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private static boolean validateGender(char gender) {
        return gender == 'f' || gender == 'm';
    }



    // other methods
    // ...
}


