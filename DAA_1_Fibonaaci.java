import java.util.Arrays;

public class DAA_1_Fibonaaci
{
    // Recursive approach
    static int fibonacciRecursive(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

        // Non-recursive (iterative) approach
    static void fibonacciIterative(int n)
    {
        int a = 0, b = 1, c;
        System.out.print("Iterative Fibonacci Series: ");
        System.out.print(a + " " + b + " ");
        for (int i = 2; i < n; i++) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }

    public static void main(String[] args)
    {
        int n = 10;

        // Recursive
        System.out.println("Recursive Fibonacci for n=" + n + ": " + fibonacciRecursive(n - 1));

        // Iterative
        fibonacciIterative(n);
    }
}

/*
Time Complexity:
Recursive: O(2^n)
Iterative: O(n)

Space Complexity:
Recursive: O(n) (function call stack)
Iterative: O(1)
*/


