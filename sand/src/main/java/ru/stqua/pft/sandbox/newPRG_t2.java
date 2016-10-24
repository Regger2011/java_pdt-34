package ru.stqua.pft.sandbox;

public class newPRG_t2 {
    public static void main(String[] args) {

        double x1 = 1;
        double y1 = 2;
        double x2 = 3;
        double y2 = 4;
        double d;

        d = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        System.out.println("Расстояние между точками p1" + "(" + x1 + ";" + y1 + ")" + " и " + "p2" + "(" + x2 + ";" + y2 + ")" + " равно " + d); /* вывод результата */
        /*d2=Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2)+Math.pow((z1-z2),2)); /*трехмерная плоскость*/
    }
}
