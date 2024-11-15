package A;
//Романов Альберт Б762-2 Вариант 9
class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(x) * 31 + Double.hashCode(y);
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", x, y);
    }
}

class Circle {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус должен быть положительным числом.");
        }
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус должен быть положительным числом.");
        }
        this.radius = radius;
    }

    public void moveCenter(double dx, double dy) {
        center = new Point(center.getX() + dx, center.getY() + dy);
    }

    public boolean isPointInside(Point point) {
        double distance = Math.sqrt(Math.pow(point.getX() - center.getX(), 2) + Math.pow(point.getY() - center.getY(), 2));
        return distance <= radius;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Circle circle = (Circle) obj;
        return Double.compare(circle.radius, radius) == 0 && center.equals(circle.center);
    }

    @Override
    public int hashCode() {
        return center.hashCode() * 31 + Double.hashCode(radius);
    }

    @Override
    public String toString() {
        return String.format("Круг(Центр: %s, Радиус: %.2f)", center, radius);
    }
}

public class A {
    public static void main(String[] args) {
        Point center = new Point(0, 0);
        Circle circle = new Circle(center, 5);

        System.out.println(circle);

        circle.setRadius(10);
        System.out.println("Радиус изменён: " + circle);

        circle.moveCenter(2, 3);
        System.out.println("Центр перемещён: " + circle);

        Point pointInside = new Point(2, 3);
        Point pointOutside = new Point(15, 15);
        System.out.println("Точка " + pointInside + " принадлежит кругу? " + circle.isPointInside(pointInside));
        System.out.println("Точка " + pointOutside + " принадлежит кругу? " + circle.isPointInside(pointOutside));
    }
}

