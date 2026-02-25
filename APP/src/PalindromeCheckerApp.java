import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class PalindromeCheckerApp {

    static String clean(String input) {
        return input.toLowerCase().replaceAll("[^a-z0-9]", "");
    }

    static boolean stackApproach(String input) {
        String cleaned = clean(input);
        Stack<Character> stack = new Stack<>();
        for (char c : cleaned.toCharArray()) stack.push(c);
        for (char c : cleaned.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }

    static boolean dequeApproach(String input) {
        String cleaned = clean(input);
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : cleaned.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) {
            if (!deque.pollFirst().equals(deque.pollLast())) return false;
        }
        return true;
    }

    static boolean reverseApproach(String input) {
        String cleaned = clean(input);
        return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
    }

    static boolean twoPointerApproach(String input) {
        String cleaned = clean(input);
        int left = 0, right = cleaned.length() - 1;
        while (left < right) {
            if (cleaned.charAt(left++) != cleaned.charAt(right--)) return false;
        }
        return true;
    }

    static long measure(Runnable approach, int iterations) {
        long start = System.nanoTime();
        for (int i = 0; i < iterations; i++) approach.run();
        return System.nanoTime() - start;
    }

    public static void main(String[] args) {
        String testInput = "A man a plan a canal Panama";
        int iterations = 100_000;

        System.out.println("Input       : \"" + testInput + "\"");
        System.out.println("Iterations  : " + iterations);
        System.out.println("=".repeat(55));
        System.out.printf("%-20s %-15s %-10s%n", "Algorithm", "Time (ms)", "Result");
        System.out.println("-".repeat(55));

        long stackTime      = measure(() -> stackApproach(testInput), iterations);
        long dequeTime      = measure(() -> dequeApproach(testInput), iterations);
        long reverseTime    = measure(() -> reverseApproach(testInput), iterations);
        long twoPointerTime = measure(() -> twoPointerApproach(testInput), iterations);

        System.out.printf("%-20s %-15.3f %-10s%n", "Stack",       stackTime / 1_000_000.0,      stackApproach(testInput));
        System.out.printf("%-20s %-15.3f %-10s%n", "Deque",       dequeTime / 1_000_000.0,      dequeApproach(testInput));
        System.out.printf("%-20s %-15.3f %-10s%n", "Reverse",     reverseTime / 1_000_000.0,    reverseApproach(testInput));
        System.out.printf("%-20s %-15.3f %-10s%n", "Two Pointer", twoPointerTime / 1_000_000.0, twoPointerApproach(testInput));

        System.out.println("=".repeat(55));

        long fastest = Math.min(Math.min(stackTime, dequeTime), Math.min(reverseTime, twoPointerTime));
        String winner = fastest == stackTime ? "Stack"
                : fastest == dequeTime ? "Deque"
                : fastest == reverseTime ? "Reverse"
                : "Two Pointer";
        System.out.println("Fastest Algorithm: " + winner);
    }
}