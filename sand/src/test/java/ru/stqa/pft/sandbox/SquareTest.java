package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareTest {
    @Test
    public void test_SquareArea() {
        Square s = new Square(5);
        assert s.Square_Area()==25.0;
        Assert.assertEquals(s.Square_Area(), 25.0);

    }
}
