import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class PalindromeCheckerApp {

    // Method to check if a string is palindrome using Deque
    public static boolean isPalindrome(String input) {
        // Normalize input: remove spaces and convert to lowercase
        input = input.replaceAll("\\s+", "").toLowerCase();

        Deque<Character> deque = new LinkedList<>();

        // Insert characters into deque
        for (char ch : input.toCharArray()) {
            deque.addLast(ch);
        }

        // Compare front and rear until empty or mismatch
        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                return false; // mismatch found
            }
        }

        return true; // all matched
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC7: Deque-Based Palindrome Checker ===");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("\"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome.");
        }

        scanner.close();
    }
}