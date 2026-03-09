import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

// Step 1: Define the Strategy interface
interface PalindromeStrategy {
    boolean checkPalindrome(String input);
}

// Step 2: Implement Stack-based strategy
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String input) {
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
}

// Step 3: Implement Deque-based strategy
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new LinkedList<>();

        for (char ch : normalized.toCharArray()) {
            deque.addLast(ch);
        }
        return true;
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

// Step 4: Context class to inject strategy
class PalindromeCheckerContext {
    private PalindromeStrategy strategy;

    public PalindromeCheckerContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeCheck(String input) {
        return strategy.checkPalindrome(input);
    }
}

// Step 5: Main Application
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC12: Strategy Pattern Palindrome Checker ===");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        System.out.println("Choose strategy: 1) Stack  2) Deque");
        int choice = scanner.nextInt();

        PalindromeCheckerContext context;

        if (choice == 1) {
            context = new PalindromeCheckerContext(new StackStrategy());
        } else {
            context = new PalindromeCheckerContext(new DequeStrategy());
        }

        if (context.executeCheck(input)) {
            System.out.println("\"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome.");
        }

        scanner.close();
    }
}