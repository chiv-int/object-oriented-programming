package lab03;

public class ex05 {
     public static void main(String[] args) {

        System.out.println("add(5, 7)      = " + Math.add(5, 7));
        System.out.println("subtract(5, 7) = " + Math.subtract(5, 7));
        System.out.println("multiply(5, 7) = " + Math.multiply(5, 7));
        System.out.println("divide(10, 2)  = " + Math.divide(10, 2));
        System.out.println("min(5, 7)      = " + Math.min(5, 7));
        System.out.println("max(5, 7)      = " + Math.max(5, 7));
    }
    public class Math {
        public static double add(double a, double b) {
            return a + b;
        }

        public static double subtract(double a, double b) {
            return a - b;
        }

        public static double multiply(double a, double b) {
            return a * b;
        }

        public static double divide(double a, double b) {
            if (b == 0) {
                System.out.println("Error: Cannot divide by zero!");
                return 0;
            }
            return a / b;
        }

        public static double min(double a, double b) {
            return (a < b) ? a : b;
        }

        public static double max(double a, double b) {
            return (a > b) ? a : b;
        }
    }
}
