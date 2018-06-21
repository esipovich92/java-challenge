package com.esipovich.challenge.text_analizer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * @author Artem Esipovich 21.06.2018
 *
 *  Count matching string in files
 *
 *  Write a method, which will iterate a folder with files and count occurencies of a string in each line
 *
 *  The implementation of a method should:
 *
 *  - Iterate over files in a temporary folder.
 *  - Check if name of the file is matching a pattern.
 *  - Check only files that are matching a given date range specified as startDate and numberOfDays.
 *  - For each file matching date pattern count number of lines that contains search string.
 *  - Return a Map with a file name as a key, and number of lines with search string as a value.
 */

public class TextAnalizer {

    private final static String TEMP_DIR = "d://temp";

    public static void main(String[] args) throws IOException {
        Map<String, Integer> occurencies = countOccurencies("mozilla", new File("filename"),
                LocalDate.of(2018, 6, 11), 10);
    }

    private static Map<String, Integer> countOccurencies(String searchQuery, File zipFile, LocalDate startDate,
                                                         Integer numberOfDays) throws IOException {
        Map<String, Integer> occurrences = new HashMap<>();

        File targetDir = new File(TEMP_DIR);

        File[] extractedFiles = targetDir.listFiles();
        String fileNamePattern = "logs_\\d{4}-\\d{2}-\\d{2}-access.log";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if (extractedFiles == null){
            return occurrences;
        }

        for (File file : extractedFiles){
            String fileName = file.getName();

            if (fileName.matches(fileNamePattern)){
                int firstDateIndex = fileName.indexOf('_') + 1;
                int lastDateIndex = fileName.lastIndexOf('-');
                String expectedDate = fileName.substring(firstDateIndex, lastDateIndex);

                LocalDate dateFromFileName = null;
                try {
                    dateFromFileName = LocalDate.parse(expectedDate, formatter);
                } catch (DateTimeParseException dateTimeParseException){
                    System.out.println(dateTimeParseException.getMessage());
                }

                if (dateFromFileName != null && (startDate.until(dateFromFileName).getDays() <= numberOfDays)) {
                    AtomicInteger count = new AtomicInteger();
                    try (Stream<String> stream = Files.lines(Paths.get(targetDir + "\\" + fileName))) {

                        stream.forEach(line -> {
                            if (line.contains(searchQuery)){
                                count.getAndIncrement();
                            }
                        });

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    occurrences.put(fileName, count.intValue());
                }
            }
        }
        return occurrences;
    }
}
