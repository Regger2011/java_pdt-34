package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {
    @Test(enabled = false)
    public void testPrimeFor () {
        Assert.assertTrue(Primes.isPrimeFor(Integer.MAX_VALUE));
    }
    @Test(enabled = false)
    public void testNonPrimesFor () {
        Assert.assertFalse(Primes.isPrimeFor(Integer.MAX_VALUE-2));
    }
    @Test(enabled = false)
    public void testPrimesWhile1 () {
        Assert.assertTrue(Primes.isPrimeWhile1(Integer.MAX_VALUE));
    }
    @Test(enabled = false)
    public void testNonPrimesWhile1 () {
        Assert.assertFalse(Primes.isPrimeWhile1(Integer.MAX_VALUE-2));
    }
    @Test(enabled = false)
    public void testPrimesWhile2 () {
        Assert.assertTrue(Primes.isPrimeWhile2(Integer.MAX_VALUE));
    }
    @Test(enabled = false)
    public void testNonPrimesWhile2 () {
        Assert.assertFalse(Primes.isPrimeWhile2(Integer.MAX_VALUE-2));
    }
    @Test(enabled = false)
    public void testPrimeForLong () {
        long n = Integer.MAX_VALUE;
        Assert.assertTrue(Primes.isPrimeForLong(n));
    }
    @Test(enabled = false)
    public void testNonPrimesForLong () {
        long n = Integer.MAX_VALUE-2;
        Assert.assertFalse(Primes.isPrimeForLong(n));
    }
    @Test(enabled = false)
    public void testPrimesWhileLong1 () {
        long n = Integer.MAX_VALUE;
        Assert.assertTrue(Primes.isPrimeWhileLong1(n));
    }
    @Test(enabled = false)
    public void testNonPrimesWhileLong1 () {
        long n = Integer.MAX_VALUE-2;
        Assert.assertFalse(Primes.isPrimeWhileLong1(n));
    }
    @Test(enabled = false)
    public void testPrimesWhileLong2 () {
        long n = Integer.MAX_VALUE;
        Assert.assertTrue(Primes.isPrimeWhileLong2(n));
    }
    @Test(enabled = false)
    public void testNonPrimesWhileLong2 () {
        long n = Integer.MAX_VALUE-2;
        Assert.assertFalse(Primes.isPrimeWhileLong2(n));
    }
    @Test(enabled = false)
    public void testPrimeFor2Faster () {
        Assert.assertTrue(Primes.isPrimeFor2Faster(Integer.MAX_VALUE));
    }
    @Test(enabled = true)
    public void testPrimeForMFaster () {
        Assert.assertTrue(Primes.isPrimeForMFaster(Integer.MAX_VALUE));
    }
}
