package task1;

public class Solution {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        StringBuilder result = new StringBuilder();
        int i = 1;

        do {
            result.append(i);
            i = next(i, m, n);
        } while (i != 1);
        System.out.println(result);

    }

    public static int next(int i, int m, int n) {
        return 1 + (i + m - 2) % n;
    }
}
