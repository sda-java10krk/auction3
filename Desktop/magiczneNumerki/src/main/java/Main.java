import org.apache.commons.io.FilenameUtils;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        Path file = Paths.get("1.png");
        String extension = FilenameUtils.getExtension("1.png");

    }
}
