/*
 * Application entry point
 * This is the first method execute by the JVM when the program starts
 * @author Developer
 * @Version 1.0
 */

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        public static void main(String[] args) {

            String input = "madam";   // Hardcoded string
            boolean isPalindrome = true;

            // Loop only till half of the string length
            for (int i = 0; i < input.length() / 2; i++) {

                // Compare characters from both ends
                if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                    isPalindrome = false;
                    break;
                }
            }

            // Print input text
            System.out.println("Input text: " + input);

            // Print result
            System.out.println("Is it a Palindrome?: " + isPalindrome);
        }
    }
}
