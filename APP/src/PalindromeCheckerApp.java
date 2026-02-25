import java.util.Scanner;
public class PalindromeCheckerApp {

    // Application entry point
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        System.out.print("Input : ");
        String input = reader.nextLine();

        // Normalize input (optional improvement)
        input = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Convert string into character array
        char[] chars = input.toCharArray();

        // Initialize pointers
        int start = 0;
        int end = chars.length - 1;

        // Assume it is palindrome
        boolean isPalindrome = true;

        // Compare characters until pointers cross
        while (start < end) {

            if (chars[start] != chars[end]) {
                isPalindrome = false;
                break;
            }

            start++;
            end--;
        }

        System.out.println("Is Palindrome : " + isPalindrome);

        reader.close();
    }
}