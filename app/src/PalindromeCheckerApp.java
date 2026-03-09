import java.util.Scanner;

public class PalindromeCheckerApp {

    // Recursive method to check palindrome
    public static boolean isPalindrome(String input, int start, int end) {
        // Base condition: if start crosses end, it's a palindrome
        if (start >= end) {
            return true;
        }

        // If mismatch found, return false
        if (input.charAt(start) != input.charAt(end)) {
            return false;
        }

        // Recursive call: move inward
        return isPalindrome(input, start + 1, end - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC9: Recursive Palindrome Checker ===");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        // Normalize input: remove spaces and convert to lowercase
        input = input.replaceAll("\\s+", "").toLowerCase();

        if (isPalindrome(input, 0, input.length() - 1)) {
            System.out.println("\"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome.");
        }

        scanner.close();
    }
}