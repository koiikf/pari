package org.example;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> numbers = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader("17.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            numbers.add(Integer.parseInt(line));
        }
        br.close();

        int min3digitDiv7 = 999;
        int min4digit = 9999;

        for (int num : numbers) {
            if (num % 7 == 0 && Math.abs(num) >= 100 && Math.abs(num) <= 999) {
                min3digitDiv7 = Math.min(min3digitDiv7, num);
            }
            if (Math.abs(num) >= 1000 && Math.abs(num) <= 9999) {
                min4digit = Math.min(min4digit, num);
            }
        }

        int count = 0;
        int maxSum = 0;
        int targetLastDigit = Math.abs(min4digit) % 10;

        for (int i = 0; i < numbers.size() - 1; i++) {
            int n1 = numbers.get(i);
            int n2 = numbers.get(i + 1);
            if ((n1 < min3digitDiv7 || n2 < min3digitDiv7) && (Math.abs((long) n1 * n2) % 10 == targetLastDigit)) {
                maxSum = Math.max(maxSum, n1 + n2);
                count++;
            }
        }


        System.out.println(count + " " + maxSum);
    }
}