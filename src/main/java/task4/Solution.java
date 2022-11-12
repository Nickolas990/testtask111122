package task4;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        try (InputStream inputStream = Files.newInputStream(Paths.get(args[0]));
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            while (reader.ready()) {
                nums.add(Integer.parseInt(reader.readLine()));
            }
            Collections.sort(nums);
            int result = 0;
            int medium = nums.get(nums.size()/2);
            for (Integer num: nums) {
                result += Math.abs(num - medium);
            }
            System.out.println(result);


    } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
