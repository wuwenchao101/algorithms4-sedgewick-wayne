package com.chao.chapter1.session2;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 1.2.1
 * Write a Point2D client that takes an integer value N from the command line,
 * generates N random points in the unit square,
 * and computes the distance separating the closest pair of points.
 */
public class Exercise1_Point2D_closet_pair extends Throwable {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        Point2D[] point2DS = new Point2D[n];
        createPoint2D(point2DS);
        drawPoint2D(point2DS);

        StdOut.printf("Compute the distance of the closest pair of points: %8.4f", computeClosest(point2DS));
    }

    private static void createPoint2D(Point2D[] point2DS) {
        for (int i = 0; i < point2DS.length; i++) {
            double x = StdRandom.uniform();
            double y = StdRandom.uniform();
            point2DS[i] = new Point2D(x, y);
        }
    }

    private static void drawPoint2D(Point2D[] point2DS) {
        StdDraw.setCanvasSize(300, 300);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.01);
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);

        // Replace
        // { for (int i = 0; i < point2DS.length; i++) {StdDraw.point(point2DS[i].x(), point2DS[i].y());} }
        // with enhanced "for"
        for (Point2D point2D : point2DS) {
            StdDraw.point(point2D.x(), point2D.y());
        }
    }

    private static double computeClosest(Point2D[] point2DS) {
        double closest = Double.MAX_VALUE;
        double distance;
        for (int i = 0; i < point2DS.length; i++) {
            for (int j = i + 1; j < point2DS.length; j++) {
                distance = point2DS[i].distanceTo(point2DS[j]);
                if (distance < closest) {
                    closest = distance;
                }
            }
        }
        return closest;
    }
}
