public class Methods {
    public Methods() {
    }
    //should be unreadable, this ciphers into it
    public static String convert(String nums) {
        String jumbled = "";
        String[] arrayThing = nums.split(" ");
        for (int i = 0; i < arrayThing.length; i++) {
            jumbled += (char)(Integer.parseInt(arrayThing[i]));
        }
        return jumbled;
    }

    public static String decode(String encString) {
        String unscrambled = "";
        char[] arrayTemp = new char[encString.length()];
        for (int i = 0; i < encString.length(); i++) {
            arrayTemp[i] = encString.charAt(i);
        }
        for (int round = 1; round <= 20; round++) {
            if (arrayTemp[0] == 1) {
                break;
            }
            String currentPass = "";
            for (int j = 0; j < arrayTemp.length; j++) {
                arrayTemp[j] = (char)((arrayTemp[j] * 2) % 257);
            }
            for (char x : arrayTemp) {
                currentPass += x;
            }
            System.out.println("Round " + round + ": " + currentPass);
        }
        for (int k = 1; k < arrayTemp.length; k++) {
            int shifted = arrayTemp[k] - 10;
            if (shifted < 32) {
                shifted = 127 - (32 - (shifted));
            }
            arrayTemp[k] = (char)(shifted);
        }
        for (int i = 1; i < arrayTemp.length; i++) {
            unscrambled += arrayTemp[i];
        }
        return unscrambled;
    }
}