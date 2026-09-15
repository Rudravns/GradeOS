package Saver;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.nio.file.Path;

public class ReadFile {
    
    public static Object Readfile(String SaveFileName, String folder_path){
        // Target the same folder used in SaveFile
        Path saveDirectory = Path.of(folder_path);

        try (FileInputStream fileIn = new FileInputStream(saveDirectory.resolve(SaveFileName).toFile());
         ObjectInputStream in = new ObjectInputStream(fileIn)) {

           return in.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}



//javac -d out src\Saver\Person.java src\Saver\ReadFile.java
//java -cp out Saver.ReadFile
