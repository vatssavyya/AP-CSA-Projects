public class Methods {
    public Methods() {
    }

    private static int round = 1;

    public static String convert(String nums) {
        String jumbled = "";
        String[] arrayThing = nums.split(" ");
        for (int i = 0; i < arrayThing.length; i++) {
            jumbled += (char)(Integer.parseInt(arrayThing[i]));
        }
        return jumbled;
    }

    public static String decode(String encString) {
        if (encString.charAt(0) == '\1') {
            round = 1;
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
        if (round <= 20) {
            System.out.println("Round " + round + ": " + currentPass);
        }
        round++;
        return decode(currentPass);
    }
}