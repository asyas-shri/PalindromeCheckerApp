import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine().replaceAll("\\s+", "").toLowerCase();

        boolean result = check(input, 0, input.length() - 1);

        if (result)
            System.out.println("The given string is a Palindrome.");
        else
            System.out.println("The given string is NOT a Palindrome.");

        sc.close();
    }

    private static boolean check(String s, int start, int end) {

        if (start >= end)
            return true;

        if (s.charAt(start) != s.charAt(end))
            return false;

        return check(s, start + 1, end - 1);
    }
}