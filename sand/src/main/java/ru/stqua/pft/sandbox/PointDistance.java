package ru.stqua.pft.sandbox;

public class PointDistance {
    Point p1;
    Point p2;

    public PointDistance(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public double distance_PointDistance() {
        return Math.sqrt(Math.pow(this.p2.x - this.p1.x, 2) + Math.pow((this.p2.y - this.p1.y), 2)+ Math.pow((this.p2.z - this.p1.z), 2));
    }
}