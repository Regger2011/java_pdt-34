package ru.stqua.pft.sandbox;

public class NewPrgT2 {
    public static void main(String[] args) {
        Point p1 = new Point("тчк1",0,0/*,y*/);
        Point p2 = new Point("point2",10,0/*,y*/);
        System.out.println("Расстояние между точками: " + p1.point_name + "(" + p1.x + ";" + p1.y + /*";" + p1.z-*/")" + " и " + p2.point_name + "(" + p2.x + ";" + p2.y + /*";" + p2.z-*/")" + " равно " + distance(p1, p2)); /* вывод результата */
    }

    public static double distance(Point p1, Point p2){
    return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));

    }
}
