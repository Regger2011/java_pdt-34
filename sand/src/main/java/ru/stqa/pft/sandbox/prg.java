package ru.stqa.pft.sandbox;

public class prg {
    public static void main(String[] args) {
        Point p1 = new Point("тчк1", 0, 0, 0);
        Point p2 = new Point("point2", 10, 0, 0);
        PointDistance d = new PointDistance(p1, p2);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Использование функции из основного класса prg");
        System.out.println("Расстояние между точками: " + p1.point_name + "(" + p1.x + ";" + p1.y + ";" + p1.z + ")" + " и " + p2.point_name + "(" + p2.x + ";" + p2.y + ";" + p2.z + ")" + " в трёхмерном пространстве равно " + distance_Main(p1, p2));
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Использование метода из класса Point");
        System.out.println("Расстояние между точками: " + p1.point_name + "(" + p1.x + ";" + p1.y + ";" + p1.z + ")" + " и " + p2.point_name + "(" + p2.x + ";" + p2.y + ";" + p2.z + ")" + " в трёхмерном пространстве равно " + p1.distance_Point(p2));
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Использование метода из класса PointDistance");
        System.out.println("Расстояние между точками: " + p1.point_name + "(" + p1.x + ";" + p1.y + ";" + p1.z + ")" + " и " + p2.point_name + "(" + p2.x + ";" + p2.y + ";" + p2.z + ")" + " в трёхмерном пространстве равно " + d.distance_PointDistance());
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
    }

    public static double distance_Main(Point p1, Point p2) {
        return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2)+Math.pow((p2.z-p1.z),2));
    }

}