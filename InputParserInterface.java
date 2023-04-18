import java.io.FileWriter;
import java.io.IOException;
public interface InputParserInterface {
    Person parse(String input) throws InvalidInputException;
}

