package ru.stqa.pft.sandbox;

public class Primes {
    public static boolean isPrimeFor(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeWhile1(int n) {
        int i = 2;
        while (i < n) {
            if (n % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }
    public static boolean isPrimeWhile2(int n) {
        int i = 2;
        while (i < n && n % i != 0) {
          i++;
        }
        return i==n;
    }

    public static boolean isPrimeForLong(long n) {
        for (long i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeWhileLong1(long n) {
        long i = 2;
        while (i < n) {
            if (n % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }
    public static boolean isPrimeWhileLong2(long n) {
        long i = 2;
        while (i < n && n % i != 0) {
            i++;
        }
        return i==n;
    }

    public static boolean isPrimeFor2Faster(int n) {
        for (int i = 2; i < n/2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeForMFaster(int n) {
        int m = (int) Math.sqrt (n);
        for (int i = 2; i < m; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
