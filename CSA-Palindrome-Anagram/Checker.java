public class Checker {
    public static double palindrome(String str) {
        /*for EC, manually use ascii table to convert uppercase to lowercase 
        and stuff like special chars*/

        //clearing out spaces and stuff
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch + 32);
                str = str.substring(0, i) + ch + str.substring(i + 1);
            }
            if (ch < 'a' || ch > 'z') {
                str = str.substring(0, i) + str.substring(i + 1);
                i--;
            }
        }

        //System.out.println(str);
        //checking the conditions for palindrome
        double mismatch = 1.0;
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                mismatch -= 1.0 / (str.length() / 2);
            }
        }
        return mismatch;


    }
    public static boolean anagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int counter = 0;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    counter++;
                    str2 = str2.substring(0, j) + str2.substring(j + 1);
                    break;
                }
            }
        }

        if (counter == str1.length()) {
            return true;
        } 
        else {
            return false;
        }
        
    }
}
