import java.util.Stack;

public class PalindromeCheckerApp {

    /**
     * Application entry point for UC5.
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        // Declare and initialize the input string
        String input = "noon";

        // Optional normalization (can remove if not required)
        input = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Create a Stack to store characters
        Stack<Character> stack = new Stack<>();

        // Push each character of the string into the stack
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        // Assume palindrome initially
        boolean isPalindrome = true;

        // Iterate again through original string
        for (char c : input.toCharArray()) {

            char poppedChar = stack.pop();

            if (c != poppedChar) {
                isPalindrome = false;
                break;
            }
        }

        // Display result
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome : " + isPalindrome);
    }
}