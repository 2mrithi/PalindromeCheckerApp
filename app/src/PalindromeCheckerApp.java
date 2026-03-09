import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    // Stack-based palindrome check
    public static boolean stackPalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char ch : normalized.toCharArray()) {
            stack.push(ch);
        }
        for (char ch : normalized.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    // Deque-based palindrome check
    public static boolean dequePalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new LinkedList<>();
        for (char ch : normalized.toCharArray()) {
            deque.addLast(ch);
        }
        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();
            if (front != rear) {
                return false;
            }
        }
        return true;
    }
}

    // Recursive palindrome check
    public static boolean recursivePalindrome(String input, int start, int end) {
        if (start >= end) return true;
        if (input.charAt(start) != input.charAt(end)) return false;
        return recursivePalindrome(input, start + 1, end - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC13: Performance Comparison of Palindrome Algorithms ===");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        // Normalize once for recursion
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // Measure StackStrategy
        long startTime = System.nanoTime();
        boolean stackResult = stackPalindrome(input);
        long stackTime = System.nanoTime() - startTime;

        // Measure DequeStrategy
        startTime = System.nanoTime();
        boolean dequeResult = dequePalindrome(input);
        long dequeTime = System.nanoTime() - startTime;

        // Measure RecursiveStrategy
        startTime = System.nanoTime();
        boolean recursiveResult = recursivePalindrome(normalized, 0, normalized.length() - 1);
        long recursiveTime = System.nanoTime() - startTime;

        // Display results
        System.out.println("\nResults:");
        System.out.println("Stack Strategy: " + (stackResult ? "Palindrome" : "Not Palindrome") +
                " | Time: " + stackTime + " ns");
        System.out.println("Deque Strategy: " + (dequeResult ? "Palindrome" : "Not Palindrome") +
                " | Time: " + dequeTime + " ns");
        System.out.println("Recursive Strategy: " + (recursiveResult ? "Palindrome" : "Not Palindrome") +
                " | Time: " + recursiveTime + " ns");

        scanner.close();
    }
}