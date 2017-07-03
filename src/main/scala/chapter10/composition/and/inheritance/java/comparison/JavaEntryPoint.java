package chapter10.composition.and.inheritance.java.comparison;

public class JavaEntryPoint {
    public static void main(String[] args) {
        Rectangular rectangle = new Rectangle(new Point(3,4), new Point(10, 10));
        System.out.println(rectangle.left());
        System.out.println(rectangle.right());
        System.out.println(rectangle.width());
    }
}
