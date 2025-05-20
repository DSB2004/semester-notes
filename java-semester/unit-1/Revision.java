import java.util.*;

public class Revision {

    // Method to add two numbers
    int add(int a, int b) {
        return a + b;
    }

    // Static method for multiplication
    static int multiply(int a, int b) {
        return a * b;
    }

    // Simple class with constructor
    static class Person {
        String name;
        int age;

        Person(String n, int a) {
            name = n;
            age = a;
        }

        void greet() {
            System.out.println("Hello, my name is " + name + " and I'm " + age + " years old.");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Primitive data types
        int i = 10;
        double d = 20.5;
        char c = 'A';
        boolean flag = true;
        System.out.println("Primitive values: " + i + ", " + d + ", " + c + ", " + flag);

        // Type casting
        double converted = i; // Implicit
        int casted = (int) d; // Explicit
        System.out.println("Implicit cast (int to double): " + converted);
        System.out.println("Explicit cast (double to int): " + casted);

        // Conditional check
        if (i > 5) {
            System.out.println("i is greater than 5");
        } else {
            System.out.println("i is 5 or less");
        }

        // Loops
        System.out.println("For loop 0-4:");
        for (int x = 0; x < 5; x++) {
            System.out.print(x + " ");
        }
        System.out.println();

        System.out.println("While loop 5-1:");
        int y = 5;
        while (y > 0) {
            System.out.print(y + " ");
            y--;
        }
        System.out.println();

        // Arrays
        int[] nums = {1, 2, 3, 4};
        System.out.println("Array values:");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 2D Arrays
        int[][] matrix = {
            {1, 2},
            {3, 4}
        };
        System.out.println("2D Array:");
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

        // Strings
        String str = "Java";
        System.out.println("String length: " + str.length());
        System.out.println("Substring: " + str.substring(1));
        System.out.println("Uppercase: " + str.toUpperCase());

        // Object usage
        Person p1 = new Person("Alice", 22);
        p1.greet();

        // User input
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name);

        // Exception Handling
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.err.println("Error: Division by zero!");
        }

        // Function call
        Revision obj = new Revision();
        System.out.println("Addition: " + obj.add(5, 6));
        System.out.println("Multiplication: " + multiply(3, 4));

        scanner.close(); // Always close scanner
    }
}
