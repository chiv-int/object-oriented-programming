package lab04;

class Point {
    double x, y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    void displayPoint() {
        System.out.println("Point: (" + x + ", " + y + ")");
    }
}

class Line extends Point {
    double length;

    Line(double x, double y, double length) {
        super(x, y);
        this.length = length;
    }

    void displayLine() {
        System.out.println("Line: start=(" + x + ", " + y + "), length=" + length);
    }
}

class Triangle extends Line {
    double base, height;

    Triangle(double x, double y, double length, double base, double height) {
        super(x, y, length);
        this.base = base;
        this.height = height;
    }

    double area() {
        return 0.5 * base * height;
    }

    void displayTriangle() {
        System.out.println("Triangle: base=" + base + ", height=" + height
                + ", area=" + area());
    }
}

class Rectangle extends Triangle {
    double width;

    Rectangle(double x, double y, double length, double base,
              double height, double width) {
        super(x, y, length, base, height);
        this.width = width;
    }

    double rectArea() {
        return base * width;
    }

    void displayRectangle() {
        System.out.println("Rectangle: base=" + base + ", width=" + width
                + ", area=" + rectArea());
    }
}
class ITStudent {
    String name;
    int id;
    String major;

    ITStudent(String name, int id, String major) {
        this.name = name;
        this.id = id;
        this.major = major;
    }

    void displayInfo() {
        System.out.println("IT Student: " + name + " | ID: " + id
                + " | Major: " + major);
    }
}

class ProgrammingStudent extends ITStudent {
    String programmingLanguage;

    ProgrammingStudent(String name, int id, String programmingLanguage) {
        super(name, id, "Programming");
        this.programmingLanguage = programmingLanguage;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("  Language: " + programmingLanguage);
    }
}

class TelecomStudent extends ITStudent {
    String networkType;

    TelecomStudent(String name, int id, String networkType) {
        super(name, id, "Telecom");
        this.networkType = networkType;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("  Network: " + networkType);
    }
}
        
public class ex07 {
    public static void main(String[] args) {

        System.out.println("===== Multiple Inheritance: Point -> Line -> Triangle -> Rectangle =====");

        Point p = new Point(1, 2);
        p.displayPoint();

        Line l = new Line(0, 0, 10);
        l.displayLine();

        Triangle t = new Triangle(0, 0, 5, 6, 4);
        t.displayTriangle();

        Rectangle r = new Rectangle(0, 0, 5, 8, 4, 3);
        r.displayRectangle();

        System.out.println();
        System.out.println("===== Hierarchical Inheritance: ITStudent -> Programming / Telecom =====");

        ITStudent it = new ITStudent("Sokha", 1001, "General IT");
        it.displayInfo();

        ProgrammingStudent ps = new ProgrammingStudent("Dara", 1002, "Java");
        ps.displayInfo();

        TelecomStudent ts = new TelecomStudent("Sreyla", 1003, "5G");
        ts.displayInfo();
    }
}