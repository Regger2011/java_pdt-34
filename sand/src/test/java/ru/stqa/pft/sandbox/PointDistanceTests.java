package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointDistanceTests {
    @Test
    public void testPointDistance() {
        Point p1 = new Point("тчк1", 0, 0, 0);
        Point p2 = new Point("point2", 22, 0, 0);

        prg d1 = new prg();
        assert d1.distance_Main(p1, p2) == 22.0;
        Assert.assertEquals(d1.distance_Main(p1, p2), 22.0);

        assert p1.distance_Point(p2) == 22.0;
        Assert.assertEquals(p1.distance_Point(p2), 22.0);

        PointDistance d3 = new PointDistance(p1, p2);
        assert d3.distance_PointDistance() == 22.0;
        Assert.assertEquals(d3.distance_PointDistance(), 22.0);
    }
}