package lab5;
import java.util.ArrayList;
import java.util.Scanner;

// Base class
abstract class Shape {
    public abstract void display();
}

// Line subclass
class Line extends Shape {
    int length;

    public Line(int length) {
        this.length = length;
    }

    @Override
    public void display() {
        System.out.println("length: " + length);
        for (int i = 0; i < length; i++) System.out.print("-");
        System.out.println();
    }
}

// Rectangle subclass
class Rectangle extends Shape {
    int width, height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void display() {
        System.out.println("Width: " + width + ", Height: " + height);
        for (int i = 0; i < height; i++) {
            if (i == 0 || i == height - 1) {
                for (int j = 0; j < width; j++) System.out.print("*");
            } else {
                System.out.print("*");
                for (int j = 0; j < width - 2; j++) System.out.print(" ");
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

// Triangle subclass
class Triangle extends Shape {
    int base;

    public Triangle(int base) {
        this.base = base;
    }

    @Override
    public void display() {
        System.out.println("Base: " + base);
        for (int i = 1; i <= base; i++) {
            for (int j = 0; j < i; j++) System.out.print("*");
            System.out.println();
        }
    }
}

public class ex3 {
    static ArrayList<Line> lines = new ArrayList<>();
    static ArrayList<Rectangle> rectangles = new ArrayList<>();
    static ArrayList<Triangle> triangles = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void viewAllLines() {
        System.out.println("\n==== List all lines ====");
        if (lines.isEmpty()) { System.out.println("No lines found."); return; }
        int no = 1;
        for (Line l : lines) { System.out.print(no++ + ". "); l.display(); System.out.println(); }
    }

    public static void viewAllRectangles() {
        System.out.println("\n==== List all rectangles ====");
        if (rectangles.isEmpty()) { System.out.println("No rectangles found."); return; }
        int no = 1;
        for (Rectangle r : rectangles) { System.out.print(no++ + ". "); r.display(); System.out.println(); }
    }

    public static void viewAllTriangles() {
        System.out.println("\n==== List all triangles ====");
        if (triangles.isEmpty()) { System.out.println("No triangles found."); return; }
        int no = 1;
        for (Triangle t : triangles) { System.out.print(no++ + ". "); t.display(); System.out.println(); }
    }

    public static void addShape() {
        System.out.println("\n==== Add new shape ====");
        System.out.println("Select a shape:");
        System.out.println("1.  Line");
        System.out.println("2.  Rectangle");
        System.out.println("3.  Triangle");
        System.out.print("Choose an opt: ");
        int choice = Integer.parseInt(sc.nextLine().trim());

        switch (choice) {
            case 1:
                System.out.print("Input length: ");
                lines.add(new Line(Integer.parseInt(sc.nextLine().trim())));
                break;
            case 2:
                System.out.print("Input width: ");
                int w = Integer.parseInt(sc.nextLine().trim());
                System.out.print("Input height: ");
                int h = Integer.parseInt(sc.nextLine().trim());
                rectangles.add(new Rectangle(w, h));
                break;
            case 3:
                System.out.print("Input base: ");
                triangles.add(new Triangle(Integer.parseInt(sc.nextLine().trim())));
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n==== Menu ===");
            System.out.println("1.   View all lines");
            System.out.println("2.   View all rectangles");
            System.out.println("3.   View all triangles");
            System.out.println("4.   Add a new shape");
            System.out.println("5.   Quit");
            System.out.print("Choose an opt: ");
            choice = Integer.parseInt(sc.nextLine().trim());

            switch (choice) {
                case 1: viewAllLines(); break;
                case 2: viewAllRectangles(); break;
                case 3: viewAllTriangles(); break;
                case 4: addShape(); break;
                case 5: System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid option.");
            }
        } while (choice != 5);
        sc.close();
    }
}