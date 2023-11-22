package g7.upskill.ips;

public class Main {
    public static void main(String[] args) {


        // Original string with multiple single quotes
        String originalString = "This is a string with single quotes: 'example' and 'another'";

        // Replace the first single quote with another character or sequence
        String replacedString = originalString.replace("'", "");

        // Display the original and replaced strings
        System.out.println("Original String: " + originalString);
        System.out.println("Replaced String: " + replacedString);

    }
}