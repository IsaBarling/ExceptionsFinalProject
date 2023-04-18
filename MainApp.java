import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class MainApp {
    public static void main(String[] args) {
        InputParserInterface inputParser = new InputParser();
        PersonFileWriterInterface personFileWriter = new PersonFileWriter();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Введите данные в формате: Фамилия Имя Отчество Дата_рождения Телефон Пол(m/f)");
            String input = reader.readLine();

            Person person = inputParser.parse(input);

            personFileWriter.writePerson(person);

            System.out.println("Данные успешно записаны в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода: " + e.getMessage());
        } catch (InvalidInputException e) {
            System.out.println("Ошибка валидации входных данных: " + e.getMessage());
        }
    }
}

