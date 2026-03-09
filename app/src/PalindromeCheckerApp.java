import java.util.Scanner;

public class PalindromeCheckerApp {

    // Method to check palindrome ignoring case and spaces
    public static boolean isPalindrome(String input) {
        // Normalize string: remove spaces and convert to lowercase
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        int start = 0;
        int end = normalized.length() - 1;

        // Compare characters from both ends
        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC10: Case-Insensitive & Space-Ignored Palindrome Checker ===");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("\"" + input + "\" is a Palindrome (ignoring case and spaces).");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome (ignoring case and spaces).");
        }

        scanner.close();
    }
}