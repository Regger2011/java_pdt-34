package ru.stqua.pft.sandbox;

public class prg {
    public static void main(String[] args) {
        Hi (" This is Me");
        Hi (" This is U");
        Hi (" What's UP");
        double l = 10; /* задаем величину стороны квадрата */
        double a = 11; /* задаем величину длины прямоугольника */
        System.out.println("Площадь квадрата со стороной равной " + l + " равна " + Measures(l)); /* вывод результата */
        double b = 12; /* задаем величину высоты прямоугольника */
        System.out.println("Площадь прямоугольника со сторонами равными " + a +" и "+b+ " равна " + Measures(a,b)); /* вывод результата */
    }
    public static void  Hi (String smbd) {
            /* String smbd = " - This is Me"; */
        System.out.println("Hi, "+smbd+"!!!");
        System.out.println();
        System.out.println("________________________________");
        System.out.println();
    }
    public static double Measures(double l) {
        return l*l;
            /*double s = l * l; /* задаем формулу расчета площади квадрата */
            /*double p = 4 * l; /* задаем формулу расчета периметра квадрата */
            /*System.out.println("Площадь квадрата со стороной равной " + l + " равна " + s); /* вывод результата */
            /*System.out.println("Периметр квадрата со стороной равной " + l + " равен " + p); /* вывод результата */
    }
    public static double Measures(double a,double b) {
        return a*b;
            /*double s = l * l; /* задаем формулу расчета площади квадрата */
            /*double p = 4 * l; /* задаем формулу расчета периметра квадрата */
            /*System.out.println("Площадь квадрата со стороной равной " + l + " равна " + s); /* вывод результата */
            /*System.out.println("Периметр квадрата со стороной равной " + l + " равен " + p); /* вывод результата */
    }
}