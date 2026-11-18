import java.util.Scanner;

public class Main {

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String s) {
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
            }


            if (balance < 0) {
                return false;
            }
        }


        return balance == 0;
    }

    // 2. reverseInteger
    public static String reverseInteger(int n) {
        String str = String.valueOf(n);
        String inverse = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            inverse = inverse + str.charAt(i);
        }

        return inverse;
    }

    // 3. encryptThis
    public static String encryptThis(String input) {
        String result = "";
        String word = "";

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == ' ') {
                if (word.length() > 0) {
                    int len = word.length();
                    if (len == 1) {
                        result = result + (int) word.charAt(0);
                    } else if (len == 2) {
                        result = result + (int) word.charAt(0) + word.charAt(1);
                    } else {
                        int num = (int) word.charAt(0);
                        String second = word.substring(1, 2);
                        String last = word.substring(len - 1);
                        String middle = word.substring(2, len - 1);
                        result = result + num + last + middle + second;
                    }
                    result = result + " ";
                    word = "";
                }
            } else {
                word = word + c;
            }
        }

        // Process the last word
        if (word.length() > 0) {
            int len = word.length();
            if (len == 1) {
                result = result + (int) word.charAt(0);
            } else if (len == 2) {
                result = result + (int) word.charAt(0) + word.charAt(1);
            } else {
                int num = (int) word.charAt(0);
                String second = word.substring(1, 2);
                String last = word.substring(len - 1);
                String middle = word.substring(2, len - 1);
                result = result + num + last + middle + second;
            }
        }

        return result;
    }


    // 4. decipherThis
    public static String decipherThis(String input) {
        String firstletter = "";
        String lastletter = "";
        String result = "";
        String word = "";
        String rest = "";
        int idx = 0;
        for (int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if (c == ' '){
                for (int j = 0; j < word.length(); j++){
                    while (idx < word.length() && Character.isDigit(c)){
                        idx ++;
                    }
                String numberpart = word.substring(0,idx);
                String letterpart = word.substring(idx);
                int code = Integer.parseInt(numberpart);
                char num2 = (char) code;
                firstletter = word.substring(idx,idx+1);
                lastletter = word.substring(word.length()-1);
                rest = word.substring(idx+1,word.length()-1);

                result = result + num2 + lastletter + rest + firstletter + " ";
                word = "";
                }
            }
            else{
                word = word + c;
            }
        }
        return result;

    }

}
