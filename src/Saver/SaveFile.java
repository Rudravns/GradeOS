package Saver;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;



public class SaveFile {
    public static void Save(Object p, String SaveFileName, String folder_path) {
        try {
            Path saveDirectory = Path.of(folder_path);
            Files.createDirectories(saveDirectory);

            try (FileOutputStream fileOut = new FileOutputStream(saveDirectory.resolve(SaveFileName).toFile());
                 ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

                out.writeObject(p);
                System.out.println("Object saved successfully!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

