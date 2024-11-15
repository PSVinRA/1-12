package B;
import java.util.*;
//Романов Альберт Б762-2 Вариант 9
class Circle {
    private double x;
    private double y;
    private double radius;

    public Circle(double x, double y, double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус должен быть положительным числом.");
        }
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public Circle() {
        this(0, 0, 1);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
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

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return String.format("Circle(center=(%.2f, %.2f), radius=%.2f, area=%.2f, perimeter=%.2f)",
                x, y, radius, getArea(), getPerimeter());
    }
}

class CircleDemo {
    public static List<List<Circle>> groupCirclesOnSameLine(List<Circle> circles) {
        List<List<Circle>> groups = new ArrayList<>();
        for (int i = 0; i < circles.size(); i++) {
            Circle reference = circles.get(i);
            List<Circle> group = new ArrayList<>();
            group.add(reference);

            for (int j = 0; j < circles.size(); j++) {
                if (i != j) {
                    Circle current = circles.get(j);
                    if (isCollinear(reference, current)) {
                        group.add(current);
                    }
                }
            }

            if (!groups.contains(group)) {
                groups.add(group);
            }
        }
        return groups;
    }

    private static boolean isCollinear(Circle c1, Circle c2) {
        return c1.getX() == c2.getX() || c1.getY() == c2.getY();
    }

    public static Circle findCircleByArea(List<Circle> circles, boolean findMax) {
        return circles.stream()
                .max(Comparator.comparingDouble(c -> findMax ? c.getArea() : -c.getArea()))
                .orElse(null);
    }

    public static Circle findCircleByPerimeter(List<Circle> circles, boolean findMax) {
        return circles.stream()
                .max(Comparator.comparingDouble(c -> findMax ? c.getPerimeter() : -c.getPerimeter()))
                .orElse(null);
    }

    public static void main(String[] args) {
        List<Circle> circles = Arrays.asList(
                new Circle(0, 0, 5),
                new Circle(0, 1, 2),
                new Circle(1, 0, 3),
                new Circle(0, 0, 2),
                new Circle(1, 1, 1),
                new Circle(2, 2, 4)
        );

        System.out.println("Все окружности:");
        circles.forEach(System.out::println);

        System.out.println("\nГруппы окружностей с центрами на одной прямой:");
        List<List<Circle>> groups = groupCirclesOnSameLine(circles);
        for (List<Circle> group : groups) {
            System.out.println(group);
        }

        Circle maxAreaCircle = findCircleByArea(circles, true);
        Circle minAreaCircle = findCircleByArea(circles, false);
        System.out.println("\nОкружность с максимальной площадью: " + maxAreaCircle);
        System.out.println("Окружность с минимальной площадью: " + minAreaCircle);

        Circle maxPerimeterCircle = findCircleByPerimeter(circles, true);
        Circle minPerimeterCircle = findCircleByPerimeter(circles, false);
        System.out.println("\nОкружность с максимальным периметром: " + maxPerimeterCircle);
        System.out.println("Окружность с минимальным периметром: " + minPerimeterCircle);
    }
}
