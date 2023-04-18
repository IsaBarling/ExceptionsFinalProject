import java.io.FileWriter;
import java.io.IOException;

public class InputParser implements InputParserInterface {
    public Person parse(String input) throws InvalidInputException {
        String[] parts = input.split(" ");
        if (parts.length != 6) {
            throw new InvalidInputException("Invalid number of arguments");
        }

        String lastName = parts[0];
        String firstName = parts[1];
        String middleName = parts[2];
        String dateOfBirth = parts[3];
        long phoneNumber;
        try {
            phoneNumber = Long.parseLong(parts[4]);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Invalid phone number format");
        }
        char gender = parts[5].charAt(0);
        if (gender != 'm' && gender != 'f') {
            throw new InvalidInputException("Invalid gender value");
        }

        return new Person(lastName, firstName, middleName, dateOfBirth, phoneNumber, gender);
    }
}



