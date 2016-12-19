package ru.stqa.pft.sandbox;

public class Equality {
    public static void main (String[] args) {
        String str1 = "Firefox";
        String str2 = str1;
        System.out.println("\n");
        System.out.println("Используя присваивание: str2 = str1");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Используя функцию сравнения значенний str1 = " + str1 + " и str2 = " + str2 + " получим значение равное - " + (str1==str2));
        //System.out.println(str1==str2);
        System.out.println("Используя функцию EQUALS для значенний str1 = " + str1 + " и str2 = " + str2 + " получим значение равное - " + (str1.equals(str2)));
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        //System.out.println(str1.equals(str2));

        String str3 = new String (str1);
        System.out.println("\n");
        System.out.println("Используя передачу значения: str3 = new String (str1)");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Используя функцию сравнения значенний str1 = " + str1 + " и str3 = " + str3 + " получим значение равное - " + (str1==str3));
        System.out.println("Используя функцию EQUALS для значенний str1 = " + str1 + " и str3 = " + str3 + " получим значение равное - " + (str1.equals(str3)));
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");

        String str4 = "Firefox";
        System.out.println("\n");
        System.out.println("Используя заданные одинаковые значения для str1 и str4)");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Используя функцию сравнения значенний str1 = " + str1 + " и str4 = " + str4 + " получим значение равное - " + (str1==str4));
        System.out.println("Используя функцию EQUALS для значенний str1 = " + str1 + " и str4 = " + str4 + " получим значение равное - " + (str1.equals(str4)));
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
    }
}
