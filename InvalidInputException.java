// Класс исключения для обработки некорректного ввода
public class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}
