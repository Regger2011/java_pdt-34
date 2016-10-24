package ru.stqua.pft.sandbox;

public class Rectangle {
    public double a;
    public double b;

    /*создаем конструктор*/
    public Rectangle (double a, double b){
        this.a=a;
        this.b=b;
    /*конец конструктора*/
    }
    public double Measures() {
        return this.a*this.b;
    }
}
