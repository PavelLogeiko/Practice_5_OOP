import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Saver {
    // сохраняет
    public static void saveFile(String text, String path) {
        File file = new File(path);
        try {
            file.createNewFile();
        } catch (Exception ignored) {
            throw new RuntimeException();
        }

        try (FileWriter fw = new FileWriter(path, true)) {
            fw.write(text);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}