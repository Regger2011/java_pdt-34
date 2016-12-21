package ru.stqa.pft.sandbox;

import java.util.Arrays;
import java.util.List;

public class Collections {
    public static void main (String [] args) {
/* Вариант 1 объявления элементов
        String[] langs = new String[4];
        langs[0]="Java";
        langs[1]="C#";
        langs[2]="Python";
        langs[3]="PHP";
*/

// Вариант 2 объявления элементов
        String[] langs = {"Java","C#","Python","PHP"};
        /*
        for (int i=0; i < langs.length; i++) {
            System.out.println("I want to belive in power of - " + langs[i]);
       }*/
/* Вариант 1 задания элементов коллекции
        List<String> languages= new ArrayList<String>();
        languages.add ("Java");
        languages.add("C#");
        languages.add ("Python");
        languages.add("PHP");
*/
// Вариант 2 задания элементов коллекции

        List<String> languages =  Arrays.asList("Java","C#","Python","PHP");

        for (String l : languages) {
            System.out.println("I want to belive in power of " + l);
        }
/* Некрасивый но рабочий вариант
        for (int i = 0; i < languages.size(); i++) {
            System.out.println("I want to belive in power of " + languages.get(i));
        }*/
    }
}
