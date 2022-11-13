package task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Solution {

    public static void main(String[] args) {
        try(BufferedReader circleReader = new BufferedReader(new InputStreamReader(Files.newInputStream(Paths.get(args[0])), StandardCharsets.UTF_8));
            BufferedReader pointsReader = new BufferedReader(new InputStreamReader(Files.newInputStream(Paths.get(args[1])), StandardCharsets.UTF_8))) {
            String [] center = circleReader.readLine().split(" ");
            int radius = Integer.parseInt(circleReader.readLine());
            Circle circle = Circle.getCircle(center, radius);

            while (pointsReader.ready()) {
                String[] xy = pointsReader.readLine().split(" ");
                Point point = new Point(Float.parseFloat(xy[0]), Float.parseFloat(xy[1]));
                System.out.print(isInCircle(circle, point) + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int isInCircle(Circle circle, Point point) {
        double dist = Math.sqrt(Math.pow(point.x - circle.x, 2) + Math.pow(point.y - circle.y, 2));
        return dist > circle.radius ? 2 : dist < circle.radius ? 1 : 0;
    }

    static class Circle {
        float x, y;
        int radius;

        public Circle(float x, float y, int radius) {
            this.x = x;
            this.y = y;
            this.radius = radius;
        }
        private static Circle getCircle(String[] center, int radius) {
            return new Circle(Float.parseFloat(center[0]), Float.parseFloat(center[1]), radius);
        }
    }

    static class Point {
        float x;
        float y;

        public Point(float x, float y) {
            this.x = x;
            this.y = y;
        }
    }
}

