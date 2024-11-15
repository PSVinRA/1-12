package С;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Comparator;
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

    public double distanceTo(Point other) {
        return Math.sqrt(Math.pow(other.x - this.x, 2) + Math.pow(other.y - this.y, 2));
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", x, y);
    }
}

class Triangle {
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private double sideAB;
    private double sideBC;
    private double sideCA;

    public Triangle(Point pointA, Point pointB, Point pointC) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.sideAB = pointA.distanceTo(pointB);
        this.sideBC = pointB.distanceTo(pointC);
        this.sideCA = pointC.distanceTo(pointA);
    }

    public double getPerimeter() {
        return sideAB + sideBC + sideCA;
    }

    public double getArea() {
        double semiPerimeter = getPerimeter() / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - sideAB) * (semiPerimeter - sideBC) * (semiPerimeter - sideCA));
    }

    public String getType() {
        if (Double.compare(sideAB, sideBC) == 0 && Double.compare(sideBC, sideCA) == 0) {
            return "Равносторонний";
        } else if (Double.compare(sideAB, sideBC) == 0 || Double.compare(sideBC, sideCA) == 0 || Double.compare(sideCA, sideAB) == 0) {
            return "Равнобедренный";
        } else if (isRight()) {
            return "Прямоугольный";
        } else {
            return "Произвольный";
        }
    }

    private boolean isRight() {
        double a = Math.pow(sideAB, 2);
        double b = Math.pow(sideBC, 2);
        double c = Math.pow(sideCA, 2);
        return Double.compare(a + b, c) == 0 || Double.compare(a + c, b) == 0 || Double.compare(b + c, a) == 0;
    }

    @Override
    public String toString() {
        return String.format("Треугольник(%s, %s, %s) - Тип: %s, Площадь: %.2f, Периметр: %.2f",
                pointA, pointB, pointC, getType(), getArea(), getPerimeter());
    }
}

class TriangleDemo {
    public static void main(String[] args) {
        List<Triangle> triangles = Arrays.asList(
                new Triangle(new Point(0, 0), new Point(1, 1), new Point(1, 0)),
                new Triangle(new Point(0, 0), new Point(2, 2), new Point(2, 0)),
                new Triangle(new Point(1, 1), new Point(4, 1), new Point(2.5, Math.sqrt(6.75))),
                new Triangle(new Point(2, 2), new Point(5, 2), new Point(3.5, 2 + Math.sqrt(6.75))),
                new Triangle(new Point(0, 0), new Point(4, 0), new Point(2, Math.sqrt(12))),
                new Triangle(new Point(1, 2), new Point(3, 5), new Point(5, 2)),
                new Triangle(new Point(2, 0), new Point(4, 4), new Point(6, 0)),
                new Triangle(new Point(0, 0), new Point(6, 0), new Point(3, 5.2)),
                new Triangle(new Point(0, 0), new Point(1.5, 0), new Point(0.75, 1.3)),
                new Triangle(new Point(0, 0), new Point(3, 0), new Point(1.5, Math.sqrt(6.75)))

        );

        Map<String, List<Triangle>> trianglesByType = triangles.stream()
                .collect(Collectors.groupingBy(Triangle::getType));

        for (String type : trianglesByType.keySet()) {
            List<Triangle> group = trianglesByType.get(type);
            System.out.println("\nТип: " + type);
            System.out.println("Количество: " + group.size());

            if (group.size() > 1) {
                Triangle maxArea = group.stream().max(Comparator.comparingDouble(Triangle::getArea)).orElse(null);
                Triangle minArea = group.stream().min(Comparator.comparingDouble(Triangle::getArea)).orElse(null);
                System.out.println("Наибольший по площади: " + maxArea);
                System.out.println("Наименьший по площади: " + minArea);

                Triangle maxPerimeter = group.stream().max(Comparator.comparingDouble(Triangle::getPerimeter)).orElse(null);
                Triangle minPerimeter = group.stream().min(Comparator.comparingDouble(Triangle::getPerimeter)).orElse(null);
                System.out.println("Наибольший по периметру: " + maxPerimeter);
                System.out.println("Наименьший по периметру: " + minPerimeter);
            } else {
                System.out.println("Треугольник: " + group.get(0));
            }
        }
    }
}
