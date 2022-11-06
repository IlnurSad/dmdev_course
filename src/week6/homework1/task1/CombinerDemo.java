package week6.homework1.task1;

import java.io.IOException;
import java.nio.file.Path;

public class CombinerDemo {
    public static void main(String[] args) throws IOException {
        Path file1 = Path.of("resources", "week6.homework1.task1", "items-name.csv");
        Path file2 = Path.of("resources", "week6.homework1.task1", "items-price.csv");
        Path file3 = Path.of( "resources", "week6.homework1.task1", "result.csv");
        Path file4 = Path.of( "resources", "week6.homework1.task1", "errors.csv");

        CombinerHelper.combineTwoFilesByIdAndWrite(file1, file2, file3);
        CombinerHelper.errorChecking(file1, file2, file4);
    }
}
