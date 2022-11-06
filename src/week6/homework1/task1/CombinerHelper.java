package week6.homework1.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CombinerHelper {

    private CombinerHelper() {
    }

    public static void combineTwoFilesByIdAndWrite(Path file1, Path file2, Path file3) throws IOException {
        Map<Integer, String> idAndName = getIdAndNameFromFile(file1);
        Map<Integer, Double> idAndPrice = getIdAndPriceFromFile(file2);
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(file3)) {
            bufferedWriter.write("ID,NAME,PRICE");
            bufferedWriter.newLine();
            for (Map.Entry<Integer, String> pair : idAndName.entrySet()) {
                Integer id = pair.getKey();
                String name = pair.getValue();
                if (idAndPrice.containsKey(id)) {
                    bufferedWriter.write(id + "," + name + "," + idAndPrice.get(id));
                    bufferedWriter.newLine();
                }
            }
        }

    }


    public static Map<Integer, Double> getIdAndPriceFromFile(Path fileName) throws IOException {
        Map<Integer, Double> idAndPrice = new HashMap<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(fileName)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] st = line.split(",");
                if (!st[0].equals("ID")) {
                    idAndPrice.put(Integer.valueOf(st[0]), Double.valueOf(st[1]));
                }
            }
        }
        return idAndPrice;
    }

    public static Map<Integer, String> getIdAndNameFromFile(Path fileName) throws IOException {
        Map<Integer, String> idAndName = new HashMap<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(fileName)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] st = line.split(",");
                if (!st[0].equals("ID")) {
                    idAndName.put(Integer.valueOf(st[0]), st[1]);
                }
            }
        }
        return idAndName;
    }

    public static void errorChecking(Path file1, Path file2, Path file3) throws IOException {
        Set<Integer> idNames = getIdAndNameFromFile(file1).keySet();
        Set<Integer> idPrices = getIdAndPriceFromFile(file2).keySet();
        List<Integer> differentIds = Stream.concat(
                        idNames.stream(),
                        idPrices.stream())
                .filter(x -> !(idNames.contains(x) && idPrices.contains(x)))
                .collect(Collectors.toList());
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(file3)) {
            bufferedWriter.write("ID");
            bufferedWriter.newLine();
            for (Integer differentId : differentIds) {
                bufferedWriter.write(differentId.toString());
                bufferedWriter.newLine();
            }
        }
    }
}
