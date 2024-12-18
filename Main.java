public class Main {

    // Method to shift letters by 3 positions (for encryption)
    public static String shiftCipher(String message, boolean encrypt) {
        String result = "";
        int shift = encrypt ? 3 : -3;  // Use +3 for encryption, -3 for decryption
        
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (c >= 'a' && c <= 'z') {
                c = (char) ('a' + (c - 'a' + shift + 26) % 26);  // Shift for lowercase
            } else if (c >= 'A' && c <= 'Z') {
                c = (char) ('A' + (c - 'A' + shift + 26) % 26);  // Shift for uppercase
            }
            result += c;
        }
        return result;
    }

    // Method to reverse the string
    public static String reverseMessage(String message) {
        String result = "";
        for (int i = message.length() - 1; i >= 0; i--) {
            result += message.charAt(i);
        }
        return result;
    }

    // Method to replace letters with their alphabet positions (A=1, B=2, etc.)
    public static String numberSubstitution(String message) {
        String result = "";
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (c >= 'a' && c <= 'z') {
                result += (c - 'a' + 1) + " ";
            } else if (c >= 'A' && c <= 'Z') {
                result += (c - 'A' + 1) + " ";
            } else {
                result += c;  // Non-alphabet characters remain unchanged
            }
        }
        return result.trim();
    }

    // Method to decode numbers back to letters
    public static String numberToLetter(String message) {
        String result = "";
        String[] numbers = message.split(" ");
        for (String num : numbers) {
            try {
                int n = Integer.parseInt(num);
                if (n >= 1 && n <= 26) {
                    result += (char) ('A' + n - 1);
                } else {
                    result += num;  // Non-number characters remain unchanged
                }
            } catch (NumberFormatException e) {
                result += num;  // Non-number characters remain unchanged
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String originalMessage = "Hello World!";
        System.out.println("Original Message: " + originalMessage);

        // Step 1: Encrypt the message by shifting each letter by 3 positions
        String shifted = shiftCipher(originalMessage, true);
        System.out.println("Shifted Message: " + shifted);

        // Step 2: Reverse the shifted message
        String reversed = reverseMessage(shifted);
        System.out.println("Reversed Message: " + reversed);

        // Step 3: Convert the reversed message to numbers (A=1, B=2, etc.)
        String encryptedMessage = numberSubstitution(reversed);
        System.out.println("Encrypted Message: " + encryptedMessage);

        // Step 4: Decode the numbers back to letters
        String decodedNumbers = numberToLetter(encryptedMessage);
        System.out.println("Decoded Numbers to Letters: " + decodedNumbers);

        // Step 5: Reverse the string back to the original order
        String restoredOrder = reverseMessage(decodedNumbers);
        System.out.println("Restored Order: " + restoredOrder);

        // Step 6: Decrypt the message by shifting the letters back by 3 positions
        String decryptedMessage = shiftCipher(restoredOrder, false);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }
}



