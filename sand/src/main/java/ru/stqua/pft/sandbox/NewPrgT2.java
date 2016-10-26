package ru.stqua.pft.sandbox;

public class NewPrgT2 {
    public static void main(String[] args) {
        Point p1 = new Point("тчк1", -1.9, 1/*,y*/);
        Point p2 = new Point("point2", 10, -9.66/*,y*/);
        PointDistance d= new PointDistance (p1, p2);
        System.out.println("Расстояние между точками: " + p1.point_name + "(" + p1.x + ";" + p1.y + /*";" + p1.z-*/")" + " и " + p2.point_name + "(" + p2.x + ";" + p2.y + /*";" + p2.z-*/")" + " равно " + d.distance()); /* вывод результата */
    }
}