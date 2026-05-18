public class Methods {
    public Methods() {
    }

    public static String convert(String nums) {
        String jumbled = "";
        String[] arrayThing = nums.split(" ");
        for (int i = 0; i < arrayThing.length; i++) {
            jumbled += (char)(Integer.parseInt(arrayThing[i]));
        }
        return jumbled;
    }

    public static void showPasses(String encString) {
        char[] arrayTemp = new char[encString.length()];
        for (int i = 0; i < encString.length(); i++) {
            arrayTemp[i] = encString.charAt(i);
        }
        for (int round = 1; round <= 20; round++) {
            for (int j = 0; j < arrayTemp.length; j++) {
                arrayTemp[j] = (char)((arrayTemp[j] * 2) % 257);
            }
            String currentPass = "";
            for (int i = 0; i < arrayTemp.length; i++) {
                currentPass += arrayTemp[i];
            }
            System.out.println("Round " + round + ": " + currentPass);
            if (arrayTemp[0] == '\1') break;
        }
    }

    public static String decode(String encString) {
        if (encString.charAt(0) == '\1') {
            String unscrambled = "";
            for (int k = 1; k < encString.length(); k++) {
                int shifted = encString.charAt(k) - 10;
                if (shifted < 32) {
                    shifted = 127 - (32 - shifted);
                }
                unscrambled += (char)(shifted);
            }
            return unscrambled;
        }
        String currentPass = "";
        for (int j = 0; j < encString.length(); j++) {
            currentPass += (char)((encString.charAt(j) * 2) % 257);
        }
        return decode(currentPass);
    }
}