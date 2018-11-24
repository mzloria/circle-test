/*
 * TCSS 305 Autumn 2018
 * Assignment 1
 */

package tests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.geom.Point2D;
import org.junit.Before;
import org.junit.Test;
import shapes.Circle;

/**
 * This contains tests of the circle class.
 * 
 * @author Michael Zachary Loria
 * @version October 10 2018
 */
public class CircleTest
{
    /**
     * This is the tolerance that is used when comparing doubles.
     */
    private static final double TOLERANCE = .000001;

    /**
     * The circle that will be used in the tests.
     */
    private Circle myCircle;

    /**
     * This is the method that initializes myCircle before each test.
     */
    @Before // This method runs before each test method.
    public void setUp()
    {
        myCircle = new Circle();
    }

    /**
     * Test method of the constructor with three arguments when the radius
     * argument is less than 0.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegativeRadius()
    {
        new Circle(-2.0, new Point2D.Double(0.0, 0.0), Color.BLACK);
    }
    
    /**
     * Test method of the constructor with three arguments when the center
     * argument is null.
     */
    @Test(expected = NullPointerException.class)
    public void testConstructorCenterNull()
    {
        new Circle(1.0, null, Color.BLACK);
    }
    
    /**
     * Test method of the constructor with three arguments when the color
     * argument is null.
     */
    @Test(expected = NullPointerException.class)
    public void testConstructorColorNull()
    {
        new Circle(1.0, new Point2D.Double(0.0, 0.0), null);
    }
    

    /**
     * Test method for {@link shapes.Circle#setRadius(double)}.
     */
    @Test
    public void testSetRadius()
    {
        myCircle.setRadius(7.55);
        assertEquals(7.55, myCircle.getRadius(), TOLERANCE);
    }

    /**
     * Test method for setRadius(theRadius) when the argument is less than 0.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetRadiusNegative()
    {
        myCircle.setRadius(-55);
    }

    /**
     * Test method for {@link shapes.Circle#setCenter(java.awt.geom.Point2D)}.
     */
    @Test
    public void testSetCenter()
    {
        myCircle.setCenter(new Point2D.Double(5.5, 3.5));
        assertEquals(new Point2D.Double(5.5, 3.5), myCircle.getCenter());
    }
    
    /**
     * Test method for setCenter(thePoint) when the argument is null.
     */
    @Test(expected = NullPointerException.class)
    public void testSetCenterNull()
    {
        myCircle.setCenter(null);
    }

    /**
     * Test method for {@link shapes.Circle#setColor(java.awt.Color)}.
     */
    @Test
    public void testSetColor()
    {
        myCircle.setColor(Color.RED);
        assertSame(Color.RED, myCircle.getColor());
    }
    
    /**
     * Test method for setColor(theColor) when the argument is null.
     */
    @Test(expected = NullPointerException.class)
    public void testSetColorNull()
    {
        myCircle.setColor(null);
    }

    /**
     * Test method for {@link shapes.Circle#calculateDiameter()}.
     */
    @Test
    public void testCalculateDiameter()
    {
        final Circle circleOne = new Circle(20, new Point2D.Double(0.0, 0.0), Color.BLACK);
        assertEquals(40, circleOne.calculateDiameter(), TOLERANCE);
    }

    /**
     * Test method for {@link shapes.Circle#calculateCircumference()}.
     */
    @Test
    public void testCalculateCircumference()
    {
        myCircle.setRadius(25);
        assertEquals(2 * myCircle.getRadius() * Math.PI, myCircle.calculateCircumference(),
                     TOLERANCE);
    }

    /**
     * Test method for {@link shapes.Circle#calculateArea()}.
     */
    @Test
    public void testCalculateArea()
    {
        myCircle.setRadius(4);
        assertEquals(Math.pow(myCircle.getRadius(), 2) * Math.PI, myCircle.calculateArea(),
                     TOLERANCE);
    }

    /**
     * Test method for {@link shapes.Circle#toString()}.
     */
    @Test
    public void testToString()
    {
        assertEquals("Circle [radius=1.00, center=Point2D.Double[0.0, 0.0], "
                        + "color=java.awt.Color[r=0,g=0,b=0]]", myCircle.toString());
    }

}
