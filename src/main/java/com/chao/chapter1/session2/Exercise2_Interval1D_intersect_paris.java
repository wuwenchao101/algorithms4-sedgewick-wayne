package com.chao.chapter1.session2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 *  1.2.2
 *  Write an Interval1D client that takes an int value N as command-line argument,
 *  reads N intervals (each defined by a pair of double values) from standard input,
 *  and prints all pairs that intersect.
 */
public class Exercise2_Interval1D_intersect_paris {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);  // 5
        Interval1D[] interval1DS = new Interval1D[n];

        createInterval1DArray(interval1DS);

        printIntersect(interval1DS);
    }

    private static void printIntersect(Interval1D[] interval1DS) {
        for (int i = 0; i < interval1DS.length; i++) {
            for (int j = i + 1; j < interval1DS.length; j++) {
                if (interval1DS[i].intersects(interval1DS[j])) {
                    StdOut.printf(interval1DS[i] + " intersect " + interval1DS[j] + "\n");
                }
            }
        }
    }

    private static void createInterval1DArray(Interval1D[] interval1DS) {
        int n = interval1DS.length;
        StdOut.printf("Please input %s pairs of Double numbers: \n", n); // 2 3 3 4 4 5 5 6 2 6
        String ss = StdIn.readLine();
        String[] s = ss.split("\\s");
        for (int i = 0; i < n; i++) {
            int start = Integer.parseInt(s[2 * i]);
            int end = Integer.parseInt(s[2 * i + 1]);
            if (start > end) {
                int end1 = end;
                end = start;
                start = end1;
            }
            interval1DS[i] = new Interval1D(start, end);
            StdOut.print(interval1DS[i]);
        }
        StdOut.println();
    }
}
