package ru.stqua.pft.sandbox;
// класс определяющий точку
public class Point {
    String point_name; //название точки
    double x; // координата по оси X
    double y; // координата по оси Y
    //double z; // координата по оси Z
    public Point (String point_name,double x,double y/*,*double z*/){
        this.point_name=point_name; //название точки
        this.x=x; // координата по оси X
        this.y=y; // координата по оси Y
        //this.z=z; // координата по оси Z
    }
}
