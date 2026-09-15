package Saver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Path;

public class ReadFile {
    public static Object read(String fileName, String folderPath) {
        Path saveDirectory = Path.of(folderPath);

        try (FileInputStream fileIn = new FileInputStream(saveDirectory.resolve(fileName).toFile());
         ObjectInputStream in = new ObjectInputStream(fileIn)) {

           return in.readObject();

        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }

    public static Object Readfile(String fileName, String folderPath) {
        return read(fileName, folderPath);
    }
}
