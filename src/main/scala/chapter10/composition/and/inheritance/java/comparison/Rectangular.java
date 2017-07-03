package chapter10.composition.and.inheritance.java.comparison;

public abstract class Rectangular implements IRectangular{
    protected Point topLeft;
    protected Point bottomRight;

    public int left() { return topLeft().getX(); }
    public int right() { return bottomRight().getX(); }
    public int width() { return left() - right(); }
}
