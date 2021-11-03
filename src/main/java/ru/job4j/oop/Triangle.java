package ru.job4j.oop;

public class Triangle {
    private Point first;
    private  Point second;
    private Point third;

    public Triangle(Point pointA, Point pointB, Point pointC) {
        this.first = pointA;
        this.second = pointB;
        this.third = pointC;
    }

    public double semiPerimeter(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    public boolean exist(double ab, double ac, double bc) {
        if (ab < ac + bc && ac < ab + bc && bc < ac + ab) {
            return true;
        }
        return false;
    }

    public double area() {
        double rsl = -1;
        double ab = first.distance(second);
        double ac = first.distance(third);
        double bc = second.distance(third);
        if (this.exist(ab, ac, bc)) {
            double p = semiPerimeter(ab, ac, bc);
            rsl = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }
}
