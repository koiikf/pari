package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int k0 = 0, k1 = 0, k2 = 0, k3 = 0, k4 = 0;
        int R1 = 1000000, R2 = 1000000, R3 = 1000000, R4 = 1000000;
        int[] A1 = new int[2];
        int[] A2 = new int[2];
        int[] A3 = new int[2];
        int[] A4 = new int[2];

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if (x > 0 && y > 0) {
                k1++;
                int r = Math.min(Math.abs(x), Math.abs(y));
                if (r < R1) {
                    R1 = r;
                    A1[0] = x;
                    A1[1] = y;
                }
            } else if (x < 0 && y > 0) {
                k2++;
                int r = Math.min(Math.abs(x), Math.abs(y));
                if (r < R2) {
                    R2 = r;
                    A2[0] = x;
                    A2[1] = y;
                }
            } else if (x < 0 && y < 0) {
                k3++;
                int r = Math.min(Math.abs(x), Math.abs(y));
                if (r < R3) {
                    R3 = r;
                    A3[0] = x;
                    A3[1] = y;
                }
            } else if (x > 0 && y < 0) {
                k4++;
                int r = Math.min(Math.abs(x), Math.abs(y));
                if (r < R4) {
                    R4 = r;
                    A4[0] = x;
                    A4[1] = y;
                }
            } else {
                k0++;
            }
        }

        List<QuadrantData> quadrants = new ArrayList<>();
        quadrants.add(new QuadrantData(k1, R1, 1, A1));
        quadrants.add(new QuadrantData(k2, R2, 2, A2));
        quadrants.add(new QuadrantData(k3, R3, 3, A3));
        quadrants.add(new QuadrantData(k4, R4, 4, A4));

        Collections.sort(quadrants);

        QuadrantData best = quadrants.get(quadrants.size() - 1);

        System.out.println("K = " + best.quadrant);
        System.out.println("M = " + best.count);
        System.out.println("A = (" + best.point[0] + ", " + best.point[1] + ")");
        System.out.println("R = " + best.radius);
    }

    static class QuadrantData implements Comparable<QuadrantData> {
        int count;
        int radius;
        int quadrant;
        int[] point;

        public QuadrantData(int count, int radius, int quadrant, int[] point) {
            this.count = count;
            this.radius = radius;
            this.quadrant = quadrant;
            this.point = point.clone();
        }

        @Override
        public int compareTo(QuadrantData other) {
            if (this.count != other.count)
                return Integer.compare(this.count, other.count);
            if (this.radius != other.radius)
                return Integer.compare(other.radius, this.radius);
            return Integer.compare(other.quadrant, this.quadrant);
        }
    }
}