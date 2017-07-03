package chapter10.composition.and.inheritance.java.comparison;

public class Rectangle extends Rectangular {

    public Rectangle(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    @Override
    public Point topLeft() {
        return topLeft;
    }

    @Override
    public Point bottomRight() {
        return bottomRight;
    }
}
