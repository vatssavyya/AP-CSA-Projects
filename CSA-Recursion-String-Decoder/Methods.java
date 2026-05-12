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
    //do 2 * mod 257 cuz it guarantees a return to 1
    public static String decode(String encString) {
        String unscrambled = "";
        char[] arrayTemp = new char[encString.length()];
        for (int i = 0; i < encString.length(); i++) {
            arrayTemp[i] = encString.charAt(i);
        }
        while (arrayTemp[0] != 1) {
            for (int j = 0; j < encString.length(); j++) {
                arrayTemp[j] = (char)((arrayTemp[j] * 2) % 257);
            }
        }
        for (int k = 0; k < arrayTemp.length; k++) {
            if ((arrayTemp[k] - 10) < 32) {
                
                arrayTemp[k] = (char)(32);
            }
            arrayTemp[k] = (char)(arrayTemp[k]);
        }



        return unscrambled;
    }
}
