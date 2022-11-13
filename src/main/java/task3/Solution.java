package task3;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.List;
import java.util.Objects;

public class Solution {

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try (InputStream inputStream = Files.newInputStream(Paths.get(args[0]));
             BufferedReader tests = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
             InputStream valuesStream = Files.newInputStream(Paths.get(args[1]));
             BufferedReader values = new BufferedReader(new InputStreamReader(valuesStream))) {


            Tests array = objectMapper.readValue(tests, Tests.class);
            Values valuesList = objectMapper.readValue(values, Values.class);

            setTestsValues(array.tests, valuesList.values);
            createAndFillReport(objectMapper, array);


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void createAndFillReport(ObjectMapper objectMapper, Tests array) throws IOException {
        File report = new File("src/main/java/task3/report.json");
        if (!report.createNewFile()) {
            report.delete();
            report.createNewFile();
            System.out.println("report refreshed");
        }
        FileWriter writer = new FileWriter(report);
        writer.write(objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(array));
        writer.close();
    }

    private static void setTestsValues(List<Test> tests, List<Values.Value> values) {
        for (Test test : tests) {
            for (Values.Value value : values) {
                if (Objects.isNull(test.values)) {
                    if (test.id == value.id) {
                        test.setValue(value.getValue());
                    }
                } else {
                    test.setValue(value.getValue());
                    setTestsValues(test.values, values);
                }
            }
        }
    }
}
