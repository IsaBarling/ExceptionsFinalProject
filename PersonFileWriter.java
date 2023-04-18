import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PersonFileWriter implements PersonFileWriterInterface {
    @Override
    public void writePerson(Person person) throws IOException {
        String fileName = person.getLastName() + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(person.getLastName());
            writer.newLine();
            writer.write(person.getFirstName());
            writer.newLine();
            writer.write(person.getMiddleName());
            writer.newLine();
            writer.write(person.getDateOfBirth());
            writer.newLine();
            writer.write((int) person.getPhoneNumber());
            writer.newLine();
            writer.write(person.getGender());
        }
        catch (IOException e) {
            // Обработка ошибки записи в файл, например, вывод сообщения об ошибке или логгирование
            e.printStackTrace();
        }
    }
}

