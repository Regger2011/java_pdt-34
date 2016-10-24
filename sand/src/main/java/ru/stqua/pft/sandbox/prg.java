package ru.stqua.pft.sandbox;

public class prg {
    public static void main(String[] args) {
        /*Hi (" This is Me");
        Hi (" This is U");
        Hi (" What's UP");*/

        Square s = new Square(5.5);
        /*s.l = 10; /* задаем величину стороны квадрата */
        System.out.println("Площадь квадрата со стороной равной " + s.l + " равна " + s.Measures()); /* вывод результата */

        Rectangle sr =new Rectangle(5.8,7.8);
        /*sr.a = 11; /* задаем величину длины прямоугольника */
        /*sr.b = 12; /* задаем величину высоты прямоугольника */
        System.out.println("Площадь прямоугольника со сторонами равными " + sr.a +" и "+sr.b+ " равна " + sr.Measures()); /* вывод результата */
    }
   /* public static void  Hi (String smbd) {
            /* String smbd = " - This is Me";
        System.out.println("Hi, "+smbd+"!!!");
        System.out.println();
        System.out.println("________________________________");
        System.out.println();
    } */



}