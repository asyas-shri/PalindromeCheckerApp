import java.util.Scanner;

public class PalindromeCheckerUC3 {

    public static boolean isPalindrome(String input) {

        // Normalize input (optional enhancement)
        input = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        String reversed = "";

        // Reverse using for loop
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + input.charAt(i);
        }

        // Compare original and reversed
        return input.equals(reversed);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("✅ It is a Palindrome.");
        } else {
            System.out.println("❌ Not a Palindrome.");
        }

        scanner.close();
    }
}