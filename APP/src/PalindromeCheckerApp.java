import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

interface PalindromeStrategy {
    boolean check(String input);
}

class StackStrategy implements PalindromeStrategy {
    public boolean check(String input) {
        String cleaned = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        Stack<Character> stack = new Stack<>();
        for (char c : cleaned.toCharArray()) {
            stack.push(c);
        }
        for (char c : cleaned.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }
}

class DequeStrategy implements PalindromeStrategy {
    public boolean check(String input) {
        String cleaned = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : cleaned.toCharArray()) {
            deque.addLast(c);
        }
        while (deque.size() > 1) {
            if (!deque.pollFirst().equals(deque.pollLast())) return false;
        }
        return true;
    }
}

class PalindromeChecker {
    private PalindromeStrategy strategy;

    public PalindromeChecker(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(String input) {
        return strategy.check(input);
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose strategy: 1 = Stack, 2 = Deque");
        int choice = Integer.parseInt(scanner.nextLine().trim());

        PalindromeStrategy strategy = (choice == 1) ? new StackStrategy() : new DequeStrategy();
        PalindromeChecker checker = new PalindromeChecker(strategy);

        System.out.print("Enter string: ");
        String input = scanner.nextLine();

        System.out.println("Strategy: " + strategy.getClass().getSimpleName());
        System.out.println(input + " -> " + (checker.validate(input) ? "Palindrome" : "Not a Palindrome"));

        scanner.close();
    }
}