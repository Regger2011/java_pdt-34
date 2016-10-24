package ru.stqua.pft.sandbox;

public class Square {
    public double l;

    /*создаем конструктор*/
    public Square(double l) {
        this.l = l;
    /*конец конструктора*/
    }

    public double Measures() {
        return this.l * this.l;
    }
}