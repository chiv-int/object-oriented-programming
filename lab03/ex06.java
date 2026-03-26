package lab03;

public class ex06 {

    public class Math2 {

    public static long factorial(int n) {
        if (n < 0) {
            System.out.println("Error: Negative number!");
            return -1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static double rectangleSurface(double width, double height) {
        return width * height;
    }

    public static double circleSurface(double radius) {
        return java.lang.Math.PI * radius * radius;
    }

    public static double max(double a, double b, double c, double d, double e) {
        double max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        if (d > max) max = d;
        if (e > max) max = e;
        return max;
    }

    public static double min(double a, double b, double c, double d, double e) {
        double min = a;
        if (b < min) min = b;
        if (c < min) min = c;
        if (d < min) min = d;
        if (e < min) min = e;
        return min;
    }
}
    public static void main(String[] args) {

        System.out.println("factorial(5)              = " + Math2.factorial(5));
        System.out.println("rectangleSurface(4, 6)    = " + Math2.rectangleSurface(4, 6));
        System.out.printf ("circleSurface(7)          = %.2f%n", Math2.circleSurface(7));
        System.out.println("max(3,1,9,5,7)            = " + Math2.max(3, 1, 9, 5, 7));
        System.out.println("min(3,1,9,5,7)            = " + Math2.min(3, 1, 9, 5, 7));
    }
    
}
