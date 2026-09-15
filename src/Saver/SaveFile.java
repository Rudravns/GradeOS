package Saver;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class SaveFile {
    public static boolean save(Object object, String fileName, String folderPath) {
        try {
            Path saveDirectory = Path.of(folderPath);
            Files.createDirectories(saveDirectory);

            try (FileOutputStream fileOut = new FileOutputStream(saveDirectory.resolve(fileName).toFile());
                 ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

                out.writeObject(object);
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static void Save(Object object, String fileName, String folderPath) {
        save(object, fileName, folderPath);
    }
}

