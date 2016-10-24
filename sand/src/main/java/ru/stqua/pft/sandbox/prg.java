package ru.stqua.pft.sandbox;

public class prg {
    public static void main(String[] args) {

        Square s = new Square(5.5);/* задаем величину стороны квадрата */
        System.out.println("Площадь квадрата со стороной равной " + s.l + " равна " + s.Measures()); /* вывод результата */

        Rectangle sr =new Rectangle(5.8,7.8);/* задаем величину длины и ширины прямоугольника */
        System.out.println("Площадь прямоугольника со сторонами равными " + sr.a +" и "+sr.b+ " равна " + sr.Measures()); /* вывод результата */
    }

}