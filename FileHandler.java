import java.io.IOException;

public interface FileHandler {
    void writeToFile(String fileName, String data) throws IOException;
    String readFromFile(String fileName) throws IOException;
}

