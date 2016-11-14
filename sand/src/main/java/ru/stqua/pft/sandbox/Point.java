package ru.stqua.pft.sandbox;

public class Point {
    String point_name;
    double x;
    double y;
    double z;

    public Point(String point_name, double x, double y, double z) {
        this.point_name = point_name;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double distance_Point(Point p2) {
        return Math.sqrt(Math.pow(p2.x - this.x, 2) + Math.pow(p2.y - this.y, 2) + Math.pow(p2.z - this.z, 2));
    }
}